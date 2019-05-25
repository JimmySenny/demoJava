package demo.CreationalPattern;

/**
 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
 * 这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，
 * JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，
 * 这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
 */
class Singleton {
    private Singleton(){
    }

    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    public Object readResolve() {
        return getInstance();
    }

}

/**
 * 上例中，如果在构造函数中抛出异常，实例将永远得不到创建
 * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的：
 */
class  Singleton2 {
    private static Singleton2 instance2 = null;

    private Singleton2(){
    }

    private static synchronized void syncInit(){
        if ( instance2 == null ){
            instance2 = new Singleton2();
        }
    }

    public static Singleton2 getInstance(){
        if( instance2 == null ){
            syncInit();
        }

        return instance2;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 + " vs " + singleton2);

        Singleton2 s2a = Singleton2.getInstance();
        Singleton2 s2b = Singleton2.getInstance();

        System.out.println(s2a + " vs " + s2b);
    }
}
