public class t21 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode merge = new ListNode(0);
        ListNode p1 = l1, p2 = l2, m = merge;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                m.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                m.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            m = m.next;
        }
        if(p1 == null){
            m.next = p2;
        }else{
            m.next = p1;
        }
        return merge.next;
    }

    public static void main(String[] args){
        t21 test = new t21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        test.mergeTwoLists(l1, l2);


    }
}
