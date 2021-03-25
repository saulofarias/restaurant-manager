package com.indracompany.restaurantserver.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.indracompany.restaurantserver.model.OrderDTO;
import com.indracompany.restaurantserver.model.OrderResponseDTO;
import com.indracompany.restaurantserver.model.Table;
import com.indracompany.restaurantserver.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/orders")
public class OrderController {

	@Autowired
	IOrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

	@GetMapping("/number")
	public ResponseEntity<Map<String, String>> getNumOrder() {
		return ResponseEntity.ok().body(orderService.getNumOrder());
	}

	@GetMapping("/pendings")
	public ResponseEntity<List<OrderResponseDTO>> pendingOrders() {
		return ResponseEntity.ok().body(orderService.pendingOrders());
	}

	@PostMapping
	public ResponseEntity<OrderResponseDTO> save(@RequestBody OrderDTO order) {
		OrderResponseDTO savedOrder = orderService.save(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedOrder);
	}

	@PutMapping("/cancel/{id}")
	public ResponseEntity<OrderResponseDTO> cancelOrder(@PathVariable Long id) {
		return ResponseEntity.ok().body(orderService.cancelOrder(id));
	}

	@PutMapping("/close/{id}")
	public ResponseEntity<OrderResponseDTO> closeOrder(@PathVariable Long id) {
		return ResponseEntity.ok().body(orderService.closeOrder(id));
	}

	@PutMapping("/close/all/{table}")
	public ResponseEntity<Map<String, String>> closeAll(@PathVariable Long table) {
		return ResponseEntity.ok().body(orderService.closeTableAccount(table));
	}

	@GetMapping("/tables/{size}")
	public ResponseEntity<List<Table>> getTables(@PathVariable Integer size) {
		return ResponseEntity.ok().body(orderService.getTables(size));
	}
}
