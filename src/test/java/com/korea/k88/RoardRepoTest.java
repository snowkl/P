package com.korea.k88;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.korea.k88.board.domain.Board900;
import com.korea.k88.board.domain.Member900;
import com.korea.k88.board.domain.Role;
import com.korea.k88.board.persistance.BoardRepository;
import com.korea.k88.board.persistance.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoardRepoTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsert() {
		Member900 m1 = new Member900();
		m1.setId("member");
		m1.setPassword("member123");
		m1.setName("둘리");
		m1.setRole(Role.ROLE_MAMBER);
		m1.setEnabled(true);
		memberRepo.save(m1);
		
		Member900 m2 = new Member900();
		m2.setId("admin");
		m2.setPassword("admin123");
		m2.setName("도우너");
		m2.setRole(Role.ROLE_ADMIN);
		m2.setEnabled(true);
		memberRepo.save(m2);
		
		for(int i=0 ; i <= 13 ; i++) {
			Board900 b1 = new Board900();
			b1.setMember(m1);
			b1.setTitle(m1.getName() + "가 등록한 글 " + i);
			b1.setContent(m1.getName() + "가 등록한 게시글 " + i);
			boardRepo.save(b1);
		}
		
		for(int i=0 ; i <= 23 ; i++) {
			Board900 b2 = new Board900();
			b2.setMember(m2);
			b2.setTitle(m2.getName() + "가 등록한 글 " + i);
			b2.setContent(m2.getName() + "가 등록한 게시글 " + i);
			boardRepo.save(b2);
		}
	}
}
