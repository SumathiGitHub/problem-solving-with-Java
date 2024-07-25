public class ArmstrongNumber {

    public static void main(String[] args) {
        int number = 1634;
        int orgNo = number;
        int noOfDigits = Integer.toString(number).length();
        int sum = 0;
        while(number>0){
            int digit = number%10;
            double value = Math.pow(digit, noOfDigits);
            sum = sum + (int) value;
            number = number/10;

        }
        if (orgNo==sum) {
          System.out.println("The given number " + orgNo + " is " + "Armstrong Number!");  
        }
        else
        System.out.println("The given number " + orgNo + " is" + " Not Armstrong Number!");  
    }
    
}
