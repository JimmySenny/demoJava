package demo.BehavioralPattern;

/**
 * 策略模式
 */

/**
 * 统一接口
 */
interface ICalculator {
    public int calculate(String exp);
}

/**
 * 辅助类 提供辅助方法
 */
abstract class AbstractCalculator {
    public int[] split (String exp, String opt) throws NumberFormatException{
        String array[] = exp.split(opt);
        int arrayInt[] = new int[array.length];
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            try {
                arrayInt[i] = Integer.parseInt(array[i]);
            }catch (NumberFormatException e){
                e.printStackTrace();
                throw e;
            }finally {
                ;
            }
        }
        return arrayInt;
    }
}

class Plus extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        int result = 0;
        for (int i = 0; i < arrayInt.length; i++) {
           result += arrayInt[i];
        }
        return result;
    }
}

class Minus extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0] - arrayInt[1];
    }
}

class Multiply extends AbstractCalculator implements ICalculator{
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0] * arrayInt[1];
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        String exp = "+2+8+1++";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
