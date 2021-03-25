package com.indracompany.customerserver.auth.controller;

import com.indracompany.customerserver.auth.config.JwtRequest;
import com.indracompany.customerserver.auth.config.JwtResponse;
import com.indracompany.customerserver.auth.entity.AuthUser;
import com.indracompany.customerserver.auth.service.JwtUserDetailsService;
import com.indracompany.customerserver.auth.util.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = { "/api/authenticate" }, method = { RequestMethod.POST })
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        this.authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        String token = this.jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok((Object) new JwtResponse(token));
    }

    @RequestMapping(value = { "/api/register" }, method = { RequestMethod.POST })
    public ResponseEntity<?> register(@RequestBody AuthUser user) throws Exception {
        return ResponseEntity.ok(this.userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            this.authenticationManager.authenticate(
                    (Authentication) new UsernamePasswordAuthenticationToken((Object) username, (Object) password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
