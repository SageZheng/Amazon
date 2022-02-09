import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1268 {
    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String s= searchWord.substring(0,i+1);
            List<String> temp= new ArrayList<>();
            for(int j=0;j<products.length;j++){
                if(products[j].length()>i&&products[j].substring(0,i+1).equals(s))
                    temp.add(products[j]);
            }
            temp.sort(Comparator.naturalOrder());
            List<String> add = new ArrayList<>();
            for(int j=0;j<Math.min(3,temp.size());j++){
                add.add(temp.get(j));
            }
            res.add(add);
        }
        return res;
    }
    int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
    public
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> temp = new ArrayList<>();
        for(int i=0;i<products.length;i++){
            if(products[i].substring(0,1).equals(searchWord.substring(0,1)))
                temp.add(products[i]);
        }
        temp.sort(Comparator.naturalOrder());
        products=temp.toArray(new String[0]);
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;

            // Get the starting index of word starting with `prefix`.
            start = lower_bound(products, bsStart, prefix);

            // Add empty vector to result.
            result.add(new ArrayList<>());

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }
        return result;
    }
}
