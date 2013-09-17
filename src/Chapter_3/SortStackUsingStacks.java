package Chapter_3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/15/13
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortStackUsingStacks {

    public static Stack<Integer> sort(Stack<Integer> originalStack){
        Stack<Integer> sortedStack = new Stack<Integer>();
        while(!originalStack.isEmpty()){
            int element = originalStack.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek() > element){
                System.out.println("Pushing "+sortedStack.peek()+" from the sortedStack into the originalStack");
                originalStack.push(sortedStack.pop());

                System.out.println("OriginalStack: "+originalStack);
                System.out.println("SortedStack: "+sortedStack);
                System.out.println();
            }
            System.out.println("Pushing "+element+" from the originalStack into the sortedStack");
            sortedStack.push(element);

            System.out.println("OriginalStack: "+originalStack);
            System.out.println("SortedStack: "+sortedStack);
            System.out.println();
        }
        return sortedStack;
    }

    public static Stack<Integer> sortStacks(Stack<Integer> originalString){
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!originalString.isEmpty()){
            int top = originalString.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek() > top){
                originalString.push(sortedStack.pop());
            }
            sortedStack.push(top);
        }
        return sortedStack;
    }

    public static void main(String[] args){

        Stack<Integer> originalStack = new Stack<Integer>();

        originalStack.add(6);
        originalStack.add(17);
        originalStack.add(2);
//        originalStack.add(3);
//        originalStack.add(1);
//        originalStack.add(26);
//        originalStack.add(0);
//        originalStack.add(16);
//        originalStack.add(63);
//        originalStack.add(4);
//        originalStack.add(20);

        System.out.println("OriginalStack: "+originalStack+"\n");

        Stack<Integer> sortedStack;
        sortedStack = sortStacks(originalStack);
        sortedStack = sort(originalStack);
        System.out.println("SortedStack: "+sortedStack);
    }
}
