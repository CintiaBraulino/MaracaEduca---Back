package com.maracaEduca.maracaEduca.security;

import com.maracaEduca.maracaEduca.model.User;
import com.maracaEduca.maracaEduca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o username: " + username));


        return new org.springframework.security.core.userdetails.User(
                ((User) user).getUsername(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}