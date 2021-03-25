package com.indracompany.restaurantserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indracompany.restaurantserver.model.OrderedItem;

@Repository
public interface OrderedItemRepository  extends JpaRepository<OrderedItem, Long>{

	
}
