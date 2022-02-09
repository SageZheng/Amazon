import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> resLetter=new ArrayList<>();
        ArrayList<String> resDig=new ArrayList<>();
        for(int i=0;i<logs.length;i++ ){
          if(logs[i].charAt(logs[i].length()-1)<='9')
              resDig.add(logs[i]);
          else
              resLetter.add(logs[i]);
        }
        resLetter.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                if (s1[1].equals(s2[1]))
                    return s1[0].compareTo(s2[0]);
                return s1[1].compareTo(s2[1]);
            }
        });
        String[] res = new String[logs.length];
        for(int i=0;i<resLetter.size();i++){
            res[i]=resLetter.get(i);
        }
        for(int i=resLetter.size(),j=0;j<resDig.size();i++,j++){
            res[i]=resDig.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("abcd".compareTo("abch"));
    }
}
