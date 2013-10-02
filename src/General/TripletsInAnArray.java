package General;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/1/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TripletsInAnArray {

    public static void printTriplets(int[] a){
      HashSet<Integer> map = new HashSet<Integer>();
      for(int j=0; j<a.length; ++j){
         map.add(a[j]);
      }

      for(int i=0; i<a.length; ++i){
          for(int j=i+1; j<a.length; ++j){
               if(map.contains(-(a[i]+a[j]))){
                   System.out.println(a[i]+","+a[j]+", "+ -(a[i]+a[j]));
               }
          }
      }
    }

    public static void main(String[] args){
        try{
            BufferedReader bin = new BufferedReader(new FileReader("/Users/sowmyahariharan/Desktop/workspace - all/workspace/Java/CTCI/src/General/TripletsInAnArrayInput.txt"));
            String[] array = bin.readLine().split(" ");
            int[] a = new int[array.length];

            for(int i=0; i<array.length; ++i){
                a[i] = Integer.parseInt(array[i]);
            }

            printTriplets(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
