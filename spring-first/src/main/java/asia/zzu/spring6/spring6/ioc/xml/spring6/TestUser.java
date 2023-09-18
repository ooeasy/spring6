package asia.zzu.spring6.spring6.ioc.xml.spring6;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    //创建logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        //1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println("1:" + user);
        //3、使用对象调用方法
        System.out.print("2:");
        user.add();
        //手动写入日志
        logger.info("执行调用成功");
    }

    @Test
    public void testUserObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类class对象
        Class clazz = Class.forName("asia.zzu.spring6.spring6.ioc.xml.spring6.User");
        //调用方法创建对象
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }

}
