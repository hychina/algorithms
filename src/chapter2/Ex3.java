// Implement an algorithm to delete a node in the middle of a single linked list,
// given only access to that node
// EXAMPLE
// Input: the node 'c' from the linked list a->b->c->d->e
// Result: nothing is returned, but the new linked list looks like a->b->d->e

package chapter2;
import utils.Node;

public class Ex3 {
    public static void main(String[] args) {
        int[] values = {2, 3, 4, 5};
        Node<Integer> head = new Node<Integer>(1);
        for (int v : values) {
            head.appendToTail(v);
        }
        Node<Integer> node = head.next.next;
        deleteNode(node);
        head.showList();
    }

    public static void deleteNode(Node<Integer> node) {
        while (node.next != null) {
            node.data = node.next.data;
            if (node.next.next == null) {
                node.next = null;
            } else{
                node = node.next;
            }
        }
    }
}
