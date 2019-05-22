public class ClassTest {
    public static void main(String[] args) {
        String objString = new String();
        Class objClass;

        try{
            objClass = objString.getClass();
            System.out.println(objClass.getName());
            objClass = Integer.class;
            System.out.println(objClass.getName());
            objClass = Class.forName("java.lang.String");
            System.out.println(objClass.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
