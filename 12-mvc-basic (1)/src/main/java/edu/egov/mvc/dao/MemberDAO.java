package edu.egov.mvc.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
//	@Autowired
	JdbcTemplate jt;
	
	public String login() {
		Map<String, Object> map = jt.queryForMap(
				"select * from member where id=? and pw=?");
		return (String) map.get("id");
	}
}











