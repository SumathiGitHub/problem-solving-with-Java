public class CountingOfDigits {
    public static void main(String[] args) {

        int number = 1234556788;
        int count = 0;
        while(number>0){
            int digit = number%10;
            count++;
            number = number/10;

        }
        if(count==0){
            count = 1;
        }
        System.out.println(count);
        
    }
}
