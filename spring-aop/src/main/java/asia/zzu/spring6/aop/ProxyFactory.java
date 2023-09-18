package asia.zzu.spring6.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    ////返回代理对象
    public Object getProxy() {
        /**
         * Proxy.newProxyInstance()方法三个参数
         * ClassLoader:加载动态生成代理类的类加载器
         * Class[] interfaces:目标对象实现的所有接口的class类型的数组
         * InvocationHandler:设置代理对象实现目标对象方法的`过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            //代理对象，需要重写目标对象的方法，method方法里的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法调用之前
                System.out.println("[动态代理】【日志】" + method.getName());
                //调用目标方法
                Object result = method.invoke(target, args);
                //方法调用之后
                System.out.println("【日志】");
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
