package com.testcase.generator.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testcase.generator.model.UserLoginTest;
import com.testcase.generator.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserLoginTest user=userRepository.findByUsername(username);
		
		Set<GrantedAuthority>auth=new HashSet<>();
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),auth);
	}

}
