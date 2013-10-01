package General;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/1/13
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */

class StringEnclosure{

    public StringEnclosure(String word){
        this.word = word;
        indexes = new ArrayList<Integer>();
    }

    String word;
    ArrayList<Integer> indexes;
}

public class FindDistanceBetweenStringsInAnArray {

    public static int findDistanceBetweenTwoStrings(ArrayList<String> array, String string1, String string2){
        StringEnclosure s1 = new StringEnclosure(string1);
        StringEnclosure s2 = new StringEnclosure(string2);
        fillInTheIndexes(s1,s2,array);
        return findMinimumDistance(s1.indexes, s2.indexes);
    }
    public static void fillInTheIndexes(StringEnclosure s1, StringEnclosure s2, ArrayList<String> arrayList){
        int counter = 0;
        for(String s:arrayList){
            if(s.equals(s1.word)){
                s1.indexes.add(counter);
            }
            else if(s.equals(s2.word)){
                s2.indexes.add(counter);
            }
            ++counter;
        }
    }

    public static int findMinimumDistance(ArrayList<Integer> a1, ArrayList<Integer> a2){
        int counter1 = 0, counter2 = 0;
        int globalMin = -1;
        while (counter1<a1.size() && counter2 < a2.size()){
            int min = Math.abs(a1.get(counter1) - a2.get(counter2));
            if( globalMin < min ){
               globalMin = min;
            }
            if(a1.get(counter1) < a2.get(counter2)){
                ++counter1;
            }
            else {
                ++counter2;
            }
        }
        return globalMin;
    }

    public static void main(String[] args){
        try{
            BufferedReader bin = new BufferedReader(new FileReader("/Users/sowmyahariharan/Desktop/workspace - all/workspace/Java/CTCI/src/General/FindDistanceBetweenStringsInAnArrayInput.txt"));
            String[] array = bin.readLine().split(" ");
            int testCases = Integer.parseInt(bin.readLine());
            System.out.println("Array of strings from the file:");
            for(int j=0; j<array.length; ++j){
                System.out.print(array[j]+" ");
            }
            System.out.println();
            for(int i=0; i<testCases; ++i){
                String[] words = bin.readLine().split(" ");
                String word1 = words[0];
                String word2 = words[1];
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
                System.out.println("Distance between "+ word1 +" and "+ word2+" in the array is: "+findDistanceBetweenTwoStrings(arrayList, word1, word2));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
