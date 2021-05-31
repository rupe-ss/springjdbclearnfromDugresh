package org.example;

import org.example.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Spring Jdbc Program has started." );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDaoImp = context.getBean("studentDaoImp", StudentDao.class);

        Student student = new Student();
        student.setId(2);
        student.setName("Alex");
        student.setCity("Dallas");

        int insert = studentDaoImp.insert(student);
        System.out.println("No of rows added are " + insert);
    }
}
