package com.purplecow.businesslogic.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.purplecow.businesslogic.interfaces.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemRepository
{
    // no need to initialize the class members here.
    //  Spring's dependency injection will handle this
    //  at runtime.

    // Also, since you're using the DB, this list isn't really necessary
    private ArrayList<Item> itemList;
    private IItemRepository itemRepository;

    /*
    * Constructor.
    * */
    // NTOE: newer versions of SpringBoot will automatically
    //  autowire your constructor
    public ItemRepository(IItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
        this.itemList = new ArrayList<Item>();
        this.makeItems();
    }

    /*
    Get all the items in the list.
    */
    public List<Item> getItems()
    {
        // by doing this, every time this method is executed, you're
        //  adding all 3 of the items to the list again, so it continues
        //  to grow with each call.
        //itemRepository.findAll().forEach(itemList::add);
        //return this.itemList;
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
        /*
            Optional.get() throws an exception if no value is present,
              so the recommended way is to use one of the other methods
              that allow you to return specific values, handle exceptions, etc.
              Examples:
              itemRepository.findById(id).orElse(null);
              itemRepository.findById(id).orElseGet(nothing -> { return someItem;});

              Another way to handle this would most likely be to create a generic response Object
              that you always return from every call. That object can contain a List<Item> and a String
              with an error message. So if a call fails, you populate the error string and return the response
              object. If it doesn't, you return the Item(s) in the list and return the response object. Either way,
              the return type is always the same for the client.
         */
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
        // You were getting errors because you weren't adding
        //  the items to the DB. This fixed the errors.
        itemRepository.saveAll(itemList);
    }


}
