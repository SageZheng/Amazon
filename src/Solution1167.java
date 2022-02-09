import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1167 {
    public static int connectSticks(int[] sticks) {
        if(sticks.length==1)
            return 0;
        Arrays.sort(sticks);
        int res=0;
        int n=sticks.length;
        for(int i=1;i<n;i++){
            System.out.println(sticks[i]);
          res+= sticks[i]* (n-i);
        }
        res+=sticks[0]*(n-1);
        return res;
    }

    public static void main(String[] args) {
        int[] sticks = new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        int[] sticks2 = new int[]{3,2,5,7,10};
       System.out.println( connectSticks(sticks2));
    }
}
