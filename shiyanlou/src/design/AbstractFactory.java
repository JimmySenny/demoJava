package design;

interface Food {
    public String getFoodName();
}

interface TableWare {
    public String getToolName();
}

interface KitchenFactory {
    public Food getFood();
    public TableWare getTableWare();
}

class Apple implements Food{
    @Override
    public String getFoodName() {
        return "Apple";
    }
}

class Knife implements TableWare {
    @Override
    public String getToolName() {
        return "Knife";
    }
}

class AKitchen implements KitchenFactory {
    public Food getFood(){
        return new Apple();
    }
    public TableWare getTableWare(){
        return new Knife();
    }

}

public class AbstractFactory {
    public void eat(KitchenFactory k){
        System.out.println("A foodaholic is eating " + k.getFood().getFoodName() + " with " + k.getTableWare().getToolName());
    }

    public static void main(String[] args) {
        AbstractFactory af = new AbstractFactory();
        KitchenFactory kf = new AKitchen();
        af.eat(kf);
    }

}
