package utils;

public class Node<T> {
	public Node<T> next = null;
	public T data;
	public Node(T data) {
		this.data = data;
	}
	public Node<T> appendToTail(T data) {
		Node<T> n = this;
		while (n.next != null) n = n.next;
		n.next = new Node<T>(data);
		return n.next;
	}
	@Override
	public String toString() {
		return this.data.toString();
	}
}
