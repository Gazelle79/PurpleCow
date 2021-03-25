package com.purplecow.businesslogic.controllers;

import com.purplecow.businesslogic.classes.Item;
import com.purplecow.businesslogic.classes.ItemDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Return an item with this ID.
    */
    @RequestMapping(method=RequestMethod.GET, value= "/item/{id}", produces = "application/json")
    public Item getItem(@PathVariable UUID id)
    {
        return this.dataAccess.getItem(id);
    }

    /*
    Set "ItemsToSet" to an internal list of items.
    */
    @RequestMapping(method=RequestMethod.PUT, value = "/item", produces = "application/json")
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.dataAccess.setItems(itemsToSet);
    }

    /*
    Update an item with this id.
     */
    @RequestMapping(method=RequestMethod.PUT, value = "/item/{id}", produces = "application/json")
    public void updateItem(@PathVariable UUID id, @RequestBody Item updatedItem)
    {
        this.dataAccess.updateItem(updatedItem);
    }

    /*
    Update many items.
     */
    /*
    @RequestMapping(method=RequestMethod.PUT, value = "/item", produces = "application/json")
    public void updateItems(@RequestBody ArrayList<Item> updatedItems)
    {
        this.dataAccess.updateItems(updatedItems);
    }
    */

    /*
    Delete an item with this id.
    */
    @RequestMapping(method=RequestMethod.DELETE, value = "/item/{id}")
    public void deleteItem(@PathVariable UUID id)
    {
        this.dataAccess.deleteItem(id);
    }

    /*
    Delete all items in the specified list.
    */
    /*
    @RequestMapping(method=RequestMethod.DELETE, value = "/item/{id}")
    public void deleteItems(ArrayList<Item> itemsToDelete)
    {
        this.dataAccess.deleteItems(itemsToDelete);
    }
    */

    /*
    Clear the internal set of items.
    */
    @RequestMapping(method=RequestMethod.DELETE, value = "/item", produces = "application/json")
    public void deleteItems()
    {
        this.dataAccess.deleteItems();
    }


    /*
    Add an Item.
    */
    @RequestMapping(method=RequestMethod.POST, value = "/item", produces = "application/json")
    public void addItem(@RequestBody Item itemToAdd)
    {
        this.dataAccess.addItem(itemToAdd);
    }

    /*
    Add many Items.
    */
    /*
    @RequestMapping(method=RequestMethod.POST, value = "/item", produces = "application/json")
    public void addItems(@RequestBody ArrayList<Item> itemsToAdd)
    {
        this.dataAccess.addItems(itemsToAdd);
    }

    */


}
