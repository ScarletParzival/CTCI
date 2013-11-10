package Chapter_9;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/16/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciUsingDP {

    public static void main(String[] args){
        int N = 5;
        int[] fib = new int[N+1];
        int fibonacciResult = fibonacci(N,fib, "main");
        System.out.println("\n\nFibonacci number at position " + N + " is: "+fibonacciResult);
//        for(int i=0; i<N+1; ++i){
//            System.out.println(fib[i]);
//        }
    }
    public static String arrayToString(int[] a){
        for(int i=0; i<a.length; ++i){
            System.out.print(a[i]+" ");
        }
        return "";
    }
    public static int fibonacci(int f,int[] fib, String id){
        System.out.print(id+" call -- f: "+f+"  fib: ");//+arrayToString(fib));
        for(int i=0; i<fib.length; ++i){
            System.out.print(fib[i]+" ");
        }
        System.out.println();
        if(f == 0) {
            System.out.println("\t\tReturning zero");
            return 0;
        }
        if(f == 1) {
            System.out.println("\t\tReturning one");
            return 1;
        }
        if(fib[f] != 0) {
            System.out.println("\t\tReturning the already stored value: "+fib[f]);
            return fib[f];
        }
        fib[f] = fibonacci(f-1,fib, "left") + fibonacci(f-2,fib, "right");
        System.out.println("\tReturning the sum: "+fib[f]);
        return fib[f];
    }

}
