/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelinkedlist;

import java.util.Scanner;

public class SingleLinkedList {

    Node head;

    static class Node {

        int roll_no;
        String name;
        Node next;

        Node(int roll_no, String name) {
            this.roll_no = roll_no;
            this.name = name;
            next = null;
        }
    }

    public static SingleLinkedList insert(SingleLinkedList list, int roll_no, String name) {
        Node new_node = new Node(roll_no, name);
        new_node.next = null;
        if (isListEmpty(list)) {
            list.head = new_node;
            //  System.out.println("hi");
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;

        }
        return list;

    }

    public static SingleLinkedList insertByPosition(SingleLinkedList list, int roll_no,
            String name, int pos) {
        Node newNode = new Node(roll_no, name);
        newNode.next = null;
        if (isListEmpty(list)) {  //check if list is empty
            System.out.println("The List is empty");
        }
        Node start = list.head; //if not then to traverse make start point to head of list//
        int counter = 1;
        if (counter == pos) {
            newNode.next = start;
            list.head = newNode;
            return list;
        }
        while (start != null) //traverse till end
        {
            if (counter == (pos - 1)) {
                // if counter is equal to the position to be inserted                              
                newNode.next = start.next; // then point the newnode's next to the start's next
                start.next = newNode;      //  and the start's next to the new node*/
                break;
            } else {
                start = start.next;
                counter++;
            }

        }
        if (start == null) {
            System.out.println("Position is out of the list");
        }
        return list;

    }

    public static void printList(SingleLinkedList list) {
        if (isListEmpty(list)) {
            System.out.println("The List is Empty");
        } else {
            Node currNode = list.head;
            System.out.println("\t*****SingleLinkedList*****\n");
            while (currNode != null) {
                System.out.print(currNode.roll_no + ". " + currNode.name + "\n");
                currNode = currNode.next;
            }
        }

    }

    public static SingleLinkedList deleteByKey(SingleLinkedList list, int key) {
        /* case 1 key was present at the head */
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.roll_no == key) {
            list.head = currNode.next;
            System.out.println(key + "key found and deleted");

            return list;
        }

        /* case 2 key was present other than head */
        while (currNode != null && currNode.roll_no != key) {
            prev = currNode;
            currNode = currNode.next;

        }
        /*the reason behind getting out of the above while will be that either
        currNode is not null but key is found or key is not found and currNode is null
        ie. end of list*/
        if (currNode != null) {
            /*key found*/
            prev.next = currNode.next;
            System.out.println("key found and deleted");
        }

        if (currNode == null) {
            /*out of list */
            System.out.println("key not found");
        }
        return list;
    }

    public static SingleLinkedList deleteByPosition(SingleLinkedList list, int position) {
        Node currNode = list.head, prev = null;

        int counter = 1;
        /*Case 1 first node is the position to be deleted */
        if (position == 1 && currNode != null) {
            list.head = currNode.next;
            System.out.println("/n node at the first position  is deleted");
            return list;
        }
        //case 2 traverse the list to the given position element and delete the element

        while (currNode != null) {    //traversing to the end node
            if (counter == position) {     // check if the counter is equal to the pos
                prev.next = currNode.next;
                System.out.println("\nelement at " + position + " position element is deleted");
                break;

            } else {
                //if current node is not the pos then continue to the node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }

        }
        //case 3 if the entered position element is out of the size of the list 
        if (currNode == null) {
            System.out.println("\n\n The entered position is out of the list");

        }
        return list;
    }

    public static SingleLinkedList reverseList(SingleLinkedList list) {
        if (isListEmpty(list)) {
            System.out.println("the List is Empty");
        } else {
            Node head = list.head;
            Node start = head;
            Node currNode = start.next;
            start.next = null;
            Node nextNode;
            while (currNode != null) {
                nextNode = currNode.next;
                currNode.next = start;
                start = currNode;
                currNode = nextNode;

            }
            head = start;

        }
        return list;
    }

    public static boolean isListEmpty(SingleLinkedList list) {
        return (list.head == null);
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("*****Linked List*****");
            System.out.println("1. Insert records in LinkedList");
            System.out.println("2. Insert record by position");
            System.out.println("3. Print the list");
            System.out.println("4. Delete the record by roll_no");
            System.out.println("5. Delete the record by position");
            System.out.println("6. Reverse the List");
            System.out.println("7. Exit out of the program");
            System.out.println("Enter your Choice (1/2/3/4/5)");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How many records to insert?");
                    int size = scan.nextInt();
                    for (int i = 1; i <= size; i++) {
                        System.out.println("Enter the record number" + i);
                        System.out.println(" roll_no:");
                        int roll_no = scan.nextInt();
                        System.out.println("Name: ");
                        String name = scan.next();
                        list = SingleLinkedList.insert(list, roll_no, name);
                        System.out.println("");
                    }
                    System.out.println("Press Enter to continue");
                    scan.nextLine();
                    break;
                case 2:
                    System.out.println("Enter the position where you want to insert");
                    int pos = scan.nextInt();
                    System.out.println("Roll_no: ");
                    int roll_no = scan.nextInt();
                    System.out.println("Name: ");
                    String name = scan.next();
                    list = SingleLinkedList.insertByPosition(list, roll_no, name, pos);
                case 3:
                    printList(list);
                    break;
                case 4:
                    System.out.println("Enter the roll_no which you want to delete");
                    int key = scan.nextInt();
                    list = SingleLinkedList.deleteByKey(list, key);
                    System.out.println("");
                    System.out.println("Record is deleted");
                    break;
                case 5:
                    System.out.println("Enter the position whose record you want to delete");
                    int position = scan.nextInt();
                    list = SingleLinkedList.deleteByPosition(list, position);
                    System.out.println("Record on given position is deleted");
                    break;
                case 6:
                    list = SingleLinkedList.reverseList(list);
                    System.out.println("List is Reversed");
                    Node currNode1 = list.head;
                    while(currNode1 != null ){
                        System.out.println("roll_no : "+ currNode1.roll_no + "name: "+ currNode1.name);
                    }
                    break;
                case 7:
                    return;

            }
        }

    }

}
