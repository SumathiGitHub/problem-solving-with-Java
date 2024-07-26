public class PerfectNumber {

    public static void main(String[] args) {
        //A perfect number is a positive integer that is equal to the sum of its proper divisors.
        //Example: 6 is a perfect number because 1+2+3=6.

        int no = 496;
        int orgNo = no;
        int sum = 0 ; 
        for(int i = 1; i < no ; i++){
            if(no%i==0){
                sum = sum + i;
            }
            
        }
        if(sum==orgNo){
            System.out.println("Perfect Number!");
        }
        else
        System.out.println("Not perfect Number!");

    }
    
}
