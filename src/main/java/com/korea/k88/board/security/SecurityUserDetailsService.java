package com.korea.k88.board.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.korea.k88.board.domain.Member900;
import com.korea.k88.board.persistance.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	MemberRepository  memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member900> optional=memberRepo.findById(username);
		if (!optional.isPresent()) {

			throw  new UsernameNotFoundException(username + " 사용자없음");
		} else {
			Member900 member=optional.get();
			return  new  SecurityUser(member);
		}
	}

}
