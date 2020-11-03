public class t25 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode start;
        ListNode end = dummyHead;
        ListNode temp;
        while(end != null){
            for(int i = 0; i < k && end != null; i++) end = end.next;
            if(end == null) break;
            start = pre.next;
            temp = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }
        return dummyHead.next;

    }
    private ListNode reverse(ListNode start){
        ListNode pre = null;
        ListNode curr = start;
        ListNode temp;
        while(curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
