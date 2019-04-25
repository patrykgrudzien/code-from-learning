package com.jurik99.Interpreter;

import java.util.List;

public class Select implements Expression {

    private final String column;
    private final From from;

    Select(final String column, final From from) {
        this.column = column;
        this.from = from;
    }

    /**
     * It gets the column name to be selected and another concrete Expression of type From as parameters in the constructor.
     *
     * Note that in the overridden interpret() method it sets the state of the context
     * and passes the interpretation further to another expression along with the context.
     *
     * That way, we see that it’s a NonTerminalExpression.
     */
    @Override
    public List<String> interpret(final Context context) {
        context.setColumn(column);
        return from.interpret(context);
    }
}
