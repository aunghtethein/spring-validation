package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.dao.StaffRepository;
import com.demo.ds.Staff;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private StaffRepository staffRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff = staffRepo.getUserByUsername(username);
		if(staff == null) {
			throw new UsernameNotFoundException("Could not find user!");
		}
		return new MyUserDetails(staff);
	}

}
