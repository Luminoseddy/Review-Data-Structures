package reversewordsinastring;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("Testing reveresed strings"));
    }
    
    public static String reverseWords(String s) {

        /* BASE CASE. */
        if (s == null || s.length() == 0) { return ""; }
        
        /* For every " " it sees in the string, it gets cut out and placed in a index of an array. */
        String[] arr = s.split(" "); 
        
        /* Create a Stringbuilder object. */
        StringBuilder sb = new StringBuilder(); 
        
        /* Traverse from the end of the array. */
        for (int i = arr.length - 1; i >= 0; --i) {
            /* If the word in the index of the array is not empty string */
            if (!arr[i].equals("")) {
                /* Append in the string builder: the word and then a space.  */
                sb.append(arr[i]).append(" "); 
            }
        }
        /**
         * ? is a wild card.
         * If the string builders length is 0, return empty string
         * Else, return the entire string from index 0 to stringBuilders length -1.
         **/
        System.out.println("return: " + sb.substring(0, sb.length() - 1));
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
