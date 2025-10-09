package iuh.fit.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringPureJdbAnnotationConfigApplication {
    @SuppressWarnings("rescource")
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringPureJdbAnnotationConfigApplication.class,args);
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource=context.getBean("dataSource1", DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
