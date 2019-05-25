package demo.BehavioralPattern;

interface Expression{
    public int interprete(ContextI contexti);
}

class PlusI implements Expression{
    @Override
    public int interprete(ContextI contexti) {
        return contexti.getNum1()+contexti.getNum2();
    }
}

class MinusI implements Expression{
    @Override
    public int interprete(ContextI contexti) {
        return contexti.getNum1()-contexti.getNum2();
    }
}

class ContextI {
    private int num1;
    private int num2;

    public ContextI(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

public class InterpreterTest {
    public static void main(String[] args) {
        //9+2
        int result1 = new PlusI().interprete(new ContextI(9,2));
        System.out.println(result1);

        //9+2-8
        int result2 = new MinusI().interprete(new ContextI(new PlusI().interprete(new ContextI(9,2)),8));
        // int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));
        System.out.println(result2);

    }
}
