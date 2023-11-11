package com.dmb.coffee.shop.system.jwt;

import com.dmb.coffee.shop.system.dao.UserDao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Slf4j
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    @Getter
    private com.dmb.coffee.shop.system.models.User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {}",username);
        userDetail = userDao.findByEmailId(username);
        if (!Objects.isNull(userDetail)) {
            log.info("Inside loadUserByUsername email: {} password : {}", userDetail.getEmail(),userDetail.getPassword());
            return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public com.dmb.coffee.shop.system.models.User getUserDetail(){
        com.dmb.coffee.shop.system.models.User user=userDetail;
        //user.setPassword(null);
        return user;
    }
}
