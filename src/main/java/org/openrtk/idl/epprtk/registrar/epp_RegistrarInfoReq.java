/*
**
** EPP RTK Java
** Copyright (C) 2002, Tucows, Inc.
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
 * Class that contains the elements necessary to retrieve detailed
 * information associated with a domain in the registry.</p>
 * $Header: /cvsroot/epp-rtk/epp-rtk/java/src/org/openrtk/idl/epprtk/domain/epp_DomainInfoReq.java,v 1.1 2004/12/07 15:27:50 ewang2004 Exp $<br>
 * $Revision: 1.1 $<br>
 * $Date: 2004/12/07 15:27:50 $<br>
 * @see com.tucows.oxrs.epprtk.rtk.xml.EPPDomainInfo
 * @see org.openrtk.idl.epprtk.domain.epp_DomainInfoRsp
 */
public class epp_RegistrarInfoReq implements org.omg.CORBA.portable.IDLEntity
{
  /**
   * The common and generic command element.
   * @see #setCmd(org.openrtk.idl.epprtk.epp_Command)
   * @see #getCmd()
   */
  public org.openrtk.idl.epprtk.epp_Command m_cmd = null;
  /**
   * The name of the domain object to be queried.
   * @see #setId(String)
   * @see #getId()
   */
  public String m_id = null;

  /**
   * Empty constructor
   */
  public epp_RegistrarInfoReq ()
  {
  } // ctor

  /**
   * The constructor with initializing variables.
   * The hosts type parameter tells the server how much
   * host information to return in the response.
   * @param _m_cmd The common and generic command element
   * @param _m_id The name of the domain object to be queried
   * @param _m_hosts_type The type of hosts of the domain object to be queried
   */
  public epp_RegistrarInfoReq (org.openrtk.idl.epprtk.epp_Command _m_cmd, String _m_id)
  {
    m_cmd = _m_cmd;
    m_id = _m_id;
  } // ctor


  /**
   * Accessor method for the common and generic command element
   * @param value The command element
   * @see #m_cmd
   */
  public void setCmd(org.openrtk.idl.epprtk.epp_Command value) { m_cmd = value; }
  /**
   * Accessor method for the common and generic command element
   * @return The command element
   * @see #m_cmd
   */
  public org.openrtk.idl.epprtk.epp_Command getCmd() { return m_cmd; }

  /**
   * Accessor method for the name of the domain object to be queried
   * @param value The domain name
   * @see #m_id
   */
  public void setId(String value) { m_id = value; }
  /**
   * Accessor method for the name of the domain object to be queried
   * @return The domain name
   * @see #m_id
   */
  public String getId() { return m_id; }


  /**
   * Converts this class into a string.
   * Typically used to view the object in debug output.
   * @return The string representation of this object instance
   */
  public String toString() { return this.getClass().getName() + ": { m_cmd ["+m_cmd+"] m_id ["+m_id+"] }"; }

} // class epp_DomainInfoReq
