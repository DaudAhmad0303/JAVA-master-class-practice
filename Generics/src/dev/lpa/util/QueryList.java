package dev.lpa.util;

import dev.lpa.model.Student1;

import java.util.ArrayList;
import java.util.List;

//public class QueryList<T extends QueryItem> {
// We are here in providing multiple upper bound for the class.
public class QueryList<T extends Student1 & QueryItem> {
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatchs(List<T> items,
                                        String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
    public List<T> getMatchs(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
