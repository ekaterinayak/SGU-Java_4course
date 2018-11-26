import config.JavaConfig;
import model.C;
import model.E;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        // XML config
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        // Java config
        //ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        C c = (C)context.getBean("c");
        c.sayHiFromD();

        E e = (E)context.getBean("e");
        e.sayBye();

        context.close();
    }
}
