package package1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class RemovingDuplicates_UsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(40);
		list.add(20);
		list.add(10);
		list.add(30);
		
		// 1......just if we need to remove duplicates and doesnt care about order na directly we print hashset
		//below is enough
		//HashSet<Integer> set = new LinkedHashSet<Integer>(list);
		//System.out.println("After removing duplictaes:::::" + set);
		
		// 2......else if i need to maintain the list structure or need insertion order means we finally may change from set into list...if we use 
		//linked hashset means insertion oder should be maintained ok
		
		HashSet<Integer> set = new LinkedHashSet<Integer>(list);
		List<Integer> uniqueList = new ArrayList<Integer>(set);
		System.out.println("After removing duplictaes:::::" + uniqueList);
	}

}
