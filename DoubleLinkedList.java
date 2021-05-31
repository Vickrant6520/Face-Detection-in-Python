package doublelinkedlist;

//import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VIKRANT
 */
public class DoubleLinkedList {

    class Node {

        String movie;
        Node next;
        Node prev;

        Node(String movie) {
            this.movie = movie;

        }
    }
    Node head, tail = null;

    public void insert(String movie) {
        //create a newnode 
        Node newNode = new Node(movie);
        //check if list is empty if empty then point the head and tail to the newnode
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } //if list is not empty then add the newnode next to the tail
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
            /*tail  should always point to null*/
        }
    }

    public void display() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("List is EMpty");
        }
        while (currentNode != null) {
            System.out.println(currentNode.movie + " ");
            currentNode = currentNode.next;
        }
    }

    public void reverseDisplay() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.movie + " ");
            currentNode = currentNode.prev;
        }

    }

    public static void main(String[] args) {
        DoubleLinkedList newList = new DoubleLinkedList();
        newList.insert("3 Idiots");
        newList.insert("The Bucketlist");
        newList.insert("8 Mile");
        newList.insert("Jab We Met");
        newList.insert("Radhe");
        newList.insert("Ye Jawani He Diwani");
        newList.display();
        System.out.println("");
        System.out.println("****Reverse display ****");
        newList.reverseDisplay();
    }
}
