package demo.BehavioralPattern;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 观察者模式
 */

interface Observer{
    public void update();
}

class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("Observer1 has received");
    }

}

class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("Observer2 has received");
    }
}

interface Subject {
    public void add(Observer observer);
    public void del(Observer observer);
    public void notifyObserver();
    public void operation();
}

abstract class AbstractSubject implements Subject{
    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        this.vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        this.vector.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()){
            Observer ob = enumo.nextElement();
            ob.update();
            System.out.println(ob.toString());
        }
    }

    @Override
    public void operation() {
        System.out.println("this is Abstract operation");
    }
}

class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self");
        notifyObserver();
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
