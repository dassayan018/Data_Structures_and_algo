package stack_and_queue;
import java.util.Scanner;

public class DeleteKthElement {

    public static void main(String[] args){
        Node head = createLinkedList();

        System.out.println("Before deletion");
        printLinkedList(head);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of K");
        int k = sc.nextInt();

        head = DeleteKthElement(head,k);

        System.out.println("After deletion");
        printLinkedList(head);
    }

    public static Node createLinkedList(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            return null;
        }

        System.out.print("Enter the values of nodes: ");
        Node head = new Node(scanner.nextInt());
        Node curr = head;

        for (int i = 1; i < n; i++) {
            curr.setNext(new Node(scanner.nextInt()));
            curr = curr.getNext();
        }

        return head;


    }

    public static Node DeleteKthElement(Node head, int k){
        if (head == null || k <= 1) {
            return head; // Nothing to delete for empty list or k <= 1
        }

        Node curr = head;
        Node prev = null;
        int count = 1;

        while (curr != null) {
            if (count % k == 0) {
                if (prev == null) {
                    head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
            } else {
                prev = curr;
            }

            curr = curr.getNext();
            count++;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    // Node class definition and methods
    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
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
}
