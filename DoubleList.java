package com.company;
import java.util.Random;
// DoubleList.java

class DoubleList<Type> {
    // a Node of the list
    private class Node {
        public Type data;
        public Node next;
        public Node prev;
    }

    // we keep references to the first and last nodes
    private Node head;
    private Node tail;

    // the list starts empty
    public DoubleList() {
        head = null;
        tail = null;
    }

    // add an item to the start of the list
    public void addStart(Type item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        newNode.prev = null;
        if (tail == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    // add an item to the end of the list
    public void addEnd(Type item) {
        Node newNode = new Node();//makes a node
        newNode.data = item;//makes the thing a thing
        newNode.prev = tail;//makes the last an end
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }//end of addend

    // loop through the list forwards
    void print() {//method to print
        Node current = head;//makes the starter
        while (current != null) {//keeps going till end
            System.out.println(current.data);//prints it out
            current = current.next;//makes next
        }
    }//end of print

    // loop through the list backwards
    void printBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // remove an item based on the value
    public void remove(Type item) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(item)) {
                // remove current from list
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }

            current = current.next;
        }
    }
    public int total(){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void reverse(){
        Node begin = head;//makes the starter

        while(begin != null){//makes a while that

            Type song = begin.data;

            remove(begin.data);

            addStart(song);

            begin = begin.next;
        }//end of while
    }//end of reverse


    public Type gets(int index){
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public void shuffle(int total) {
        int time  = 0;

        Node start  = head;
        Random rand = new Random();

        while(time != total){
            int x = rand.nextInt(total-1);
            for (int i = 0; i < x; i++) {
                start = start.next;
            }//end of for

            Type song = start.data;//saves into an object

            remove(start.data);//removes the data
            addStart(song);//add it to the start

            time++;//adds the time

            start = head;//restarts it
        }//end of while
    }//end of shuffle

}//end of class




