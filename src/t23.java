import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class t23 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists){
        ListNode ans = new ListNode(-1);
        ListNode pa = ans;
        int len = lists.length;
        if(len == 0) return ans.next;
        Comparator<ListNode> myComparator = Comparator.comparingInt((ListNode p) -> p.val);
        //Comparator<ListNode> myComparator = (p1, p2) -> p1.val - p2.val;
        PriorityQueue<ListNode> pq = new PriorityQueue(len, myComparator);
        for(int i = 0; i < len; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        while(pq.size() > 0){
            ListNode p = pq.poll();
            pa.next = p;
            pa = pa.next;
            if(p.next == null){
                continue;
            }else{
                pq.add(p.next);
            }
        }

        return ans.next;
    }

    public static void main(String[] args){
        t23 test = new t23();
        ListNode l1 = new ListNode(1);
        ListNode[] lists = new ListNode[]{l1};
        test.mergeKLists(lists);

    }
}
