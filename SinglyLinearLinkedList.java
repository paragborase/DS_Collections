//SinglyLinearLinkedList

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

    public LinkedList() {
        First = null;
    }

    public void insertFirst(int no) {
        Node newn = new Node(no);
        if (First == null) {
            First = newn;
        } else {
            newn.next = First;
            First = newn;
        }
    }

    public void insertLast(int no) {
        Node newn = new Node(no);
        Node temp = First;
        if (First == null) {
            First = newn;
        } else {
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newn;
        }
    }

    public void insertAtPos(int no , int iPos) {
        int nodeCount = count();
        if ((iPos < 1) && (iPos > nodeCount+1)) {
            System.out.println("Invalid Position");
            return;
        }

        if (iPos == 1) {
            insertFirst(no);
        } else if (iPos == nodeCount+1) {
            insertLast(no);
        } else {
            Node temp = First;
            Node newn = new Node(no);
            for(int i = 1; i < iPos - 1; i++) {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
        }
    }

    public void deleteFirst() {
        if (First == null) {
            return;
        } else if (First.next == null) {
            First = null;
        } else {
            First = First.next;
        }
    }

    public void deleteLast() {
        Node temp = First;
        if (First == null) {
            return;
        } else if (temp.next == null) {
            First = null;
        } else {
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
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
            for(int i = 1; i < (iPos -1); i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void display() {
        Node temp = First;
        while (temp != null) {
            System.out.print(" | "+temp.data+" | -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public int count() {
        int iCnt = 0;
        Node temp = First;
        while (temp != null) {
            iCnt++;
            temp = temp.next;
        }
        return iCnt;
    }
}
public class SinglyLinearLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);

        linkedList.insertLast(40);
        linkedList.insertLast(50);
        linkedList.insertLast(60);

        linkedList.insertAtPos(100, 4);

        linkedList.deleteFirst();

        linkedList.deleteLast();

        linkedList.deleteAtPos(3);

        linkedList.display();

        System.out.println("Number of Nodes in LinkedList are : "+linkedList.count());
    }   
}
