package org.openrtk.idl.epprtk.domain;

import org.omg.CORBA.portable.IDLEntity;
import org.omg.CORBA.portable.ObjectImpl;
import org.openrtk.idl.epprtk.epp_AuthInfo;
import org.openrtk.idl.epprtk.epp_PollResData;

import java.util.Arrays;

public class epp_DomainInfData extends ObjectImpl implements IDLEntity, epp_PollResData {
    /**
     * Constant variable defined by IDLs.</p>
     * Used when this classes is used to hold the poll response
     * data pertaining to domain renew notifications.  The value
     * of this constant links this class to a set of poll response
     * data.
     */
    public static final String m_type = "domain:infData";

    public String m_name;

    public String m_roid;

    public epp_DomainStatus[] m_status;

    public String m_registrant;

    public epp_DomainContact[] m_contacts;

    public String[] m_nameservers;

    public String m_clid;

    public String m_crid;

    public String m_crDate;

    public String m_upid;

    public String m_upDate;

    public String m_exDate;

    public epp_AuthInfo m_authInfo;

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public String getRoid() {
        return m_roid;
    }

    public void setRoid(String roid) {
        this.m_roid = roid;
    }

    public epp_DomainStatus[] getStatus() {
        return m_status;
    }

    public void setStatus(epp_DomainStatus[] status) {
        this.m_status = status;
    }

    public String getRegistrant() {
        return m_registrant;
    }

    public void setRegistrant(String registrant) {
        this.m_registrant = registrant;
    }

    public epp_DomainContact[] getContacts() {
        return m_contacts;
    }

    public void setContacts(epp_DomainContact[] contacts) {
        this.m_contacts = contacts;
    }

    public String[] getNameservers() {
        return m_nameservers;
    }

    public void setNameservers(String[] nameservers) {
        this.m_nameservers = nameservers;
    }

    public String getClientId() {
        return m_clid;
    }

    public void setClientId(String clid) {
        this.m_clid = clid;
    }

    public String getCreatedBy() {
        return m_crid;
    }

    public void setCreatedBy(String crid) {
        this.m_crid = crid;
    }

    public String getCreatedDate() {
        return m_crDate;
    }

    public void setCreatedDate(String crDate) {
        this.m_crDate = crDate;
    }

    public String getUpdatedDate() {
        return m_upDate;
    }

    public void setUpdatedDate(String upDate) {
        this.m_upDate = upDate;
    }

    public String getUpdatedBy() {
        return m_upid;
    }

    public void setUpdatedBy(String upid) {
        this.m_upid = upid;
    }

    public String getExpirationDate() {
        return m_exDate;
    }

    public void setExpirationDate(String exDate) {
        this.m_exDate = exDate;
    }

    public epp_AuthInfo getAuthInfo() {
        return m_authInfo;
    }

    public void setAuthInfo(epp_AuthInfo authInfo) {
        this.m_authInfo = authInfo;
    }

    /**
     * Method required by ObjectImpl and the CORBA Object interface.
     * Always returns null.  It's only here to satisfy the CORBA requirements
     * of the IDL usage.
     */
    public String[] _ids() { return null; }

    @Override
    public String getType() { return m_type; }

    @Override
    public String toString() {
        return String.format("%s: { m_name [%s], m_roid [%s], m_status [%s], m_registrant [%s], m_contacts [%s], m_nameservers [%s], m_clid [%s], m_crid [%s], m_crDate [%s], m_upDate [%s], m_exDate [%s], m_authInfo [%s] }",
                this.getClass().getName(),
                m_name,
                m_roid,
                Arrays.toString(m_status),
                m_registrant,
                Arrays.toString(m_contacts),
                Arrays.toString(m_nameservers),
                m_clid,
                m_crid,
                m_crDate,
                m_upDate,
                m_exDate,
                m_authInfo);
    }
}
