package Chapter_3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/15/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueUsingTwoStacks {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public QueueUsingTwoStacks(){
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    public void addtoQueue(int element){
        if(pushStack.isEmpty()){
            transferStackElements(pushStack,popStack);
        }
        pushStack.add(element);
    }

    public int removeFromQueue(){
        if(popStack.isEmpty()){
            transferStackElements(popStack,pushStack);
        }
        if(popStack.isEmpty()){
           return Integer.MIN_VALUE;
        }
        return popStack.pop();
    }

    public void printQueue(){
        if(pushStack.isEmpty()){
            transferStackElements(pushStack, popStack);
        }
        System.out.println();
        for(Integer i : pushStack){
            System.out.print(i+"<--");
        }
        System.out.println();
    }

    public void transferStackElements(Stack<Integer> destinationStack, Stack<Integer> originStack){
        while (!originStack.isEmpty()){
           destinationStack.add(originStack.pop());
        }
    }

    public static void main(String[] args){
       QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
       for(int i=1; i<=10; ++i){
        queue.addtoQueue(i);
       }

       System.out.println(queue.pushStack);

       queue.printQueue();

       System.out.println(queue.removeFromQueue());
       System.out.println(queue.removeFromQueue());

       queue.addtoQueue(56);
       System.out.println(queue.removeFromQueue());

       queue.printQueue();
    }
}
