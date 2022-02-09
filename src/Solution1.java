import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public static int getMinimumTrips(List<Integer> weights) {
        int sum=0;
        Collections.sort(weights);
        int num=0;
        for(int i =0;i<weights.size();){
            int Cur=weights.get(i);
            //System.out.println(Cur);
            while(i< weights.size()&& weights.get(i)==Cur){
                num+=1;
                i+=1;
            }
           // System.out.println(num);
            if(num<=1)
                return -1;
            int add=num/3;
            if(num%3!=0)
                sum+=add+1;
            else
                sum+=add;
            num=0;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> weight= new ArrayList<>();
        weight.add(2);
        weight.add(4);
        weight.add(2);
        weight.add(2);
        weight.add(2);
        weight.add(2);
        weight.add(4);
        System.out.println(getMinimumTrips(weight));
    }
}
