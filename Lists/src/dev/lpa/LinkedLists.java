package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {
    public static void main(String[] args) {
//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);
//        System.out.println(placesToVisit);

//        printItinerary3(placesToVisit);

        testIterator2(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");
//        Queue methods
        list.offer("Melbourne");  // Adds to the last of list as enqueue
        list.offerFirst("Brisbane");  // Adds to the first of list
        list.offerLast("Toowoomba"); // Adds to the last of list same as offer

//        Stack Methods
        list.push("Alice Springs");  // Adds to the start of the list as in stack

    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();  // removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();  // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();  // removes last element
        System.out.println(s3 + " was removed");

//        Queue/Deque pool methods
        String p1 = list.poll();  //removes first element
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();  //removes first element
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();  //removes last element
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();  //removes first element
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " +
                list.lastIndexOf("Melbourne"));

//        Queue retrieval method
//        first element according to queue
        System.out.println("Element from element() = " + list.element());

//        Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    private static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {

        var iterator = list.iterator();
//        simple iterator has only one method to perform remove
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void testIterator2(LinkedList<String> list) {

        var iterator = list.listIterator();
//        ListIterator has more methods to perform other than remove
//        as available in iterator
        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                iterator.add("Lake Wivenhoe");

            }
        }
//        Will not print out anything since the iterator has come
//        to the end of the LinkedList
//        But we can traverse in reverse order
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);

//        We can set the iterator position in this way
        var iterator2 = list.listIterator(3);
//        It will print the current element and moves the iterator
//        to the next element
        System.out.println(iterator2.next());
        iterator2.previous();
        System.out.println(iterator2.previous());
    }
}
