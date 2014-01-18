/*
**
** EPP RTK Java
** Copyright (C) 2001-2002, Tucows, Inc.
** Copyright (C) 2003, Liberty RMS
**
**
** This library is free software; you can redistribute it and/or
** modify it under the terms of the GNU Lesser General Public
** License as published by the Free Software Foundation; either
** version 2.1 of the License, or (at your option) any later version.
**
** This library is distributed in the hope that it will be useful,
** but WITHOUT ANY WARRANTY; without even the implied warranty of
** MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
** Lesser General Public License for more details.
**
** You should have received a copy of the GNU Lesser General Public
** License along with this library; if not, write to the Free Software
** Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
**
*/

package org.openrtk.idl.epprtk.registrar;


/**
 * Class that contains the elements used to represent the registrar info
 * response from the EPP server.</p>
 * Note usually instantiated by the RTK user, but rather by EPPRegistrarInfo
 * and retrieved using that class' getResponseData() method.</p>
 * $Header: /cvsroot/epp-rtk/epp-rtk/java/src/org/openrtk/idl/epprtk/registrar/epp_RegistrarInfoRsp.java,v 1.0 2013/08/19 Ethan Exp $<br>
 * $Revision: 1.0 $<br>
 * $Date: 2013/08/19 $<br>
 * @see com.tucows.oxrs.epprtk.rtk.xml.EPPRegistrarInfo
 * @see org.openrtk.idl.epprtk.registrar.epp_RegistrarInfoReq
 */
public class epp_RegistrarInfoRsp implements org.omg.CORBA.portable.IDLEntity
{
  /**
   * The common and generic response element.
   * @see #getRsp()
   */
  public org.openrtk.idl.epprtk.epp_Response m_rsp = null;
  /**
   * The id of the registrar object in the registry.
   * @see #setId(String)
   * @see #getId()
   */
  public String m_id = null;
  /**
   * The repository object identifier associated with the registrar object.
   * @see #setRoid(String)
   * @see #getRoid()
   */
  public String m_roid = null;
  /**
   * The repository object identifier associated with the registrar object.
   * @see #setUser(String)
   * @see #getUser()
   */
  public String m_user = null;
  /**
   * The guid associated with the registrar object.
   * @see #setGuid(int)
   * @see #getGuid()
   */
  public int m_guid = 0;
  /**
   * The contact_roid associated with the registrar object.
   * @see #setContactRoid(String)
   * @see #getContactRoid()
   */
  public String m_contact_roid = null;
  /**
   * The array of contacts associated with the registrar object.
   * @see #setContacts(org.openrtk.idl.epprtk.domain.epp_DomainContact[])
   * @see #getContacts()
   */
  public org.openrtk.idl.epprtk.domain.epp_DomainContact m_contacts[] = null;
  /**
   * The url associated with the registrar object.
   * @see #setUrl(String)
   * @see #getUrl();
   */
  public String m_url = null;
  /**
   * The identifier of the client that created the registrar object.
   * @see #setCreatedBy(String)
   * @see #getCreatedBy()
   */
  public String m_created_by = null;
  /**
   * The creation date of the registrar object.
   * @see #setCreatedDate(String)
   * @see #getCreatedDate()
   */
  public String m_created_date = null;
  /**
   * The identifier of the client that last updated the registrar object.
   * @see #setUpdatedBy(String)
   * @see #getUpdatedBy()
   */
  public String m_updated_by = null;
  /**
   * The most recent modification date of the registrar object.
   * @see #setUpdatedDate(String)
   * @see #getUpdatedDate()
   */
  public String m_updated_date = null;
  /**
   * The status of this registrar
   * @see #setStatus(String)
   * @see #getStatus()
   */
  public String m_status = null;
  /**
   * The email of this registrar
   * @see #setEmail(String)
   * @see #getEmail()
   */
  public String m_email = null;
  /**
   * The perfolios of this registrar
   * @see #setPorfolios(org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio)
   * @see #getPorfolios()
   */
  public org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio m_portfolios[] = null;
  /**
   * The category of this registrar object
   * @see #setCategory(String)
   * @see #getCategory()
   */
  public String m_category = null;
  /**
   * The group lead role of the registrar object
   * @see #setGroupLeadRole(org.openrtk.idl.epprtk.domain.epp_DomainContact)
   * @see #getGroupLeadRole()
   */
  public org.openrtk.idl.epprtk.domain.epp_DomainContact m_groupLeadRole = null;
  /**
   * Empty constructor
   */
  public epp_RegistrarInfoRsp ()
  {
  } // ctor

