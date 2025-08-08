import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        //withrecursion
        System.out.println("Enter input number****");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        //input.close();
        int factorial =   withRecursion(number);
        System.out.println("Factorial of " + number + " is :"  + factorial);

        withoutRecursion();    
    }

    public static void withoutRecursion(){
        System.out.println("Enter input number****");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int i = number;
        int fact = 1;
        while (i>1) {
            fact = fact * i;
            i--;
        }

        System.out.println("Factorial of " + number + " is :"  + fact);
        input.close();
    }


    public static int withRecursion(int fact){

        if(fact<=1)
        return 1;
        else
        return fact * withRecursion(fact-1);
    }
}


