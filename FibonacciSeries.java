import java.util.Scanner;

public class FibonacciSeries {
public static void main(String[] args) {
    System.out.println("Enter the number: ");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();

    int first = 0;
    int second = 1;

    System.out.print("Fibonacci series : " + first + "," + second);
    for(int i = 2; i<number ; i++){
        int next = first + second;
        System.out.print("," + next);
        first = second;
        second = next;
        
    }

}



    
}
