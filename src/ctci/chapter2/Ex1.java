package chapter2;

import java.util.HashSet;

import utils.Node;

// Remove duplicates from an unsorted linked list
public class Ex1 {
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
        int[] values = {2, 1, 1, 2, 3, 4, 3, 1, 1, 1};
        for (int i : values) { 
            head.appendToTail(i);
        }
        head.showList();
        dedupNoBuffer(head);
        System.out.println();
        head.showList();
	}

	public static void dedup(Node<Integer> head) {
        HashSet<Integer> values = new HashSet<>();
        Node<Integer> n = head;
        while(n.next != null) {
            if (values.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                values.add(n.next.data);
                n = n.next;
            }
        }
	}

    public static void dedupNoBuffer(Node<Integer> head) { 
        Node<Integer> p1 = head;
        Node<Integer> p2 = head;

        while (p1 != null) {
            while (p2.next != null) {
                if (p1.data == p2.next.data) { 
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
            p2 = p1;
        }
    }
}
