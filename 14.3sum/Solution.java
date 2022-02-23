import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (Integer num : nums) {
            if (count.containsKey(num))
                count.put(num, count.get(num) + 1);
            else
                count.put(num, 1);
        }
        Integer[] arrTemp;
        Arrays.sort(nums);
        int tempCount, temp, neg = 0, pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                neg = i - 1;
                pos = i;
                break;
            }
        }

        for (int i = pos; i < nums.length; i++) {
            for (int j = 0; j <= neg; j++) {
                temp = -(nums[i] + nums[j]);
                if (count.containsKey(temp)) {
                    tempCount = count.get(temp);
                    if (nums[i] == temp || nums[j] == temp)
                        tempCount--;
                    if (tempCount > 0) {
                        arrTemp = new Integer[] { temp, nums[i], nums[j] };
                        Arrays.sort(arrTemp);
                        ans.add(new ArrayList<Integer>(Arrays.asList(arrTemp)));
                    }
                }
            }
        }
        if (count.containsKey(0)&&count.get(0) > 2)
            ans.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));

        return new ArrayList<>(ans);
    }
}
