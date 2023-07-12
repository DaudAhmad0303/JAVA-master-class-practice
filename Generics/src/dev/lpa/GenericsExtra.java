package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student1;
import dev.lpa.util.QueryItem;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class GenericsExtra {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student1> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student1());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreLists(lpaStudents);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var querylist = new QueryList<>(lpaStudents);
        var matches = querylist.getMatchs(
                "Course", "Python"
        );
        printMoreLists(matches);

        var students2021 =
                QueryList.getMatchs(students, "YearStarted", "2021");

//        To call a static method from a generic class as generic method
//        var students2021 =
//                QueryList.<Student1>getMatchs(new ArrayList<>(), "YearStarted", "2021");
        printMoreLists(students2021);

//        QueryList<Employee> employeeList = new QueryList<>();


    }


//    public static void printList(List students) {
//    public static void printList(List<Student1> students) {
//    Here we have declared a generic method.
//    public static <T extends Student1> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }

//    ? in the argument as a type is called wildcard
    public static void printMoreLists(List<? extends Student1> students) {

       for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }


//    Both of these following methods will have Object type argument
//    after compilation in byte code.
//    public static void testLists(List<String> list) {
//
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testLists(List<Integer> list) {
//
//        for (var element : list) {
//            System.out.println("String: " + element.floatValue());
//        }
//    }

    //    Alternatively, we can do the following
    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

}
