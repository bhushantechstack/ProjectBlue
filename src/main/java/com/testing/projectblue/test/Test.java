package com.testing.projectblue.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String [] args){
        System.out.println("Hello World");

        // collection practice
        List<String> list = new ArrayList<>();
        list.add("Bhushan");
        list.add("Gandole");
        list.add("Bhairu");
        list.add("Satyarth");
        list.add("Bharat");

        // Iterator itr= list.iterator();
        // while(itr.hasNext()){
        //     String name = (String) itr.next();
        //     if(name.equals("Bhushan")){
        //         itr.remove();
        //         }

               
        // }
        // System.out.println(list);
        // System.out.println(list.get(1));

        // ListIterator<String> listItr = list.listIterator();
        // while(listItr.hasPrevious()){
        //     String name = listItr.previous();
        //     if(name.equals("Bhushan")){
        //         listItr.set("Bhushan Gandole");
        //     }
        // }
        // System.out.println(list);

        // Map<Integer,String> map= new HashMap<>();
        // map.put(1, "Bhushan");
        // map.put(2, "Bhairavi");
        // map.put(3,"Gandole");

        // Set<Integer> keys= map.keySet();
        // Iterator key= keys.iterator();
        // while(key.hasNext())
        // {
        //     int ke = (Integer)key.next();
        //     System.out.println(ke + map.get(ke));
        // }

        List<String> list1 =list.stream().filter(x-> x.length()>6).collect(Collectors.toList());
        System.out.println(list1);
        List<String> list2 = list.stream().sorted().toList();
        System.out.println(list2);

        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmployeeName("Bhushan");
        employee.setSalary(50000);

        Employee employee1 = new Employee();
        employee1.setEmpId(2);
        employee1.setEmployeeName("Bhairavi");
        employee1.setSalary(52000);

        Employee employee2 = new Employee();
        employee2.setEmpId(3);
        employee2.setEmployeeName("Karan");
        employee2.setSalary(53000);

        Employee employee3 = new Employee();
        employee3.setEmpId(4);
        employee3.setEmployeeName("Rudra");
        employee3.setSalary(54000);

        List<Employee> employees= new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        // get me employee name having highest salary

        double salary = employees.stream().map(x -> x.getSalary()).max((a,b)-> a.compareTo(b)).get();
        System.out.println(salary);

        // N th salary
        double secondHighest = employees.stream().map(x-> x.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest);

        // highest salary employee name

        Employee sHighestSalariedEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println(sHighestSalariedEmployee.getEmployeeName()+ " "+sHighestSalariedEmployee.getEmpId());

        List<Integer> integers = Arrays.asList(1,10,35,50,6, 55, 90);
        // find values greter than 10 and multiply with same number and then do sum of it
        int sum = integers.stream().filter(x-> x>10).map(x-> x * x).mapToInt(x->x).sum();
        System.out.println(sum);

        // get employee name which has length grether that 5

        List<Employee> employeeName = employees.stream().filter(x->x.getEmployeeName().length()>5).collect(Collectors.toList());
        for(Employee emp:employeeName)
        {
            System.out.println(emp.getEmployeeName());
        }

        // make employee name upper case
        List<String> upperCase = employees.stream().map(x->x.getEmployeeName().toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCase);

        Map<String,Employee> map = new HashMap<>();
        map.put("1", employee);
        map.put("2", employee1);
        map.put("3", employee2);
        map.put("4", employee3);

        System.out.println(map.entrySet().stream().map(x->x.getValue().getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        
        SortingTest sortingTest = new SortingTest();
        sortingTest.setEmpId(1);
        sortingTest.setEmployeeName("Bhushan"); 

        SortingTest sortingTest1 = new SortingTest();
        sortingTest1.setEmpId(2);
        sortingTest1.setEmployeeName("Bhairavi"); 

        SortingTest sortingTest2 = new SortingTest();
        sortingTest2.setEmpId(3);
        sortingTest2.setEmployeeName("Karan");

        List<SortingTest> sortingTests = new ArrayList<>();
        sortingTests.add(sortingTest);
        sortingTests.add(sortingTest1);
        sortingTests.add(sortingTest2);


        TreeSet<SortingTest> treeSet = new TreeSet<>(sortingTests);
        treeSet.add(sortingTest1);
        treeSet.add(sortingTest2);
        treeSet.add(sortingTest);
        
        for (SortingTest sort: treeSet)
        {
            System.out.println(sort.getEmpId()+" "+sort.getEmployeeName());
        }

        SortingTestComparator comparator = new SortingTestComparator();
        comparator.setRollno(3);
        comparator.setStudentName("Vajir");

        SortingTestComparator comparator1 = new SortingTestComparator();
        comparator1.setRollno(10);
        comparator1.setStudentName("Shahir");

        SortingTestComparator comparator2 = new SortingTestComparator();
        comparator2.setRollno(15);
        comparator2.setStudentName("Kashir");

        SortingTestComparator comparator3 = new SortingTestComparator();
        comparator3.setRollno(1);
        comparator3.setStudentName("Hashir");

        TreeSet<SortingTestComparator> comparators = new TreeSet<>(new RollNoSorting());
        comparators.add(comparator);
        comparators.add(comparator1);
        comparators.add(comparator2);
        comparators.add(comparator3);
        System.out.println("-------------");
        for(SortingTestComparator sort1: comparators)
        {
            System.out.println(sort1.getRollno()+" "+sort1.getStudentName());
        }

        // throw new BroException("Bhushan you are such a cool person");
        



    }
     
}
