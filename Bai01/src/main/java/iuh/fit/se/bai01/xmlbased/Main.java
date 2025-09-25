package iuh.fit.se.bai01.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;
    public static void main(String[] args) {
        context=new ClassPathXmlApplicationContext("META-INF/beans.xml");
        Student student1=context.getBean("student1", Student.class);
        Student student2=context.getBean("student2", Student.class);
        Student student3=context.getBean("student3", Student.class);
        Person person=context.getBean("person", Person.class);
        Class_ class2 = context.getBean("class2", Class_.class);
        System.out.println("XML-Based Configuration – Setter Injection: "+student1);
        System.out.println("XML-Based Configuration – Setter Injection – Object Injection: "+student2);
        System.out.println("XML-Based Configuration – Setter Injection – Object Injection: "+student3);
        System.out.println("XML-Based Configuration – Collection Injection: "+person);
        System.out.println("XML-Based Configuration – Literal Values Injection: "+class2);
    }
}
