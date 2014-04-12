package chapter2;
import utils.Node;

public class Reverse {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(8);
        head.appendToTail(1)
            .appendToTail(2)
            .appendToTail(3)
            .appendToTail(4);
        reverse(head).showList();
    }

    // null
    // a -> null
    // a -> b -> null
    // a -> b -> c -> null
    public static Node<Integer> reverse(Node<Integer> head) { 
        if (head == null) return null;
        Node<Integer> n = head;
        Node<Integer> p = n.next;
        Node<Integer> q;
        while (p != null) { 
            q = p.next;
            p.next = n;
            n = p;
            p = q;
        }
        head.next = null;
        return n;
    }
}
