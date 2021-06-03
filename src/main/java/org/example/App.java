package org.example;

import org.example.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "org.example.jdbc.dao")
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Spring Jdbc Program has started." );
        ApplicationContext context = new AnnotationConfigApplicationContext("org/example/jdbc.dao");
        StudentDao studentDaoImp = context.getBean("studentDaoImp", StudentDao.class);

//        Student student = new Student();
//        student.setId(2);
//        student.setName("Alex Block");
//        student.setCity("New Mexico");
//
//        int update = studentDaoImp.update(student);
//        System.out.println("No of rows added are " + update);

//        int delete = studentDaoImp.delete(111);
//        System.out.println("No. of deleted rows are = " + delete);

//        Student student = studentDaoImp.getStudent(123);
//        System.out.println(student);

        List<Student> students = studentDaoImp.getAllStudents();
        for (Student s:students) {
            System.out.println(s);
        }

    }
}
