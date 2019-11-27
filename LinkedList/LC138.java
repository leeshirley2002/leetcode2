public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            if (map.containsKey(cur) == false) {
                map.put(cur, new Node(cur.val, null, null));
            }
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.random = map.get(cur.random);
            node.next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }
}


class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};