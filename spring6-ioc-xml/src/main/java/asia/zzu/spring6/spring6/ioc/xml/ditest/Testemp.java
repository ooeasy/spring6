package asia.zzu.spring6.spring6.ioc.xml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testemp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Emp emp = (Emp) context.getBean("emp3", Emp.class);
        emp.work();
    }
}
