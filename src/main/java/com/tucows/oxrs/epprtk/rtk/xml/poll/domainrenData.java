package com.tucows.oxrs.epprtk.rtk.xml.poll;

import com.tucows.oxrs.epprtk.rtk.xml.EPPDomainBase;
import com.tucows.oxrs.epprtk.rtk.xml.EPPXMLBase;
import org.openrtk.idl.epprtk.domain.epp_DomainRenData;
import org.openrtk.idl.epprtk.epp_PollResData;
import org.openrtk.idl.epprtk.epp_XMLException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domainrenData extends EPPXMLBase implements PollResData {
    private epp_DomainRenData poll_res_data_ = null;

    @Override
    public void fromXML(Node res_data_sub_node) throws epp_XMLException {
        String method_name = "fromXML(Node)";

        NodeList domainRenDataList = res_data_sub_node.getChildNodes();

        poll_res_data_ = new epp_DomainRenData();

        debug(DEBUG_LEVEL_TWO,method_name,"domain:renData's node count ["+domainRenDataList.getLength()+"]");

        if (domainRenDataList.getLength() == 0) {
            throw new epp_XMLException("missing domain renew data");
        }

        // NOTE: If this sees replication, move to EPPDomainBase
        poll_res_data_ = new epp_DomainRenData();

        for (int count = 0; count < domainRenDataList.getLength(); count++) {
            Node node = domainRenDataList.item(count);

            if (node.getNodeName().equals("domain:name")) {
                poll_res_data_.setName(node.getFirstChild().getNodeValue());
            }

            if (node.getNodeName().equals("domain:exDate")) {
                poll_res_data_.setExpirationDate(node.getFirstChild().getNodeValue());
            }
        }
    }

    @Override
    public epp_PollResData getPollResData() {
        return poll_res_data_;
    }
}
