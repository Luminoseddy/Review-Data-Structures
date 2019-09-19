
package reversewordsinastring;


public class ReverseWordsInAString {


    public static void main(String[] args) {
        System.out.println(reverseWords("Testing reveresed strings"));
    }
    
    public static String reverseWords(String s) {
            /* BASE CASE. */
            if (s == null || s.length() == 0) { return ""; }

            /* Every " " it sees in the string, it gets cut out and placed in a index of an array. */
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; --i) {
                    if (!arr[i].equals("")) {
                        sb.append(arr[i]).append(" ");
                    }
            }
            return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
}
