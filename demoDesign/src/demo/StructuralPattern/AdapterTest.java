package demo.StructuralPattern;

class Source{
    public void method1(){
        System.out.println("this is original method1");
    }
    public void method2() {
        System.out.println("this is original method2");
    }
}

interface Targetable{
    public void method1();
    public void method2();
}

/**
 * 类的适配器
 */
class Adapter extends Source implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}

/**
 * 对象的适配器
 */
class Wrapper implements Targetable{
    private Source source;
    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method");

    }
}

/**
 * 接口的适配器
 */
interface Sourceable{
    public void method1();
    public void method2();
}

abstract class Wrapper2 implements Sourceable{
    public void method1(){
        System.out.println("this is abstract's method1");
    };
    public void method2(){
        System.out.println("this is abstract's method2");
    };
}

class SourceSub1 extends Wrapper2{
    @Override
    public void method1() {
        System.out.println("the sourceable interface's first Sub1");
    }
}

class SourceSub2 extends Wrapper2{
    @Override
    public void method2() {
        System.out.println("the sourceable interface's first Sub2");
    }
}


public class AdapterTest {
    public static void main(String[] args) {
        Targetable target1 = new Adapter();
        target1.method1();
        target1.method2();

        Source source = new Source();
        Targetable target2 = new Wrapper(source);
        target2.method1();
        target2.method2();

        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
