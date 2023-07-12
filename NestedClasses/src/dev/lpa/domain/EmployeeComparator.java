package dev.lpa.domain;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee t1, Employee t2) {
//        return t1.yearStarted - t2.yearStarted;
        return t1.getName().compareTo(t2.getName());
    }
}
