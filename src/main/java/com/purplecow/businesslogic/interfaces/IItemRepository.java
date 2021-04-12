package com.purplecow.businesslogic.interfaces;

import com.purplecow.businesslogic.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IItemRepository extends CrudRepository<Item, UUID>
{

}
