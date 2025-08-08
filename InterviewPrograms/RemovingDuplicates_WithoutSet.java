package package1;

import java.util.ArrayList;
import java.util.List;

public class RemovingDuplicates_WithoutSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> uniqueList = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(40);
		list.add(20);
		list.add(10);
		list.add(30);
		System.out.println("Original values in List:::::" + list);
		for(Integer num : list) {
			if(!uniqueList.contains(num)) {
				uniqueList.add(num);
			}
		}
		System.out.println("After removing duplictaes:::::" + uniqueList );
	}

}
