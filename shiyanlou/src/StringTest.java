public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        char c1 = s1.charAt(2);
        System.out.println(c1);

        byte[] b1 = s1.getBytes();
        for (int i = 0; i < b1.length; i++) {
            System.out.println(b1[i]);
        }

        char[] c2 = s1.toCharArray();
        for (int i = 0; i < c2.length; i++) {
            System.out.println(c2[i]);
        }

        StringBuffer sb1 = new StringBuffer(s1);
        sb1.append(123);
        System.out.println(sb1);

        String s3 = sb1.toString();
        System.out.println(s3);
    }
}
