import java.util.ArrayList;
import java.util.List;

public class Solution696 {
    public int countBinarySubstrings(String s) {
        int res=0;
        ArrayList<Integer> Group = new ArrayList<>();
      for(int i =0;i<s.length();){
          int CurGroup=1;
            char curr=s.charAt(i);
            i+=1;
            while(i<s.length()&&s.charAt(i)==curr){
                i+=1;
                CurGroup+=1;
            }
            Group.add(CurGroup);
          System.out.println(CurGroup);
        }
      for(int i=1;i<Group.size();i++){
          res+=Math.min(Group.get(i-1),Group.get(i));
      }
        return res;
    }

    public static void main(String[] args) {
        Solution696 s = new Solution696();
        String s1= "1110001";
        System.out.println(s.countBinarySubstrings(s1));
    }
}
