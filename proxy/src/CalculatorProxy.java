/**
 * Created by sdzn-dsj on 2016/12/12.
 */
public class CalculatorProxy implements Calculator{
    private Calculator calculator;
    CalculatorProxy(Calculator calculator){
        this.calculator=calculator;
    }

    public int add(int a, int b) {
        return a+b;
    }
}
