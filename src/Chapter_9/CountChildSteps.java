package Chapter_9;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/18/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountChildSteps {
    public int countWays(int n, int actualN, String me){
        System.out.println("Function call with n: "+n +", called actually by the actualN: "+ actualN + ", function: "+me);
        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        return countWays(n-1,n,"left") + countWays(n-2,n,"middle") + countWays(n-3,n,"right");
    }

    public int countWaysDP(int n, int[] map, int actualN, String description){
        System.out.println("Function call with n: "+n +", called actually by the actualN: "+ actualN + ", function: "+description);
        if(n<0){
            System.out.println("\t\tReturning 0");
            return 0;
        }
        else if(n == 0){
            System.out.println("\t\tReturning 1");
            return 1;
        }
        else if(map[n] > -1){
            System.out.println("\t\tReturning map["+n+"]: "+map[n]);
            return map[n];
        }
        else{
            map[n] = countWaysDP(n-1, map, n, "left") +
                    countWaysDP(n-2, map, n, "middle") +
                    countWaysDP(n-3, map, n, "right");
            System.out.println("\t\tReturning map[" + n +"]: "+map[n]);
            return map[n];
        }

    }
    public static void main(String[] args){
        CountChildSteps childSteps = new CountChildSteps();
        int N=3;
        System.out.println("Counting the number of ways with n="+N+": "+childSteps.countWays(N,N,"main"));
        int[] map = new int[N+1];
        for(int i=0; i<map.length; ++i){
            map[i] = -1;
        }
        System.out.println("\n");
        System.out.println("Counting the number of ways with n="+N+": "+childSteps.countWaysDP(N, map, N,"main"));
        System.out.println(Math.random());
    }
}
