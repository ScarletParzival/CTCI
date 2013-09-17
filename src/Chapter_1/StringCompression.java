package Chapter_1;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/7/13
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
/*
aaabbbbccdeeee
a3b4c2d1e4
 */

public class StringCompression {
    public static void main(String[] args){
        System.out.println(compressStringUsingCounts("aaabbbbccdeeee"));
    }
    private static String compressStringUsingCounts(String string){
        StringBuffer encodedString = new StringBuffer();
        int count =1;
        for(int i=0; i<string.length(); ++i){
            char ch = string.charAt(i);
            if(((i+1)<string.length()) && ch == string.charAt(i+1)){
                ++count;
            }
            else {
                encodedString.append(ch);
                encodedString.append(count);
                count = 1;
            }
        }
        String resultString = new String(encodedString);
        if(resultString.length() >= string.length())
            return string;
        return resultString;
    }
}