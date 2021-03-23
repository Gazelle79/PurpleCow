package com.purplecow.businesslogic.controllers;

import com.purplecow.businesslogic.classes.Item;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@RestController
public class ItemController
{
    private ArrayList<Item> theseItems = new ArrayList<Item>();

    @RequestMapping("/")
    public String index()
    {
        String hello = "\n\n Greetings from Spring Boot! \n\n";
        return hello;
    }

    /*
    Get all the items in the list.
    */
    //@RequestMapping("/item")
    public ArrayList<Item> getItems()
    {
        return theseItems;
    }

    /*
    Set "ItemsToSet" to an internal list of items.
    */
    //@RequestMapping("/item")
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.theseItems = itemsToSet;
    }

    /*
    Clear the internal set of items.
    */
    //@RequestMapping("/item")
    public void deleteItems()
    {
        this.theseItems.clear();
    }


    /*
    Return an item with this ID.
    */
    //@RequestMapping("/item")
    public Item getItem(UUID itemId)
    {
        Item itemToReturn = null;
        for(Item thisItem : theseItems)
        {
            if(thisItem.getId().equals(itemId))
            {
                itemToReturn = thisItem;
            }
            //returns a null item if not found.
        }
        return itemToReturn;
    }

    /*
    Update an item with this id. Return true if found & updated. Otherwise, false.
     */
    //@RequestMapping("/item")
    public boolean updateItem(UUID itemId, String newItemName)
    {
        boolean wasItemUpdated = false;
        for(Item thisItem : theseItems)
        {
            if(thisItem.getId().equals(itemId))
            {
                thisItem.setName(newItemName);
                wasItemUpdated = true;
            }
            // wasItemUpdated stays false if item is never found.
        }
        return wasItemUpdated;
    }

    /*
    Delete an item with this id. Return true if found & deleted. Otherwise, false.
    */
    //@RequestMapping("/item")
    public boolean deleteItem(UUID itemId)
    {
        boolean wasItemDeleted = false;
        for(Item thisItem : theseItems)
        {
            if(thisItem.getId().equals(itemId))
            {
                theseItems.remove(thisItem);
                wasItemDeleted = true;
            }
            // wasItemDeleted stays false if item is never found.
        }
        return wasItemDeleted;
    }


}
