/**
 * Created by ryoichi on 4/17/2017.
 */
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] a = {15,1,93,52,66,31,87,0,42,77,46,24,99,10,19,36,27,4,58,76,2,81,50,102,33,94,20,14,80,82,49,41,12,143,121,7,111,100,60,55,108,34,150,103,109,130,25,54,57,159,136,110,3,167,119,72,18,151,105,171,160,144,85,201,193,188,190,146,210,211,63,207};
        Arrays.sort(a);
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[a.length-1-i];
        }
        String c = Arrays.toString(b);

        System.out.println(String.join("",c));
        for(int i = 0; i < a.length; i++){
            System.out.print(b[i]);
        }
    }
}
