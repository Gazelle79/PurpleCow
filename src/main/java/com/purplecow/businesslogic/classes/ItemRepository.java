package com.purplecow.businesslogic.classes;

import java.util.ArrayList;
//import java.util.Map;
import java.util.UUID;

import com.purplecow.businesslogic.interfaces.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemRepository
{
    private ArrayList<Item> itemList = null;
    //private Map<Item, Item> itemList = null;

    @Autowired
    private IItemRepository itemRepository = null;

    /*
    * Constructor.
    * */
    public ItemRepository()
    {
        this.itemList = new ArrayList<Item>();

    }

    /*
    Get all the items in the list.
    */
    public ArrayList<Item> getItems()
    {
        itemRepository.findAll().forEach(itemList::add);
        return this.itemList;
    }

    /*
    Set "ItemsToSet" to an internal list of items.
    */
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.itemList = itemsToSet;
    }

    /*
    Add the item to the list.
    */
    public void addItems(ArrayList<Item> itemsToAdd)
    {
        itemRepository.saveAll(itemsToAdd);
    }

    /*
    Add the item to the list.
    */
    public void addItem(Item itemToAdd)
    {
        itemRepository.save(itemToAdd);
    }


    /*
    Return an item with this ID.
    */
    public Item getItem(UUID itemId)
    {
        return itemRepository.findById(itemId).get();
    }

    /*
    Update an item.
     */
    public void updateItem(Item updatedItem)
    {
        itemRepository.save(updatedItem);
    }

    /*
    Update many items.
     */
    public void updateItems(ArrayList<Item> updatedItems)
    {
        itemRepository.saveAll(updatedItems);
    }

    /*
    Delete an item with this id.
    */
    public void deleteItem(UUID itemId)
    {
        itemRepository.deleteById(itemId);
    }

    /*
    Update many items.
    */
    public void deleteItems(ArrayList<Item> itemsToDelete)
    {
        itemRepository.deleteAll(itemsToDelete);
    }

    /*
    Clear the internal set of items.
    */
    public void deleteItems()
    {
        this.itemList.clear();
        itemRepository.deleteAll();
    }



}
