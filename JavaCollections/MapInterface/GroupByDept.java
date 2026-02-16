package MapInterface;

import java.util.*;

public class GroupByDept {

    static class Employee {
        String name, dept;
        Employee(String name, String dept){ this.name=name; this.dept=dept; }
        public String toString(){ return name; }
    }

    static Map<String,List<Employee>> groupByDept(List<Employee> list){
        Map<String,List<Employee>> m = new HashMap<>();
        for (Employee e: list)
            m.computeIfAbsent(e.dept, k -> new ArrayList<>()).add(e);
        return m;
    }

    public static void main(String[] args){
        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR"),
                new Employee("Bob","IT"),
                new Employee("Carol","HR")
        );

        System.out.println(groupByDept(employees)); // {HR=[Alice, Carol], IT=[Bob]}
    }
}
