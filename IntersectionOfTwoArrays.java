package package1;

import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,6,7,9,4};
		int[] b = {2,4,5,7,9};
		
		HashSet<Integer> setA = new HashSet<Integer>();
		for(int num : a) {
			setA.add(num);
		}
		 // Loop through the second array and check if element exists in the HashSet
		HashSet<Integer> intersection = new HashSet<Integer>();
		for(int num1 : b) {
			if(setA.contains(num1)) {
				intersection.add(num1);
			}
		}

		System.out.println("Intersection of two arrays::::::" + intersection);
	}

}
