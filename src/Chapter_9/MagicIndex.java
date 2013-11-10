package Chapter_9;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/18/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MagicIndex {

    public static void printMagicIndexes(int[] a){
        System.out.print("Magic indexes: ");
        int loopCounter = 0;
        for(int i=0; i<a.length; ++i){
            ++loopCounter;
            if(a[i] == i){
                System.out.print(i+" ");
            }
            else if(a[i] > i){
                if(a[i] < a.length){
                    i = a[i]-1;
                }
                else{
                    System.out.println("\nThe for loop was run "+loopCounter+" times");
                    return;
                }
            }
        }
        System.out.println("\nThe loop was run: "+loopCounter);
    }
    public static void main(String[] args){
//        int[] sortedArray = {0,1,2,3,4,5,6,734,234234};
//        int[] sortedArray = {1,2,3,4,5,6,734,234234};
        int[] sortedArray = {0,1,3,3,4,5,6,734,234234};
        printMagicIndexes(sortedArray);
    }
}
