package Chapter_3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/14/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackOfPlates {

    ArrayList<Stack> listOfStacks = new ArrayList<Stack>();
    int capacity;

    public StackOfPlates(int capacity){
        this.capacity =capacity;
    }

    public void push(int value){
        if(listOfStacks.size()!=0){
            int index  = listOfStacks.size() - 1;
            if(listOfStacks.get(index).size() < capacity){
                listOfStacks.get(index).push(value);
                return;
            }
        }
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.push(value);
        listOfStacks.add(newStack);
    }

    public int pop(){
        if(listOfStacks.size()>0){
            int index = listOfStacks.size()-1;
            Stack<Integer> lastStack = listOfStacks.get(index);
            int value = lastStack.pop();
            if(lastStack.size()==0){
                listOfStacks.remove(index);
            }
            return value;
        }
        return Integer.MIN_VALUE;
    }

    public void printStackOfPlates(){
       for(int i=0; i<listOfStacks.size();++i){
           Stack<Integer> current = listOfStacks.get(i);
           System.out.println("\n"+current);
       }
    }

    public static void main(String[] args){
        StackOfPlates stackOfPlates = new StackOfPlates(3);

        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);

        stackOfPlates.push(4);

        stackOfPlates.printStackOfPlates();

        stackOfPlates.pop();
        stackOfPlates.pop();

        stackOfPlates.printStackOfPlates();
    }
}
