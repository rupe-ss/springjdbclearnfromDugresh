package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String query = "insert into student (id,name,city) values (?,?,?)";

        int update = jdbcTemplate.update(query, 005, "Rupesh Khadka", "Pokhara");
        System.out.println("Number of record inserted = " + update);
    }
}
