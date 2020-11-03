public class t24 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head){
        if(head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        ListNode p1, p2;
        while(curr.next != null && curr.next.next != null){
            p1 = curr.next;
            p2 = p1.next;
            p1.next = p2.next;
            curr.next = p2;  //notice! after renewing p1.next, p2 will not be changed!
            p2.next = p1;

            curr = curr.next.next;
        }

//        ListNode p1 = dummyHead;
//        ListNode p2 = p1.next;
//        ListNode curr = p1;
//        while(p2.next != null){
//            p1.next.next = p2.next.next;
//            p2.next.next = p1.next;  //notice! p2.next.next will change!
//            curr.next = p2;
//
//            p1 = p1.next;
//            p2 = p2.next;
//            curr = p1;
//        }

        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        t24 test = new t24();
        test.swapPairs(head);
    }
}
