package demo.StructuralPattern;

interface SourceableB{
    public void method();
}

class SourceSubP1 implements SourceableB{
    @Override
    public void method() {
        System.out.println("this is the first sub");
    }
}

class SourceSubP2 implements  SourceableB{
    @Override
    public void method() {
        System.out.println("this is the second sub");
    }
}

abstract class Bridge{
    private SourceableB source;

    public void method() {
        this.source.method();
    }

    public SourceableB getSource(){
        return this.source;
    }

    public void setSource(SourceableB source){
        this.source = source;
    }
}

class MyBridge extends Bridge{
    public void method(){
        getSource().method();
    }
}

public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        SourceableB source1 = new SourceSubP1();
        bridge.setSource(source1);
        bridge.method();

        SourceableB source2 = new SourceSubP2();
        bridge.setSource(source2);
        bridge.method();
    }
}
