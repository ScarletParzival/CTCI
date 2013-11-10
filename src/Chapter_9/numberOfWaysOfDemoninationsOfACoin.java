//package Chapter_9;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
///**
// * Created with IntelliJ IDEA.
// * User: sowmyahariharan
// * Date: 10/26/13
// * Time: 6:36 PM
// * To change this template use File | Settings | File Templates.
// */
//
//class CoinDenomination{
//    public int quarters;
//    public int dimes;
//    public int nickels;
//    public int pennies;
//
//    public CoinDenomination(int quarters, int dimes, int nickels, int pennies){
//        this.quarters = quarters;
//        this.dimes = dimes;
//        this.nickels = nickels;
//        this.pennies = pennies;
//    }
//
//    @Override
//    public String toString(){
//        return "Coin -  "+ quarters + " quarters: " + dimes + " dimes: " + nickels + " nickels: " + pennies + " pennies";
//    }
//}
//
//class IntegerWrap{
//    int value;
//    public IntegerWrap(int value){
//        this.value = value;
//    }
//}
//
//public class numberOfWaysOfDemoninationsOfACoin {
////    public static int makeChange(int amount, int[] denoms, int index) {
////        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
////        int denomAmount = denoms[index];
////        int ways = 0;
////        for (int i = 0; i * denomAmount <= amount; i++) {
////            int amountRemaining = amount - i * denomAmount;
////            ways += makeChange(amountRemaining, denoms, index + 1); // go to next denom
////        }
////        return ways;
////    }
////
////    public static int makeChange1(int n) {
////        int[] denoms = {25, 10, 5, 1};
////        return makeChange(n, denoms, 0);
////    }
////
////    public static int makeChange2(int n) {
////        int[] denoms = {25, 10, 5, 1};
////        int[][] map = new int[n + 1][denoms.length];
////        return makeChange2(n, denoms, 0, map);
////    }
////
////    public static int makeChange2(int amount, int[] denoms, int index, int[][] map) {
////        if (map[amount][index] > 0) { // retrieve value
////            return map[amount][index];
////        }
////        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
////        int denomAmount = denoms[index];
////        int ways = 0;
////        for (int i = 0; i * denomAmount <= amount; i++) {
////            // go to next denom, assuming i coins of denomAmount
////            int amountRemaining = amount - i * denomAmount;
////            ways += makeChange2(amountRemaining, denoms, index + 1, map);
////        }
////        map[amount][index] = ways;
////        return ways;
////    }
////
////    public static int makeChange(int n) {
////        int x = makeChange1(n);
////        int y = makeChange2(n);
////        if (x != y) {
////            System.out.println("Error: " + x + " " + y);
////        }
////        return x;
////    }
////
////    public static void main(String[] args) {
////        for (int i = 0; i <= 100; i++) {
////            System.out.println("makeChange(" + i + ") = " + makeChange(i));
////        }
////    }
////
////}
//
//    public static long numberOfDenomintaions(ArrayList<CoinDenomination> listOfCoinCombos,int amountRemaning, IntegerWrap quarters, IntegerWrap dimes, IntegerWrap nickels, IntegerWrap pennies, String me{
////        System.out.println(amountRemaning +": "+quarters+", "+dimes+", "+nickels+", "+dimes);
//        System.out.println("Checking for amount: " + amountRemaning+" with a: "+me);
//        if(amountRemaning < 0) {
//            System.out.println(":");
//            return 0;
//        }
//        if(amountRemaning == 0) {
//
////            switch (d){
////
////                case 'q': ++quarters.value; break;
////                case 'd': ++dimes.value; break;
////                case 'n': ++nickels.value; break;
////                case 'p': ++pennies.value; break;
////            }
////            System.out.println(amountRemaning +": "+quarters+", "+dimes+", "+nickels+", "+dimes);
////            CoinDenomination coinDenomination = new CoinDenomination(quarters.value, dimes.value, nickels.value, pennies.value);
////            listOfCoinCombos.add(coinDenomination);
//            System.out.println("Yes!");
//            return 1;
//        }
//
//        long totalWays = numberOfDenomintaions(listOfCoinCombos, amountRemaning-25, quarters, dimes, nickels, pennies, "quarter") +
//                         numberOfDenomintaions(listOfCoinCombos, amountRemaning-10, quarters, dimes, nickels, pennies, "dime") +
//                         numberOfDenomintaions(listOfCoinCombos, amountRemaning-5, quarters, dimes, nickels, pennies, "nickel") +
//                         numberOfDenomintaions(listOfCoinCombos, amountRemaning-1, quarters, dimes, nickels, pennies, "penny");
//        return totalWays;
//
//    }
//    public static void main(String[] args) throws IOException {
//        // Get the amount remaining as the input from the user
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//        int amountRemaining;
////        amountRemaining = Integer.parseInt(stringTokenizer.nextToken());
//        amountRemaining = 5*2;
//        ArrayList<CoinDenomination> coinDenominations = new ArrayList<CoinDenomination>();
//
//        long totalNumberOfWays = numberOfDenomintaions(coinDenominations, amountRemaining, new IntegerWrap(0), new IntegerWrap(0), new IntegerWrap(0), new IntegerWrap(0), "Main");
//        for(CoinDenomination c : coinDenominations){
//            System.out.println(c);
//        }
//        System.out.println("Total number of ways: "+totalNumberOfWays);
//    }
//}
