import java.util.Scanner;

class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    public static int intVal(){return scanner.nextInt();};
}

class Node {
    private int data;
    private Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedList {
    public static void main (String[] args) {
        LinkedListOperation linkedListOperation = new LinkedListOperation();
        int choice = 0;
        System.out.println("****Simple Linked List*****");
        System.out.println("1.Add linked List");
        choice = UserInput.intVal();

        switch (choice) {
            case 1:
                linkedListOperation.insertFirst(UserInput.intVal());
                break;
            default:
                System.out.println("Wrong Choice..!");
                break;
        }
    }
}

class LinkedListOperation {
    private Node head;
    private int counter;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        counter++;
    }
}
