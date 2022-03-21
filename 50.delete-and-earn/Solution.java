import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteAndEarn(new int[] { 1, 1, 1, 2, 4, 5, 5, 5, 6 }));
    }

    TreeMap<Integer, Integer> map;

    int getGain(int x) {
        if (map.containsKey(x)) {
            return x * map.get(x);
        }
        return 0;
    }

    public int deleteAndEarn(int[] nums) {
        map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int oneBack = getGain(1);
        int twoBack = getGain(0);
        //System.out.print("0-" + twoBack + " 1-" + oneBack + " ");
        int key, temp, oneIndex = 1;
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            if (key < 2)
                continue;
            //System.out.print(key + "-");
            if (oneIndex + 1 != key) {
                twoBack = oneBack;
                oneBack += getGain(key);
            } else {
                temp = oneBack;
                oneBack = Math.max(oneBack, twoBack + getGain(key));
                twoBack = temp;
            }
            oneIndex = key;
            //System.out.print(oneBack + " ");
        }
        return oneBack;
    }
}