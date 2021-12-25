import java.util.Scanner;

class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    public static int intVal(){return scanner.nextInt();};
}
//UC-1
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
        int exit = 10;
        do {
            System.out.println("****Simple Linked List*****");
            System.out.println("1.Add First\n2.Add Last\n3.Nth Position\n4.Remove First\n5.Remove Last" +
                    "\n6.Remove Nth Position\n7.Search Node\n8.Print List\n9.Sort Order\n10.Exit");
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
                    System.out.println("Enter the Position :");
                    linkedListOperation.deleteNthPosition(UserInput.intVal());
                    break;
                case 7:
                    System.out.println("Enter the Search Element :");
                    linkedListOperation.searchElement(UserInput.intVal());
                    break;
                case 8:
                    linkedListOperation.printList();
                    break;
                case 9:
                    linkedListOperation.ascendingOrder();
                    break;
                case 10:
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
    //UC-2
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
    //UC-5
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
    //UC-3
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
    //UC-6
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
    //UC-4,8
    public void insertNthPosition(int data, int pos) {
        Node newNode = new Node(data);
        int countNode = 0;
        Node prev = head;
        if (head == null) {
            head = newNode;
        } else if (pos < 0 || pos > counter) {
            System.out.println("Invalid Position");
        } else if (pos - 1 == 0) {
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
    //UC-9
    public void deleteNthPosition(int pos) {
        int countNode = 0;
        if (head == null) {
            System.out.println("List Empty..!");
        } else if (head.getNext() == null) {
            System.out.println(head.getData()+" Remove..");
            head = null;
            counter--;
        } else if (pos < 0 || pos > counter) {
            System.out.println("Invalid Position..!");
        } else if (pos - 1 == 0) {
            deleteFirst();
        } else {
            Node prev = head;
            Node temp = head;
            while (countNode < pos -1) {
                prev = temp;
                temp = temp.getNext();
                countNode++;
            }
            prev.setNext(temp.getNext());
            temp.setNext(null);
            counter--;
        }
    }
    //UC-7
    public void searchElement(int data) {
        if (head == null) {
            System.out.println("No Element Found..!");
        }
        else {
            Node temp = head;
            while (temp != null) {
                if (temp.getData() == data) {
                    System.out.println("Element Found -> "+data);
                    break;
                }
                else {
                    temp = temp.getNext();
                }
            }
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
    //UC-10
    public void ascendingOrder() {
        if (head == null) {
            System.out.println("List is Empty..!");
        }
        else {
            Node temp = head, nextNode = null;

            while (temp != null) {
                nextNode = temp.getNext();
                while (nextNode != null) {
                    if (temp.getData() > nextNode.getData()) {
                        int temp_Node = temp.getData();
                        temp.setData(nextNode.getData());
                        nextNode.setData(temp_Node);
                    }
                    nextNode = nextNode.getNext();
                }
                temp = temp.getNext();
            }
            printList();
        }
    }
}
