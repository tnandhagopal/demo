package com.example.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.login.UserPrincipal;

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

	public List<Employee> getAllEmployee() {
		return userRepository.findAll();
	}

	public boolean save(Employee employee) {

		if (userRepository.findByUserName(employee.getUserName()) == null) {
			employee.setStatus("NEW");
			employee.setPassword(new BCryptPasswordEncoder(10).encode(employee.getPassword()));
			userRepository.save(employee);
			return true;
		}

		return false;
	}
}
