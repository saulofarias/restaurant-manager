package com.indracompany.restaurantserver.service;

import java.util.List;
import java.util.Map;

import com.indracompany.restaurantserver.model.OrderDTO;
import com.indracompany.restaurantserver.model.OrderResponseDTO;
import com.indracompany.restaurantserver.model.Table;

public interface IOrderService {

	List<OrderResponseDTO> findAll();
	OrderResponseDTO save(OrderDTO order);
	void deleteById(Long id);
	OrderResponseDTO detailOrder(Long id);
	OrderResponseDTO cancelOrder(Long id);
	OrderResponseDTO closeOrder(Long id);
	Map<String,String> closeTableAccount(Long mesa);
	List<OrderResponseDTO> pendingOrders();
	Map<String,String> getNumOrder();
	List<Table> getTables(Integer size);

	
	
}
