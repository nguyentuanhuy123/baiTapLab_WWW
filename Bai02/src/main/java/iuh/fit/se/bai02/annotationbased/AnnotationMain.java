package iuh.fit.se.bai02.annotationbased;

import iuh.fit.se.bai02.annotationbased.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "iuh.fit.se.bai02.annotationbased.models")
public class AnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AnnotationMain.class);
        Employee e1=context.getBean(Employee.class);
        System.out.println("Dùng Annotation-Based Configuration: AnnotationConfigApplicationContext: "+e1);
    }
}
