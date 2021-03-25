package com.indracompany.customerserver.service;

import java.util.List;
import java.util.Map;

import com.indracompany.customerserver.model.Table;
import com.indracompany.customerserver.model.OrderDTO;
import com.indracompany.customerserver.model.OrderResponseDTO;

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
