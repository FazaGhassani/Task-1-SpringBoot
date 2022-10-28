package com.task.stunting.service;

import com.task.stunting.model.MyUserDetail;
import com.task.stunting.model.User;
import com.task.stunting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No User Found");
        }
        return new MyUserDetail(user);
    }

}
