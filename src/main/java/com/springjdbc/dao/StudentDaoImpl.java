package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
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

	public Student getStudent(int studentId) {
		// select single student data
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		// Selecting multiple student
		String query = "select * from student";
		List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperImpl());
		return studentList;
	}
	
}