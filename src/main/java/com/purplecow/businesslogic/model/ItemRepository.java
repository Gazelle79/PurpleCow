package com.purplecow.businesslogic.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.purplecow.businesslogic.interfaces.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemRepository
{
    private ArrayList<Item> itemList = null;

    @Autowired
    private IItemRepository itemRepository = null;

    /*
    * Constructor.
    * */
    public ItemRepository()
    {
        this.itemList = new ArrayList<Item>();
        this.makeItems();
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
    Set the internal list of items to "itemsToSet".
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
    public Item getItem(UUID id)
    {
        return itemRepository.findById(id).get();
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
    public void deleteItem(UUID id)
    {
        itemRepository.deleteById(id);
    }

    /*
    Update many items.
    */
    public void deleteItems(ArrayList<Item> itemsToDelete)
    {
        itemRepository.deleteAll(itemsToDelete);
    }

    /*
    Clear all items in the repository.
    */
    public void clearItems()
    {
        this.itemList.clear();
        itemRepository.deleteAll();
    }

    /*
    Something went wrong.
    */
    public void error()
    {
        System.out.println("It's wrong!");
    }


    private void makeItems()
    {
        for(int i=0; i<3; i++)
        {
            Item thisItem = new Item();
            thisItem.setName("Item_" + i);
            this.itemList.add(thisItem);
        }
    }


}
