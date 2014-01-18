package com.tucows.oxrs.epprtk.rtk.example;

import org.openrtk.idl.epprtk.epp_Command;
import org.openrtk.idl.epprtk.epp_Exception;
import org.openrtk.idl.epprtk.epp_Greeting;
import org.openrtk.idl.epprtk.epp_Result;
import org.openrtk.idl.epprtk.epp_XMLException;
import org.openrtk.idl.epprtk.registrar.epp_RegistrarInfoReq;

import com.tucows.oxrs.epprtk.rtk.EPPClient;
import com.tucows.oxrs.epprtk.rtk.xml.EPPRegistrarInfo;

public class RegistrarInfoExample
{
    private static String USAGE = "Usage: com.tucows.oxrs.epprtk.rtk.example.RegistrarInfoExample <epp host> <epp port> <client> <password> <registrar id>";

    public static void main(String args[])
    {
        try
        {
            if (args.length < 5)
            {
                System.err.println(USAGE);
                System.exit(1);
            }

            String host = args[0];
            int port = Integer.parseInt(args[1]);
            String user = args[2];
            String password = args[3];
            String registrarID = args[4];

            System.out.println("          HOST: " + host);
            System.out.println("          PORT: " + port);
            System.out.println("        CLIENT: " + user);
            System.out.println("  REGISTRAR ID: " + registrarID);

            EPPClient client = new EPPClient(host, port, user, password);
            client.setLang("en");

            System.out.println("Connecting to EPP Server...");
            epp_Greeting greeting = client.connectAndGetGreeting();

            System.out.println("  EPP-Server ID:           " + greeting.getServerId());
            System.out.println("  EPP-Server current date: " + greeting.getServerDate());
            System.out.println("  EPP-Server services:     " + greeting.getSvcMenu());
            System.out.println();

            String client_trid = getClientTrid(user);

            System.out.println("Logging in as \"" + user + "\"...");
            client.login(client_trid);
            System.out.println();
            
            epp_RegistrarInfoReq registrar_info_request = new epp_RegistrarInfoReq();
            epp_Command command_data = new epp_Command();
            command_data.setClientTrid(getClientTrid(client.getEPPClientID()));
            registrar_info_request.setCmd(command_data);
            registrar_info_request.setId(registrarID);
            EPPRegistrarInfo registrar_info = new EPPRegistrarInfo();
            registrar_info.setRequestData(registrar_info_request);
            System.out.println("tring to retrieve registrar infomation for : " + registrarID);
            try{
            registrar_info = (EPPRegistrarInfo) client.processAction(registrar_info);
            System.out.println("registrar Id:               " + registrar_info.getResponseData().getId());
            System.out.println("registrar Roid:             " + registrar_info.getResponseData().getRoid());
            System.out.println("registrar Guid:             " + registrar_info.getResponseData().getGuid());
            System.out.println("registrar user:             " + registrar_info.getResponseData().getUser());
            System.out.println("registrar created by:       " + registrar_info.getResponseData().getCreatedBy());
            System.out.println("registrar created date:     " + registrar_info.getResponseData().getCreatedDate());
            System.out.println("registrar updated by:       " + registrar_info.getResponseData().getUpdatedBy());
            System.out.println("registrar updated date:     " + registrar_info.getResponseData().getUpdatedDate());
            System.out.println("registrar contact roid:     " + registrar_info.getResponseData().getContactRoid());
            System.out.println("registrar status:           " + registrar_info.getResponseData().getStatus());
            System.out.println("registrar category:         " + registrar_info.getResponseData().getCategory());
            System.out.println("registrar email:            " + registrar_info.getResponseData().getEmail());
            System.out.println("registrar Url:              " + registrar_info.getResponseData().getUrl());
            System.out.println("registrar group lead role:  ");
            System.out.println("     type:   " + registrar_info.getResponseData().getGroupLeadRole().getType());
            System.out.println("     id:     " + registrar_info.getResponseData().getGroupLeadRole().getId());
            
            System.out.println("registrar contacts: ");
           for(int i = 0; i < registrar_info.getResponseData().getContacts().length; i++){
               System.out.println("     " + registrar_info.getResponseData().getContacts()[i].getType() + " : " + registrar_info.getResponseData().getContacts()[i].getId());
           }
            
           System.out.println("registrar portfolios: ");
           for(int i = 0; i < registrar_info.getResponseData().getPortfolios().length; i++){
               System.out.println("     name:       " + registrar_info.getResponseData().getPortfolios()[i].getName());
               System.out.println("     balance:    " + registrar_info.getResponseData().getPortfolios()[i].getBalance());
               System.out.println("     threshold:  " + registrar_info.getResponseData().getPortfolios()[i].getThreshold());
           }
            
            }catch(Exception e){
                if(e instanceof epp_Exception){
                    if(((epp_Exception) e).getDetails()[0].getCode() == 2303) {
                        System.out.println(registrarID + " does not exist in registry.");
                    }
                }
                else {
                    e.printStackTrace();
                }
            }
            
            System.out.println();

            // All done with this session, so let's log out...
            System.out.println("Logging out from the EPP Server...");
            client.logout(getClientTrid(user));
            System.out.println();

            // ... and disconnect
            System.out.println("Disconnecting from the EPP Server...");
            client.disconnect();
            System.out.println();
        }
        catch (epp_XMLException xcp)
        {
            System.err.println("ERROR: (epp_XMLException): " + xcp.getErrorMessage());
        }
        catch (epp_Exception xcp)
        {
            System.err.println("ERROR (epp_Exception):");
            epp_Result[] results = xcp.getDetails();
            System.err.println("  Result: [" + results[0] + "]");
        }
        catch (Exception xcp)
        {
            System.err.println("ERROR: Exception [" + xcp.getClass().getName() + "] [" + xcp.getMessage()
                    + "]");
            xcp.printStackTrace();
        }
    }

    private static String getClientTrid(String epp_client_id)
    {
        return "ABC:" + epp_client_id + ":" + System.currentTimeMillis();
    }
}
