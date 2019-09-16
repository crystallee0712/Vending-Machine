# Project Information

This project implements an application that controls a Beverage Vending Machine.

Currently, coffee and tea are supported by this beverage vending machine. The machine can brew hot or cold coffee or tea. Adding milk or/and sugar to the hot coffee is supported. However, adding milk or sugar to the cold coffee or tea is not supported.

Only Espresso, Americano, Latte can be brewed as coffee for the moment.

Only Black tea, Green tea and Yellow tea can be brewed as tea for the moment.

# Project Design

1. Flexibility

    To realize the flexibility, this project contains one abstract class named Drink, which has one field to define if the drink is ice or hot, three methods as initializing(), brewing() and finishing(). 
    
    This project also contains one interface named Condiments, which has one method addingCondiments with the amount of milk and amount of sugar as parameters. 
    
    Class Coffee and class Tea inherit the parent class Drink. Class Coffee also implements the interface Condiments.
    
    For future new drink types, new class could be defined to inherit the existing current parent class Drink. If necessary, the new class could also implements interface Condiments.


2. Simplicity

    This project is very straightforward and easy to understand.

    For Coffee class, the system will verify if the drink is ice or hot by overriding the brewing() method from Drink class. No other type, warm for instance, will be allowed. In addition, the system will examine if the coffee type is currently supported by the system. If not, warning message will be shown. A flag will be set to 1 if the previous steps are fulfilled. The system will also verify if the units of sugar and milk are acceptable by overriding addingCondiments() method from Condiments class. If the flag equals to 1, then the system can show brewing is done in the finishing step, otherwise, the system will show not able to fulfill the customer's request.

    For Tea class, the design flow is basically same with Coffee class, except that condiments are not allowed to be added to the tea. So Condiments interface will not be implemented in this class.

3. Efficiency

    Since this project is implementing interface and extending Drink, several methods can be defined in the interface and in the abstract class, which reduces the duplicated code.

# How to compile the project

I use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```


# Run all the unit test classes.


```bash
mvn clean compile test

```


