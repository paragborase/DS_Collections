//DoublyLinearLinkedList

class Node {
    int data;
    Node prev;
    Node next;
    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class LinkedList {
    public Node First;

    public LinkedList() {
        First = null;
    }

    public void insertFirst(int no) {
        Node newn = new Node(no);
        if(First == null) {
            First = newn;
        } else {
            newn.next = First;
            First.prev = newn;
            First = newn;
        }
    }

    public void insertLast(int no) {
        Node newn = new Node(no);
        if(First == null) {
            First = newn;
        } else {
            Node temp = First;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newn;
            newn.prev = temp;
        }
    }

    public void insertAtPos(int no, int iPos) {
        int nodeCount = count();
        if((iPos < 1) && (iPos > nodeCount+1)){
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1){
            insertFirst(no);
        } else if(iPos == nodeCount+1) {
            insertLast(no);
        } else {
            Node newn = new Node(no);
            Node temp = First;
            for(int i = 1; i < (iPos - 1); i++) {
                temp = temp.next;
            }
            newn.next = temp.next.next;
            newn.prev = temp.next;
            temp.next.next = newn;
        }
    }

    public void deleteFirst() {
        if(First == null) {
            return;
        } else if (First.next == null) {
            First = null;
        } else  {
            First = First.next;
            First.prev = null;
        }
    }

    public void deleteLast() {
        if(First == null) {
            return;
        } else if (First.next == null) {
            First = null;
        } else {
            Node temp = First;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void deleteAtPos(int iPos) {
        int nodeCount = count();
        if((iPos < 1) && (iPos > nodeCount)){
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1) {
            deleteFirst();
        } else if(iPos == nodeCount) {
            deleteLast();
        } else {
            Node temp = First;
            Node temp1 = null;
            for(int i = 1; i < (iPos-1); i++) {
                temp = temp.next;
            }
            temp1 = temp.next.next;
            temp.next = temp1;
            temp.next.prev = temp;
        }
    }

    public void display() {
        Node temp = First;
        System.out.print("NULL --><--");
        while(temp != null) {
            System.out.print(" | "+temp.data+" | --><-- ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public int count() {
        Node temp = First;
        int iCnt = 0;
        while(temp != null) {
            iCnt++;
            temp = temp.next;
        }
        return iCnt;
    }
}
public class DoublyLinearLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(11);
        linkedList.insertFirst(21);
        linkedList.insertFirst(31);

        linkedList.insertLast(41);
        linkedList.insertLast(51);
        linkedList.insertLast(61);

        linkedList.insertAtPos(100, 3);

        linkedList.deleteFirst();

        linkedList.deleteLast();

        linkedList.deleteAtPos(3);

        linkedList.display();

        System.out.println("Number of Nodes in Linked List are : "+linkedList.count());

    }
}
