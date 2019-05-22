public class characterTest {
    public static void main(String[] args) {
        int count = 0;
        char[] values = {'*','_','%','8','L','l'};

        for (int i = 0; i < values.length; i++){
            System.out.print(values[i]);
            if(Character.isDigit(values[i])){
                System.out.println(" isDigit ");
            }
            if(Character.isAlphabetic(values[i])){
                System.out.println(" isAlphabetic");
            }
            if(Character.isLetter(values[i])){
                System.out.println(" isLetter");
            }
            if(Character.isUpperCase(values[i])){
                System.out.println(" isUpper");
            }
            if(Character.isLowerCase(values[i])){
                System.out.println(" isLower");
            }
            if(Character.isUnicodeIdentifierStart(values[i])){
                System.out.println(" isUnicode");
            }
            System.out.println("");

        }
    }
}
