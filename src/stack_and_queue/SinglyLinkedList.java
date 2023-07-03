package stack_and_queue;

class Node {
    public int nodeData;
    public Node nextNode;
}

//import org.w3c.dom.Node;

public class SinglyLinkedList {

    private Node head;

    public void displayLinkedList() {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.nodeData + " -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("Null");
    }

    public void insertAtFront(int data) {
        Node newNode = new Node();
        newNode.nodeData = data;
        newNode.nextNode = head;
        head = newNode;
    }

    public void insertAtLast(int data) {
        Node currentNode = head;
        while(currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }

        Node newNode = new Node();
        newNode.nodeData = data;
        currentNode.nextNode = newNode;

    }

    public void insertAtPos(int data, int pos){
        Node currentNode = head;
        for(int i=0;i<pos-1;i++){
            currentNode = currentNode.nextNode;
        }
        Node tempNode = currentNode;
        currentNode = currentNode.nextNode;

        Node newNode = new Node();
        newNode.nodeData = data;

        tempNode.nextNode = newNode;
        newNode.nextNode = currentNode;
    }

    public void deleteAtFront(){

        head = head.nextNode;

    }

    public void deleteAtEnd() {
        Node currentNode = new Node();
        if(head.nextNode==null){
            head = null;
        } else {
            while(currentNode.nextNode.nextNode !=null){
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = null;
        }
    }

    public void deleteAtPos(int position){
        if(head ==null){
            return;
        }
        Node temp = head;
        if(position==1){
            head = temp.nextNode;
            return;
        }
        for (int i=1; temp!=null && i<position-1; i++)
            temp = temp.nextNode;

        if (temp==null || temp.nextNode==null){
            System.out.println("Position entered is more than number of elements");
            return;
        }
        Node next = temp.nextNode.nextNode;
        temp.nextNode = next;
    }

    public static void main(String  args[]){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtFront(10);
        linkedList.insertAtFront(9);
        linkedList.displayLinkedList();
        linkedList.deleteAtPos(1);
        linkedList.displayLinkedList();
        linkedList.deleteAtPos(1);
        linkedList.displayLinkedList();
    }


}
