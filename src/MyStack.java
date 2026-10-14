/*
    Name: Christina Kim Tran
    PID:  200349533 / A18864701
 */

import java.util.EmptyStackException;
import utilities.FullStackException;

/**
 * MyStack Implementation
 * @author Christina Kim Tran
 * @since 10/6/26
 */
public class MyStack {
    private String[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    /*
     * Initializes a stack using a given initial capacity.
     * @param capacity integer representing the max amount in the stack possible
     * @throws IllegalArgumentException when the capacity is less than 1
     * */
    public MyStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.data = new String[capacity];
        this.size = 0;
    }

    /*
     * Initializes a stack with its default capacity being 10
     * */
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    /*
     * Checks if the stack is empty.
     * @return true means the stack is empty, false if not
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Completely clears out the stack.
     * */
    public void clear() {
        size = 0;
    }

    /*
     * Checks the size of the stack
     * @return integer representing number of stack's elements
     * */
    public int size() {
        return size;
    }

    /*
     * Returns the max amount of elements a stack can store.
     * @return int representing the length of the backing array
     * */
    public int capacity() {
        return data.length;
    }

    /*
     * Checks the top element of the stack.
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     * */
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    /*
     * Pushes the inputted element onto the stack.
     * @param element The inputted String to push
     * @throws FullStackException when the stack is full
     * @throws IllegalArgumentException when element is null
     * */
    public void push(String element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size == data.length) {
            throw new FullStackException("Your stack is full.");
        }
        data[size] = element;
        size++;
    }

    /*
     * Returns and then removes the stack's top element.
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     * */
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        String top = data[size];
        data[size] = null;
        return top;
    }

    /*
     * Pushes all strings of the elements array to the stack.
     * Push order is from lowest to highest index.
     * @param elements String array to push
     * @throws IllegalArgumentException if elements array is null
     * @throws FullStackException when the stack is at full capacity
     * */
    public void multiPush(String[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException();
        }
        for (String element : elements) {
            if (size == data.length) {
                throw new FullStackException("Your stack is full.");
            }
            push(element);
        }
    }

    /*
     * Pops the inputted amount of elements from the stack.
     * If the stack has less than this amount, all elements are popped.
     * @return A String array containing all popped elements
     * @param amount Integer representing number of elements to pop
     * @throws IllegalArgumentException if amount is not positive
     * */
    public String[] multiPop(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException();
        }
        int counter = Math.min(amount, size);
        String[] popped = new String[counter];
        for (int i = 0; i < counter; i++) {
            popped[i] = pop();
        }
        return popped;
    }
}