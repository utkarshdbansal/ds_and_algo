
public class singlyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode (int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    public int length(){
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println(count);
        return count;
    }
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public ListNode deleteFirst(){
        if(head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public ListNode deleteLast(){
        if(head == null || head.next == null){ return head;}
        ListNode current = head;
        ListNode previous = null;
        while (current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    public void insert(int position, int value){        //******very important
        ListNode node = new ListNode(value);
        if (position == 1){
            node.next = head; head = node;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count<position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }
    public void delete(int position){
        if (position == 1){
            head = head.next;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count<position-1){
                previous = previous.next; count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }
    public ListNode getMiddleNode(){
        if(head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
//    public ListNode getNthNodeFromEnd(int n){
//        if(head == null){
//            return null;
//        }
//        if(n<=0){
//            throw new illegalArguementException("Invalid")
//        }
//    }
    public void removeDuplicates(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while (current!= null && current.next!=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }
    // Q-> How to search an element in a linkedlist?
    // Q-> Reverse a linked list.
    public boolean containsLoop(){
        ListNode fastptr = head;
        ListNode slowptr = head;
        while(fastptr!= null && fastptr.next!=null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){
                return true;
            }
        }
        return false;
    }
    // method to create a loop in list
    public void aLoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }
    public ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = current.next;
        }
        return previous;
    }
//    public boolean searchElement(int data)
    public void add(int e){
        insert(head,e);
    }
    void insert(ListNode n,int e){
        if(n.next == null){
            n.next=new ListNode(e);
        }
        else{
            insert(n.next,e);
        }
    }
    public static void main(String[] args) {
        singlyLinkedList sll = new singlyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);


        sll.head.next = second;
        second.next = third;
        third.next = fourth;
//        //sll.insertFirst(9);
        sll.insertLast(11);
//        sll.add(100);
        sll.display();
//        sll.removeDuplicates();
//        sll.reverse(sll.head);
//        sll.aLoopInLinkedList();
        sll.display();
////        sll.deleteFirst();
//        sll.display();
////        sll.deleteLast();
//        sll.display();
//        sll.insert(1,4);
//        sll.display();
//        sll.delete(4);
//        sll.display();
//        sll.getMiddleNode();
//        ListNode middleNode = sll.getMiddleNode();
//        System.out.println("Middle Node is "+middleNode.data);
    }
}
