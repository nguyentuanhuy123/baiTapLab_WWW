package iuh.fit.se.bai02.xmlbased;

import iuh.fit.se.bai02.xmlbased.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLMain {
    private static ApplicationContext context;
    public static void main(String[] args) {
        context=new ClassPathXmlApplicationContext("META-INF/beans.xml");
        Employee e1=context.getBean("employee1", Employee.class);
        Employee e2=context.getBean("employee2", Employee.class);
        System.out.println("Tạo bean sử dụng setter: "+e1);
        System.out.println("Tạo bean sử dụng constructor: "+e2);
    }
}
