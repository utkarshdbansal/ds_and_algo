import java.sql.ClientInfoStatus;
import java.util.EmptyStackException;
import java.util.Stack;

/*
    -- it is a linear data structure used for storing data.
    -- it is an ordered list in which insertion and deletion and are done at one end, called top.
    -- the last element inserted is the first one to be deleted called as "LIFO"
 */
public class stack {
    private ListNode top;
    private int length;

    private class ListNode {
        private int data;// can be a generic type
        private ListNode next;// reference to next ListNode in list

        public ListNode (int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public void pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            top = top.next;
        }
        length--;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }


//    public Stack(){
//        top = null;
//        length = 0;
//    }


    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void traverse(){
        ListNode temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("size: " + length);
    }
    public static String reverseString(String str){
        Stack <Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            stack.push(c);
        }
        for(int i = 0; i<str.length();i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        stack stack = new stack();
//        stack.push(1);
//        stack.push(2);
//        stack.push(4);
//        stack.push(6);
//        stack.traverse();
        String str = "ABCD";
        System.out.println("before reverse-"+ str);
        System.out.println("After reverse-"+reverseString(str));
    }

}
