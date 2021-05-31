package doublecircularlist;

public class DoubleCircularList {

    class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
    Node head = null;

    public void insert(int data) {
        //this method creates a newnode
        Node newNode = new Node(data);
        //check if the list is empty
        if (head == null) {
            //if list is not empty add the newnode to the end 
            head = newNode;
            newNode.next = newNode.prev = newNode;

        } else {
            //no need to iterate through whole list instead go to the prev of head 
            //you will get to the last element of the list
            Node last = (head).prev;
            newNode.next = head;
            (head).prev = newNode;
            newNode.prev = last;
            last.next = newNode;
        }

    }

    public void printList() {
        System.out.println("Printing in forward direction");
        Node current = head;
        while (current.next != head) {
            System.out.println(current.data + "");
            current = current.next;
        }
        System.out.println(current.data + "");
        System.out.println("");
        System.out.println("**********");
        System.out.println("");
        System.out.println("Printing in Reverse Direction");
        Node last = head.prev;
        while (last.prev != head.prev) {
            System.out.println(last.data + "");
            last = last.prev;
        }
        System.out.println(last.data + "");
        System.out.println("Done printing");
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            System.out.println("List is empty make a new list");
        }
        //if list is not empty go to the last node and add the newnode and make it new tail
        Node newNode = new Node(data);
        Node last = head.prev;
        newNode.next = head;
        head.prev = newNode;
        newNode.prev = last;
        last.next = newNode;

    }

    public void insertInBetween(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is Empty create a new ");
        }
        int counter = 1;
        Node current = head;     // current will point to the head
        Node currPrev = head.prev;     //currPrev will point to the previous of the current
        while (counter != position) {
            //will check for the position and the counter 
            currPrev = current;
            current = current.next;

            counter++;
        }
        //when the current and currPrev will be on exact place they will add the newnode
        //between them
        newNode.next = current;
        current.prev = newNode;
        currPrev.next = newNode;
        newNode.prev = currPrev;

    }

    public static void main(String[] args) {
        DoubleCircularList myList = new DoubleCircularList();
        myList.insert(100);
        myList.insert(200);
        myList.insert(300);
        myList.insert(400);
        myList.insert(500);
        myList.insertAtEnd(900);
        myList.insertInBetween(10000, 3);

        myList.printList();
    }

}
