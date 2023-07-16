package com.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		//insert query
        String query = "insert into student(name,city,age) values(?,?,?)";
        this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getAge());
		return 0;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}