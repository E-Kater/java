/*219
* Given an array of integers and an integer k, find out whether there are two distinct
* indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false*/

import java.util.HashMap;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int currInt = nums[i];
            if (hm.get(currInt) != null && i - hm.get(currInt) <= k) return true;
            else hm.put(currInt, i);
        }
        return false;
    }

    }

