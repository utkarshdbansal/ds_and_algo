public class circularLinkedList {
   private ListNode last;
   private int length;

private class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data){
        this.data= data;
    }
}
public circularLinkedList(){
    last = null;
    length = 0;
}
public void createCircularLinkedList(){
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(10);
    ListNode third = new ListNode(13);
    ListNode fourth = new ListNode(15);
}
public void  display(){
    if(last == null){
        return;
    }
    ListNode first = last.next;
    while(first != last){
        System.out.print(first.data+"-->");
        first = first.next;
    }
    System.out.println(first.data);
}
public void insertFirst(int data){
    ListNode temp = new ListNode(data);
    if(last == null){
        last = temp;
    }
    else {
        temp.next = last.next;
    }
    last.next = temp;
    length++;
}
public void insertLast(int data){
    ListNode temp = new ListNode(data);
    if(last == null){
        last = temp;
        last.next = last;
    }
    else {
        temp.next = last.next;
        last.next = temp;
        last = temp;
    }
    length++;
}

    public static void main(String[] args) {
        circularLinkedList cll = new circularLinkedList();
//        cll.createCircularLinkedList();
        cll.insertFirst(12);
        cll.insertFirst(13);
        cll.insertLast(11);
        cll.display();
    }
}
