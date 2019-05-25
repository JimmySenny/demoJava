package demo.StructuralPattern;


interface  SourceableD{
    public void method();
}

class SourceD implements SourceableD{
    @Override
    public void method() {
        System.out.println("the original method");
    }
}

class Decotator implements SourceableD{
    private SourceableD source;

    public Decotator(SourceableD source){
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator");
        source.method();
        System.out.println("after decorator");
    }
}


public class DecoratorTest {
    public static void main(String[] args) {
        SourceableD source = new SourceD();
        SourceableD obj = new Decotator(source);

        source.method();
        obj.method();
    }
}
