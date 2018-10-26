//
// Created by Joshua.cao, 2018/10/17
//
// https://leetcode.com/problems/insert-delete-getrandom-o1/
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Accepted, beats 42.51%
public class RandomizedSet {
  List<Integer> nums;
  Map<Integer, Integer> locs;
  Random rand = new Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
    nums = new ArrayList<>();
    locs = new HashMap<>();
  }
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (locs.containsKey(val)) {
      return false;
    }
    locs.put(val, nums.size());
    nums.add(val);
    return true;
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!locs.containsKey(val)) return false;
    int index = locs.get(val);
    if (index != nums.size() - 1) {
      int lastOne = nums.get(nums.size() - 1);
      nums.set(index, lastOne);
      locs.put(lastOne, index);
    }
    nums.remove(nums.size() - 1);
    locs.remove(val);
    return true;
  }
  
  /** Get a random element from the set. */
  public int getRandom() {
    return nums.get(rand.nextInt(nums.size()));
  }

  public static void main(String[] args) {
    RandomizedSet randomSet = new RandomizedSet();
    System.out.println(randomSet.insert(1));
    System.out.println(randomSet.remove(2));
    System.out.println(randomSet.insert(2));
    System.out.println(randomSet.getRandom());
    System.out.println(randomSet.remove(1));
    System.out.println(randomSet.insert(2));
    System.out.println(randomSet.getRandom());
  }
}