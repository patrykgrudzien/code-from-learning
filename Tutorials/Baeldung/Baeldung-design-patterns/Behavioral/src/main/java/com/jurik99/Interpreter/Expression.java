package com.jurik99.Interpreter;

import java.util.List;

/**
 * To show the pattern in action, we’ll build a simple SQL-like syntax in an object-oriented way,
 * which will be then interpreted and return us the result.
 *
 * First, we’ll define Select, From, and Where expressions,
 * build a syntax tree in the client’s class and run the interpretation.
 *
 * The Expression interface will have the interpret method:
 */
public interface Expression {

    List<String> interpret(Context context);
}
