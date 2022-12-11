package lessons_Alishev.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.*;

public class Base {
    private static final Base BaseInstance = getInstance();
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
    public static Base getInstance() {
        return Objects.requireNonNullElseGet(BaseInstance, Base::new);
    }

    public static void main(String[] args) throws IOException {
//        BaseInstance.primitives();
//        BaseInstance.strings();
//        BaseInstance.forLoop();
//        BaseInstance.inputs();
//        BaseInstance.switchOperator();
//        BaseInstance.arrays();
//        BaseInstance.multidimensionalArrays();
        ClassesAndObjects.myDummyMethod();
    }

    private void primitives() {
        int myInt = 333330000;
        System.out.printf("myInt: %d%n", myInt);
    }

    private void strings() {
        String hello = "Hello";
        String space = " ";
        String name = scanner.nextLine();

        List<String> strings = Arrays.asList(hello, space, name);
        StringBuilder builder = new StringBuilder();
        strings.forEach(builder::append);
        System.out.println(builder);
    }

    private void forLoop() throws IOException {
        System.out.println("Please enter counter below:");
        int counter = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= counter; i += 2) {
            System.out.println("#" + i);
        }
        System.out.println("*".repeat(15));
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("Odd number: " + i);
        }
    }

    private void inputs() {
        System.out.println("Enter something");
        String s = scanner.nextLine();
        int x = scanner.nextInt();
        System.out.println("Your input is: " + s);
        System.out.println("Your number input is: " + x);
    }

    private void switchOperator() {
        System.out.println("Enter your age below: ");
        int age = scanner.nextInt();
        switch (age) {
            case 0:
                System.out.println("You are just born");
                break;
            case 7:
                System.out.println("You are in going to school");
                break;
            case 18:
                System.out.println("You are finished school education");
                break;
            default:
                System.out.println("Do you try to learn something?)");
        }
    }

    private void arrays() {
        String [] strings = {"1", "2"};
        int[] numbers = new int[5];
        for(int i = 0; i < numbers.length; i ++) {
            numbers[i] = getRandomNumber();
        }
        List<String> strings1  = new ArrayList<String>() {
            List<String> addValues() {
                for (int i = 0; i < 5; i++) {
                    StringBuilder b = new StringBuilder();
                    for (int j = 0; j < 5; j++) {
                        int tempInt;
                        while (true) {
                            tempInt = getRandomNumber();
                            if (tempInt >= 65 && tempInt <= 90) {
                                break;
                            }
                        }
                        char c = (char) tempInt;
                        b.append(c);
                    }
                    this.add(b.toString());
                }
                return this;
            }
        }.addValues();
        strings1.addAll(Arrays.asList(strings));
        System.out.println(strings1);
    }

    private void multidimensionalArrays() {
        int[][] myArray = new int[2][3];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = getRandomNumber();
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }

        int[][] myArray1 = {{1, 2}, {1, 2, 3}};
        for (int[] ints : myArray1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
class ClassesAndObjects {

    public static void main(String[] args) throws Exception{
        Person zettai = new Person("Zettai", 777);
        zettai.setName(zettai.name + " Makenai!");
        zettai.setAge(31);
        zettai.greeting();
        Person vlad = new Person("Vlad v Salat", 12);
        vlad.scream();
        int vladYears = vlad.calculateYearsToRetirement();
        System.out.println(vladYears);

        Person human = new Human();
        human.scream();

        Animal animal = new Animal();
        animal.setType("Unknown animal");
        animal.makeSound();

        Dog dog = new Dog();
        dog.setType("");
        dog.makeSound();

        if (dog instanceof Animal) {
            System.out.println(1);
        }
        Dog dog1 = (Dog) animal;
        dog1.makeSound();

    }

    static void myDummyMethod() {
        System.out.println("Something from second class " + ClassesAndObjects.class.getCanonicalName());
    }

    static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            greeting();
        }

        public Person(){}

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) throws Exception {
            if (name.isEmpty()) {
                throw new Exception("User have to have name!");
            }
            this.name = name;
        }

        public void setAge(int age) throws Exception{
            if (age <= 0) {
                throw new Exception("Your age cannot be less than or equals 0");
            }
            this.age = age;
        }

        void scream() {
            System.out.println(name + ": ");
            System.err.println("AAAAAAAAARRRRGHH!!!!!!!!");
        }

        void greeting() {
            System.out.println(this);
        }

        int calculateYearsToRetirement() {
            int restOfTheYears = 65 - age;
            System.out.printf("You have %d years to retirement.\n", restOfTheYears);
            return restOfTheYears;
        }

        @Override
        public String toString() {
            return String.format("My name is: %s, my age is age: %s\n", name, age);
        }
    }

    static class Human extends Person {

    }

    static class Animal {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void makeSound() {
            System.out.println(this.type + " said something");
        }
    }

    static class Dog extends Animal {

        @Override
        public void setType(String type) {
            super.type = "Dog";
        }

        @Override
        public void makeSound() {
            System.out.println(this.getType() + " said wouv");
        }
    }
}