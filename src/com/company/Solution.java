package com.company;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //sort array at the start (n^2) but makes rest super easy
        List<List<Integer>> solution = new LinkedList<>(); //setup solution list o' lists

        for (int i = 0; i < nums.length - 2; i++) { //begin by looking at the 'smallest number'
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //begin at i ==0, and be sure that we're not repeating tesing on the same number (i is not the same as the last test)
                int low = i + 1; //smallest number not already checked against current i
                int high = nums.length - 1; //end of array
                int sum = -nums[i]; //super important <- we need the sum of the remaining 2 numbers in the triplet to match the inverted value of our target number, i

                while (low < high) { //begin checking, but stop once we converge from going inwards
                    if (nums[low] + nums[high] == sum) { //see if we have a match where b + c = -a, in effect
                        solution.add(Arrays.asList(nums[i], nums[low], nums[high])); //add this to the solution by forcing array to list
                        while (low < high && nums[low] == nums[low + 1]) { //rapid adjust low in prep for now match
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) { //rapid adjust high to look for new match
                            high--;
                        }
                        //move both inwards to look for next 'set'
                            //unlikely to happen, and we may increase speed here.
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) { //if we are over the target value, reduce high number to look for a match: if sum < low + high, we need to reduce high
                        high--;
                    } else { // increase low, as we cannot increase high: sum > high + low, we can increase low, not high
                        low++;
                    }
                }
            }

        }
        return solution;
    }
}
