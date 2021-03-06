package com.purplecow.businesslogic.model;

import javax.persistence.Entity;
import javax.persistence.Id;  //Tell JPA this is the Primary Key

import java.util.*;

@Entity
public class Item
{
    @Id
    private UUID id = null;
    private String name = "No_Name";

    //Getters
    public UUID getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }


    public Item(String itemName)
    {
        super();
        this.id = UUID.randomUUID();
        this.name = itemName;
    }

    public Item()
    {
        super();
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString()
    {
        return "Item [ id="
                + this.id.toString() + ", name="
                + this.name + " ]";
    }

}
