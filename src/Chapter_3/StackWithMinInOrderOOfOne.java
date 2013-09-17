package Chapter_3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/14/13
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackWithMinInOrderOOfOne extends Stack<Integer> {
    Stack<Integer> minStack;

    public StackWithMinInOrderOOfOne(){
        minStack = new Stack<Integer>();
    }

    public void push(int value){
        int minValue = min();
        if(value < minValue){
            minStack.push(value);
        }
        else{
            minStack.push(minValue);
        }
        super.push(value);
    }

    public Integer pop(){
        if(!super.isEmpty()){
            minStack.pop();
            return super.pop();
        }
        return Integer.MAX_VALUE;
    }

    public int min(){
        if(!minStack.empty()){
            return minStack.peek();
        }
        else
            return Integer.MAX_VALUE;
    }

    public void printStack(){
        System.out.println(this);
//        for(Integer i:super){
//            System.out.println(i);
//        }
    }

    public void printMinStack(){
        System.out.println(minStack);
//        for(Integer i:minStack){
//            System.out.println(i);
//        }
    }

    public static void main(String[] args){
        StackWithMinInOrderOOfOne stack = new StackWithMinInOrderOOfOne();
        stack.push(11);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        stack.push(6);
        stack.push(2);

        stack.printStack();
        stack.printMinStack();

        stack.pop();
        System.out.println();
        stack.printStack();
        stack.printMinStack();

        stack.pop();
        System.out.println();
        stack.printStack();
        stack.printMinStack();

//        System.out.println(stack);


    }
}
