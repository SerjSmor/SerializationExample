package com.example.sergey.serializationexample;

import java.io.Serializable;

/**
 * Created by sergey on 6/14/16.
 */
public class Person implements Serializable //Added implements Serializable
{
    String name="";
    private String number="";
    private String address="";
    private static final long serialVersionUID = 46543445;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getAddress()
    {
        return address;
    }
}