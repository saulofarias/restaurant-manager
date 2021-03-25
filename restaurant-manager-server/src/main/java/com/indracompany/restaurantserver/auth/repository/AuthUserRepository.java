package com.indracompany.restaurantserver.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indracompany.restaurantserver.auth.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
}
