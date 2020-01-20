package com.korea.k88.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.korea.k88.board.domain.Member900;

public class SecurityUser extends  User {
	 private static final long serialVersionUID = 1L;
	 
	 private  Member900  member;
	 public SecurityUser(Member900  member) {
	  super(member.getId(),"{noop}"+member.getPassword(),AuthorityUtils.createAuthorityList(member.getRole().toString()));
	        this.member =member;
	 }
	 
	 public  Member900  getMember900() {
	  return member;
	 }
}
