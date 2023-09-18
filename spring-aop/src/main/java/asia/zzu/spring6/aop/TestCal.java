package asia.zzu.spring6.aop;

public class TestCal {
    public static void main(String[] args) {
        //创建动态代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
    }
}