  /**
   * The constructor with initializing variables.
   * @param _m_rsp The common and generic response element
   * @param _m_id The id of the registrar in the registry
   * @param _m_roid The repository object identifier associated with the registrar object
   * @param _m_user The user associated with the registrar object
   * @param _m_guid The guid associated with the registrar object
   * @param _m_contact_roid The contact roid associated with the registrar object
   * @param _m_contacts The array of contacts associated with the registrar object
   * @param _m_url The url associated with the registrar object
   * @param _m_created_by The identifier of the client that created the registrar object
   * @param _m_created_date The creation date of the registrar object
   * @param _m_updated_by The identifier of the client that last updated the registrar object
   * @param _m_updated_date The most recent modification date of the registrar object
   * @param _m_status The status of the registrar object
   * @param _m_email The email of the registrar object
   * @param _m_portfolios The portfolios fo the registrar object 
   * @param _m_category The category of the registrar object
   * @param _m_groupLeadRole The group lead role of the registrar object
   */
  public epp_RegistrarInfoRsp (org.openrtk.idl.epprtk.epp_Response _m_rsp, String _m_id, String _m_roid, String _m_user, int _m_guid, String _m_contact_roid, org.openrtk.idl.epprtk.domain.epp_DomainContact[] _m_contacts, String _m_url, String _m_created_by, String _m_created_date, String _m_updated_by, String _m_updated_date, String _m_status, String _m_email, org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio[] _m_portfolios, String _m_category, org.openrtk.idl.epprtk.domain.epp_DomainContact _m_groupLeadRole)
  {
    m_rsp = _m_rsp;
    m_id = _m_id;
    m_roid = _m_roid;
    m_user = _m_user;
    m_guid = _m_guid;
    m_contact_roid = _m_contact_roid;
    m_contacts = _m_contacts;
    m_url = _m_url;
    m_created_by = _m_created_by;
    m_created_date = _m_created_date;
    m_updated_by = _m_updated_by;
    m_updated_date = _m_updated_date;
    m_status = _m_status;
    m_email = _m_email;
    m_portfolios = _m_portfolios;
    m_category = _m_category;
    m_groupLeadRole = _m_groupLeadRole;
  } // ctor

  /**
   * Accessor method for the common and generic response element.
   * @param value The new value for the response element
   * @see #m_rsp
   */
  public void setRsp(org.openrtk.idl.epprtk.epp_Response value) { m_rsp = value; }
  /**
   * Accessor method for the common and generic response element.
   * @return The value for the response element
   * @see #m_rsp
   */
  public org.openrtk.idl.epprtk.epp_Response getRsp() { return m_rsp; }
  /**
   * Accessor method for the registrar identification object in the registry
   * @param value The registrar name
   * @see #m_id
   */
  public void setId(String value) { m_id = value; }
  /**
   * Accessor method for the registrar identification object in the registry
   * @return The registrar name
   * @see #m_id
   */
  public String getId() { return m_id; }

  /**
   * Accessor method for the repository object identifier associated with the registrar object
   * @param value The registrar repository object identifier
   * @see #m_roid
   */
  public void setRoid(String value) { m_roid = value; }
  /**
   * Accessor method for the repository object identifier associated with the registrar object
   * @return The registrar repository object identifier
   * @see #m_roid
   */
  public String getRoid() { return m_roid; }
  /**
   * Accessor method for the repository user associated with the registrar object
   * @param value The user of the registrar
   * @see #m_user
   */
  public void setUser(String value) { m_user = value; }
  /**
   * Accessor method for the repository user associated with the registrar object
   * @return The user of the registrar
   * @see #m_user
   */
  public String getUser() { return m_user; }
  /**
   * Accessor method for the registrar guid associated with the registrar object
   * @param value Guid of the registrar
   * @see #m_guid
   */
  public void setGuid(int value) { m_guid = value; }
  /**
   * Accessor method for the registrar guid associated with the registrar object
   * @return The guid of the registrar
   * @see #m_guid
   */
  public int getGuid() { return m_guid; }
  /**
   * Accessor method for contact roid associated with the registrar object
   * @param value The contact roid of the registrar
   * @see #m_contact_roid
   */
  public void setContactRoid(String value) { m_contact_roid = value; }
  /**
   * Accessor method for contact roid associated with the registrar object
   * @return The contact roid of the registrar
   * @see #m_contact_roid
   */
  public String getContactRoid() { return m_contact_roid; }
  /**
   * Accessor method for the array of contacts associated with the registrar object
   * @param value The array of registrar contacts
   * @see #m_contacts
   */
  public void setContacts(org.openrtk.idl.epprtk.domain.epp_DomainContact[] value) { m_contacts = value; }
  /**
   * Accessor method for the array of contacts associated with the registrar object
   * @return The array of registrar contacts
   * @see #m_contacts
   */
  public org.openrtk.idl.epprtk.domain.epp_DomainContact[] getContacts() { return m_contacts; }
  /**
   * Accessor method for the url associated with the registrar object
   * @param value The url of registrar
   * @see #m_url
   */
  public void setUrl(String value) { m_url = value; }
  /**
   * Accessor method for the url associated with the registrar object
   * @return The url of registrar
   * @see #m_url
   */
  public String getUrl() {return m_url; }
  /**
   * Accessor method for the identifier of the client that created the registrar object
   * @param value The identifier of the client that created the registrar object
   * @see #m_created_by
   */
  public void setCreatedBy(String value) { m_created_by = value; }
  /**
   * Accessor method for the identifier of the client that created the registrar object
   * @return The identifier of the client that created the registrar object
   * @see #m_created_by
   */
  public String getCreatedBy() { return m_created_by; }

