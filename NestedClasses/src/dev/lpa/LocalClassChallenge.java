package dev.lpa;

import dev.lpa.domain.MyEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LocalClassChallenge {
    public static void main(String[] args) {
        MyEmployee e1 = new MyEmployee("Minnie", "Mouse", "01/02/2015");
        MyEmployee e2 = new MyEmployee("Mickie", "Mouse", "05/08/2000");
        MyEmployee e3 = new MyEmployee("Daffy", "Duck", "11/02/2011");
        MyEmployee e4 = new MyEmployee("Daisy", "Duck", "05/03/2013");
        MyEmployee e5 = new MyEmployee("Goofy", "Dog", "23/07/2020");

        List<MyEmployee> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

        printOrderList(list, "name");
        System.out.println();
        printOrderList(list, "year");
    }

    public static void printOrderList(List<MyEmployee> eList, String sortField) {
        int currentYear = LocalDate.now().getYear();

        class MyGoodEmployee {
            MyEmployee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyGoodEmployee(MyEmployee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ",
                        containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(
                        fullName, yearsWorked);
            }
        }

        List<MyGoodEmployee> list = new ArrayList<>();
        for (MyEmployee employee : eList) {
            list.add(new MyGoodEmployee(employee));
        }

        var comparator = new Comparator<MyGoodEmployee>(){

            @Override
            public int compare(MyGoodEmployee t1, MyGoodEmployee t2) {

                if (sortField.equals("name")) {
                    return t1.fullName.compareTo(t2.fullName);
                }
                return t1.yearsWorked - t2.yearsWorked;
            }
        };

        list.sort(comparator);

        for (MyGoodEmployee myGoodEmployee : list) {
            System.out.println(myGoodEmployee);
        }

    }

}
