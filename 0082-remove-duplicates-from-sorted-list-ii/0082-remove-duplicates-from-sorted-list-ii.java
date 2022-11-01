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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        // fast pointer is at head, and slow pointer is pointing to fast
        // slow is one step behind fast
        while(fast!=null){
            while(fast.next!=null && fast.val == fast.next.val){
                fast = fast.next; // finding last dupicate element
            }
            if(slow.next != fast){ // if dupicate found
                slow.next = fast.next; // unink all the repeated elements
                fast = slow.next; // and reposition the  fast pointer, VVIMP
            }else{
                // else move both  pointers one one step
                slow = slow.next;
                fast = fast.next;
            }
        }
        // always return dummy.next instead of head
        return dummy.next;
    }
}