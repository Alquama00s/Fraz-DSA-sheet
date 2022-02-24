import java.util.*;

class RandomizedSet {

    ArrayList<Integer> values;
    HashMap<Integer, Integer> val_to_index;
    Random rand;

    public RandomizedSet() {
        values = new ArrayList<>();
        val_to_index = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (val_to_index.containsKey(val)) {
            return false;
        }
        values.add(val);
        val_to_index.put(val, Math.max(values.size() - 1,0));
        return true;
    }

    public boolean remove(int val) {
        if (!val_to_index.containsKey(val)) {
            return false;
        }
        values.remove(val_to_index.get(val));
        val_to_index.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */