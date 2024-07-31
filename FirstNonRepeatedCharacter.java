import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "sumathi";
       char c =  findingFirstNonRepeated(input);
       if(c!=0){
        System.out.println("First non-repeated character in a string : " + c);
         }
         else
         System.out.println("No non-repeated character!");
    }

    public static char findingFirstNonRepeated(String input){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c ,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()==1)
            return entry.getKey();
        }
    return 0;
    }
}
