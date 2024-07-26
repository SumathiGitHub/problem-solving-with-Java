public class CountingConsonantsinString {

    public static void main(String[] args) {
        
        String input = "hello";
        for(int i = 0 ; i < input.length()-1 ; i++){
           char inputChar =  input.charAt(i);
            if(!(inputChar=='a' || inputChar=='e' || inputChar=='i' || inputChar=='o' || inputChar=='u')){
                System.out.println(input.charAt(i));
            }
        }
    }
    
}
