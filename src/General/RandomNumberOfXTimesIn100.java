package General;

import javax.xml.ws.soap.MTOM;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/2/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class RandomNumberOfXTimesIn100 {
    public static int randomX(int x){
        int y = (int)(Math.random()*100);
        if(y < x){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(randomX(50));
        System.out.println(randomX(50));
        System.out.println(randomX(50));
        System.out.println(randomX(50));
//        System.out.println((int)(Math.random()*100));
    }
}
