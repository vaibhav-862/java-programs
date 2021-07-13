package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {

        Map<Employee, String> mutableKeyMap = new HashMap<>();
        Employee emp1 = new Employee(1, "Vaibhav");
        mutableKeyMap.put(emp1, "Employee1");

        Employee emp2 = new Employee(1, "Vaibhav");
        System.out.println("Fetching emp1 from map by passing emp2 as key : " + mutableKeyMap.get(emp2));

        //mutating the employee key object
        emp1.setName("Karan");

        //retrieve the employee object should return null due to modified hashcode
        System.out.println("Fetching mutated employee : " + mutableKeyMap.get(emp1));

        Employee emp3 = new Employee(1, "Vaibhav");
        //retrieving lost entry object of employee type from map by passing employee
        //object in the map.get() with similar content as that of lost object

        //Still null will be the output, as lost object key combination is now "1 and Karan"
        //after mutation, but the object which is passed into get() has combination of "1 and Vaibhav"
        System.out.println("Fetching lost employee : " + mutableKeyMap.get(emp3));
    }

}
