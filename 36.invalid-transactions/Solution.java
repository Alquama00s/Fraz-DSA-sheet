import java.util.*;

class Solution {
    class CoustomComp implements Comparator<String> {
        public int compare(String a, String b) {
            int _stringWeightA = 0, _stringWeightB = 0;
            String alfa = a.split(",")[0];
            String beta = b.split(",")[0];
            for (int i = 0; i < alfa.length(); i++) {
                _stringWeightA += (int) alfa.charAt(i);
            }
            for (int i = 0; i < beta.length(); i++) {
                _stringWeightB += (int) beta.charAt(i);
            }
            int _a = Integer.parseInt(a.split(",")[1]);
            int _b = Integer.parseInt(b.split(",")[1]);
            return (_stringWeightA + _a) - (_b + _stringWeightB);
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        boolean[] done = new boolean[transactions.length];
        Arrays.fill(done, false);
        Arrays.sort(transactions, new CoustomComp());
        List<String> ans = new ArrayList<>();
        if (!done[0] && Integer.parseInt(transactions[0].split(",")[2]) > 1000) {
            ans.add(transactions[0]);
            done[0] = true;
        }
        for (int i = 1; i < transactions.length; i++) {
            if (!done[i] && Integer.parseInt(transactions[i].split(",")[2]) > 1000) {
                ans.add(transactions[i]);
                done[i] = true;
            } else if (transactions[i].split(",")[0].equals(transactions[i - 1].split(",")[0]) &&
                    transactions[i].split(",")[3] != transactions[i - 1].split(",")[3] &&
                    Integer.parseInt(transactions[i].split(",")[1]) <= Integer
                            .parseInt(transactions[i - 1].split(",")[1]) + 60) {
                if (!done[i]) {
                    ans.add(transactions[i]);
                    done[i]=true;
                }
                if (!done[i - 1]) {
                    ans.add(transactions[i - 1]);
                    done[i-1]=true;

                }

            }
        }

        return ans;
    }
}