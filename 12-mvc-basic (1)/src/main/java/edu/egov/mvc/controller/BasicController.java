package edu.egov.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.egov.mvc.dao.MemberDAO;

/* TODO 12-08. Controller 애노테이션 등록 */
@Controller
public class BasicController {
	@Autowired
	MemberDAO dao;
	
	/* TODO 12-09. 요청을 처리할 URL Mapping 지정 및 컨트롤러 메소드 작성 */
	@RequestMapping("index.do")
	public String index() {
		return "index";
	}

	/* TODO 12-10. 요청을 처리할 URL Mapping 지정 및 컨트롤러 메소드 작성 */
	@RequestMapping("main.do")
	public String main(
			@RequestParam(name="page", required=false) String p,
			@RequestParam(name="name", required=false) String name) {
		System.out.println(p);
		System.out.println(name);
		return "main";
	}
	// 로그인 기능
	@RequestMapping("login")
	public String login(
			@RequestParam(name="id", required=false) String id,
			@RequestParam(name="pw", required=false) String pw) {
		
		// 데이터베이스 확인 작업
		String result = dao.login();
		
		
		
		if(id != null) {
			if(id.equals("egov") && pw.equals("1")) {
				return "login_ok";
			}
		}
		
		return "login";
	}
	
	@RequestMapping("resume")
	public String resume() {
		return "resume";
	}
}












