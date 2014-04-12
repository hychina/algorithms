package chapter2;

import utils.Node;

// Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
// so as to make a loop in the linked list
// EXAMPLE
// input: A -> B -> C -> D -> E -> C [the same C as earlier]
// output: C

public class Ex5 {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(0);
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = head;
        Node<Integer> n = findLoopBeginning(head);
        System.out.println(n);
    }

    public static Node<Integer> findLoopBeginning(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> n1 = head;
        Node<Integer> n2 = head;

        // 书上有bug
        while (n2 != null && n2.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
            if (n1 == n2) break;
        }
        if (n2 == null || n2.next == null) {
            return null;
        }
        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
