package StackQueue;


import java.util.Stack;

public class QueueUsingStacks<T> {

    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(T item) {
        enqueueStack.push(item);
    }

    public T dequeue() {
        if (dequeueStack.isEmpty()) {
            // Transfer elements from enqueueStack to dequeueStack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        if (dequeueStack.isEmpty()) {
            return null; // Queue is empty
        }

        return dequeueStack.pop();
    }
    public T peek() {
        if (dequeueStack.isEmpty()) {
            // Transfer elements from enqueueStack to dequeueStack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        if (dequeueStack.isEmpty()) {
            return null; // Queue is empty
        }

        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue size: " + queue.size()); // Output: 3
        System.out.println("Peek: " + queue.peek());     // Output: 10

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 10
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 20

        System.out.println("Queue size after dequeues: " + queue.size()); // Output: 1

        queue.enqueue(40);
        System.out.println("Queue size after enqueue: " + queue.size()); // Output: 2

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 30
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 40

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
        System.out.println("Dequeue from empty queue: " + queue.dequeue()); // Output: null
        System.out.println("Peek from empty queue: " + queue.peek());   // Output: null
    }
}

