public class Palindrome {
    public static void main(String[] args) {
        //withString();
        withNumber();            
    }

    public static void withString(){
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

    public static void withNumber(){
        int number = 12321;
        int original = number;
        int reversedNo = 0;
        while(number>0){
            int digit = number%10;   // extracting digits
            reversedNo = reversedNo*10 + digit;
            number = number/10;   // removing digits
         }
         if(original==reversedNo){
            System.out.println("Palindrome!");
         }
         else
         System.out.println("Not Palindrome!");

    }
}
