package com.infotech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infotech.model.Employee;
import com.infotech.model.Employer;

public class User_Client_Test {

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));
		empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

		List<Employer> employeerList = Arrays.asList(new Employer("Tom", 25), new Employer("harry", 65),
				new Employer("steven", 42), new Employer("jackson", 59), new Employer("Zack", 34),
				new Employer("Bravo", 26), new Employer("Charlie", 67));

		for (Employee emp : empList) {
			System.out.println(emp);
		}

		System.out.println("No of employees in the organisation :: " + empList.stream().count());

		empList.stream().filter(e -> e.getAge() == 25).forEach(e -> System.out.println(e));

		System.out.println("-----------------------------------------------------------------------");

		empList.stream().filter(e -> e.getGender().equals("F")).forEach(e -> System.out.println(e));

		System.out.println("-----------------------------------------------------------------------");

		empList.stream().filter(e -> e.getGender().equals("M")).collect(Collectors.toList())
				.forEach(e -> System.out.println(e));

		System.out.println("------------------------------------------------------------------------");

		empList.stream().filter(e -> e.getDeptName().equals("HR")).forEach(e -> System.out.println(e));

		/*
		 * Grouping employee by city
		 */
		Map<String, List<Employee>> empByCity;
		empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Grouping city by :\n \t" + empByCity);

		System.out.println("------------------------------------------------------------------------");

		/*
		 * Grouping Employee By Age
		 */

		Map<Integer, List<Employee>> empByAge;
		empByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("Employees grouped by age :: \n" + empByAge);

		System.out.println("------------------------------------------------------------------------");

		/*
		 * Printing name of all Departments
		 */
		List<String> empdept;
		empdept = empList.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
		empdept.forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		/*
		 * Employee Details By Age Criteria
		 */

		List<Employee> empAge = empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList());
		empAge.forEach(System.out::println);

		System.out.println("------------------------------------------------------------------------");

		/*
		 * Finding Employee from HR Department
		 */

		Optional<Employee> empDept = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR")).findAny();
		if (empDept.isPresent()) {
			System.out.println("Found employee from HR Department" + empDept);
		} else {
			System.out.println("Employee is not present");
		}

		System.out.println("------------------------------------------------------------------------");

		/*
		 * Finding Highest Experienced Employee
		 */

		Optional<Employee> seniorEmployee = empList.stream()
				.min((e1, e2) -> e1.getYearOfJoining() - e2.getYearOfJoining());
		System.out.println("Highest Experienced Employee :" + seniorEmployee.get());

		System.out.println("------------------------------------------------------------------------");

		/*
		 * To find the second highest element i.e to employee
		 */

		Optional<Employee> employeeRecords = empList.stream()
				.sorted((c1, c2) -> Double.compare(c2.getSalary(), c1.getSalary())).skip(1).findFirst();

		System.out.println("Employee second highest salary :" + employeeRecords.get().getSalary());

		System.out.println("-----------------------------------------------------");

		/*
		 * Finding Highest employee salary
		 */

		Optional<Employee> highestSalary = empList.stream()
				.max((c1, c2) -> Double.compare(c1.getSalary(), c2.getSalary()));

		System.out.println("Employee Highest Salary :" + highestSalary.get().getSalary());

		System.out.println("------------------------------------------------------------------");

		/*
		 * Handling Exception through Streams
		 */
		List<String> names = Arrays.asList("Ankit", "Soni", "Java");
		String dataNames = names.stream().filter(s -> s.startsWith("Z")).findFirst().orElse("Not found names with Z ");
		System.out.println("dataNames :" + dataNames);

		System.out.println("------------------------------------------------------------------");

		/*
		 * To Find even numbers using Infinite Stream
		 */

		Stream.iterate(1, n -> n + 1).filter(n -> n % 2 == 0).limit(10).forEach(System.out::println);

		System.out.println("-------------------------------------------------------------");

		/*
		 * To Find Odd Numbers using Infinite Stream
		 */
		Stream.iterate(1, n -> n + 1).filter(n -> n % 2 != 0).limit(10).forEach(System.out::println);

		/*
		 * To calculate average number
		 */
		OptionalDouble averageData = Stream.iterate(1, n -> n + 1).limit(10).mapToInt(Integer::intValue).average();
		System.out.println("Average Data :" + averageData);

		System.out.println("-------------------------------------------------------------");

		/*
		 * To Calculate Sum using Infinite Stream
		 */

		int sum = Stream.iterate(1, n -> n + 1).limit(10).mapToInt(Integer::intValue).sum();
		System.out.println("Sum of an infinite series :" + sum);

		/*
		 * Calculating average using normal stream
		 */

		System.out.println("-------------------------------------------------------------");

		List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		OptionalDouble average = dataList.stream().mapToDouble(Integer::intValue).average();
		System.out.println("Average of List :" + average);

		/*
		 * To Calculate Square of all even Numbers
		 */

		System.out.println("-------------------------------------------------------------");

		List<Integer> evenData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = evenData.stream().filter(n -> n % 2 == 0).map(n -> n * n)
				.collect(Collectors.toList());
		evenNumbers.forEach(System.out::println);

		System.out.println("-------------------------------------------------------------");

		/*
		 * To Calculate sum of squares using Streams
		 */
		List<Integer> evenRecords = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		OptionalDouble evenDataRecords = evenRecords.stream().filter(n -> n % 2 == 0).map(n -> n * n)
				.mapToInt(Integer::intValue).average();
		System.out.println("evenDataRecords :" + evenDataRecords);

		System.out.println("-------------------------------------------------------------");

		/*
		 * To Calculate odd numbers and print them Squares using Stream
		 */

		List<Integer> oddNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> oddData = oddNumbers.stream().filter(x -> x % 2 != 0).map(x -> x * x)
				.collect(Collectors.toList());
		oddData.forEach(System.out::println);

		/*
		 * Names order as alphabetical People with age >60 eligibility check with
		 * retirement (Both with Java 7 and Java 8)
		 */
		List<Employer> employee = employeerList.stream().filter(e -> e.getAge() > 60)
				.sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName())).collect(Collectors.toList());
		employee.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");

		List<List<String>> apiResponse = Arrays.asList(Arrays.asList("item 1", "item 2"),
				Arrays.asList("item 3", "item 4"));
		List<String> apiResponseData = apiResponse.stream().flatMap(List::stream).collect(Collectors.toList());
		apiResponseData.forEach(System.out::println);

		/*
		 * To find out vowels using data streams API
		 */
		String str = "Ankit";
		List<String> dataRec = Arrays.asList(str.split(""));
		List<String> dataVal = dataRec.stream().filter(ch -> "aeiou".contains(ch)).collect(Collectors.toList());
		dataVal.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");

		/*
		 * To do all Products of all integers using streams by reduce keyword
		 */

		List<Integer> recordList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int productData = recordList.stream().filter(n -> n % 2 == 0) // keep even numbers
				.map(n -> n * n) // square them
				.reduce(1, (a, b) -> a * b); // multiply of all numbers

		System.out.println(productData);

	}

}
