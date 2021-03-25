package com.indracompany.restaurantserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indracompany.restaurantserver.constants.Status;
import com.indracompany.restaurantserver.model.Order;
import com.indracompany.restaurantserver.model.OrderDTO;
import com.indracompany.restaurantserver.model.OrderResponseDTO;
import com.indracompany.restaurantserver.model.OrderedItem;
import com.indracompany.restaurantserver.model.Product;
import com.indracompany.restaurantserver.model.ProductDTO;
import com.indracompany.restaurantserver.model.Table;
import com.indracompany.restaurantserver.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository repository;

	@Autowired
	IProductService productService;
	
	@Autowired
	OrderedItemService itemService;

	@Override
	public List<OrderResponseDTO> findAll() {
		return this.toDTO(repository.findAll());
	}

	@Override
	public OrderResponseDTO save(OrderDTO order) {
		Order savedOrder = repository.save(toEntity(order));
		savedOrder.getItems().forEach(item -> {
			item.setOrder(savedOrder);
			itemService.save(item);
		});
		return this.toDTO(savedOrder);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public OrderResponseDTO detailOrder(Long id) {
		return this.toDTO(repository.getOne(id));
	}

	@Override
	public OrderResponseDTO cancelOrder(Long id) {
		Order order = repository.findById(id).orElseThrow();
		order.setStatus(Status.CANCELADO.getStatus());
		return this.toDTO(repository.save(order));
	}

	@Override
	public OrderResponseDTO closeOrder(Long id) {
		Order order = repository.findById(id).orElseThrow();
		order.setStatus(Status.CONCUIDO.getStatus());
		return this.toDTO(repository.save(order));
	}

	@Override
	public Map<String, String> closeTableAccount(Long numTable) {
		Map<String, String> toReturn = new HashMap<>();
		var orders = repository.findByStatusAndTable(Status.CONCUIDO.getStatus(), numTable);
		Double amount = 0.0;
		
		for(Order order : orders) {
		    amount += order.getAmount();
			order.setStatus(Status.FECHADO.getStatus());
			repository.save(order);
		}

		toReturn.put("total", String.valueOf(amount));
		return toReturn;
	}

	@Override
	public List<OrderResponseDTO> pendingOrders() {
		return this.toDTO(repository.findByStatusBetween(Status.NOVO.getStatus(), Status.CONCUIDO.getStatus()));
	}

	@Override
	public Map<String, String> getNumOrder(){
		var numOrder = repository.getNumOrder();
		if(numOrder == null){
			numOrder = 1;
		}else{
			numOrder++;
		}

		Map<String, String> newNumOrder = new HashMap<>();
		newNumOrder.put("number", String.valueOf(numOrder));
		return newNumOrder;
	}

	@Override
	public List<Table> getTables(Integer size){
		List<Table> tables = new ArrayList<>(); 
		for(int i = 1; i <= size; i++){
			tables.add(new Table("Mesa - " + i, i));
		}
		return tables;
	}
	private Order toEntity(OrderDTO dto) {
		List<OrderedItem> items = new ArrayList<>();
		Double orderPrice = 0.0;
		for (ProductDTO item : dto.getProducts()) {
			Product product = productService.getById(item.getId());
			orderPrice += product.getPrice();
			items.add(new OrderedItem(product.getName(), product.getPrice(), product));
		}
		return new Order(orderPrice, Status.NOVO.getStatus(), dto.getNumber(), dto.getTable(), items);
	}

	private OrderResponseDTO toDTO(Order order){
		return new OrderResponseDTO(order.getId(),
				order.getAmount(),
				order.getNumber(),
				order.getNumTable(),
				itemService.toDTO(order.getItems()),
				order.getStatus());
	}

	private List<OrderResponseDTO> toDTO(List<Order> orders){
		List<OrderResponseDTO> ordersDto = new ArrayList<>();
		for (Order order : orders) {

		 var orderDto = new OrderResponseDTO(order.getId(),
				order.getAmount(),
				order.getNumber(),
				order.getNumTable(),
				itemService.toDTO(order.getItems()),
				order.getStatus());
			ordersDto.add(orderDto);	
		}
		return ordersDto;
	}
}
