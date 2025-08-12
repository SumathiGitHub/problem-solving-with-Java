package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ArrayListPractice {
	/*
	 * 1.Add few names to an ArrayList and print them using a loop. 
	 * 2.Check if a specific name exists in the ArrayList. 
	 * 3.Remove a name from the ArrayList.
	 * 4.Replace the 3rd element with another name. 
	 * 5.Sort the ArrayList alphabetically. 
	 * 6.Sort the ArrayList in reverse order. 
	 * 7.Print only names longer than 5 characters. 
	 * 8.Count how many names start with 'S'. 
	 * 9.Check if the ArrayList is empty. 
	 * 10.Clear the ArrayList and print it.
	 * 11.Remove all names that contain the letter 'a'.
	 * 12.Create two ArrayLists and find common names (intersection).
	 * 13.Merge two ArrayLists and remove duplicates.
     * 14.Print names that start and end with the same letter.
     * 15.Find the longest name in the ArrayList.
	 * 16.Remove duplicate names using a Set.
	 * 17.Reverse the ArrayList without using Collections.reverse().
     * 18.Find duplicates in the ArrayList without using a Set
     * 19.Convert the ArrayList into an array and print.
     * 20.Remove all even numbers from a list
     * 21.Remove all names with less than 5 letters
     * 22.Remove null or blank values from a list
     * 23.Remove duplicate integers from list
     * 24.Keep only names that start with "S" or "M"
     * 25.Count the frequency of each name in a list
     * 26.Find first repeated integer element in a list
     * 27.Find first non-repeated character element  in a list
     * 28.Use retainAll() to find the students who both registered and attended.
     * 29.use removeAll()to find the names of students who registered but did not attend the session.	
     * 30.Merge Two Department Employee Lists.	
     * 31.Find the First Occurrence of an Item in a Shopping List.
     * 32.Extract a Range of Tasks from a To-Do List using a sublist.
	 * 33.Backup cart before discount to restore if needed.
     * 34.Import 1000 products into an ArrayList, using ensureCapacity() to avoid repeated resizing and speed up loading.
	 */
	public static void main(String[] args) {

		ArrayListPractice obj1 = new ArrayListPractice();
		
		List<String> addedNameList = obj1.addNames();
		obj1.checkIfNameExists(addedNameList);
		obj1.deleteElement(addedNameList);
		obj1.replaceElement(addedNameList);
		obj1.sortElement(addedNameList);
		obj1.printingList(addedNameList);
		obj1.countingList(addedNameList);
		obj1.checkList(addedNameList);
	//	obj1.clearList(addedNameList);
		obj1.removingParticularElement(addedNameList);
		List<List<String>> returningTwoArraylists= obj1.findIntersectionOfLists();
			List<String> list1 = returningTwoArraylists.get(0);
			List<String> list2 = returningTwoArraylists.get(1);	
		obj1.mergingListThenRemovingDuplicates(list1, list2);
			List<String> nameList = obj1.printingList();
		obj1.longestNameInTheList(nameList);
			List<Integer> li = obj1.removingDuplicates();
		obj1.reverseList(li);
		obj1.findingDuplicatesWithoutSet(nameList);
		obj1.convertingIntoArray();
		obj1.removingEven();
		obj1.removingNames();
		obj1.removingBlank();
		obj1.removingDuplicates();
		obj1.removingDup();
		obj1.filteringList();
		obj1.frequencyChecking();
		obj1.findingFirstRepeated();
		obj1.findingFirstNonRepeated();
		obj1.usingRetainAll();
		obj1.usingRemoveAll();
		obj1.mergingEmp();
		obj1.findingFirstOccurance();
		obj1.filteringRange();
		obj1.usingSublist();
	}

	// 1. Add few names to an ArrayList and print them using a loop.
	
	public List<String> addNames() {
		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("Sumathi");
		nameList.add("Malathi");
		nameList.add("Karthick");
		nameList.add("Rajendiran");
		nameList.add("Tamilselvi");
		for (String name : nameList) {
			System.out.println(name);
		}
		System.out.println("1---------------------------------------------------------------------");

		return nameList;

	}
	
	
	

	// 2.Check if a specific name exists in the ArrayList.
	public void checkIfNameExists(List<String> neededList) {

		for (String name : neededList) {
			if (name.contains("Malathi")) {
				System.out.println("\nYes! Malathi exist!!!!");
				System.out.println("2---------------------------------------------------------------------");
				return;
			}
		}
		System.out.println("Nope!");
		System.out.println("2---------------------------------------------------------------------");

	}

	// 3.Remove a name from the ArrayList.
	public void deleteElement(List<String> neededList) {

		if (neededList.contains("Malathi")) {
			neededList.remove("Sumathi");
		}
		System.out.println("NewName List::: ");
		for (String name : neededList) {
			System.out.println(name);
		}

		System.out.println("3---------------------------------------------------------------------");
	}
	

	// 4.Replace the 3rd element with another name.
	public void replaceElement(List<String> neededList) {

//		String thirdElement = neededList.get(3);
//		System.out.println(thirdElement);
		if (neededList.size() >= 3) {
			neededList.set(2, "Mohith");
		}
		System.out.println("After replacing 3rd element.....");
		for (String name : neededList) {
			System.out.println(name);
		}

		System.out.println("4---------------------------------------------------------------------");
	}

	
	// 5/6.Sort the ArrayList alphabetically.
	public void sortElement(List<String> inputList) {

		Collections.sort(inputList);
		System.out.println("After sorting elemnet alphabetically.....");
		for (String s : inputList) {
			System.out.println(s);
		}

		Collections.sort(inputList, Collections.reverseOrder());
		System.out.println("After sorting elemnet in reverse order.....");
		for (String s : inputList) {
			System.out.println(s);
		}
		System.out.println("5/6..---------------------------------------------------------------------");

	}

	
	// 7.Print only names longer than 5 characters.
	public void printingList(List<String> inputString) {

		for (String sname : inputString) {
			if (sname.length() > 5) {
				System.out.println(sname);
			}
		}

		System.out.println("7-------------------------------------------------------------------------");

	}

	
	// 8.Count how many names start with 'S'.
	public void countingList(List<String> inputList) {

		int count = 0;
		for (String s : inputList) {
			if (s.startsWith("S")) {
				count++;
			}
		}
		System.out.println("Count is::::: " + count);
		System.out.println("8-------------------------------------------------------------------------");

	}
	

	// 9.Check if the ArrayList is empty.
	public void checkList(List<String> checkingString) {
		if (checkingString.isEmpty()) {
			System.out.println("ArrayList is Empty!..");
		} else {
			int listSize = checkingString.size();
			System.out.println("ListSize:::: " + listSize);
		}

		System.out.println("9--------------------------------------------------------------------------");
	}

	
	// 10.Clear the ArrayList and print it.
	public void clearList(List<String> inputList) {
		inputList.clear();
		for(String s : inputList) {
			System.out.println(s);
		}
		
		System.out.println("10--------------------------------------------------------------------------");
	}

	
	
	//* 11.Remove all names that contain the letter 'a'.
	
	public void removingParticularElement(List<String> inputString) {

		List<String> needToDelete = new ArrayList<String>();
		for (String name : inputString) {
			if (name.contains("a")) {
				needToDelete.add(name);
			}
		}
		System.out.println("after removig names that contain the letter 'a'....");
		inputString.removeAll(needToDelete);
		System.out.println(inputString);
		System.out.println("11---------------------------------------------------------------------");
	}
	
	
	//	12.Create two ArrayLists and find common names (intersection).
	
	public List<List<String>> findIntersectionOfLists() {

		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();

		list1.add("Sumathi");
		list1.add("Malathi");
		list1.add("Karthik");
		list1.add("Tamilselvi");
		list1.add("Rajendiran");

		System.out.println("List1 names ::: " + list1.toString());

		list2.add("Muthuveerappan");
		list2.add("Sathyavani");
		list2.add("Jawahar");
		list2.add("Sumathi");
		list2.add("Mohith");

		System.out.println("List2 names ::: " + list2.toString());

		ArrayList<String> commonList = new ArrayList<String>();

		for (String name : list1) {
			if (list2.contains(name)) {
				commonList.add(name);
			}
		}		
		System.out.println("Common List is :::: " + commonList);
		
		System.out.println("12---------------------------------------------------------------------");
		
		//HashMap<String, List<String>> result = new HashMap<String, List<String>>();
		List<List<String>> bothLists = new ArrayList<>();
	
		bothLists.add(list1);
		bothLists.add(list2);
				
		return bothLists;
	}
	
	
	//* 13.Merge two ArrayLists and remove duplicates.
	
	public void mergingListThenRemovingDuplicates(List<String> list1 , List<String> list2) {

		System.out.println("List1 is :::: " + list1);
		System.out.println("List2 is :::: " + list2);
		
		//Merging two lists
		list1.addAll(list2);
		
		System.out.println("After merging two lists ::: " + list1 + list2);
		
		List<String> uniqueList = new ArrayList<>();

		for (String name : list1) {
			if (!uniqueList.contains(name)) {
				uniqueList.add(name);
			}
		}

		System.out.println("UniqueList Names::: " + uniqueList.toString());
		System.out.println("13---------------------------------------------------------------------");
	}
	
	
	// * 14.Print names that start and end with the same letter.
	
	public List<String> printingList() {

		List<String> nameList = new ArrayList<String>();
		nameList.add("Sumathi");
		nameList.add("BhB");
		nameList.add("KarishmaK");
		nameList.add("Malathi");
		nameList.add("AmalA");

		System.out.println(nameList.toString());

		List<String> newList = new ArrayList<String>();

		int capacity = nameList.size();
//		
//		for(int i = 0; i < capacity ; i++) {
//			String name = nameList.get(i);
//			if(name.charAt(0)==name.charAt(name.length()-1)) {
//				newList.add(name);
//			}
//		}
		
		//alternative
		
		for (String name : nameList) {
			if (name == null || name.isEmpty()) {
				continue;
			}
			char first = name.charAt(0);
			char last = name.charAt(name.length() - 1);

			if (first == last) {
				newList.add(name);
			}
		}

		System.out.println("Printing names that start and end with the same letter ::::: " + newList.toString());
		System.out.println("14---------------------------------------------------------------------");
		return nameList;
	}
	
	
	
	// * 15.Find the longest name in the ArrayList.
	
	public String longestNameInTheList(List<String> nameList) {

		String longestName = null;
		int max = 0;
		for (String name : nameList) {
			int curr = name.length();
			if (curr > max) {
				max = curr;
				longestName = name;
			}
		}
		System.out.println("Longest name is :::: " + longestName);
		System.out.println("15---------------------------------------------------------------------");

		return longestName;
	}
	 
	
	 // * 16.Remove duplicate names using a Set.
	 
		public List<Integer> removingDuplicates() {

			ArrayList<Integer> ar = new ArrayList<Integer>();
			ar.add(8);
			ar.add(10);
			ar.add(15);
			ar.add(12);
			ar.add(8);
			ar.add(6);
			ar.add(10);

			System.out.println("Original List ::::  " + ar);

			Set<Integer> set = new HashSet<Integer>();
			set.addAll(ar);

			System.out.println("After removing duplicates :::: " + set);
			System.out.println("16---------------------------------------------------------------------");

			return ar;
		}
	
	
		
		// 17.Reverse the ArrayList without using Collections.reverse().
		
		public List<Integer> reverseList(List<Integer> list){
			
			//with using collections.reverse()
			//Collections.sort(list, Collections.reverseOrder());
		
			//without using collections.reverse()

	        System.out.println("Original List: " + list);

	        int size = list.size();
	        for (int i = 0; i < size / 2; i++) {
	            Integer temp = list.get(i);
	            list.set(i, list.get(size - 1 - i));
	            list.set(size - 1 - i, temp);
	        }

	        System.out.println("Reversed List: " + list);
	        System.out.println("17---------------------------------------------------------------------");
						
			return list;
		}
		
		
		
		//18. Find duplicates in the ArrayList without using a Set
		
		public List<String> findingDuplicatesWithoutSet(List<String> inputList) {

			inputList.add("Sumathi");
			inputList.add("Malathi");

			System.out.println("Original List is ::: " + inputList);

			List<String> uniqueList = new ArrayList<String>();
			List<String> duplicatesList = new ArrayList<String>();

			for (String name : inputList) {

				if (uniqueList.contains(name)) {
					if (!duplicatesList.contains(name)) {
						duplicatesList.add(name);
					}
				} else {
					uniqueList.add(name);
				}
			}
			
			System.out.println("Duplicate List is :::: " + duplicatesList);
			System.out.println("18---------------------------------------------------------------------");

			return duplicatesList;
		}
		
		
		//19.Convert the ArrayList into an array and print.
		
		public void convertingIntoArray() {
			
			List<Integer> list = new ArrayList<Integer>();
			list.add(20);
			list.add(24);
			list.add(22);
			list.add(23);
			
			Integer[] arrayL =  list.toArray(new Integer[0]);
			
			System.out.println(Arrays.toString(arrayL));	
			System.out.println("19---------------------------------------------------------------------");
		}
		
		
		//20. Remove all even numbers from a list
		
		public List<Integer> removingEven() {

			List<Integer> arr1 = new ArrayList<Integer>();
			arr1.add(11);
			arr1.add(20);
			arr1.add(15);
			arr1.add(22);
			arr1.add(16);

			List<Integer> arr2 = new ArrayList<Integer>();

			for (int no : arr1) {
				if (no % 2 != 0) {
					arr2.add(no);
				}
			}
			System.out.println("After removing even numbers from list is ::: " + arr2);
			System.out.println("20---------------------------------------------------------------------");

			return arr2;
		}
	
		
		//21.Remove all names with less than 5 letters
		
		public void removingNames() {
			
			List<String> li = new ArrayList<String>();
			li.add("Sumathi");
			li.add("Tamilselvi");
			li.add("Jawahar");
			li.add("Puma");
			li.add("Eli");
			li.add("Rajesh");
			
			List<String> li2 = new ArrayList<String>();
			
			for(String name : li) {
				if(name.length() >= 5 ) {
					li2.add(name);
				}		
			}
			System.out.println("After removing names with less than 5 characters:::" + li2);
			System.out.println("21---------------------------------------------------------------------");
		}
		
		
		//22. Remove null or blank values from a list
		
		public void removingBlank() {
			
			List<String> list1 = new ArrayList<String>();
			list1.add("Sumathi");
			list1.add(null);
			list1.add("Karthi");
			list1.add("");
			list1.add(" ");
			list1.add("Jawahar");
			
			List<String> list2 = new ArrayList<String>();
			for(String name : list1) {
				if( name!=null && !name.trim().isEmpty()) {
					list2.add(name);
					
				}
			}
			
			System.out.println("After removing blank and null values :::: " + list2);
			System.out.println("22---------------------------------------------------------------------");
			
		}
		
		
		//23.Remove duplicate integers from list
		
		public List<Integer> removingDup(){
			
			List<Integer> orgList = new ArrayList<Integer>();
			orgList.add(10);
			orgList.add(20);
			orgList.add(12);
			orgList.add(10);
			orgList.add(12);
			orgList.add(30);
			
			System.out.println("Orginial List is :::: " + orgList);
			
			List<Integer> uniqueList = new ArrayList<Integer>();
			List<Integer> dupList = new ArrayList<Integer>();
			
			for(Integer no : orgList) {
				if(uniqueList.contains(no)) {
					if(!dupList.contains(no))
					dupList.add(no);
				}
				else {
					uniqueList.add(no);
				}
			}
			System.out.println("Duplicate List is ::: " + dupList);
			System.out.println("After removing dupplicates :::: " + uniqueList);
			
			System.out.println("23---------------------------------------------------------------------");
			return uniqueList;
		}
		
		
		
		//24.Keep only names that start with "S" or "M"
		
		public List<String> filteringList(){
			
			List<String> list1 = new ArrayList<String>();
			list1.add("Sumathi");
			list1.add("Malathi");
			list1.add("Sowndraya");
			list1.add("malavika");
			list1.add("Karthik");
			list1.add("Vignesh");
			
			List<String> list2 = new ArrayList<String>();
			
			for(String name : list1) {
				if(name.startsWith("S") || name.startsWith("M")) {
					list2.add(name);
				}
			}
			
			System.out.println("Names starting with 'S' and 'M' ::::" + list2);
			System.out.println("24---------------------------------------------------------------------");
			return list2;
			
		}
		
		
		//25.Count the frequency of each name in a list

		public void frequencyChecking() {

			List<String> nameList = new ArrayList<String>();
			nameList.add("Sumathi");
			nameList.add("Mohith");
			nameList.add("Jawahar");
			nameList.add("Sumathi");
			nameList.add("Mohith");
			nameList.add("Rejany");
			nameList.add("Arulselvi");
			nameList.add("Mohith");
			nameList.add("Rejany");

			Map<String, Integer> freqMap = new HashMap<String, Integer>();

			for (String name : nameList) {
				if (freqMap.containsKey(name)) {
					freqMap.put(name, freqMap.get(name) + 1);
				} else {
					freqMap.put(name, 1);
				}
			}

			for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
				System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times ");
			}

			System.out.println("25---------------------------------------------------------------------");
		}
		
		
		//26. Find first repeated integer element 
		
		public void findingFirstRepeated() {

			List<Integer> elementList = new ArrayList<Integer>();
			elementList.add(10);
			elementList.add(20);
			elementList.add(30);
			elementList.add(20);
			elementList.add(10);

			List<Integer> uniqueList = new ArrayList<Integer>();

			for (Integer no : elementList) {
				if (uniqueList.contains(no)) {
					System.out.println("First repeated character ::: " + no);
					return;
				} else {
					uniqueList.add(no);
				}
			}
			System.out.println("26---------------------------------------------------------------------");
		}
		
		// 27. Find first non - repeated character element in a list
		
		public void findingFirstNonRepeated() {

			List<String> li = new ArrayList<String>();
			li.add("c");
			li.add("h");
			li.add("g");
			li.add("o");
			li.add("o");
			li.add("h");
			li.add("c");
			System.out.println("The original list is ::: " + li);

			Map<String, Integer> mapList = new HashMap<String, Integer>();

			for (String c : li) {
				if (mapList.containsKey(c)) {
					mapList.put(c, mapList.get(c) + 1);
				} else {
					mapList.put(c, 1);
				}
			}
//			 for( Map.Entry<String, Integer> entry : mapList.entrySet()) {
//				 if(entry.getValue() == 1) {
//					 System.out.println("First non-repeated element ::: " + entry.getKey());
//				 }
//			 }

			for (String ch : li) {
				if (mapList.get(ch) == 1) {
					System.out.println("First non-repeated element is ::: " + ch);
				}
			}

			System.out.println("27---------------------------------------------------------------------");
		}
		
		
		//28. You have two lists of student names — one for students who registered for a workshop and another for those who actually attended.
		//Use retainAll() to find the students who both registered and attended.
		
		public void usingRetainAll(){
			
			List<String> registeredList = new ArrayList<String>();
			registeredList.add("Sumathi");
			registeredList.add("Menaka");
			registeredList.add("Ishwarya");
			registeredList.add("Benny");
			registeredList.add("Stephyrose");
			registeredList.add("KavithaMalar");
			registeredList.add("Senthamarai");
			registeredList.add("Yasothai");
			registeredList.add("SoniaKumari");
			registeredList.add("MerinJose");
			
			System.out.println("Registered List is :::: " + registeredList);
			
			List<String> attendedList = new ArrayList<String>();
			attendedList.add("KavithaMalar");
			attendedList.add("Sumathi");
			attendedList.add("Yasothai");
			attendedList.add("Benny");
			
			System.out.println("Attended List is :::: " + attendedList);
			
			registeredList.retainAll(attendedList);
			
			System.out.println("The students who both registered and attended :::");
			for(String name : registeredList) {
				System.out.println(name);
			}
			System.out.println("28---------------------------------------------------------------------");
		}
		
		
		//29. You are managing a list of students who registered for a session and another list of students who attended the session.
		//Write a Java program to find the names of students who registered but did not attend the session.
		//use removeAll()
		
		public void usingRemoveAll() {
			
			List<String> registeredList = new ArrayList<String>();
			registeredList.add("Sumathi");
			registeredList.add("Menaka");
			registeredList.add("Ishwarya");
			registeredList.add("Benny");
			registeredList.add("Stephyrose");
			registeredList.add("KavithaMalar");
			registeredList.add("Senthamarai");
			registeredList.add("Yasothai");
			registeredList.add("SoniaKumari");
			registeredList.add("MerinJose");
			
			System.out.println("Registered List is :::: " + registeredList);
			
			List<String> attendedList = new ArrayList<String>();
			attendedList.add("KavithaMalar");
			attendedList.add("Sumathi");
			attendedList.add("Yasothai");
			attendedList.add("Benny");
			
			System.out.println("Attended List is :::: " + attendedList);
			
			registeredList.removeAll(attendedList);
			
			System.out.println("The names of students who registered but did not attend the session...");
			
			for(String name : registeredList) {
				System.out.println(name);
			}
			System.out.println("29---------------------------------------------------------------------");
		}
		
		
		//30.Merge Two Department Employee Lists.
		
		public void mergingEmp(){
			
			List<Employee> teamA = new ArrayList<Employee>();
			teamA.add(new Employee("Sumathi", "Gems", 1581));
			teamA.add(new Employee("Rejany", "Gems", 1234));
			teamA.add(new Employee("Arul", "Gems", 1641));
			teamA.add(new Employee("Geethanjali", "Gems", 1598));
			
			List<Employee> teamB = new ArrayList<Employee>();
			teamB.add(new Employee("Krithika", "BFS", 1582));
			teamB.add(new Employee("Jagadhaaranya", "BFS", 1584));
			teamB.add(new Employee("Malini", "BFS", 1345));
			teamB.add(new Employee("Padmapriya", "BFS", 2345));
			
			
			List<Employee> allEmployees = new ArrayList<Employee>();
			allEmployees.addAll(teamA);
			allEmployees.addAll(teamB);
			
			System.out.println("Two Department Employee Lists :::: " + allEmployees);
			System.out.println("30---------------------------------------------------------------------");
						
		}
		
		
		//31. Find the First Occurrence of an Item in a Shopping List
	
		public void findingFirstOccurance(){
			
			List<String> shoppingList = new ArrayList<String>();
			shoppingList.add("Maggi");
			shoppingList.add("Maida");
			shoppingList.add("Veggies");
			shoppingList.add("Pulses");
			shoppingList.add("Maida");
			shoppingList.add("Nuts");
			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter the input ::: ");
//			
//			String searchItem = sc.nextLine();
			String searchItem = "Veggies";
			System.out.println("The search item is ::: " + searchItem);
			
			int occurance = shoppingList.indexOf(searchItem);
			int last = shoppingList.lastIndexOf(searchItem);
			
			if(occurance != -1) {
				System.out.println("The first occurance of the search item " + searchItem + " occcurs at the index at " + occurance);
				System.out.println("The last occurance of the search item is at " + last);
			}
			else {
				System.out.println("Your search item is not in your shoppinglist ");
			}
			
			//incase if we want the things of particular position 
			String grocery = shoppingList.get(2);
			
			System.out.println("31---------------------------------------------------------------------");
			
		}
		
		
	    //32. You are maintaining a List<String> for your daily to-do tasks. You want to extract only the tasks planned 
		//between 11:00 AM and 2:00 PM, which are stored at positions 3 to 6 (inclusive of 3, exclusive of 7).
		
		public List<Task> filteringRange(){
			
			List<Task> dailyTasks = new ArrayList<Task>();
			dailyTasks.add(new Task("Wakeup", 7));
			dailyTasks.add(new Task("Walking", 8));
			dailyTasks.add(new Task("Bathing", 9));
			dailyTasks.add(new Task("Eating", 10));
			dailyTasks.add(new Task("Studying", 11));
			dailyTasks.add(new Task("Writing", 12));
			
			List<Task> filtered = new ArrayList<Task>();
			
			for(Task t : dailyTasks) {
				if(t.time>=8 && t.time<=11) {
					filtered.add(t);
				}
			}
			System.out.println("Filtered to do list from 8 to 11 ::: " + filtered);
			System.out.println("32---------------------------------------------------------------------");
			return filtered;
			
		}
		
		
		//using a sublist
		
		public void usingSublist() {
			
			List<String> toDoList = new ArrayList<String>();
			toDoList.add("Walking");  //0  //7
			toDoList.add("Bathing");  //1  //8
			toDoList.add("Eating");   //2  //9
			toDoList.add("Studying"); //3  //10
			toDoList.add("Sleeping"); //4  //11
			toDoList.add("Writing");  //5  //12
			toDoList.add("Speaking"); //6  //1
			toDoList.add("Chating");  //7  //2 
			toDoList.add("Painting"); //8  //3
			
			List<String> filteredList = toDoList.subList(3, 6);
			System.out.println("Filtered to do list from 8 to 11 ::: " + filteredList);
			System.out.println("33---------------------------------------------------------------------");
			
		}
	
			// 33.Backup cart before discount to restore if needed.
		private void backupCart() {

			ArrayList<String> cartList = new ArrayList<String>();
			cartList.add("Shampoo");
			cartList.add("Soap");
			cartList.add("Towel");
			cartList.add("Brush");
			cartList.add("TennisBall");

			System.out.println("The original cartlist is ::: " + cartList);
			ArrayList<String> backupCart = (ArrayList<String>) cartList.clone();
			System.out.println("Backup cart is ::: " + backupCart);
			cartList.remove("Brush");
			System.out.println("After removing one item from org list is ::: " + cartList);
			System.out.println("Backup cart is ::: " + backupCart);

		}
		
		//34. Write a Java program that reads product IDs from a file (or generates them) and stores them in an ArrayList.
		//Use ensureCapacity() to prepare the list for all elements before insertion, so resizing happens only once.
		
		public void usingEnsureCapacity() {
			
			ArrayList<String> productList = new ArrayList<String>();
			productList.ensureCapacity(1000);
			for(int i = 1 ; i <= 100 ; i++) {
			productList.add("Product-" + i);
			}
			System.out.println(productList);
			
		}
		
		// showing methods of arraylist used in this file.
		public List<String> showMethodsofArrayList() {

			List<String> methodsList = new ArrayList<String>();
			List<String> methodsList1 = new ArrayList<String>();
			
			System.out.println("ArrayList Specific methods :: ");
			methodsList.add("add");
			methodsList.add("contains");
			methodsList.add("remove");
			methodsList.add("get");
			methodsList.add("set");
			methodsList.add("size");
			methodsList.add("sort");
			methodsList.add("clear");
			methodsList.add("remove");
			methodsList.add("isEmpty /isBlank");
			methodsList.add("toArray");
			methodsList.add("retainAll");
			methodsList.add("removeAll");
			methodsList.add("addAll");
			methodsList.add("subList");
			methodsList.add("indexOf");
			methodsList.add("lastIndexOf");
			
			System.out.println("String specific methods used in list elements :::");
			methodsList1.add("toString");
			methodsList1.add("charAt");
			methodsList1.add("startsWith");
			methodsList1.add("endsWith");
			methodsList1.add("equals");
			methodsList1.add("equalsIgnoreCase");
			methodsList1.add("trim");			
			
			return methodsList;
		}
			
		
}	
	
		//created for 30th problem
		class Employee{
			String empName;
			String empDept;
			int idNo;
			
			public Employee(String name , String department , int id){
				this.empName = name;
				this.empDept = department;
				this.idNo = id;
			}
			
			public String toString() {
				return empName + "-" + empDept + "-" + idNo;
				
			}
		}
		
		
		//created for 32nd problem
		class Task{
			String plan;
			int time;
			
			public Task(String schedule , int timing) {
			
				this.plan = schedule;
				this.time = timing;
			}
			
			public String toString() {
				return plan + "-" + time ;
			}
			
		}


