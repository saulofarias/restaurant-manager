package com.indracompany.restaurantserver;

import com.indracompany.restaurantserver.model.Product;
import com.indracompany.restaurantserver.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantServerApplication implements ApplicationRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			productRepository.save(getProduct("Arroz com Feijão", 15.0, "1234"));
			productRepository.save(getProduct("Arroz com Peixe", 25.0, "1235"));
			productRepository.save(getProduct("Suco Laranja", 5.0, "1236"));
			productRepository.save(getProduct("Refrigerante", 10.0, "1237"));
			productRepository.save(getProduct("Lasanha", 35.0, "1238"));
			productRepository.save(getProduct("Torta Limão", 20.0, "1239"));
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	private Product getProduct(String name, Double price, String barCode) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setBarCode(barCode);
		return product;
	}

}
