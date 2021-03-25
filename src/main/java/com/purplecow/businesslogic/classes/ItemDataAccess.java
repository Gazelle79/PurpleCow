package com.purplecow.businesslogic.classes;

import java.util.ArrayList;
import java.util.UUID;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
@Service
public class ItemDataAccess
{
    private ArrayList<Item> itemList = null;

    /*
    * Constructor.
    * */
    public ItemDataAccess()
    {
        this.itemList = new ArrayList<Item>();
        this.createItems();
    }

    /*
    Get all the items in the list.
    */
    public ArrayList<Item> getItems()
    {
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
    Clear the internal set of items.
    */
    public void deleteItems()
    {
        this.itemList.clear();
    }

    /*
    Add the item to the list.
    */
    public void addItems(ArrayList<Item> itemsToAdd)
    {
        for(Item itemToAdd : itemsToAdd)
        {
            if(itemToAdd != null)
            {
                this.itemList.add(itemToAdd);
            }
        }
    }

    /*
    Add the item to the list.
    */
    public void addItem(Item itemToAdd)
    {
        if(itemToAdd != null)
        {
            this.itemList.add(itemToAdd);
        }
    }


    /*
    Return an item with this ID.
    */
    public Item getItem(UUID itemId)
    {
        Item itemToReturn = null;
        for(Item thisItem : itemList)
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
    Update an item.
     */
    public void updateItem(Item updatedItem)
    {
        for(Item itemToUpdate : this.itemList)
        {
            if(itemToUpdate.getId().equals(updatedItem.getId()))
            {
                this.itemList.set(this.itemList.indexOf(itemToUpdate), updatedItem);
            }
        }
    }

    /*
    Update many items.
     */
    public void updateItems(ArrayList<Item> updatedItems)
    {
        for(Item itemToUpdate : this.itemList)
        {
            for(Item updatedItem: updatedItems)
            {
                if (itemToUpdate.getId().equals(updatedItem.getId()))
                {
                    this.itemList.set(this.itemList.indexOf(itemToUpdate), updatedItem);
                }
            }
        }
    }

    /*
    Delete an item with this id.
    */
    public void deleteItem(UUID itemId)
    {
        for(Item thisItem : itemList)
        {
            if(thisItem.getId().equals(itemId))
            {
                itemList.remove(thisItem);
            }
        }
    }

    /*
    Update many items.
    */
    public void deleteItems(ArrayList<Item> itemsToDelete)
    {
        for(Item thisItem : itemList)
        {
            for(Item itemToDelete: itemsToDelete)
            {
                if (thisItem.getId().equals(itemToDelete.getId()))
                {
                    itemList.remove(itemToDelete);
                }
            }
        }
    }


    private void createItems()
    {
        Item itemA = new Item("Frederick");
        Item itemB = new Item("Robert");
        Item itemC = new Item("Matthew");
        Item itemD = new Item("Shakirah");
        Item itemE = new Item("Claudia");
        Item itemF = new Item("Stephanie");

        this.itemList.add(itemA);
        this.itemList.add(itemB);
        this.itemList.add(itemC);
        this.itemList.add(itemD);
        this.itemList.add(itemE);
        this.itemList.add(itemF);

    }

}
