package com.jurik99.Composite;

/**
 * The composite pattern is meant to allow treating individual objects and compositions of objects, or “composites” in the same way.
 *
 * It can be viewed as a tree structure made up of types that inherit a base type, and it can represent a single part or a whole hierarchy of objects.
 *
 * We can break the pattern down into:
 * *) component – is the base interface for all the objects in the composition.
 *      It should be either an interface or an abstract class with the common methods to manage the child composites.
 * *) leaf – implements the default behavior of the base component. It doesn’t contain a reference to the other objects.
 * *) composite – has leaf elements. It implements the base component methods and defines the child-related operations.
 * *) client – has access to the composition elements by using the base component object.
 */
public class Main {

    public static void main(final String[] args) {

        /*
         * Now, let’s dive into the implementation. Let’s suppose we want to build a hierarchical structure of departments in a company.
         */
        final Department salesDepartment = new SalesDepartment(1, "Sales Department");
        final Department financialDepartment = new FinancialDepartment(2, "Financial Department");

        final HeadDepartment headDepartment = new HeadDepartment(3, "Head Department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);

        headDepartment.printDepartmentName();
    }
}
