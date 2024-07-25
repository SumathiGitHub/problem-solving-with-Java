public class CountOfEachVowels {

    public static void main(String[] args) {
        String word = "entertainment";
        int count_a = 0;
        int count_e = 0;
        int count_i = 0;
        int count_o = 0;
        int count_u = 0;
        for(int i = 0 ; i < word.length(); i++){
            // if(word.charAt(i) == 'a')
            // count_a++;
            // else if (word.charAt(i) == 'e')
            // count_e++;
            // else if(word.charAt(i)=='i')
            // count_i++;
            // else if(word.charAt(i)=='o')
            // count_o++;
            // else if(word.charAt(i) == 'u')
            // count_u++;
            //char ch =  word.charAt(i);
            switch (word.charAt(i)) {
                case 'a':
                count_a++;
                break;
            
                case 'e':
                count_e++;
                break;

                case 'i':
                count_i++;
                break;

                case 'o':
                count_o++;
                break;

                case 'u':
                count_u++;
                break;

                default:
                break;
            }

        }
        System.out.println("Count of each vowels present in the string : " + "a: "+count_a + " e: "+count_e + " i: " + count_i + " o: " + count_o + " u: " + count_u);
    }
    
}
