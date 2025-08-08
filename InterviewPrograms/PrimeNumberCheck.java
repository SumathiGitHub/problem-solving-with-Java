public class PrimeNumberCheck {

    public static void main(String[] args) {
        int i = 0;
        int number = 28;
        boolean prime = true;
        if(number<=1)
        {
            System.out.println("Not prime");     
        }
        else{
            for(i = 2; i < number ; i++){
                if(number%i ==0){
                    prime = false;
                    break;
                }       
            }
        
        if(prime)
        System.out.println("Prime!");
        else
        System.out.println("Not Prime!");
        }
    }
    
}
