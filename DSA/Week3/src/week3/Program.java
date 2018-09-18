package week3;
import java.util.*;

public class Program {
    static Program pg = new Program();

    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            head = new SinglyLinkedListNode(data);
        }
        else {
            head.next = insertNodeAtTail(head.next, data);            
        }
        return head;
    }
//    
//    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
//        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
//        if(head == null) head = add;
//        else {
//            SinglyLinkedListNode p = head;
//            while(p.next != null) {
//                p = p.next;
//            }
//            p.next = add;      
//        }
//        return head;        
//    }
    
    
    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        if(llist == null) llist = add;
        else {
            add.next = llist;
            llist = add;
        }
        return llist;
    }
    
    SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        if(position == 0) {
            add.next = head;
            head = add;
        }
        else {
            SinglyLinkedListNode p = head;
            int i = 0; 
            while (i < position-1) {
                p = p.next;
                i++;
            }
            add.next = p.next;
            p.next = add;
        }
        return head;
    }
    
    SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position == 0) {
            head = head.next;
        }
        else {
            SinglyLinkedListNode p = head;
            int i = 0; 
            while (i < position-1) {
                p = p.next;
                i++;
            }
            SinglyLinkedListNode del = p.next;
            p.next = del.next;
        }
        return head;
    }
    
    SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedList rev = new SinglyLinkedList();
        SinglyLinkedListNode p = head;
        
        while(p != null) {
            rev.head = insertNodeAtHead(rev.head,p.data);
            p = p.next;
        }
        return rev.head;

    }
    
    void printLinkedList(SinglyLinkedListNode head) {
        if(head == null) return;
        System.out.println(head.data);
        printLinkedList(head.next);
    }
    
    void reversePrint(SinglyLinkedListNode head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }
    
    boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null && head2 == null) return true;
        else if(head1 != null && head2 == null || 
                head1 == null && head2 != null ||
                head1.data != head2.data) return false;
        else {
            return compareLists(head1.next,head2.next);
        }        

    }
    
    static int i;
    int getNode(SinglyLinkedListNode head, int positionFromTail) {
        if(head == null) {
            i = 0;
        }
        if(i == positionFromTail) return head.data;
        if(head != null) {
            
        }
        
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList llist1 = new SinglyLinkedList();
        SinglyLinkedList llist2 = new SinglyLinkedList();
        //int llistCount = scanner.nextInt();

        for (int i = 0; i < 9; i++) {
            
            int llistItem = scanner.nextInt();
            SinglyLinkedListNode llist_head = pg.insertNodeAtTail(llist1.head, llistItem);
            llist1.head = llist_head;
          
        }
        
        for (int i = 0; i < 1; i++) {
            
            int llistItem = scanner.nextInt();
            SinglyLinkedListNode llist_head = pg.insertNodeAtTail(llist2.head, llistItem);
            llist2.head = llist_head;
          
        }
        
        llist1.head = pg.mergeLists(llist1.head, llist2.head);
        pg.printLinkedList(llist1.head);
        
        scanner.close();
    }
    
}
