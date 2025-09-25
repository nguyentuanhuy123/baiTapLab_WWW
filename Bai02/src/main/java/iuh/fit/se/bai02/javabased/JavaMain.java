package iuh.fit.se.bai02.javabased;

import iuh.fit.se.bai02.javabased.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        Employee e1=context.getBean("employee1", Employee.class);
        System.out.println("Dùng Java-Based: "+e1);
    }
}
