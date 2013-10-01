import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/30/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordInABoard {

    static void isWordPresentInBoard(char[][] board, String word){
        int size = board.length;
        boolean wordFound = false;
        int k = 0;
        for(int i=0; i<size; ++i){
            for(int j=0; j<size; ++j){
                if(board[i][j] == word.charAt(k)){
                    if(checkForWordAtPosition(board, i, j, word, 1)){
                        System.out.println("TRUE");
                    }
                }
            }
        }
    }

    static boolean checkForWordAtPosition(char[][] board, int i, int j, String word, int characterAt){
        System.out.println(characterAt);
        if(characterAt >= word.length()){
            System.out.println("TRUE");
            return true;
        }
//        System.out.println("Outside    i: "+i+", j: "+j);
        if(((i>=0 && i<board.length) && (j>=0 && j<board.length))){
            System.out.println("i: "+i+", j: "+j);
            if(i-1 >= 0){
                System.out.println("i-1: "+(i-1)+", j: "+j+", characterAt: "+characterAt);
                if(board[i-1][j] == word.charAt(characterAt)){
                    System.out.println("i-1: "+(i-1)+", j: "+j);
                    checkForWordAtPosition(board, i-1, j, word, characterAt+1);
                }
//                System.out.println("i-1: "+(i-1)+", j-1: "+(j-1));
                if(j-1 >= 0){
                    if(board[i-1][j-1] == word.charAt(characterAt)){
                        System.out.println("i-1: "+(i-1)+", j-1: "+(j-1));
                        checkForWordAtPosition(board, i-1, j-1, word, characterAt+1);
                    }
                }
//                System.out.println("i-1: "+(i-1)+", j+1: "+(j+1));
                if(j+1 < board.length){
                    if(board[i-1][j+1] == word.charAt(characterAt)){
                        System.out.println("i-1: "+(i-1)+", j+1: "+(j+1));
                        checkForWordAtPosition(board, i-1, j+1, word, characterAt+1);
                    }
                }
            }
            if(i+1 < board.length){
//                System.out.println("i+1: "+(i+1)+", j: "+j);
                if(board[i+1][j] == word.charAt(characterAt)){
                    System.out.println("i+1: "+(i+1)+", j: "+j);
                    checkForWordAtPosition(board, i+1, j, word, characterAt+1);
                }
//                System.out.println("i+1: "+(i+1)+", j-1: "+(j-1));
                if(j-1 >= 0){
                    if(board[i+1][j-1] == word.charAt(characterAt)){
                        System.out.println("i+1: "+(i+1)+", j-1: "+(j-1));
                        checkForWordAtPosition(board, i+1, j-1, word, characterAt+1);
                    }
                }
//                System.out.println("i-1: "+(i-1)+", j+1: "+(j+1));
                if(j+1 < board.length){
                    if(board[i+1][j+1] == word.charAt(characterAt)){
                        System.out.println("i-1: "+(i-1)+", j+1: "+(j+1));
                        checkForWordAtPosition(board, i+1, j+1, word, characterAt+1);
                    }
                }
            }
//            System.out.println("i: "+i+", j-1: "+(j-1));
            if(j-1 >= 0){
                if(board[i][j-1] == word.charAt(characterAt)){
                    System.out.println("i: "+i+", j-1: "+(j-1));
                    checkForWordAtPosition(board, i, j-1, word, characterAt+1);
                }
            }
//            System.out.println("i: "+i+", j+1: "+(j+1));
            if(j+1 < board.length){
                if(board[i][j+1] == word.charAt(characterAt)){
                    System.out.println("i: "+i+", j+1: "+(j+1));
                    checkForWordAtPosition(board, i, j+1, word, characterAt+1);
                }
            }
        }
        else
            return false;
        return false;
    }

    public static void main(String[] args){
        char[][] board = new char[4][4];

        try{
            BufferedReader bin = new BufferedReader(new FileReader("/Users/sowmyahariharan/Desktop/workspace - all/workspace/Java/CTCI/src/General/WordInBoardInput.txt"));
            int N = Integer.parseInt(bin.readLine());
            System.out.println("N: "+N);
            for(int i=0; i<N; ++i){
                String[] ithRow = bin.readLine().split(" ");
                for(int j=0; j<N; ++j){
                    board[i][j] = ithRow[j].charAt(0);
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }

            String word = bin.readLine();
            System.out.println("\nFind word: "+word);
            System.out.println();
            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            isWordPresentInBoard(board, word);
        }
        catch (Exception e){
            System.out.println("Exception thrown!");
            e.printStackTrace();
        }

//        Scanner cin = new Scanner(System.in);
//        int N = Integer.parseInt(cin.nextLine());
//        System.out.println("N: "+N);
//        for(int i=0; i<N; ++i){
//            String[] ithRow = cin.nextLine().split(" ");
//            for(int j=0; j<N; ++j){
//                board[i][j] = ithRow[j].charAt(0);
//                System.out.print(board[i][j]);
//            }
//        }
//
//        String word = cin.nextLine();
//        System.out.println("Find word: "+word + " in");
//        System.out.println();
//        for(int i=0; i<N; ++i){
//            for(int j=0; j<N; ++j){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(isWordPresentInBoard(board, word));
    }
}