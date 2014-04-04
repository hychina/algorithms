package chapter2;

import utils.Node;

// Implement an algorithm to find the nth to last element of a singly linked list
public class Ex2 {
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.appendToTail(2)
			.appendToTail(3)
			.appendToTail(4)
			.appendToTail(5)
			.appendToTail(6)
			.appendToTail(7)
			.appendToTail(8) ;
		System.out.println(findNthToLast(head, 8));
	}
	public static Node<Integer> findNthToLast(Node<Integer> head, int nth) {
		int len = 0;
		Node<Integer> n = head;
		while (n != null) {
			n = n.next;
			len++;
		}
		n = head;
		len = len - nth;
		while (len-- > 0) {
			n = n.next;
		}
		return n;
	}
	public static Node<Integer> findNthToLastRecursive(Node<Integer> node, int nth) {
		return null;
	}
	private static int distanceToNth(Node<Integer> node, int nth) {
		if (node == null) return nth; 
		int d = distanceToNth(node.next, nth);
		d--;
		if (d == 0) 
	}
}
