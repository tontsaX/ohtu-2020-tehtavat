1. Task 1 is not meant to be returned.

2. Add classes, that implement Matcher interface with operation names as 
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

3. Add Or Mathcer implementation.

4. Learn from the material about builder classes andd Make a builder class called 
QueryBuilder. Get rid of writing new Operation every time.

5. Add oneOf(Matcher...) method to the Builder class to use Or operation.
