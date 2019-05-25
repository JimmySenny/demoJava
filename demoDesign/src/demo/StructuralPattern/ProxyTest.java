package demo.StructuralPattern;

interface  SourceableP{
    public void method();
}

class SourceP implements SourceableP{
    @Override
    public void method() {
        System.out.println("the original method");
    }
}

class Proxy implements SourceableP{
    private SourceP source;

    public Proxy(){
        super();
        this.source = new SourceP();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before(){
        System.out.println("before proxy");
    }

    private void after(){
        System.out.println("after proxy");
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SourceableP s = new Proxy();
        s.method();
    }
}
