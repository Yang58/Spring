package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	
	// bdfore 어노테이션이 붙은 메서드는 모든 테스트전에 매번 실행되는 메서드
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	public void testListPaging() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		// MockMvcRequestBuilders 의 Post를 이용하면 POST방식으로 데이터를 전달할 수 있고 param을 이용해 전달해야 하는 파라미터들을 지정할 수 있다 .
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
							.param("title", "테스트 새글 제목")
							.param("content", "테스트 새글 내용")
							.param("writer", "user00")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void tetGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "13"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception{
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
							.param("bno", "8")
							.param("title", "수정된 테스트 새글 제목")
							.param("content", "수정된 테스트 새글 내용")
							.param("writer", "user01")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testRemove() throws Exception{
		// 삭제 전에 DB 게시물 번호를 확인해야 함 
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "10")).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
}
