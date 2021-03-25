package com.indracompany.restaurantserver.service;

import java.util.ArrayList;
import java.util.List;

import com.indracompany.restaurantserver.model.OrderedItem;
import com.indracompany.restaurantserver.model.OrderedItemDTO;
import com.indracompany.restaurantserver.repository.OrderedItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemService {

	@Autowired
	OrderedItemRepository repository;

	@Autowired
	IProductService productService;

	public OrderedItemDTO save(OrderedItem item) {
		return toDTO(repository.save(item));
	}

	public OrderedItemDTO getById(Long id) {
		return toDTO(repository.findById(id).orElseThrow());
	}

	public OrderedItemDTO toDTO(OrderedItem item) {
		return new OrderedItemDTO(item.getId(), item.getDescription(), item.getPrice(),
				productService.toDTO(item.getProduct()));
	}

	public List<OrderedItemDTO> toDTO(List<OrderedItem> items) {
		List<OrderedItemDTO> itemsDto = new ArrayList<>();

		for (OrderedItem item : items) {
			var itemDto = new OrderedItemDTO(item.getId(), item.getDescription(), item.getPrice(),
					productService.toDTO(item.getProduct()));

			itemsDto.add(itemDto);
		}
		return itemsDto;
	}

}