  /**
   * Accessor method for the creation date of the registrar object
   * @param value The registrar creation date
   * @see #m_created_date
   */
  public void setCreatedDate(String value) { m_created_date = value; }
  /**
   * Accessor method for the creation date of the registrar object
   * @return The registrar creation date
   * @see #m_created_date
   */
  public String getCreatedDate() { return m_created_date; }

  /**
   * Accessor method for the identifier of the client that last updated the registrar object
   * @param value The identifier of the client that last updated the registrar object
   * @see #m_updated_by
   */
  public void setUpdatedBy(String value) { m_updated_by = value; }
  /**
   * Accessor method for the identifier of the client that last updated the registrar object
   * @return The identifier of the client that last updated the registrar object
   * @see #m_updated_by
   */
  public String getUpdatedBy() { return m_updated_by; }

  /**
   * Accessor method for the most recent modification date of the registrar object
   * @param value The most recent modification date
   * @see #m_updated_date
   */
  public void setUpdatedDate(String value) { m_updated_date = value; }
  /**
   * Accessor method for the most recent modification date of the registrar object
   * @return The most recent modification date
   * @see #m_updated_date
   */
  public String getUpdatedDate() { return m_updated_date; }
  /**
   * Accessor method for the status of the registrar object
   * @param value The status of the registrar object
   * @see #m_status
   */
  public void setStatus(String value) { m_status = value; }
  /**
   * Accessor method for the status of the registrar object 
   * @return The status of the registrar object
   * @see #m_status
   */
  public String getStatus() { return m_status; }
  /**
   * Accessor method for the email of the registrar object
   * @param value The email of the registrar object
   * @see #m_email
   */
  public void setEmail(String value) { m_email = value; }
  /**
   * Accessor method for the email of the registrar object
   * @return The email of the registrar object
   * @see #m_email
   */
  public String getEmail() { return m_email; }
  /**
   * Accessor method for portfolios of the registrar object
   * @param value The portfolios of the registrar object
   * @see #m_portfolios
   */
  public void setPortfolios(org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio[] value) { m_portfolios = value; }
  /**
   * Accessor method for portfolios of the registrar object
   * @return The portfolios of the registrar object
   * @see #m_portfolios
   */
  public org.openrtk.idl.epprtk.registrar.epp_RegistrarPortfolio[] getPortfolios() { return m_portfolios; }
  /**
   * Accessor method for the category of the registrar object
   * @param value The category of the registrar object
   * @see #m_category
   */
  public void setCategory(String value) { m_category = value; }
  /**
   * Accessor method for the category of the registrar object
   * @return The category of the registrar object
   * @see #m_category
   */
  public String getCategory() { return m_category; }
  /**
   * Accessor method for group lead role of the registrar object
   * @param value The group lead role of the registrar object
   * @see #m_groupLeadRole
   */
  public void setGroupLeadRole (org.openrtk.idl.epprtk.domain.epp_DomainContact value) { m_groupLeadRole = value; }
  /**
   * Accessor method for group lead role of the registrar object
   * @return The group lead role of the registrar object
   * @see #m_groupLeadRole
   */
  public org.openrtk.idl.epprtk.domain.epp_DomainContact getGroupLeadRole() { return m_groupLeadRole; }
  /**
   * Converts this class into a string.
   * Typically used to view the object in debug output.
   * @return The string representation of this object instance
   */
  public String toString() { return this.getClass().getName() + ": { m_rsp ["+m_rsp+"] m_id ["+m_id+"] m_roid ["+m_roid+"] m_user ["+m_user+"] m_guid ["+ m_guid +"] m_contact_roid [" + m_contact_roid +"] m_contacts ["+(m_contacts != null ? java.util.Arrays.asList(m_contacts) : null)+"] m_url [" +m_url +"] m_created_by ["+m_created_by+"] m_created_date ["+m_created_date+"] m_updated_by ["+m_updated_by+"] m_updated_date ["+m_updated_date+"] m_status ["+m_status+"] m_email ["+m_email+"] m_portfolios ["+(m_portfolios != null ? java.util.Arrays.asList(m_portfolios) : null)+"] m_category ["+m_category+"] m_groupLeadRole ["+m_groupLeadRole+"] }"; }

} // class epp_RegistrarInfoRsp
