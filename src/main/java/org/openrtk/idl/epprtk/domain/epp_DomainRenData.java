package org.openrtk.idl.epprtk.domain;

public class epp_DomainRenData extends org.omg.CORBA.portable.ObjectImpl implements org.omg.CORBA.portable.IDLEntity, org.openrtk.idl.epprtk.epp_PollResData {
    /**
     * Constant variable defined by IDLs.</p>
     * Used when this classes is used to hold the poll response
     * data pertaining to domain renew notifications.  The value
     * of this constant links this class to a set of poll response
     * data.
     */
    public static final String m_type = "domain:renData";

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public String getExpirationDate() {
        return m_ex_date;
    }

    public void setExpirationDate(String m_ex_date) {
        this.m_ex_date = m_ex_date;
    }

    public String m_name = null;
    public String m_ex_date = null;

    @Override
    public String getType() { return m_type; }

    public epp_DomainRenData() {}

    public epp_DomainRenData(String name, String exDate) {
        this.m_name = name;
        this.m_ex_date = exDate;
    }

    /**
     * Method required by ObjectImpl and the CORBA Object interface.
     * Always returns null.  It's only here to satisfy the CORBA requirements
     * of the IDL usage.
     */
    public String[] _ids() { return null; }

    /**
     * Converts this class into a string.
     * Typically used to view the object in debug output.
     * @return The string representation of this object instance
     */
    public String toString() {
        return String.format("%s: { m_name [%s] m_ex_date [%s]", this.getClass().getName(), m_name, m_ex_date);
    }
}
