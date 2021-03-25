package com.indracompany.customerserver.auth.service;

import java.util.ArrayList;
import java.util.Optional;

import com.indracompany.customerserver.auth.entity.AuthUser;
import com.indracompany.customerserver.auth.repository.AuthUserRepository;
import com.indracompany.customerserver.exception.CustomerAlreadExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    AuthUserRepository authUserRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = this.getAuthUser(username);
        if (authUser.isPresent()) {
            return new User(authUser.get().getEmail(), this.passwordEncoder(authUser.get().getPassword()),
                    new ArrayList());
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    private Optional<AuthUser> getAuthUser(String username) {
        return this.authUserRepository.findById(username);
    }

    private String passwordEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode((CharSequence) password);
    }

    public AuthUser save(AuthUser user) {
        if (isPresent(user.getEmail())) {
            throw new CustomerAlreadExistsException();
        }
        return authUserRepository.save(user);
    }

    private Boolean isPresent(String id) {
        return authUserRepository.findById(id).isPresent();
    }
}
