// We create nodes in linked list as objects of a class Node
//Linkedlist class has its own properties
public class LinkedList {
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
        public void PrintLL(){
            Node temp = head;
            while(temp!=null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
            System.out.println();
        }
        
        public void Reversehelper(Node head, Node prev){
            if(head == null){
                return;
            }
            Reversehelper(head.next, head);
            head.next = prev;
            return;    
        }

        public void ReverseLL(){
            Reversehelper(head, null);
            Node temp = head;
            head = tail;
            tail = temp;
        }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.PrintLL();
        ll.addAti(4, 3);
        ll.PrintLL();
        System.out.println(LinkedList.size);
        ll.ReverseLL();
        //Reversing of a linked list can also be done using 3 variables(prev, curr, next) and a loop---O(n)
        ll.PrintLL();
        //Garbage collector deletes any non associated nodes, e.g if we remove a node from a linked list,
        //java removes it from memory automatically
        System.out.println(tail.data);

    }
}
