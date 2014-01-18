package com.tucows.oxrs.epprtk.rtk.xml;

import java.util.Hashtable;

import org.openrtk.idl.epprtk.domain.epp_DomainContactType;
import org.w3c.dom.Element;

public abstract class EPPRegistrarBase extends EPPXMLBase
{
    protected static Hashtable contact_type_hash_;
    
    public EPPRegistrarBase() { initHashes(); }
    
    public EPPRegistrarBase(String xml) { super(xml); initHashes(); }
    
    public static void initHashes()
    {
        initContactTypeHash();
    }
    
    protected static void initContactTypeHash()
    {
        if ( contact_type_hash_ == null )
        {
            contact_type_hash_ = new Hashtable();
            contact_type_hash_.put("admin", epp_DomainContactType.ADMIN);
            contact_type_hash_.put("billing", epp_DomainContactType.BILLING);
            contact_type_hash_.put("tech", epp_DomainContactType.TECH);
        }
    }
    
    protected void setCommonAttributes(Element command)
    {
        command.setAttribute("xmlns:registrar", "urn:ietf:params:xml:ns:registrar-1.0");
        command.setAttribute("xsi:schemaLocation", "urn:ietf:params:xml:ns:registrar-1.0 registrar-1.0.xsd");
    }
}
