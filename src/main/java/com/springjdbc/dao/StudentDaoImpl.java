package com.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		//insert query
        String query = "insert into student(id,name,city,age) values(?,?,?,?)";
        this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity(),student.getAge());
		return 0;
	}
	public int update(Student student) {
		String query = "update student set name = ? where id = ?";
		return this.jdbcTemplate.update(query,student.getName(),student.getId());
	}

	public int delete(Student student) {
		String query = "delete from student where id = ?";
		return this.jdbcTemplate.update(query,student.getId());
	}
	
}