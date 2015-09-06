import java.util.Arrays;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Created by feng on 2015/7/23.
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,

 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class _001_TwoSum {

	/**
	 * @param args
     *
     *
	 */
	public static void main(String[] args) {
		int[] numbers={1,5,7,8,4,7,1,5,3,6};
		System.out.println(Arrays.toString(numbers));
		int[] result=twoSum02(numbers,9);
		System.out.println(Arrays.toString(result));
	}
	/*
	 * 暴力求解O(n^2)
	 */
	private static int[] twoSum(int[] nums, int target) {
		if(nums==null)
			return new int[]{0,0};
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[i]+nums[j]==target)
					return new int[]{i+1,j+1};
			}
		}
		return new int[]{0,0};
	}
	/*
	 * 哈希表求解O(n)
	 */
	private static int[] twoSum02(int[] nums, int target){
		if(nums==null)
			return new int[]{0,0};
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(target-nums[i], i);
		}
		for (int j = 0; j < nums.length; j++) {
			if(map.get(nums[j])!=null){
				if(map.get(nums[j])!=j){
					int index1=map.get(nums[j])+1;
					int index2=j+1;
					return index1<index2?
							(new int[]{index1,index2}):
								(new int[]{index2,index1});
				}	
					
			}
		}
		return new int[]{0,0};
	}

}
