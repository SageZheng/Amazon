public class Solution926 {
    public int minFlipsMonoIncr(String s) {
        int[] leftZero = new int[s.length()];
        int[] rightOne = new int[s.length()];
        leftZero[0]=s.charAt(0)=='0'?0:1;
        rightOne[s.length()-1]=s.charAt(s.length()-1)=='1'?0:1;
        int res=s.length();
        for(int i=1;i<s.length();i++){
            leftZero[i]=leftZero[i-1];
            if(s.charAt(i)=='1')
                leftZero[i]+=1;
        }
        for(int i =s.length()-2;i>=0;i--){
            rightOne[i]=rightOne[i+1];
            if(s.charAt(i)=='0')
                rightOne[i]+=1;
        }
        for(int i=0;i<s.length();i++){
            res=Math.min(res,rightOne[i]+leftZero[i]);
        }
        return res-1;
    }
}
