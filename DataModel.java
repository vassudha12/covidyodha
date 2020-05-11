package com.e.covidyodha_v2;

public class DataModel {

    private int id;
    private String name;
    private String address;
    private int members;
    private int aadhar;
    private int foodpkt;
    private String timestamp;


    DataModel(){}
    DataModel(int id,int members,int aadhar,int foodpkt,String timestamp,String name,String address){
        this.id=id;
        this.aadhar=aadhar;
        this.address=address;
        this.foodpkt=foodpkt;
        this.members=members;
        this.name=name;
        this.timestamp=timestamp;
    }

    public int getId()
    { return this.id;}
    public void setId(int id)
    {this.id=id;}

    public int getMembers()
    {return this.members;}
    public void setMembers(int members)
    {this.members=members;}

    public int getAadhar()
    {return this.aadhar;}
    public void setAadhar(int aadhar)
    {this.aadhar=aadhar;}

    public int getFoodpkt()
    {return this.foodpkt;}
    public void setFoodpkt(int foodpkt)
    {this.foodpkt=foodpkt;}

    public String getTimestamp()
    {return this.timestamp;}
    public void setTimestamp(String timestamp)
    {this.timestamp=timestamp;}

    public String getName()
    {return this.name;}
    public void setName(String name)
    {this.name=name;}

    public String getAddress()
    {return this.address;}
    public void setAddress(String address)
    {this.address = address; }
}
