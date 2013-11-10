package Chapter_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/21/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParanthesisOfPairsOfN {

      public static void returnListOfParens(ArrayList<String> list, int leftCount, int rightCount, char[] strings, int index){
          if(leftCount < 0 || rightCount < 0){
              return;
          }
          if(leftCount==0 && rightCount==0){
              String st = String.copyValueOf(strings);
              list.add(st);
          }
          else {
              if(leftCount > 0){
                  strings[index] = '(';
                  returnListOfParens(list, leftCount-1, rightCount, strings, index+1);
              }
              // Make sure that you don't add the else here for the if part.
              // Our recursive calls have to branch out into all cases. So, we should only compare with 'if' and not 'else if'.
              if(rightCount > leftCount){
                  strings[index] = ')';
                  returnListOfParens(list, leftCount, rightCount-1, strings, index+1);
              }
          }
      }

      public static ArrayList<String> generateParens(int count){
          char[] strings = new char[2*count];
          ArrayList<String> list = new ArrayList<String>();
          returnListOfParens(list, count, count, strings, 0);
          return list;
      }

      public static void main(String[] args) throws IOException {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer stringTokenizer= new StringTokenizer(bufferedReader.readLine());
          int count = Integer.parseInt(stringTokenizer.nextToken());
          ArrayList<String> list = generateParens(count);
          System.out.println(list);
      }

}
