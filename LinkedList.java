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
        int exit = 4;
        do {
            System.out.println("****Simple Linked List*****");
            System.out.println("1.Add linked List\n2.Print List\n3.Nth Position\n4.Exit");
            choice = UserInput.intVal();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertFirst(UserInput.intVal());
                    break;
                case 2:
                    linkedListOperation.printList();
                    break;
                case 3:
                    System.out.println("Enter the Position :");
                    int pos = UserInput.intVal();
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertNthPosition(UserInput.intVal(), pos);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong Choice..!");
                    break;
            }
        } while (choice != exit);
    }
}

class LinkedListOperation {
    private Node head;
    private int counter=0;

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

    public void insertNthPosition(int data, int pos) {
        Node newNode = new Node(data);
        int coutNode;
        if (head == null) {
            head = newNode;
        }
        else if (pos <= 0) {
            System.out.println("Invalid Position..!");
        }
        else {
            Node temp = head;
            for (coutNode = 1; coutNode <= pos; coutNode++) {
                newNode.setNext(temp.getNext());
            }
            temp.setNext(newNode);
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            System.out.println("Linked List: ");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + " -> ");
                temp = temp.getNext();
            }
        }
    }
}
