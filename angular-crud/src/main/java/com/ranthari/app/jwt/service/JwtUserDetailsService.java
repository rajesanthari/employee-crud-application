//package com.ranthari.app.jwt.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.ranthari.app.model.DAOUser;
//import com.ranthari.app.repository.UserRepository;
//
//@Component
//public class JwtUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		DAOUser user = userRepository.findByUsername(username);
//		if (user != null) {
//			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username" + username);
//		}
//	}
//}
