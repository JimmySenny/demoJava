package demo.BehavioralPattern;

class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute method1");
    }

    public void method2(){
        System.out.println("execute method2");
    }
}

class Context{
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void methodSwitch(){
        if(state.getValue() == null ){
            System.out.println("nothing to do");
            return;
        }

        if(state.getValue().equals("state1")){
            state.method1();
        }else if(state.getValue().equals("state2")){
            state.method2();
        }else{
            System.out.println("nothing to do");
        }
    }
}

public class StateTest {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        context.methodSwitch();
        state.setValue("state1");
        context.methodSwitch();
        state.setValue("state2");
        context.methodSwitch();
    }
}
