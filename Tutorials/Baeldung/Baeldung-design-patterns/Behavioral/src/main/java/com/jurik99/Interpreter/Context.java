package com.jurik99.Interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Context {

    private static final Map<String, List<Row>> TABLES = new HashMap<>();

    static {
        final List<Row> list = new ArrayList<>();
        list.add(new Row("John", "Doe"));
        list.add(new Row("Jan", "Kowalski"));
        list.add(new Row("Dominic", "Doom"));

        TABLES.put("people", list);
    }

    private String table;
    private String column;

    /**
     * Index of column to be shown in result.
     * Calculated in {@link #setColumnMapper()}
     */
    private int colIndex = -1;

    /**
     * Default setup, used for clearing the context for next queries.
     * See {@link Context#clear()}
     */
    private static final Predicate<String> MATCH_ANY_STRING = s -> s.length() > 0;
    private static final Function<String, Stream<? extends String>> MATCH_ALL_COLUMNS = Stream::of;
    /**
     * Varies based on setup in subclasses of {@link Expression}
     */
    private Predicate<String> whereFilter = MATCH_ANY_STRING;
    private Function<String, Stream<? extends String>> columnMapper = MATCH_ALL_COLUMNS;

    void setColumn(final String column) {
        this.column = column;
        setColumnMapper();
    }

    void setTable(final String table) {
        this.table = table;
    }

    void setFilter(final Predicate<String> filter) {
        whereFilter = filter;
    }

    /**
     * Clears the context to defaults.
     * No filters, match all columns.
     */
    private void clear() {
        column = "";
        columnMapper = MATCH_ALL_COLUMNS;
        whereFilter = MATCH_ANY_STRING;
    }

    List<String> search() {
        final List<String> result = TABLES.entrySet()
                                          .stream()
                                          .filter(entry -> entry.getKey().equalsIgnoreCase(table))
                                          .flatMap(entry -> Stream.of(entry.getValue()))
                                          .flatMap(Collection::stream)
                                          .map(Row::toString)
                                          .flatMap(columnMapper)
                                          .filter(whereFilter)
                                          .collect(Collectors.toList());
        // After the search is done, the context is clearing itself, so the column, table, and filter are set to defaults.
        clear();
        return result;
    }

    /**
     * Sets column mapper based on {@link #column} attribute.
     * Note: If column is unknown, will remain to look for all columns.
     */
    private void setColumnMapper() {
        switch (column) {
            case "*":
                colIndex = -1;
                break;
            case "name":
                colIndex = 0;
                break;
            case "surname":
                colIndex = 1;
                break;
        }
        if (colIndex != -1) {
            columnMapper = s -> Stream.of(s.split(" ")[colIndex]);
        }
    }
}
