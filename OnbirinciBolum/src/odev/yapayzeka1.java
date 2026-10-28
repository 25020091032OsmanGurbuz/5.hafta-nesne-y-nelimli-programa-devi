package odev;


import java.util.ArrayList;
import java.util.Scanner;

// 1. Exercise 11.10: MyStack class extending ArrayList
class MyStack extends ArrayList<Object> {
    
    public int getSize() {
        return size();
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public Object push(Object o) {
        add(o);
        return o;
    }

    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}

// Main class containing the test programs for both 11.10 and 11.11
public class yapayzeka1 {
    
    // 2. Exercise 11.11: Method to sort an ArrayList of Integers
    public static void sort(ArrayList<Integer> list) {
        // Selection sort algorithm using ArrayList methods
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            int minValue = list.get(i);
            
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < minValue) {
                    minValue = list.get(j);
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, minValue);
            }
        }
    }

    public static void main(String[] args) {
        // --- Test for Exercise 11.10 (MyStack using Inheritance) ---
        System.out.println("=== 11.10 Test: Reverse 5 Strings using MyStack ===");
        Scanner input = new Scanner(System.in);
        MyStack stack = new MyStack();

        System.out.println("Enter five strings:");
        for (int i = 0; i < 5; i++) {
            System.out.print("String " + (i + 1) + ": ");
            String s = input.nextLine();
            stack.push(s);
        }

        System.out.println("\nDisplaying them in reverse order:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("\n=================================================\n");

        // --- Test for Exercise 11.11 (Sort ArrayList) ---
        System.out.println("=== 11.11 Test: Sort ArrayList of Numbers ===");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(3);
        numbers.add(25);

        System.out.println("Original list: " + numbers);
        sort(numbers);
        System.out.println("Sorted list  : " + numbers);

        input.close();
    }
}