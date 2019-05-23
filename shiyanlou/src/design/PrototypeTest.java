package design;

import java.io.*;

/*
class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }
}
 */


/**
 * 深复制
 */
class SerializableObject implements Serializable {
    private static final long serialVersionUID = 5L;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}

class Prototype implements Cloneable,Serializable {
    private static final long serialVersionUID = 1L;
    private String str;

    private SerializableObject obj;

    public Object deepClone() throws IOException,ClassNotFoundException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public String getStr(){
        System.out.println("str" + str);
        return str;
    }

    public void setStr(String str){
        this.str = str;
    }

    public SerializableObject getObj(){
        System.out.println("obj" + obj);
        return obj;
    }

    public void setObj(SerializableObject obj){
        this.obj = obj;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

public class PrototypeTest {
    public static void main(String[] args) {
        SerializableObject so = new SerializableObject();
        Prototype p1 = new Prototype();
        p1.setStr("AAAA");
        p1.setObj(so);
        Prototype p2 = null;

        try {
            p2 = (Prototype) p1.deepClone();
            p2.setStr("BBBB");
            System.out.println("p1" + p1 + "\tp2" + p2);
            System.out.println("p1:" + p1.getStr() + "|" + p1.getSerialVersionUID() );
            System.out.println(p1.getObj().getSerialVersionUID());
            System.out.println("------------------------------------------");
            System.out.println("p2:" + p2.getStr() + "|" + p2.getSerialVersionUID() );
            System.out.println(p2.getObj().getSerialVersionUID());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
