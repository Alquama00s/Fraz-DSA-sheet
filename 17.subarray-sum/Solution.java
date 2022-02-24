import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        //HashMap<Integer, Integer> count = new HashMap<>(), index = new HashMap<>();
        //Set<Integer> prefixSum_set;
        int ans = 0, temp;
        // making prefix sum array
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i]-k;
            if(temp==0)ans++;
            for (int j = 0; j < i; j++) {
                if(nums[j]==temp)ans++;
            }
        }



/*
was trying to find a more optimal solution
*/


        /*
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], 1);
            } else {
                count.put(nums[i], count.get(nums[i]) + 1);
            }
        }
        prefixSum_set = count.keySet();
        var it = prefixSum_set.iterator();
        while (it.hasNext()) {
            temp = it.next();
            System.out.println(temp + " - " + count.get(temp));
        }
        it = prefixSum_set.iterator();
        while (it.hasNext()) {
            temp = it.next();
            System.out.print(temp - k + "---");
            if (k == 0 && temp == 0) {
                ans += count.get(0) * (count.get(0) - 1) / 2;
                ans += count.get(0);
            } else if (temp - k == 0) {
                ans++;
            } else if (k == 0) {
                ans--;
                ans += count.get(temp);
            } else if (count.containsKey(temp - k)) {
                ans += count.get(temp - k);
            }
            System.out.println(ans);

        }*/
        return ans;
    }

}