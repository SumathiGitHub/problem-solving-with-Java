
public class CountOfFirstCharacter {
    public static void main(String[] args) {

        String word = "rajendiran.tr";
        int count = 0;
        for(int i = 0; i < word.length() ; i++){
            if(word.charAt(i) == word.charAt(0)){
                count = count + 1; //count++;
            }
        }
        System.out.println("Count of first character in the given string is:" + count);
    }

}