package asia.zzu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {
    //获取class对象的多种方式
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //类名.class获取
        Class clazz1 = Car.class;

        //对象.getClass()获取
        Class clazz2 = new Car().getClass();

        //Class.forNmae("path")全路径
        Class clazz3 = Class.forName("asia.zzu.reflect.Car");

        //实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //获取构造方法
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        //获取所有构造
//        Constructor[] constructors = clazz.getConstructors();
//        for (Constructor c : constructors) {
//            System.out.println("构造方法名称：" + c.getName() + "  参数个数" + c.getParameterCount());
//        }

        //如果有私有构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("构造方法名称：" + c.getName() + "  参数个数" + c.getParameterCount());
        }

        //指定又惨构造创建对象
        //构造为public时
//        Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);
//        Car car = (Car) constructor.newInstance("夏利", 10, "红色");
//        System.out.println(car);
        //构造方法为privite时
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        constructor.setAccessible(true);
        Car car = (Car) constructor.newInstance("捷达", 15, "白色");
        System.out.println(car);
    }

    //获取属性
    @Test
    public void test03() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        //获取public属性
//        Field[] fields=clazz.getFields();

        //获取privite属性
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "五菱宏光");
            }
        }
        System.out.println(car);
    }

    //获取方法
    @Test
    public void test04() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("Benz", 5, "黑色");
        Class clazz = car.getClass();
        //public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //System.out.println(method.getName());
            if (method.getName().equals("toString")) {
                String string = (String) method.invoke(car);
                //System.out.println(string);
            }
        }

        //privite方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method method : methodsAll) {
            //执行私有方法
            if (method.getName().equals("run")) {
                method.setAccessible(true);
                method.invoke(car);
            }
        }
    }
}
