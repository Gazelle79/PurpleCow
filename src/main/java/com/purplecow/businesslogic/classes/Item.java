package com.purplecow.businesslogic.classes;

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
        this.id = UUID.randomUUID();
        this.name = itemName;
    }

    public Item()
    {
        new Item(name);
    }

    @Override
    public String toString()
    {
        return "Item [ id="
                + this.id.toString() + ", name="
                + this.name + " ]";
    }



}
