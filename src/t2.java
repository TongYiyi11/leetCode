public class t2 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode sum = new ListNode(0);
        ListNode s = sum;
        int r;
        int d = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null || p2 != null){
            if(p1 == null){
                r = (p2.val + d) % 10;
                d = (p2.val + d) / 10;
            }else if(p2 == null){
                r = (p1.val + d) % 10;
                d = (p1.val + d) / 10;

            }else{
                r = (p1.val + p2.val) % 10 + d;
                d = (p1.val + p2.val) / 10;
            }

            s.next = new ListNode(r);


            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
            s = s.next;
        }

        if(d > 0){
            s.next = new ListNode(d);
        }
        return sum.next;
    }
}
