import java.util.NoSuchElementException;

public class MyLinkedList {
        public class Node {
            public int value;
            public Node next;

            public Node(int value) {
                this.value = value;
                this.next=null;
            }
        }
        public Node first;
        public Node last;
        public int size;
        //Constructors-----------------
        public MyLinkedList() {
            this.first=null;
            this.last=null;
            this.size=0;
        }
        //Methods--------------------
        public boolean isEmpty() {
            return first == null;
        }
        public void addLast(int item) {
            Node node = new Node(item);
            //System.out.println("adding item: "+item);
            if (isEmpty())
                first = last = node;
            else {
                last.next=node;
                last = node;
            }
            size++;
        }
    public void insertInOrder(int item) {
        Node node = new Node(item);
        Node current;
        if (isEmpty())
            first = last = node;
        else if (item<=first.value){
            node.next=first;
            first=node;
        }
        else {
            current=first;
            while((current.next!=null)&&(node.value>current.next.value)) current=current.next;
            if (current.next==null) {// insertion after last
                current.next=node;
                last=node;
            } else {
                node.next=current.next;
                current.next=node;
            }
        }
        size++;
    }
        public void deleteLast(){
            if (isEmpty()) throw new NoSuchElementException();
            System.out.println("Deleting last :"+ last.value);
            if (first==last) first=last=null;
            else {   // more than one node
                Node previous = first;
                Node current= first;
                while (current.next !=null){
                    previous=current;
                    current=current.next;
                }
                previous.next=null;
                last=previous;
            }
        }

        public void printLinkedList() {
            if (isEmpty())
                throw new IllegalStateException();
            Node current = first;
            while (current!= null) {
                System.out.println("Value :  "+current.value);
                current=current.next;
            }
        }
        // This method reverses the nodes of the link list in one pass
        public void reverse() {
            if (isEmpty()) return;
            Node previous = first;
            Node current = first.next;
            while (current != null) {
                Node nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            last = first;
            last.next = null;
            first = previous;
        }
    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();
        Node a = first;
        Node b = first;
        for (int i = 0; i < k-1 ; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();
        Node a = first;
        Node b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

}
