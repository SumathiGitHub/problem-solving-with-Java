import java.util.Scanner;

public class ReverseAString {

    public static void main(String[] args) {
        withoutReverseMethod();
        withReverse();      
    }

    public static void withReverse(){
        System.out.println("Enter input string : ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();   //Sumathi
        StringBuffer newString = new StringBuffer(inputString);
        StringBuffer reversedString = newString.reverse();
        System.out.println("Reversed string is : " + reversedString);
    }

    public static void  withoutReverseMethod(){

        System.out.println("Enter input string : ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();   //Sumathi
        StringBuffer newString = new StringBuffer();
        StringBuffer reversedString = null;

        for (int i = inputString.length()-1 ; i>=0 ; i--){

           reversedString = newString.append(inputString.charAt(i));

        }
        
        System.out.println(reversedString);
    }
    
}
