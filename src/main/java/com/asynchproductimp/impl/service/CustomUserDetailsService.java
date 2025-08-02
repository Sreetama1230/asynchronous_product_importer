package com.asynchproductimp.impl.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.asynchproductimp.impl.dao.UserDao;
import com.asynchproductimp.impl.entities.CustomUserDetails;
import com.asynchproductimp.impl.entities.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userRepo;

    public CustomUserDetailsService(UserDao u) {
        this.userRepo = u;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        List<String> roles = new ArrayList<>(List.of(user.getRole()));
        Collection<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}