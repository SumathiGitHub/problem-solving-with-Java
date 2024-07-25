public class Palindrome {
    public static void main(String[] args) {
        String name = "Appa";
        //checking cases
        String name1 = name.toUpperCase();
        StringBuffer newString = new StringBuffer();
        for(int i = name1.length()-1; i>=0 ; i--){
         newString.append(name1.charAt(i));
        }
        String reversed = newString.toString();
        if (name1.equals(reversed)) {
            System.out.println("The given string is palindrome!");
        }
        else
        System.out.println("The given string is not palindrome!");
       
    }
}
