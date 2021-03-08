package com.astronet.oms.security.services;

import com.astronet.oms.entity.User;
import com.astronet.oms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * As I have said before, we need UserDetailsService for getting UserDetails object.
 * You can look at UserDetailsService interface that has only one method:
 *
 * public interface UserDetailsService {
 *     UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
 * }
 * So we implement it and override loadUserByUsername() method.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}
