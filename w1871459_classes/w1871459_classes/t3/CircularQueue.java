package com.loshithan;

public class CircularQueue {



        int SIZE = 5; // Size of Circular Queue
        int front, rear;
        Passenger[] items = new Passenger[SIZE];

    CircularQueue() {
            front = -1;
            rear = -1;
        }

    /**
     * checks if the queue is full
     * @return boolean
     */
    boolean isFull() {
            if (front == 0 && rear == SIZE - 1) {
                return true;
            }
            if (front == rear + 1) {
                return true;
            }
            return false;
        }

    /**
     * checks if the queue is empty
     * @return boolean
     */
    boolean isEmpty() {
            if (front == -1)
                return true;
            else
                return false;
        }

    /**
     * insert passenger obj to queue
     * @param passenger
     */
    void enQueue(Passenger passenger) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                if (front == -1)
                    front = 0;
                rear = (rear + 1) % SIZE;
                items[rear] = passenger;
                System.out.println("Inserted " + passenger.getFname());
            }
        }

    /**
     * remove passenger obj from queue
     * @return passenger object
     */
    Object deQueue() {
            Passenger passenger;
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return (-1);
            } else {
                passenger = items[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } /* Q has only one element, so we reset the queue after deleting it. */
                else {
                    front = (front + 1) % SIZE;
                }
                return passenger;
            }
        }

//
}
