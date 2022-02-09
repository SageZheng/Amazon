import java.util.Arrays;
import java.util.Comparator;

public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int maxUnit=0;
        int currSize=0;
        int i=0;
        while(currSize<=truckSize&&i<boxTypes.length){
            if(truckSize-currSize<=boxTypes[i][0]){
                maxUnit+=(truckSize-currSize)*boxTypes[i][1];
                break;
            }
            else{
                currSize+=boxTypes[i][0];
                maxUnit+=boxTypes[i][0]*boxTypes[i][1];
                i+=1;
            }
        }
        return maxUnit;
    }
}
