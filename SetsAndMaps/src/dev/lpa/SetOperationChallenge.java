package dev.lpa;

import java.util.*;

public class SetOperationChallenge {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTask = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTask);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTask));
        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks from Boss's list", missingTasks);

        Set<Task> unAssignedTasks = getDifference(tasks, assignedTask);
        sortAndPrint("All Tasks that hasn't assigned", unAssignedTasks, sortByPriority);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder()
        );
        sortAndPrint("Overlapping", overlapping, priorityNatural);

    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }
    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {
        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> allTasks = new HashSet<>();
        for (Set<Task> task : sets) {
            allTasks.addAll(task);
        }
        return allTasks;
    }

    private static Set<Task> getIntersect(Set<Task> task1, Set<Task> task2) {
        Set<Task> intersected = new HashSet<>(task1);
        intersected.retainAll(task2);
        return intersected;
    }

    private static Set<Task> getDifference(Set<Task> task1, Set<Task> task2) {
        Set<Task> difference = new HashSet<>(task1);
        difference.removeAll(task2);
        return difference;
    }
}
