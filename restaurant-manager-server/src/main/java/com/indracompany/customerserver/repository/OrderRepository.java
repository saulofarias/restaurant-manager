package com.indracompany.customerserver.repository;

import java.util.List;

import com.indracompany.customerserver.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

@Query("SELECT o FROM Order o WHERE o.status = :novo OR o.status = :concluido")
 List<Order> findByStatusBetween(@Param("novo") String novo,@Param("concluido") String concluido);	

@Query("SELECT o FROM Order o WHERE o.status = :status AND o.numTable = :numTable")
 List<Order> findByStatusAndTable(@Param("status") String status,@Param("numTable") Long numTable);	

@Query(value = "SELECT o.number FROM orders o ORDER BY o.id DESC LIMIT 1", nativeQuery = true)
 Integer getNumOrder();	
}
