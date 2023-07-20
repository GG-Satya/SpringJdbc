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
        
          //Insert
//        Student student = new Student(1,"gg","Raighar",23);
//        studentDao.insert(student);
//        System.out.println("student added "+student);
        
        //Update
//        Student student2 = new Student(1,"new name","new city",00);
//        int update = studentDao.update(student2);
//        System.out.println("number of record updated---> "+update);
        
        //Delete
          Student student3 = new Student(1,"new name","new city",00);
          int delete = studentDao.delete(student3);
          System.out.println("number of record deleted---> "+delete);
        
    }
}
