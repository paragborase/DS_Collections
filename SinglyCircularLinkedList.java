//SinglyCircularLinkedList

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    public Node First;
    public Node Last;

    public LinkedList() {
        First = null;
        Last = null;
    }

    public void insertFirst(int no) {
        Node newn = new Node(no);
        if ((First == null) && (Last == null)) {
            First = Last = newn;
        } else {
            newn.next = First;
            First = newn;            
        }
        Last.next = First;
    }

    public void insertLast(int no) {
        Node newn = new Node(no);
        if ((First == null) && (Last == null)) {
            First = newn;
        } else {
            Last.next = newn;
            Last = newn;
        }
        Last.next = First;
    }

    public void insertAtPos(int no, int iPos) {
        int nodeCount = count();
        if ((iPos < 1) && (iPos > (nodeCount+1))) {
            System.out.println("Invalid Position");
            return;
        }

        if (iPos == 1) {
            insertFirst(no);
        } else if (iPos == nodeCount+1) {
            insertLast(no);
        } else {
            Node newn = new Node(no);
            Node temp = First;
            for(int i = 1; i < (iPos -1); i++) {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
        }
    }

    public void deleteFirst() {
        if ((First == null) && (Last == null)) {
            return;
        } else if (First == Last) {
            First = null;
        } else {
            First = First.next;
            Last.next = First;
        }
    }

    public void deleteLast() {
        if ((First == null) && (Last == null)) {
            return;
        } else if (First == Last) {
            First = null;
        } else {
            Node temp = First;
            while(temp.next != Last) {
                temp = temp.next;
            }
            Last = temp;
            Last.next = First;
        }
    }

    public void deleteAtPos(int iPos) {
        int nodeCount = count();
        if ((iPos < 1) && (iPos > nodeCount)) {
            System.out.println("Invalid Position");
            return;
        }

        if (iPos == 1) {
            deleteFirst();
        } else if (iPos == nodeCount) {
            deleteLast();
        } else {
            Node temp = First;
            for(int i = 1; i < (iPos - 1); i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void display() {
        Node temp = First;
        do {
            System.out.print(" | "+temp.data+" | ");
            temp = temp.next;
        } while(temp != First);
        System.out.println();
    }

    public int count() {
        Node temp = First;
        int iCnt = 0;
        do {
            iCnt++;
            temp = temp.next;
        } while(temp != First);
        return iCnt;
    }
}

public class SinglyCircularLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(11);
        linkedList.insertFirst(21);
        linkedList.insertFirst(31);

        linkedList.insertLast(41);
        linkedList.insertLast(51);
        linkedList.insertLast(61);

        linkedList.insertAtPos(100, 4);

        linkedList.deleteFirst();

        linkedList.deleteLast();

        linkedList.deleteAtPos(3);

        linkedList.display();

        System.out.println("Number of nodes in Linked list are : "+linkedList.count());
    }
}
