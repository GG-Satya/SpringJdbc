package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/Config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        Student student = new Student("gg","Raighar",23);
        
        studentDao.insert(student);
        
        System.out.println("student added "+student);
//        int update = template.update(query,"gudi","jaypur",20);
//        System.out.println("number of record updated---> "+update);
    }
}
