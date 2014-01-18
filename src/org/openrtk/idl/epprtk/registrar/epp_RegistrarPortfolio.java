package org.openrtk.idl.epprtk.registrar;

public class epp_RegistrarPortfolio implements org.omg.CORBA.portable.IDLEntity
{
    private String m_name;
    private float m_balance;
    private float m_threshold;
    
    public epp_RegistrarPortfolio(){
    }
    
    public epp_RegistrarPortfolio(String name, float balance, float threshold)
    {
        super();
        this.m_name = name;
        this.m_balance = balance;
        this.m_threshold = threshold;
    }


    public String getName()
    {
        return m_name;
    }


    public void setName(String name)
    {
        this.m_name = name;
    }


    public float getBalance()
    {
        return m_balance;
    }


    public void setBalance(float balance)
    {
        this.m_balance = balance;
    }


    public float getThreshold()
    {
        return m_threshold;
    }


    public void setThreshold(float threshold)
    {
        this.m_threshold = threshold;
    }
    
    public String toString() { return this.getClass().getName() + ": { m_name ["+m_name+"] m_balance ["+m_balance+"] m_threshold ["+m_threshold+"] }"; }
}
