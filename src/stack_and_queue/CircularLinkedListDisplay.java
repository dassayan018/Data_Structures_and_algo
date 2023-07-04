package stack_and_queue;
import java.util.Scanner;

class Node1 {
    int key;
    Node1 nextNode;

    Node1(int key){
        this.key=key;
        nextNode = null;
    }
}

class CircularLinkedList {
    Node1 listHead;
    Node1 listTail;

    void insert(int key){
        Node1 temp = new Node1(key);
        if (listHead==null)
            listHead=temp;
        if (listTail==null)
            listTail=temp;
        else {
            listTail.nextNode = temp;
            listTail=temp;
        }
        listTail.nextNode = listHead;
    }

    void display(){
        if (listHead==null)
            return;
        Node1 temp = listHead;
        System.out.println(temp.key+" ");
        temp=temp.nextNode;

        while (temp!=listHead){
            System.out.println(temp.key+" ");
            temp = temp.nextNode;
        }
    }
}

public class CircularLinkedListDisplay{
    public static void main (String args[]){
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int noOfNodes = sc.nextInt();
        System.out.println("Enter "+noOfNodes+" nodes");
        for (int i=0;i<noOfNodes;i++){
            list.insert(sc.nextInt());
        }
        System.out.println("<-------------Circular Linked List -------------->");
        list.display();
    }
}
