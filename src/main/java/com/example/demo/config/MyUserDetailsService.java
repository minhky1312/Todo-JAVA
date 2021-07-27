package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<Userr> userrList = userRepository.findAll();
        List<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(Role.ADMIN.toString()));
        Optional<Userr> userrOptional;


            for (Userr userr: userrList)
            {
                if (userr.getUsername().equals(userName))  return new org.springframework.security.core.userdetails.User(userr.getUsername(), userr.getPassword(), role);
            }
            return new User("foo","foo",new ArrayList<>());
    }


}
