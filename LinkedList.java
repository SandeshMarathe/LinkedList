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
        int exit = 7;
        do {
            System.out.println("****Simple Linked List*****");
            System.out.println("1.Add First\n2.Add Last\n3.Nth Position\n4.Remove First\n5.Remove Last" +
                    "\n6.Print List\n7.Exit");
            choice = UserInput.intVal();

            switch (choice) {
                case 1:
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertFirst(UserInput.intVal());
                    break;
                case 2:
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertLast(UserInput.intVal());
                    break;
                case 3:
                    System.out.println("Enter the Position :");
                    int pos = UserInput.intVal();
                    System.out.println("Enter the Data :");
                    linkedListOperation.insertNthPosition(UserInput.intVal(), pos);
                    break;
                case 4:
                    linkedListOperation.deleteFirst();
                    break;
                case 5:
                    linkedListOperation.deleteLast();
                    break;
                case 6:
                    linkedListOperation.printList();
                    break;
                case 7:
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

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty..!");
        }
        else if (head.getNext() == null){
            head = null;
        }
        else {
            Node temp = head;
            System.out.println(head.getData()+" Removed");
            head = head.getNext();
            temp.setNext(null);
        }
        counter--;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        counter++;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty..!");
        }
        else if (head.getNext() == null) {
            head = null;
        }
        else {
            Node temp = head;
            Node prev = head;
            while (temp.getNext() != null) {
                prev = temp;
                temp = temp.getNext();
            }
            System.out.println(temp.getData()+" Remove");
            prev.setNext(null);
        }
    }

    public void insertNthPosition(int data, int pos) {
        Node newNode = new Node(data);
        int countNode = 0;
        Node prev = head;
        if (head == null) {
            head = newNode;
        } else if (pos < 0 || pos > counter) {
            System.out.println("Invalid Position");
        } else if (pos-1 == 0) {
            insertFirst(data);
        } else {
            Node temp = head;
            while (countNode < pos - 1) {
                prev= temp;
                temp = temp.getNext();
                countNode++;
            }
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
            counter++;
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
