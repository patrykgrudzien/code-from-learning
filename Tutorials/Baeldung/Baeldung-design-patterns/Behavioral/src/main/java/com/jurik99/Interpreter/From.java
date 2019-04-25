package com.jurik99.Interpreter;

import java.util.List;

public class From implements Expression {

    private final String table;
    private Where where;

    From(final String table) {
        this.table = table;
    }

    From(final String table, final Where where) {
        this.table = table;
        this.where = where;
    }

    /**
     * Now, in SQL the where clause is optional, therefore this class is either a terminal or a non-terminal expression.
     *
     * If the user decides not to use a where clause, the From expression it’s going to be terminated
     * with the context.search() call and return the result.
     * Otherwise, it’s going to be further interpreted.
     */
    @Override
    public List<String> interpret(final Context context) {
        context.setTable(table);
        if (where == null) {
            return context.search();
        }
        return where.interpret(context);
    }
}
