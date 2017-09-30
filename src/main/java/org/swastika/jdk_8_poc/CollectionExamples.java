package org.swastika.jdk_8_poc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class CollectionExamples {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		printLists();
	}

	public static void printLists() {

		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6);
		myList.forEach(i -> System.out.println(i));
		myList.forEach(System.out::println);

		int sumOfDouble = myList.stream().map(l -> l * 2).reduce(0, (c, l) -> c + l);
		System.out.println(sumOfDouble);

		System.out.println(getSummation(myList, c -> true));
		System.out.println(getSummation(myList, e -> e % 2 == 0));

		Set<String> mySet = new HashSet<String>(Arrays.asList("1", "2", "3", "4", "5"));

		String result = mySet.stream().reduce((s, s1) -> s + s1).get();
		
		Set<Integer> myUnorderedSet = new HashSet<Integer>(Arrays.asList(5, 5, 1, 7, 2));
		
		System.out.println(result);
		
		System.out.println(myUnorderedSet.stream().collect(Collectors.toCollection(TreeSet::new)));
		
		//callEmployee(Admin::new);

	}


	interface Employee {
		public default void work() {
			System.out.println("We love to work !! ");
		}
	}

	class Admin implements Employee {
		public void work() {
			System.out.println("We are admin");
		}
	}

	public static void callEmployee(Employee e) {
		e.work();
	}

	public static Integer getSummation(List<Integer> numbers, Predicate<Integer> condition) {

		return numbers.stream().filter(condition).reduce(0, (c, e) -> c + e);

	}

}
