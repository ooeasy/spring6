package asia.zzu.bean;

import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext {
    //创建map集合，存放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包扫描规则
    //当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
    //创建有参数构造
    public AnnotationApplicationContext(String basePackage){


    }
}
