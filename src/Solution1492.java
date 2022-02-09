import java.util.ArrayList;
import java.util.List;

public class Solution1492 {
    public int kthFactor(int n, int k) {
        if(k>n)
            return -1;
        if(k==n&&k<=2)
            return k;
      //  boolean[] num=new boolean[n];
        int size=1;
    for(int i=1;i<=n;i++){
       if(n%i==0)
           size+=1;
        if(size==k)
            return i;
    }
return -1;
    }
}
