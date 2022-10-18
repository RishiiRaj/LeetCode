/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode fakeHead = new ListNode(), curr=fakeHead;
        while(head != null){
            int sum = 0;
            while(head.val != 0){
                sum+=head.val;
                head=head.next;
            }
            curr.next = new ListNode(sum);
            curr=curr.next;
            head=head.next;
        }
        return fakeHead.next.next;
    }
}