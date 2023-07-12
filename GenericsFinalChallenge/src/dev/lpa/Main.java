package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.LPAStudentComparator;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.printf("%nMatches%n");
        var matches = queryList
                .getMatchs("PercentComplete", "50")
                .getMatchs("Course", "Python");

        matches.sort(new LPAStudentComparator());
        printList(matches);

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);


    }

//    Here we're using a unbounded wildcard as parameter to the method
    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }
}
