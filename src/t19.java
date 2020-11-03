public class t19 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode p1 = head;
        for(int i = 0; i < n; i++){
            if(p1 == null) return head;
            p1 = p1.next;
        }
        if(p1 == null) return head.next;
        ListNode p2 = head, prev = head;
        while(p1 != null){
            p1 = p1.next;
            prev = p2;
            p2 = p2.next;
        }
        prev.next = p2.next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        t19 test = new t19();
        test.removeNthFromEnd(head, 1);

    }
}
