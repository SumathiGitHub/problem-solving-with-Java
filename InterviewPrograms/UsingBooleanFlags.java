public class UsingBooleanFlags {
    public static void main(String[] args) {
        //commasBetweenNumbers();
        firstTimeInitialization();

    }

    public static void commasBetweenNumbers(){
        int arr[] = {1,2,3,4,5};
        boolean first = true;
        for(int numbers : arr){
            if(!first){
                System.out.print(",");
            }
            
            System.out.print(numbers);
            first = false;
        }
    }


    public static void firstTimeInitialization(){
        boolean initialized = false;
        for(int i = 0 ; i<10 ; i++){

            if(!initialized){
                System.out.println("Initializing.....");
                initialized = true;
            }
            System.out.println("Processing item:" + i);

        }
    }
    
}
