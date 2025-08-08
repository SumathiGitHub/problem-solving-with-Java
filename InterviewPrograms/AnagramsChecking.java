import java.util.Arrays;

public class AnagramsChecking {
    public static void main(String[] args) {
        String word1 = "silent";
        String word2 = "listen";

        String str1 = word1.toLowerCase();
        String str2 = word2.toLowerCase();

        // if(word1.length()!=word2.length()){
        //     System.out.println("The both strings are not Anagrams!");
        // }

       char[] string1= str1.toCharArray();
       char[] string2= str2.toCharArray();

       Arrays.sort(string2);
       Arrays.sort(string1);

       if(Arrays.equals(string1, string2))
       System.out.println("The both strings are Anagrams!");
       else
       System.out.println("The both strings are not Anagrams!");
       
    }
}
