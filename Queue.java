import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {
    static List<Integer> numQueue = new ArrayList<Integer>();
    static int head = 0;
    static int tail = 0;
    static Lock lock = new ReentrantLock();

    public static void Enqueue(int Num) {
        lock.lock();
        try {
            numQueue.add(Num);
            tail = numQueue.size();
        } 
        finally {
            lock.unlock();
        }
    }

    public static int Dequeue() {
        lock.lock();
        try {
            System.out.println("Removing first number from queue");
            int temp = numQueue.get(0);
            numQueue.remove(head);
            return temp;
        } 
        finally {
            lock.unlock();
        }
    }

    public static boolean isEmpty() {
        boolean empty = numQueue.isEmpty();
        if (empty == true) {
            System.out.println("Queue is empty");
            return true;

        } 
        else {
            System.out.println("Queue is not empty");
            return false;
        }
    }

    public static boolean isFull() {
        if (numQueue.size() == 10) {
            System.out.println("Queue is Full! -> " + numQueue);
            return true;
        } 
        else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println("This queue can only store 10 numbers.");

        while (true) {
            if (!isFull()) {
                System.out.println("Type 1 to Enqueue or 2 to Dequeue");
                Scanner userInput = new Scanner(System.in);
                int choice = userInput.nextInt();
                if (choice == 1) {
                    System.out.println("Enter a number:");
                    Scanner userInput2 = new Scanner(System.in);
                    int number = userInput.nextInt();
                    Enqueue(number);
                    System.out.println("Queue: " + numQueue);
                } 
                else if (choice == 2) {
                    if (isEmpty()) {
                    } 
                    else {
                        System.out.println("removing " + Dequeue());
                    }
                }
            } 
            else {
                System.out.println("Type 1 to Enqueue or 2 to Dequeue?");
                Scanner userInput = new Scanner(System.in);
                int choice = userInput.nextInt();
                if (choice == 1) {
                    if (isFull()) {
                    } 
                    else {
                        System.out.println("Enter a number:");
                        Scanner userInput2 = new Scanner(System.in);
                        int number = userInput.nextInt();
                        Enqueue(number);
                        System.out.println("Queue: " + numQueue);
                    }
                } 
                else if (choice == 2) {
                    if (isEmpty()) {
                    } 
                    else {
                        System.out.println("removing " + Dequeue());
                    }
                }
            }
        }
    }
}
