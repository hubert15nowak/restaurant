package com.e.restaurant.security;

import com.e.restaurant.dao.UserDao;
import com.e.restaurant.database.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl(@Qualifier("userMysql") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userDao.getUserByLogin(login);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", login)));
        return new UserDetailsImpl(
                user.get(),
                AuthorityType.getAuthority(user.get().getRole()).getGrantedAuthorities());
    }
}
