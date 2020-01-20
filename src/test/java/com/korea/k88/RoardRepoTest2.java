package com.korea.k88;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.korea.k88.board.domain.Board900;
import com.korea.k88.board.persistance.BoardRepository;
import com.korea.k88.board.persistance.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoardRepoTest2 {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testgetBoard() {
		Board900 board = boardRepo.findById(130L).get();
		System.out.println(board.getSeq() + " 번호 ");
		System.out.println(board.getTitle() + " 제목 ");
		System.out.println(board.getMember().getName() + " 이름 ");
		System.out.println(board.getContent() + " 내용 ");
		System.out.println(board.getCreateDate() + " 날짜 ");
		System.out.println(board.getCnt() + " 조회 ");
	}
}
