package Chapter_1;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/7/13
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseNullTerminatedStringInC {

    public  static void main(String[] args){
        System.out.println(reverseNullTerminatedStringUseStringBuffer("Hello World"));
    }

//    private static StringBuffer reverseNullTerminatedStringInCWay(String string){
//        //Not yet implemented
//    }

    private static String reverseNullTerminatedStringUseStringBuffer(String string){
        int index = string.length();
        StringBuffer resultString = new StringBuffer();
//        resultString.append('\n');
        for(int i=string.length()-1; i>=0 ; --i){
           resultString.append(string.charAt(i));
        }
        return resultString.toString();
    }
}
