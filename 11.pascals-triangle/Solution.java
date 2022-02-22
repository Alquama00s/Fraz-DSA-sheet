import java.util.*;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).add(1);
        }
        for (int i = 0; i < numRows; i++) {
            ans.get(0).add(1);
        }
        for (int i = 2; i < numRows; i++) {

            for (int j = 1; j < i; j++) {
                ans.get(j).add(ans.get(j - 1).get(i - j) + ans.get(j).get(i - j - 1));
            }
        }
        //System.out.println(ans);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                temp.add(ans.get(j).get(i - j));
            }
            lst.add(new ArrayList<>(temp));
            temp.clear();
        }
        return lst;
    }
}


