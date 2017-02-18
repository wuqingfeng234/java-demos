import java.lang.reflect.Proxy;

/**
 * Created by sdzn-dsj on 2016/12/12.
 */
public class TestProxy {
    
    public void testDynamicProxy(){
        Calculator calculator=new CalculatorImpl();
        LogHandler lh=new LogHandler(calculator);
        Calculator proxy= (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),calculator.getClass().getInterfaces(),lh);
        proxy.add(1,1);
    }

}
