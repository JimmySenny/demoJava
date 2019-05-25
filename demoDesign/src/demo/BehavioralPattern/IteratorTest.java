package demo.BehavioralPattern;

interface Iterator {
    public Object previous();
    public boolean hasNext();
    public Object next();
    public Object first();
}

interface Collection {
    public Iterator iterator();
    public Object get(int i);
    public int size();
}

class MyIterator implements Iterator {
    private Collection collection;
    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(pos > 0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos < collection.size() -1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        if(pos < collection.size() -1 ){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}

class MyCollection implements Collection{
    public String str[] = {"A", "B", "C", "D"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return str[i];
    }

    @Override
    public int size() {
        return str.length;
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iter = collection.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
