package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user = userRepository.findByUserName(username);
		if (user == null) {
			System.out.println("user nul exception!!");
			throw new UsernameNotFoundException("User 404");
		}

		System.out.println("user : " + user.getUserName());
		return new UserPrincipal(user);
	}

}
