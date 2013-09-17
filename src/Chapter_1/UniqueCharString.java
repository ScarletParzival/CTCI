package Chapter_1;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/7/13
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueCharString {

    public static void  main(String[] args){
       System.out.println("isTheStringUnique: "+ isTheStringUnique("ABC"));
       System.out.println("isTheStringUniqueUseHash: " + isTheStringUniqueUseHash("ABCDEFA"));
       System.out.println("isTheStringUniqueUseBitVector: " + isTheStringUniqueUseBitVector("abcdefgha"));

       // I think the assumption is that 'A' and 'a' are different.
       System.out.println("isTheStringUniqueUseBoolean: " + isTheStringUniqueUseBoolean("ACDfvbsa"));
    }

    private static boolean isTheStringUnique(String string){
        for(int i=0; i<string.length(); ++i){
            char ch = string.charAt(i);
            for(int j=i+1; j<string.length(); ++j){
                char compare = string.charAt(j);
                if(ch == compare){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isTheStringUniqueUseHash(String string){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<string.length(); ++i){
            char ch = string.charAt(i);
            if(map.containsKey(ch)){
                return false;
            }
            else{
                map.put(ch,i);
            }
        }
        return true;
    }

    private static boolean isTheStringUniqueUseBitVector(String string){
        int vector = 0;
        //Assuming that the string has only ASCII characters (256 in total) and that it has only letters from a to z.
        for(int i=0; i<string.length(); ++i){
            int compare = string.charAt(i) - 'a';
            if((vector & (1<<compare)) > 0){
                return false;
            }
            else{
                vector = vector | (1 << compare);
            }
        }
        return true;
    }

    private  static boolean isTheStringUniqueUseBoolean(String string){
        boolean[] uniqueArray = new boolean[256];
        for(int i=0; i<string.length(); ++i){
            char ch = string.charAt(i);
            if(uniqueArray[ch]){
                return false;
            }
        }
        return true;
    }
}
