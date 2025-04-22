package ImportantInterviewQuestion.LinkedList;

//Reverse Singly LinkedList recursively
public class RevSLinkedListRec {

    public static Node reverseNode(Node head){
        if(head == null|| head.next == null){
            return head;
        }
        Node newHead = reverseNode(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void printNodeList(Node head){
        while(head != null){
            System.out.print(head.data+" --> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next= new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List : ");
        printNodeList(head);
        head = reverseNode(head);
        System.out.println("Reversed List : ");
        printNodeList(head);
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
