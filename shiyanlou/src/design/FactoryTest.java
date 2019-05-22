package design;

interface Human{
    public void eat();
    public void sleep();
    public void beat();
}

class Male implements Human{
    @Override
    public void eat(){
        System.out.println("Male eat");
    }
    @Override
    public void sleep(){
        System.out.println("Male sleep");
    }
    @Override
    public void beat() {
        System.out.println("Male beat");
    }
}

class Female implements Human{
    @Override
    public void eat() {
        System.out.println("Female eat");
    }
    @Override
    public void sleep() {
        System.out.println("Female sleep");
    }
    @Override
    public void beat() {
        System.out.println("Female beat");
    }
}

class HumanFactory{
    public Human createHuman(String gender){
        if(gender.equals("male")){
            return new Male();
        }else if (gender.equals("female")){
            return new Female();
        }else{
            System.out.println("Error gender");
            return null;
        }
    }
}

class HumanFactory2{
    public Human createMale(){
        return new Male();
    }
    public Human createFemale(){
        return new Female();
    }
}

class HumanFactory3{
    public static Human createMale(){
        return new Male();
    }
    public static Human createFemale(){
        return new Female();
    }
}

class HumanFactory4{
    public static Human createHuman(String className){
        Human h = null;
        try{
            h = (Human)Class.forName(className).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return h;
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();
        Human male = factory.createHuman("male");
        male.eat();

        HumanFactory2 f2 = new HumanFactory2();
        Human m2 = f2.createMale();
        m2.eat();

        Human m3 = HumanFactory3.createMale();
        m3.eat();

        Human m4 = HumanFactory4.createHuman("design.Male");
        m4.eat();
    }
}
