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
    public ListNode sortList(ListNode head) {

        ArrayList<Integer> list =new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        ListNode dumyHead =new ListNode(0);
        ListNode newHead=dumyHead;
        for(int x: list){
            dumyHead.next= new ListNode(x);
            dumyHead=dumyHead.next;
        }
        return newHead.next;
        



        
    }
}