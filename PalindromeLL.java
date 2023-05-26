import java.util.*;
//Slow fast pointer concept
//For solving the problem in O(n) time and O(1) space complexity
//We will divide the linked list in two halves and reverse one half
public class PalindromeLL {
    public static class Node{
        int data;
        Node next;
         
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        }
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
           head = newNode;
           tail = newNode;
           return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    public void addAti(int data, int i){
        if(i==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        while(i>1){
            temp = temp.next;
            i--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        return;
    }


    public Node FindMid(){
        Node fast = head;
        Node slow = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next==null){
                break;
            }
            fast = fast.next.next;
        }
        return slow;
    }  
    public Boolean isPalindrome(){
        Node mid = FindMid();
        Node curr = mid.next;
        Node prev = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = prev.next;
            curr = next;
        }
        Node temp1 = tail;
        Node temp2 = head;
        while(temp1!=mid){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if(temp1.data != temp2.data){
            return false;
        }
        return true;
    }
    
    public void PrintLL(){
        Node temp = head;
        while(temp!=null){
        System.out.print(temp.data+ " ");
        temp = temp.next;
    }
        System.out.println();
    }
    public static void main(String[] args) {
        PalindromeLL ll = new PalindromeLL();
        ll.addLast(12);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(13);
        ll.addLast(1);
        ll.addLast(13);
        ll.addLast(12);
        ll.PrintLL();
        System.out.println(ll.isPalindrome());
    }
}
