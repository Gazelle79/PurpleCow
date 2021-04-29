package com.purplecow.businesslogic.controller;

import com.purplecow.businesslogic.model.Item;
import com.purplecow.businesslogic.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;  //Can no longer use web.bind.annotation?

import java.util.*;

/*
* This class implements the functionality for REST using
* HTTP GET, POST, PUT, etc.
* */

@RestController
public class ItemController
{
    @Autowired
    private ItemRepository itemRepository = new ItemRepository();

    /*
    Get all the items in the list.
    */
    @RequestMapping(method=RequestMethod.GET, value = "/item", produces = "application/json")
    public ArrayList<Item> getItems()
    {
        return this.itemRepository.getItems();
    }

    /*
    Return an item with this ID.
    */
    @RequestMapping(method=RequestMethod.GET, value = "/item/{id}", produces = "application/json")
    public Item getItem(@PathVariable (name = "id") UUID id)
    {
        return this.itemRepository.getItem(id);
    }

    /*
    Set "ItemsToSet" to an internal list of items.
    */
    @RequestMapping(method=RequestMethod.PUT, value = "/item", produces = "application/json")
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.itemRepository.setItems(itemsToSet);
    }

    /*
    Update an item with this id.
     */
    @RequestMapping(method=RequestMethod.PUT, value = "/item/{id}", produces = "application/json")
    public void updateItem(@PathVariable (name = "id") UUID id, @RequestBody Item updatedItem)
    {
        this.itemRepository.updateItem(updatedItem);
    }


    /*
    Delete an item with this id.
    */
    @RequestMapping(method=RequestMethod.DELETE, value = "/item/{id}")
    public void deleteItem(@PathVariable (name = "id") UUID id)
    {
        this.itemRepository.deleteItem(id);
    }


    /*
    Clear the internal set of items.
    */
    @RequestMapping(method=RequestMethod.DELETE, value = "/item", produces = "application/json")
    public void clearItems()
    {
        this.itemRepository.clearItems();
    }


    /*
    Add an Item.
    */
    @RequestMapping(method=RequestMethod.POST, value = "/item/{id}", produces = "application/json")
    public void addItem(@RequestBody Item itemToAdd)
    {
        this.itemRepository.addItem(itemToAdd);
    }


    /*
    Error.
    */
    @RequestMapping(method=RequestMethod.TRACE, value = "/error", produces = "application/json")
    public void error(@RequestBody Item itemToAdd)
    {
        this.itemRepository.addItem(itemToAdd);
    }


}
