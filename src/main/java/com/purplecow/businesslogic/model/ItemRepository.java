package com.purplecow.businesslogic.model;

import java.util.*;

import com.purplecow.businesslogic.interfaces.IItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org. springframework.cache.annotation.Cacheable;

@Service
public class ItemRepository
{
    // Also, since you're using the DB, this list isn't really necessary
    private ArrayList<Item> itemList;
    private IItemRepository itemRepository;

    /*
    * Constructor.
    * */
    public ItemRepository(IItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
        this.itemList = new ArrayList<>();
        this.makeItems();
    }

    /*
    Get all the items in the list.
    */
    @Cacheable("all-items-cache")
    public List<Item> getItems()
    {
        List<Item> itemList = new ArrayList<>();
        itemRepository.findAll().forEach(itemList::add);
        return itemList;
    }

    /*
    Set the internal list of items to "itemsToSet".
    */
    public void setItems(ArrayList<Item> itemsToSet)
    {
        this.itemList = itemsToSet;
        this.itemRepository.saveAll(itemsToSet);
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
    @Cacheable(value="item-cache", key="'item-cache-' + #item.id")
    public Item getItem(UUID id)
    {
        return itemRepository.findById(id).orElse(null);
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
        for(int i=0; i<1000; i++)
        {
            Item thisItem = new Item();
            thisItem.setName("Item_" + i);
            this.itemList.add(thisItem);
        }
        itemRepository.saveAll(itemList);

    }


}
