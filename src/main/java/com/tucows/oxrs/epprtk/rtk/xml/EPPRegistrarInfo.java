package com.tucows.oxrs.epprtk.rtk.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.dom.DocumentImpl;
import org.openrtk.idl.epprtk.epp_Command;
import org.openrtk.idl.epprtk.epp_Exception;
import org.openrtk.idl.epprtk.epp_Session;
import org.openrtk.idl.epprtk.epp_XMLException;
import org.openrtk.idl.epprtk.domain.epp_DomainContact;
import org.openrtk.idl.epprtk.domain.epp_DomainContactType;
import org.openrtk.idl.epprtk.registrar.epp_RegistrarInfo;
import org.openrtk.idl.epprtk.registrar.epp_RegistrarInfoReq;
import org.openrtk.idl.epprtk.registrar.epp_RegistrarInfoRsp;
import org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EPPRegistrarInfo extends EPPRegistrarBase implements epp_RegistrarInfo
{
    private epp_RegistrarInfoReq action_request_;
    private epp_RegistrarInfoRsp action_response_;

    public EPPRegistrarInfo () {
    }

    public EPPRegistrarInfo (String xml) throws epp_XMLException, epp_Exception
    {
        String method_name = "EPPRegistrarInfo(String)";
        debug(DEBUG_LEVEL_TWO,method_name,"xml is ["+xml+"]");
        fromXML(xml);
    }

    public void setRequestData(epp_RegistrarInfoReq value) { action_request_ = value; }

    public epp_RegistrarInfoRsp getResponseData() { return action_response_; }

    public String toXML() throws epp_XMLException
    {
        String method_name = "buildRequestXML()";
        debug(DEBUG_LEVEL_THREE,method_name,"Entered");

        if ( action_request_ == null || 
             action_request_.m_cmd == null ||
             action_request_.m_id == null )
        {
            throw new epp_XMLException("missing request data or registrar id");
        }

        Document doc = new DocumentImpl();
        Element root = createDocRoot(doc);

        Element command = doc.createElement("command");
        Element info = doc.createElement("info");

        epp_Command command_data = action_request_.m_cmd;

        Element registrar_info = doc.createElement("registrar:info");
        setCommonAttributes(registrar_info);

        addXMLElement(doc, registrar_info, "registrar:id", action_request_.m_id);

        info.appendChild( registrar_info );

        command.appendChild( info );

        prepareExtensionElement( doc, command, command_data.m_extensions );

        if ( command_data.m_client_trid != null )
        {
            addXMLElement(doc, command, "clTRID", command_data.m_client_trid);
        }

        root.appendChild( command );
        doc.appendChild( root );
        
        String request_xml;
        
        try
        {
            request_xml = createXMLFromDoc(doc);
        }
        catch (IOException xcp)
        {
            throw new epp_XMLException("IOException in building XML ["+xcp.getMessage()+"]");
        }

        debug(DEBUG_LEVEL_THREE,method_name,"Leaving");

        return request_xml;
    }

    public void fromXML(String xml) throws epp_XMLException, epp_Exception
    {
        String method_name = "fromXML()";
        debug(DEBUG_LEVEL_THREE,method_name,"Entered");

        xml_ = xml;

        try
        {
            Element epp_node = getDocumentElement();
            Node response_node = epp_node.getElementsByTagName("response").item(0);

            if ( response_node == null )
            {
                throw new epp_XMLException("unparsable or missing response");
            }

            action_response_ = new epp_RegistrarInfoRsp();
            
            action_response_.m_rsp = parseGenericResult(response_node);

            if ( action_response_.m_rsp.m_results[0].m_code >= epp_Session.EPP_UNKNOWN_COMMAND )
            {
                throw new epp_Exception(action_response_.m_rsp.m_results);
            }

            Element response_data_element = getElement(response_node.getChildNodes(), "resData");

            NodeList registrar_info_result_list = response_data_element.getElementsByTagName("registrar:infData").item(0).getChildNodes();

            debug(DEBUG_LEVEL_TWO,method_name,"registrar:infData's node count ["+registrar_info_result_list.getLength()+"]");

            if ( registrar_info_result_list.getLength() == 0 )
            {
                throw new epp_XMLException("missing info results");
            }

            List contacts = (List)new ArrayList();
            List portfolios = (List)new ArrayList();
            for (int count = 0; count < registrar_info_result_list.getLength(); count++)
            {
                Node a_node = registrar_info_result_list.item(count);

                if ( a_node.getNodeName().equals("registrar:id") ) { action_response_.m_id = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:roid") ) { action_response_.m_roid = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:user") ) { action_response_.m_user = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:guid") ) { action_response_.m_guid = Integer.valueOf(a_node.getFirstChild().getNodeValue()); }
                if ( a_node.getNodeName().equals("registrar:ctID") ) { action_response_.m_contact_roid = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:contact") )
                {
                    epp_DomainContact domain_contact = new epp_DomainContact();
                    domain_contact.m_id = a_node.getFirstChild().getNodeValue();
                    domain_contact.m_type = (epp_DomainContactType)contact_type_hash_.get( ((Element)a_node).getAttribute("type") );
                    contacts.add(domain_contact);
                }
                
                if ( a_node.getNodeName().equals("registrar:url") ) { action_response_.m_url = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:crID") ) { action_response_.m_created_by = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:crDate") ) { action_response_.m_created_date = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:upID") ) { action_response_.m_updated_by = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:upDate") ) { action_response_.m_updated_date = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:status") ) { action_response_.m_status = ((Element)a_node).getAttribute("s"); }
                if ( a_node.getNodeName().equals("registrar:email") ) { action_response_.m_email = a_node.getFirstChild().getNodeValue(); }
                
                if ( a_node.getNodeName().equals("registrar:portfolio") )
                {
                    epp_RegistrarPortfolio registrarPortfolio = new epp_RegistrarPortfolio();
                    registrarPortfolio.setName(((Element)a_node).getAttribute("name"));
                    NodeList portfolio_nodelist = a_node.getChildNodes();
                    for(int i = 0; i < portfolio_nodelist.getLength(); i++ ){
                        Node portfolio_node = portfolio_nodelist.item(i);
                        if (portfolio_node.getNodeName().equals("registrar:balance")) { registrarPortfolio.setBalance(Float.valueOf(portfolio_node.getFirstChild().getNodeValue()));}
                        if (portfolio_node.getNodeName().equals("registrar:threshold")) { registrarPortfolio.setThreshold(Float.valueOf(portfolio_node.getFirstChild().getNodeValue()));}
                    }
                    portfolios.add(registrarPortfolio);
                }

                if ( a_node.getNodeName().equals("registrar:category") ) { action_response_.m_category = a_node.getFirstChild().getNodeValue(); }
                if ( a_node.getNodeName().equals("registrar:groupLeadRole") ) {
                    epp_DomainContact registrar_groupLeadRole = new epp_DomainContact();
                    registrar_groupLeadRole.m_id = a_node.getFirstChild().getNodeValue();
                    registrar_groupLeadRole.m_type = (epp_DomainContactType)contact_type_hash_.get( ((Element)a_node).getAttribute("type") );
                    action_response_.m_groupLeadRole = registrar_groupLeadRole;
                }
            }
            if ( contacts.size() > 0 ) { action_response_.m_contacts = (epp_DomainContact[]) convertListToArray((new epp_DomainContact()).getClass(), contacts); }
            if ( portfolios.size() > 0 ) { action_response_.m_portfolios = (epp_RegistrarPortfolio[]) convertListToArray(epp_RegistrarPortfolio.class, portfolios); }
        }
        catch (SAXException xcp)
        {
            debug(DEBUG_LEVEL_ONE,method_name,xcp);
            throw new epp_XMLException("unable to parse xml ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
        }
        catch (IOException xcp)
        {
            debug(DEBUG_LEVEL_ONE,method_name,xcp);
            throw new epp_XMLException("unable to parse xml ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
        }

    }
}
