package package1;

import java.util.HashMap;

public class MajorityElement {
		   
	
	public static void main(String[] args) {
		int arr[] = {2,9,3,9,9,5,6,9,9};
		System.out.println("Majority element in an array::::" + findingMajorityElement(arr));
	}
	
	
	public static int findingMajorityElement(int nums[]) {
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+ 1);
			if(map.get(num) > n/2) {
				return num;
			}
		}
		
		return -1;
		
	}
	
	
	










}

	


