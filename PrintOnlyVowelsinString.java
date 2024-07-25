import java.util.Scanner;

public class PrintOnlyVowelsinString{
    public static void main(String[] args) {
        System.out.println("Enter input string****");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        boolean first = true;
        for(int i = 0; i <inputString.length() ; i++){
            if(inputString.charAt(i)=='a' || inputString.charAt(i)=='e' || inputString.charAt(i)=='i' ||
            inputString.charAt(i)=='o'|| inputString.charAt(i)=='u'){
                    if (!first) {
                        System.out.print(" ");
                    }
                System.out.print(inputString.charAt(i));
                first = false;
            }
        }
        sc.close();
    }
}