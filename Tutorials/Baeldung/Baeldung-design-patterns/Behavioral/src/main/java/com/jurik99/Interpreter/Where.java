package com.jurik99.Interpreter;

import java.util.List;
import java.util.function.Predicate;

public class Where implements Expression {

    private final Predicate<String> filter;

    Where(final Predicate<String> filter) {
        this.filter = filter;
    }

    /**
     * The Where expression is again modifying the context by setting the necessary filter
     * and terminates the interpretation with search call:
     */
    @Override
    public List<String> interpret(final Context context) {
        context.setFilter(filter);
        return context.search();
    }
}
