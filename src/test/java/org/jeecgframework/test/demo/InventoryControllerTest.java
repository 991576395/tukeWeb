package org.jeecgframework.test.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.HashMap;
import org.hamcrest.Matchers;
import org.jeecgframework.AbstractUnitTest;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.WebUtils;
/**
 * Controller UserRest单元测试Demo
 * @author 于庚午
 */
public class InventoryControllerTest  extends AbstractUnitTest{
	
	private MockMvc mockMvc;
	private MockHttpSession session; //为模拟登录时，所有请求使用同一个session
	@Before
	public void setup() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = post("/");
		MockHttpServletRequest request = requestBuilder.buildRequest(this.wac.getServletContext());
		session = (MockHttpSession) request.getSession();

		Client c = new Client();
		TSUser u = new TSUser();
		u.setUserName("admin");
		c.setUser(u);
		session.setAttribute(session.getId(), c);

		this.mockMvc = webAppContextSetup(this.wac).build();
		this.testLogin();
	}
	//测试登录
	@Test
	public void testLogin() throws Exception {
		session.setAttribute("randCode", "1234"); //设置登录验证码
		this.mockMvc.perform(MockMvcRequestBuilders.post("/loginController.do?checkuser=1")
				.characterEncoding("UTF-8")
				.param("userName","admin")
				.param("password", "123456")
				.param("randCode", "1234")
				.header("USER-AGENT", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36")  // 设置USER-AGENT： 浏览器 
				.session(session))  //关键 每个测试都要设置session 。以保证是使用的同一个session
				.andDo(print())
				.andExpect(jsonPath("$.success").value(Matchers.equalTo(true)));
		//避免testGetAll()中admin用户的currentDepart属性循环嵌套导致json不正确
		((Client)session.getAttribute(session.getId())).getUser().setCurrentDepart(new TSDepart());
	}
	
	
	// 测试抢库存
	@Test
	public void sub() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/loginController.do?checkuser=1").characterEncoding("UTF-8")
				.param("userName", "admin").param("password", "123456").param("randCode", "1234")
				.header("USER-AGENT",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36") // 设置USER-AGENT：
																																			// 浏览器
				.session(session)) // 关键 每个测试都要设置session 。以保证是使用的同一个session
				.andDo(print()).andExpect(jsonPath("$.success").value(Matchers.equalTo(true)));
		// 避免testGetAll()中admin用户的currentDepart属性循环嵌套导致json不正确
		((Client) session.getAttribute(session.getId())).getUser().setCurrentDepart(new TSDepart());
	}

}
