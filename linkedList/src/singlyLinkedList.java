
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
        //sll.insertFirst(9);
       // sll.insertLast(12);
        sll.add(100);
        sll.display();
//        sll.deleteFirst();
        sll.display();
//        sll.deleteLast();
        sll.display();
        sll.insert(1,4);
        sll.display();
        sll.delete(4);
        sll.display();
    }
}
