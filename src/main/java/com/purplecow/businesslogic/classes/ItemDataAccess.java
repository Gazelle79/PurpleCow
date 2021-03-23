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
    public boolean addItems(ArrayList<Item> itemsToAdd)
    {
        boolean wereItemsAdded = false;
        for(Item itemToAdd : itemsToAdd)
        {
            if(itemToAdd != null)
            {
                this.itemList.add(itemToAdd);
                wereItemsAdded = true;
            }
            else
            {
                wereItemsAdded = false;
                break;
            }
        }

        return wereItemsAdded;
    }

    /*
    Add the item to the list.
    */
    public boolean addItem(Item itemToAdd)
    {
        boolean wasItemAdded = false;
        if(itemToAdd != null)
        {
            this.itemList.add(itemToAdd);
            wasItemAdded = true;
        }
        return wasItemAdded;
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
    Update an item. Return true if found & updated. Otherwise, false.
     */
    public boolean updateItem(Item updatedItem)
    {
        boolean wasItemUpdated = false;
        for(Item thisItem : itemList)
        {
            if(thisItem.getId().equals(updatedItem.getId()))
            {
                thisItem.setName(updatedItem.getName());
                wasItemUpdated = true;
            }
            // wasItemUpdated stays false if item is never found.
        }
        return wasItemUpdated;
    }

    /*
    Update many items. Return true if found & updated. Otherwise, false.
     */
    public boolean updateItems(ArrayList<Item> updatedItems)
    {
        boolean wereItemsUpdated = false;
        for(Item itemToUpdate : itemList)
        {
            for(Item updatedItem: updatedItems)
            {
                if (itemToUpdate.getId().equals(updatedItem.getId()))
                {
                    itemToUpdate.setName(updatedItem.getName());
                }
            }
            wereItemsUpdated = true;
            // wereItemsUpdated stays false if item is never found.
        }
        return wereItemsUpdated;
    }

    /*
    Delete an item with this id. Return true if found & deleted. Otherwise, false.
    */
    public boolean deleteItem(UUID itemId)
    {
        boolean wasItemDeleted = false;
        for(Item thisItem : itemList)
        {
            if(thisItem.getId().equals(itemId))
            {
                itemList.remove(thisItem);
                wasItemDeleted = true;
            }
            // wasItemDeleted stays false if item is never found.
        }
        return wasItemDeleted;
    }


}
