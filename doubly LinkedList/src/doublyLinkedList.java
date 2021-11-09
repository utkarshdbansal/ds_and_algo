/*
--two way linked list
--given a node we can navigate the list in both the forward and backward direction
--a node in the sll can only be deleted if we have a pointer to its previous node
--a node in the dll can be deleted if we don't have a pointer to its previous
 */
public class doublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }
    public doublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty() {
            return length == 0;
    }
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }
        else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    public void insertEnd(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }
    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while (temp!=null){
            System.out.println(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();
        dll.insertFirst(1);
        dll.display();
        dll.insertFirst(22);
        dll.display();
        dll.insertEnd(2);
        dll.display();

    }
}

