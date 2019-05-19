class A{
    public String toString(){
        return "class A";
    }
}
class B extends A {
    public String toString(){
        return "class B";
    }
    public void funb(){
        System.out.println("funb");
    }
}
public class testInstanceof {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        System.out.println(null instanceof A);
        if ( a instanceof B){
            B b = (B) a;
            b.funb();
        }
    }
}
