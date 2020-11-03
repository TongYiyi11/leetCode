package DoublePointers;

public class t61 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public ListNode rotateRight(ListNode head, int k){
        if(k == 0 || head == null || head.next == null) return head;
        ListNode res = null;
        ListNode fast = head, slow = head;
        int c = 1;
        for(int i = 1; i <= k; i++){
            if(fast.next != null){
                fast = fast.next;
                c += 1;
            }else{
                break;
            }
        }
        if(c <= k){
            k %= c;
            if(k == 0) return head;
            fast = head;
            for(int i = 1; i <= k; i++){
                fast = fast.next;
            }
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        res = slow.next;
        slow.next = null;
        fast.next = head;

        return res;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        t61 test = new t61();
        test.rotateRight(head, 2);
    }
}
