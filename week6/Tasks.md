1. Write classes, that implement Matcher interface as following operations 
All(true for all players), Not(negation of the parameter),HasFewerThan(inverse of the 
HasAtLeast method). Use classes And, HasAtLeast and PlaysIn as examples.

Operations
Matcher m = new And( 
    new Not( new HasAtLeast(1, "goals") ),
    new PlaysIn("NYR")
);

and

Matcher m = new And( 
    new HasFewerThan(1, "goals"),
    new PlaysIn("NYR")
);

need to print the same output.
