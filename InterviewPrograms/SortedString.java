public class sortedString{
  public static void main(String args[]){
    String input = "hello";
    char[] ch = input.tocharArray();
    Arrays.sort(ch);
    String sortedString = new String(ch);
    System.out.println("Sorted String is: " + sortedString);
}
}
