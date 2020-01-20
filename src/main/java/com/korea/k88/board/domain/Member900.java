package com.korea.k88.board.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="boardList")
@Entity
@Table(name="member900")
public class Member900 {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
	 @OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	 private  List<Board900> boardList = new  ArrayList<Board900>();
	
}
