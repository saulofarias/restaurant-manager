package com.indracompany.customerserver.auth.repository;

import com.indracompany.customerserver.auth.entity.AuthUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
}
