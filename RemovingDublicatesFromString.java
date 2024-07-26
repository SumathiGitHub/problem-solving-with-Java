public class RemovingDublicatesFromString {
    public static void main(String[] args) {
        //Write a program to remove duplicate characters from a given string.
        //Example: Input: "programming", Output: "progamin".

        String input = "programming";
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < input.length() ; i++){
           char c =  input.charAt(i);
            if((sb.indexOf(String.valueOf(c) ) == -1)){
                //System.out.println(sb.append(c));
                sb.append(c);
            }
        }
        System.out.println("After removing duplicates from string : " 
        + sb);
    }
}
