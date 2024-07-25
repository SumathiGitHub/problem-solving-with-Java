public class CountOfVowels {

    public static void main(String[] args) {
        String word = "entertainment";
        int count = 0;
        for(int i = 0; i < word.length() ; i++){
         if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u')
            {
                    count++;
            }
        }
        if(count==0)
        System.out.println("No vowels present in the string");
        else
        System.out.println("Vowels present in the string!" + "Count of Vowels in the string is :" + count);
    }
    
}
