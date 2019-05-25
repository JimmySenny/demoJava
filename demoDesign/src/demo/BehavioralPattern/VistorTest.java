package demo.BehavioralPattern;

interface Vistor{
    public void visit(MySubjectV sub);
}

class MyVistor implements Vistor{
    @Override
    public void visit(MySubjectV sub) {
        System.out.println("visit the subject:"+sub.getSubjectV());
    }
}

interface SubjectV{
    public void accept(Vistor vistor);
    public String getSubjectV();
}

class MySubjectV implements SubjectV{
    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    @Override
    public String getSubjectV() {
        return "love";
    }
}
public class VistorTest {
    public static void main(String[] args) {
        Vistor vistor = new MyVistor();
        SubjectV sub = new MySubjectV();

        sub.accept(vistor);
        System.out.println(sub.getSubjectV());
    }
}
