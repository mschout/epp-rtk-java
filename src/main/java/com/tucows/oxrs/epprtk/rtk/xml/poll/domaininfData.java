package com.tucows.oxrs.epprtk.rtk.xml.poll;

import com.tucows.oxrs.epprtk.rtk.xml.EPPDomainBase;
import org.openrtk.idl.epprtk.domain.epp_DomainContact;
import org.openrtk.idl.epprtk.domain.epp_DomainContactType;
import org.openrtk.idl.epprtk.domain.epp_DomainInfData;
import org.openrtk.idl.epprtk.domain.epp_DomainStatus;
import org.openrtk.idl.epprtk.epp_AuthInfo;
import org.openrtk.idl.epprtk.epp_AuthInfoType;
import org.openrtk.idl.epprtk.epp_PollResData;
import org.openrtk.idl.epprtk.epp_XMLException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class domaininfData extends EPPDomainBase implements PollResData {
    private epp_DomainInfData pollResData = null;

    @Override
    public void fromXML(Node resDataSubNode) throws epp_XMLException {
        NodeList infDataList = resDataSubNode.getChildNodes();

        if (infDataList.getLength() == 0) {
            throw new epp_XMLException("missing domain info data");
        }

        pollResData = new epp_DomainInfData();

        List<epp_DomainStatus> statuses = new ArrayList<>();
        List<epp_DomainContact> contacts = new ArrayList<>();
        List<String> nameServers = new ArrayList<>();

        for (int count = 0; count < infDataList.getLength(); count++) {
            Node node = infDataList.item(count);

            if (node.getNodeName().equals("domain:name")) {
                pollResData.setName(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:roid")) {
                pollResData.setRoid(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:status")) {
                NamedNodeMap attributes = node.getAttributes();
                String statusName = attributes.getNamedItem("s").getNodeValue();
                statuses.add(new epp_DomainStatus(EPPDomainBase.domainStatusFromString(statusName), null, node.getTextContent()));
            }

            if (node.getNodeName().equals("domain:registrant")) {
                pollResData.setRegistrant(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:contact")) {
                epp_DomainContactType type = (epp_DomainContactType)contact_type_hash_.get( ((Element)node).getAttribute("type"));
                contacts.add(new epp_DomainContact(type, node.getTextContent()));
            }

            if (node.getNodeName().equals("domain:ns")) {
                NodeList hostObjectsNodes = node.getChildNodes();

                for (int i = 0; i < hostObjectsNodes.getLength(); i++)
                {
                    Node hostObject = hostObjectsNodes.item(i);
                    if (!hostObject.getNodeName().equals("domain:hostObj"))
                        throw new epp_XMLException("not supporting " + hostObject.getNodeName() + " in domain:ns results");
                    nameServers.add(hostObject.getFirstChild().getNodeValue());
                }
            }

            if (node.getNodeName().equals("domain:clID")) {
                pollResData.setClientId(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:crID")) {
                pollResData.setCreatedBy(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:crDate")) {
                pollResData.setCreatedDate(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:upID")) {
                pollResData.setUpdatedBy(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:upDate")) {
                pollResData.setUpdatedDate(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:exDate")) {
                pollResData.setExpirationDate(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:authInfo")) {
                epp_AuthInfo authInfo = new epp_AuthInfo();

                Element authInfoChild = (Element)node.getFirstChild();
                if ( authInfoChild != null ) {
                    authInfo.m_value = authInfoChild.getTextContent();
                    authInfo.m_roid = authInfoChild.getAttribute("roid");
                    authInfo.m_type = (epp_AuthInfoType)auth_type_string_to_type_hash_.get(authInfoChild.getLocalName());

                    pollResData.setAuthInfo(authInfo);
                }
            }
        }

        if (!statuses.isEmpty()) {
            pollResData.setStatus(statuses.toArray(new epp_DomainStatus[0]));
        }

        if (!contacts.isEmpty()) {
            pollResData.setContacts(contacts.toArray(new epp_DomainContact[0]));
        }

        if (!nameServers.isEmpty()) {
            pollResData.setNameservers(nameServers.toArray(new String[0]));
        }
    }

    @Override
    public epp_PollResData getPollResData() {
        return pollResData;
    }
}
