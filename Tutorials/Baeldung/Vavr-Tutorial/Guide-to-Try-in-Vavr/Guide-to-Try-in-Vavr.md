# 1. Overview
In this article, <b>we’ll look at a functional way of error handling other than a standard try-catch block</b>.

We’ll be using Try class from Vavr library that will allow us to create more fluent and conscious API by
embedding error handling into normal program processing flow.

# 3. Handling Exceptions with Try
Vavr library gives us a <b>special container that represents a computation that may either result in an exception or complete successfully.</b>

Enclosing operation within "<em>Try</em>" object gave us a result that is either "<em>Success</em>" or a "<em>Failure</em>".
Then we can execute further operations accordingly to that type.