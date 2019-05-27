package com.jurik99;

public class MySimpleClass
{
    MySimpleClass()
    {
        simpleMethod();
    }

    /**
     * Wewnątrz cudzysłowu mogę podać wybrane przez siebie wartości.
     * Aby je odczytać, odwołuje się do nich przez refleksję.
     *
     * Poniżej kod, który w tym przypadku wypisuje na ekranie konsoli wartość adnotacji A:
     */
    @MyAnnotation(A = "TestA", B = "TestB")
    public void simpleMethod()
    {
        MyAnnotation annotation1 = null;
        MyAnnotation annotation2 = null;

        try
        {
            /**
             * Pobieram bieżącą klasę, a następnie metodę, której tyczy się adnotacja.
             * Z metody wyciągam adnotację.
             */
            annotation1 = this.getClass().getMethod("simpleMethod").getAnnotation(MyAnnotation.class);
            annotation2 = this.getClass().getMethod("simpleMethod").getAnnotation(MyAnnotation.class);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }

        if (annotation1 != null)
            System.out.println(annotation1.A());

        if (annotation2 != null)
            System.out.println(annotation2.B());
    }

    // -------------------------- main() -------------------------- //
    public static void main(String[] args)
    {
        new MySimpleClass();
    }
}

