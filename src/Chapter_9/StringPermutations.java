package Chapter_9;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/21/13
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringPermutations {

    public static ArrayList<String> getPerms(String str) {

        if (str == null) {
            System.out.println("It's a null string");
            return null;
        }

        System.out.println(str);
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        System.out.println("Character to be inserted: "+first);
        String remainder = str.substring(1); // remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                System.out.println("\tWord: "+word);
                System.out.println("\tInserting "+first+" between " +word.substring(0,j)+" and "+word.substring(j));
                permutations.add(s);
            }
        }
        System.out.println("Function returns");
        System.out.println(permutations);
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("\nThere are " + list.size() + " permutations.");
        System.out.println("Permutations: "+list);
        String word = "Hi!";
        System.out.println(word.substring(0,1));
        System.out.println(word.substring(1));
        System.out.println("Am I invisible: "+word.substring(3));
        System.out.println("Am I invisible: "+word.length());

        String Str = new String("Welcome to_Tutorialspoint.com");

        System.out.print("Return Value :" );
        System.out.println(Str.substring(10));

        System.out.print("Return Value :" );
        System.out.println(Str.substring(10, 15) );

    }
}
