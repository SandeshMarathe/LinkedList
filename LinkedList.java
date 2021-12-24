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
        do {
            System.out.println("****Simple Linked List*****");
            System.out.println("1.Add linked List\n2.Print List");
            choice = UserInput.intVal();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertFirst(UserInput.intVal());
                    break;
                case 2:
                    linkedListOperation.printList();
                case 3:
                    break;
                default:
                    System.out.println("Wrong Choice..!");
                    break;
            }
        } while (choice != 3);
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

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            System.out.println("Linked List: ");
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.getData() + " -> ");
                temp = temp.getNext();
            }
        }
    }
}
