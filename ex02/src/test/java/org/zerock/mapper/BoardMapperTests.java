package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
//	@Test
//	public void testInsert() {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("새로 작성한 글");
//		vo.setContent("내용");
//		vo.setWriter("admin");
//		
//		mapper.insert(vo);
//		
//		log.info(vo);
//	}
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성 : select key");
//		board.setContent("내용 : select key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		log.info(board);
//	}
//	@Test 
//	public void testRead() {
//		BoardVO board = mapper.read(10L);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testDelete() {
//		int result = mapper.delete(10L);
//		log.info("delete count : " + result);
//	}
//	
//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(11L);
//		board.setTitle("수정 제목");
//		board.setContent("수정 내용");
//		board.setWriter("수정자");
//
//		int count = mapper.update(board);
//		log.info(count);
//	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		cri.setPageNum(3);
//		cri.setAmount(10);
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board.getBno()));
//	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("tsa");
		cri.setType("TCW");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}









