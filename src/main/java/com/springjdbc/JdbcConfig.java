package com.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JdbcConfig {
	
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/springjdbc");
		ds.setUsername("axelor");
		ds.setPassword("axelor");
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
//	@Bean("studentDao")
//	public StudentDao getStudentDao() {
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getJdbcTemplate());
//		return studentDao;
//	}
}
