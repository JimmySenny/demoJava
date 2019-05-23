package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Sender {
    public void Send();
}

class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
    public String toString(){
        return "MailSender";
    }
}

class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
    public String toString(){
        return "SmsSender";
    }
}
/*
interface Provider {
    public Sender produce();
}

class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}

class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

 */

class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }

    public List<Sender> getBuilder(){
        return list;
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);

        List<Sender> list = builder.getBuilder();
        Iterator<Sender> iter = list.iterator();
        while (iter.hasNext()){
//            Sender sdr = iter.next();
//            System.out.println(sdr + sdr.toString() );
            System.out.println(iter.next());
        }
    }
}
