package com.purplecow.businesslogic.classes;

import com.purplecow.businesslogic.classes.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemCollection
{
    private List<Item> itemList = null;

    public List<Item> getItemList()
    {
        return this.itemList;
    }

    public void setItemList(List<Item> itemList)
    {
        this.itemList = itemList;
    }

    public ItemCollection()
    {
        this.itemList = new ArrayList<Item>();
    }

}
