# Test Task for Lingoda:

1. go to https://www.amazon.de/
2. search for `Batman comics`
3. check that results number above 0
4. for the 1st item:
- check that title contains `Batman` word
- check that price is above 0 and has `EUR` postfix
- check that item has rating
5. open 1st item page and check that title and price are equal to the ones in result
search
_______


Requerments:

OS: Win/Mac/Unix

Java: 11+

Maven: 3+

Chrome: 74

To run test cd to project dir and run

mvn clean test -Dtest=SearchTest
