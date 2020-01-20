package com.korea.k88.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="member")
@Entity
@Table(name="Board900")
public class Board900 {
	@Id @GeneratedValue
	private Long seq;
	private String title;
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date createDate = new Date();
	
	@Column(updatable=false)
	private Long cnt=1L;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID",nullable=false,  updatable=false)
    private  Member900  member;

    public  void  setMember900(Member900  member) {
     this.member=member;
     member.getBoardList().add(this);
     
    }
	
}
