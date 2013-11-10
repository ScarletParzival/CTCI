package Chapter_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/18/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotNavigation {
    static int xMax;
    static int yMax;
    
    public static int numberOfRobotWaysRecursive(int x, int y){
        if(x>xMax || y>yMax){
            return 0;
        }
        else if(x == xMax && y == yMax){
            return 1;
        }
        return numberOfRobotWaysRecursive(x+1,y) + numberOfRobotWaysRecursive(x,y+1);
    }

    public static int numberOfRobotWaysDP(int x, int y, int[][] map){
        if(x>xMax || y>yMax){
            return 0;
        }
        else if(x==xMax && y==yMax){
            return 1;
        }
        if(map[x][y]!=0){
            return map[x][y];
        }
        map[x][y] = numberOfRobotWaysDP(x+1, y, map) + numberOfRobotWaysDP(x, y+1, map);
        return map[x][y];
    }

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(cin.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        */

        int x = 5;
        int y = 5;

        xMax = x-1;
        yMax = y-1;

        int result = numberOfRobotWaysRecursive(0,0);
        System.out.println("Number of ways this robot can move: [Recursive solution] "+result);

        int[][] map = new int[x+1][y+1]; //The array is initialized to zero
        result = numberOfRobotWaysDP(0,0,map);
        System.out.println("Number of ways this robot can move: [DP solution] "+result);
    }

}
