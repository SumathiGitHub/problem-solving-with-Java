import java.util.HashSet;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "programming";
        char repeatedChar = findingFirstRepeatedcharacter(input);
        if(repeatedChar!=0){
            System.out.println("First repeated character in a string :" + repeatedChar);
        }
        else
        System.out.println("No repeated character in a string!");
        
    }

    public static char findingFirstRepeatedcharacter(String input){
    HashSet hashSet = new HashSet<>();
     
    for(char c : input.toCharArray()){
        if(hashSet.contains(c)){
            return c;
        }
        else
        {
            hashSet.add(c);
        }
    }
    return 0;
}
}
