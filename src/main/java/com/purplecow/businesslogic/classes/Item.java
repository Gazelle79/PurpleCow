package com.purplecow.businesslogic.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.*;

@Entity
public class Item
{
    @Id
    private UUID id = null;
    private String name = null;

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

    @Override
    public String toString()
    {
        return "Item [ id="
                + this.id.toString() + ", name="
                + this.name + " ]";
    }



}
