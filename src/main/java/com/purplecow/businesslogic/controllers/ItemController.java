package com.purplecow.businesslogic.controllers;

import com.purplecow.businesslogic.classes.Item;
import com.purplecow.businesslogic.classes.ItemCollection;
import com.purplecow.businesslogic.classes.ItemDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;

/*
* This class implements the functionality for REST using
* HTTP GET, POST, PUT, etc.
* */

@RestController
//@RequestMapping(path = "/item")
public class ItemController
{
    @Autowired
    private ItemDataAccess dataAccess = new ItemDataAccess();

    /*
    Get all the items in the list.
    */
    //@GetMapping(path = "/", produces = "application/json")
    @RequestMapping(method=RequestMethod.GET, value = "/item", produces = "application/json")
    public ArrayList<Item> getItems()
    {
        return this.dataAccess.getItems();
    }

    /*
    Set "ItemsToSet" to an internal list of items.
    */
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.dataAccess.setItems(itemsToSet);
    }

    /*
    Clear the internal set of items.
    */
    public void deleteItems()
    {
        this.dataAccess.deleteItems();
    }


    /*
    Add an Item
    */
    @RequestMapping(method=RequestMethod.POST, value = "/item", produces = "application/json")
    public void addItem(@RequestBody Item itemToAdd)
    {
        this.dataAccess.addItem(itemToAdd);
    }

    /*
    Return an item with this ID.
    */
    @RequestMapping(method=RequestMethod.GET, path = "/item/{id}", produces = "application/json")
    public Item getItem(@PathVariable UUID id)
    {
        Item itemToReturn = null;
        ArrayList<Item> availableItems = this.dataAccess.getItems();
        for(Item thisItem : availableItems)
        {
            if(thisItem.getId().equals(id))
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
    public boolean updateItem(UUID itemId, String newItemName)
    {
        boolean wasItemUpdated = false;
        ArrayList<Item> availableItems = this.dataAccess.getItems();
        for(Item thisItem : availableItems)
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
    public boolean deleteItem(UUID itemId)
    {
        boolean wasItemDeleted = false;
        ArrayList<Item> availableItems = this.dataAccess.getItems();
        for(Item thisItem : availableItems)
        {
            if(thisItem.getId().equals(itemId))
            {
                availableItems.remove(thisItem);
                wasItemDeleted = true;
            }
            // wasItemDeleted stays false if item is never found.
        }
        return wasItemDeleted;
    }


}
