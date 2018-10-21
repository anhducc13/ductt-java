package week3;
import java.util.*;

public class Program {
    static Program pg = new Program();

    // Thêm vào cuối đệ quy
    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            head = new SinglyLinkedListNode(data);
        } else {
            head.next = insertNodeAtTail(head.next, data);            
        }
        return head;
    }
    
    // Trả về giá trị tại vị trí i kể từ đầu list
    int getNode(SinglyLinkedListNode head, int positionFromHead) {  
        SinglyLinkedListNode p = head;
        int i = 0; 
        while (i < positionFromHead) {
            p = p.next;
            i++;
        }
        return p.data;        
    }
//    
////    Thêm vào cuối lặp
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
    
    
    // Thêm vào đầu
    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        if(llist == null) llist = add;
        else {
            add.next = llist;
            llist = add;
        }
        return llist;
    }
    
    // Thêm vào vị trí i lặp
    SinglyLinkedListNode insertNodeAtPosition1(SinglyLinkedListNode head, int data, int position) {
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
    
    //Thêm vào vị trí i đệ quy 
    SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if(position == 0) {
            SinglyLinkedListNode p = new SinglyLinkedListNode(data);
            p.next = head;
            head = p;
        } else {
            head.next = insertNodeAtPosition(head.next,data,position-1);
        }
        return head;
    }
    
    // Xóa tại vị trí i lặp
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
    
    // Xóa vị trí i đệ quy
    SinglyLinkedListNode deleteNode1(SinglyLinkedListNode head, int position) {
        if(position == 0) {
            head = head.next;
        } else {
            head.next = deleteNode1(head.next,position-1);
        }
        return head;
    }
    
    // đảo ngược list
    SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedList rev = new SinglyLinkedList();
        SinglyLinkedListNode p = head;
        
        while(p != null) {
            rev.head = insertNodeAtHead(rev.head,p.data);
            p = p.next;
        }
        return rev.head;

    }
    
    // in list đệ quy
    void printLinkedList(SinglyLinkedListNode head) {
        if(head == null) return;
        System.out.println(head.data);
        printLinkedList(head.next);
    }
    
    // in ngược list đệ quy
    void reversePrint(SinglyLinkedListNode head) {
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.data);
    }
    
    // so sánh list
    boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null && head2 == null) {
            return true;
        } else if(head1 != null && head2 == null || 
                head1 == null && head2 != null ||
                head1.data != head2.data) {
            return false;
        } else {
            return compareLists(head1.next,head2.next);
        }        

    }
    
    // lấy vị trí i từ cuối
    int getNodeFromTail(SinglyLinkedListNode head, int positionFromTail) {
        int size = 0;
        SinglyLinkedListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        
        int positionFromHead = size - 1 - positionFromTail;
        
        p = head;
        int i = 0; 
        while (i < positionFromHead) {
            p = p.next;
            i++;
        }
        return p.data;
        
    }
    
    // lấy vị trí phần từ nhỏ nhất list
    int posMinInList (SinglyLinkedListNode head) {
        SinglyLinkedListNode p = head;
        int pos = 0, min = p.data, i = 0;
        while(p != null) {
            if(p.data < min) {
                pos = i;
                min = p.data;
            }
            p = p.next;
            i++;
        }
        return pos;
    }
    
    // sắp xếp 2 list merge
    SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        
        // Add element in new list
        SinglyLinkedListNode head = null;
        
        if(head1 == null && head2 == null) {
            return null;
        }
        
        else {
            SinglyLinkedListNode p1 = head1;
            int sizeAll = 0;

            while(p1 != null) {
                head = insertNodeAtTail(head,p1.data);
                p1 = p1.next;
                sizeAll++;
            }   

            SinglyLinkedListNode p2 = head2;
            while(p2 != null) {
                head = insertNodeAtTail(head,p2.data);
                p2 = p2.next;
                sizeAll++;
            }


            // sort the new list
            int [] arr = new int[sizeAll];
            for(int i = 0; i < sizeAll; i++) {
                arr[i] = head.data;
                head = head.next;
            }        
            Arrays.sort(arr);

            // head is equal null
            for(int i = 0; i < sizeAll; i++) {
                head = insertNodeAtTail(head, arr[i]);
            }

            return head;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList llist1 = new SinglyLinkedList();
        SinglyLinkedList llist2 = new SinglyLinkedList();

        for (int i = 0; i < 5; i++) {
            
            int llistItem = scanner.nextInt();
            SinglyLinkedListNode llist_head = pg.insertNodeAtTail(llist1.head, llistItem);
            llist1.head = llist_head;
          
        }
        
        for (int i = 0; i < 4; i++) {
            
            int llistItem = scanner.nextInt();
            SinglyLinkedListNode llist_head = pg.insertNodeAtTail(llist2.head, llistItem);
            llist2.head = llist_head;
          
        }
        
        SinglyLinkedListNode head = pg.mergeLists(llist1.head,llist2.head);       
        pg.printLinkedList(head);

        scanner.close();
    }
    
}
