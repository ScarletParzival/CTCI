package Chapter_3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/14/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */

/*

Pseudocode:

moveDisks(int n, Tower origin, Tower destination, Tower buffer){

    if(n <= 0)
        return;

    //Move top n-1 disks from Tower 1 to Tower 2 using Tower 3 as a buffer
    moveDisks( n-1, Tower 1, Tower 2, Tower 3);

    //Move the top disk from Tower 1 to Tower 3
    moveTop(Tower 1, Tower 3);

    //Move the top n-1 disks from Tower 2 to Tower 3 using Tower 1 as a buffer
    moveDisks( n-1, Tower 2, Tower 3);
}
 */

public class TowersOfHanoi {

    Stack<Integer> disks;
    int towerIndex;

    public TowersOfHanoi(int towerIndex){
        disks = new Stack<Integer>();
        this.towerIndex = towerIndex;
    }

    public int getTowerIndex(){
        return towerIndex;
    }

    public void add(int value){
        if(!disks.isEmpty() && disks.peek() <= value){
            System.out.println("Error placing the disk");
        }
        else{
            disks.push(value);
        }
    }

    public void moveTopTo(TowersOfHanoi destination){
        int top = disks.pop();
        destination.add(top);
        System.out.println("Moving disk: "+ top + " from Tower[" + this.getTowerIndex() + "] --> Tower[" + destination.getTowerIndex() + "]");
    }

    public  void printTower(){
        System.out.println(this.disks);
    }

    public void printTowers(TowersOfHanoi destination, TowersOfHanoi buffer){
        System.out.println("\t\t\t\t"+destination.disks);
        System.out.println("\t\t\t\t"+buffer.disks);
        System.out.println("\t\t\t\t"+this.disks);
    }

    public void moveDisks(int n, TowersOfHanoi destination, TowersOfHanoi buffer){

    //Origin is not needed here since the 'this' pointer will act as the pointer to the tower of origin

        if(n>0){
            System.out.println("\n\ndestination_Tower["+ destination.getTowerIndex() +"], buffer_Tower["+ buffer.getTowerIndex()+"], origin_Tower["+this.getTowerIndex()+"]");
            printTowers(destination, buffer);
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public static void main(String[] args){

        int numberOfTowers = 3;
        TowersOfHanoi[] towers = new TowersOfHanoi[numberOfTowers];
        for(int i=0; i<numberOfTowers; ++i){
            towers[i] = new TowersOfHanoi(i);
        }

        int numberOfDisks = 5;
        for(int i=numberOfDisks; i>0; --i){
            towers[0].add(i);
        }

        System.out.println();
        towers[0].printTower();
        towers[1].printTower();
        towers[2].printTower();

        towers[0].moveDisks(numberOfDisks, towers[2], towers[1]);

        System.out.println();
        towers[0].printTower();
        towers[1].printTower();
        towers[2].printTower();

    }
}
