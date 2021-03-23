package com.purplecow.businesslogic.classes;

import java.util.ArrayList;
import java.util.UUID;

public class ItemDataAccess
{
    private ArrayList<Item> itemList = null;

    public ItemDataAccess()
    {
        this.itemList = new ArrayList<Item>();
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
        for(Item thisItem : itemList)
        {
            if(thisItem.getId().equals(updatedItem.getId()))
            {
                thisItem.setName(updatedItem.getName());
            }
        }
    }

    /*
    Update many items.
     */
    public void updateItems(ArrayList<Item> updatedItems)
    {
        for(Item itemToUpdate : itemList)
        {
            for(Item updatedItem: updatedItems)
            {
                if (itemToUpdate.getId().equals(updatedItem.getId()))
                {
                    itemToUpdate.setName(updatedItem.getName());
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


}
