public class IntegerTest {
    public static void main(String[] args) {
        Integer ia = new Integer("10");
        Integer ib = new Integer( 10);

        System.out.println(ia.compareTo(ib));
        System.out.println(ia.equals(ib));

        Double da = new Double("10.1");
        Double db = new Double(10.1);

        double dc = da.doubleValue();

        System.out.println(dc);
        System.out.println(da.equals(dc));

        String s1 = "100100100";
        int ic = Integer.parseInt(s1,2);
        System.out.println(ic);
    }
}
