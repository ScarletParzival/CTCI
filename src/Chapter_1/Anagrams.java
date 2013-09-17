package Chapter_1;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/7/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {

    public static void main(String[] args){
        System.out.println(areTheStringsAnagrams("Dog","God"));
    }
    private static boolean areTheStringsAnagrams(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        return sortString(s1).equals(sortString(s2));
    }
    private static String sortString(String string){
        char[] ch = string.toLowerCase().toCharArray();
        java.util.Arrays.sort(ch);
        System.out.println(ch.toString());
//        Character[] chObjectArray = ArrayUtil.to
//        return Arrays.toString();
        return new String(ch);
//        return ch.toString();  Why, won't it work here? See, 'Things you can't do with Java' evernote.
        /*
         12 down vote accepted


To get a human-readable toString(), you must use Arrays.toString(), like this:

System.out.println(Arrays.toString(Array));

Java's toString() for an array is to print [, followed by a character representing the type of the array's elements (in your case C for char), followed by @ then the "identity hash code" of the array (think of it like you would a "memory address").

This sad state of affairs is generally considered as a "mistake" with java.
         */
    }
}
