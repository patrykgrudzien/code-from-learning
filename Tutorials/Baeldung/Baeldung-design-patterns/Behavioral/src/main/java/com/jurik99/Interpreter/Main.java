package com.jurik99.Interpreter;

import java.util.List;

@SuppressWarnings("DanglingJavadoc")
public class Main {

    /**
     * In short, the pattern defines the grammar of a particular language in an object-oriented way
     * which can be evaluated by the interpreter itself.
     *
     * Having that in mind, technically we could build our custom regular expression,
     * a custom DSL interpreter or we could parse any of the human languages,
     * build abstract syntax trees and then run the interpretation.
     *
     * These are only some of the potential use cases, but if we think for a while,
     * we could find even more usages of it, for example in our IDEs, since they’re continually interpreting
     * the code we’re writing and thus supplying us with priceless hints.
     *
     * The interpreter pattern generally should be used when the grammar is relatively simple.
     *
     * Otherwise, it might become hard to maintain.
     */

    public static void main(final String[] args) {

        // First, we build a syntax tree with created expressions, initialize the context and then run the interpretation.
        // The context is reused, but as we showed above, it cleans itself after each search call.
        final Expression query = new Select("name", new From("people"));
        final Context context = new Context();
        final List<String> result = query.interpret(context);
        System.out.println(result);

        final Expression query2 = new Select("*", new From("people"));
        final List<String> result2 = query2.interpret(context);
        System.out.println(result2);

        final Expression query3 = new Select("name",
                                             new From("people",
                                                new Where(name -> name.toLowerCase().startsWith("d"))));
        final List<String> result3 = query3.interpret(context);
        System.out.println(result3);
    }

    /**
     * Now, any language needs to be expressed in some way, and the words (expressions)
     * are going to have some meaning based on the given context.
     *
     * AbstractExpression defines one abstract method which takes the context as a parameter.
     * Thanks to that, each expression will affect the context, change its state and either continue
     * the interpretation or return the result itself.
     *
     * Therefore, the context is going to be the holder of the global state of processing,
     * and it’s going to be reused during the whole interpretation process.
     *
     * So what’s the difference between the TerminalExpression and NonTerminalExpression?
     *
     * A NonTerminalExpression may have one or more other AbstractExpressions associated in it, therefore it can be recursively interpreted.
     * In the end, the process of interpretation has to finish with a TerminalExpression that will return the result.
     *
     * It’s worth to note that NonTerminalExpression is a composite.
     *
     * Finally, the role of the client is to create or use an already created abstract syntax tree,
     * which is nothing more than a sentence defined in the created language.
     */


    /**
     * When the grammar is getting more complex, it becomes harder to maintain.
     *
     * It can be seen in the presented example. It’d be reasonably easy to add another expression,
     * like Limit, yet it won’t be too easy to maintain if we’d decide to keep extending it with all other expressions.
     */
}
