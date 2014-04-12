// You have two numbers represented by a linked list,
// where each node contains a single digit.
// The digits are stored in reverse order,
// such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list
// EXAMPLE
// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
//     Output: 8 -> 0 -> 8

package chapter2;
import utils.Node;

public class Ex4 {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(9);
        Node<Integer> n2 = new Node<Integer>(9);
        n1.appendToTail(9)
          .appendToTail(9)
          .appendToTail(9);
        n2.appendToTail(9)
          .appendToTail(9)
          .appendToTail(9);
          
        Node<Integer> result = addListRecur(n1, n2, 0);
        result.showList();
    }

    public static Node<Integer> addListRecur(Node<Integer> n1, Node<Integer> n2, int carry) { 
        if (n1 == null && n2 == null) {
            if (carry != 0) {
                return new Node<>(carry);
            }
            return null;
        }
        int value = carry;
        if (n1 != null) {
            value += n1.data;
            n1 = n1.next;
        }
        if (n2 != null) {
            value += n2.data;
            n2 = n2.next;
        }
        if (value < 10) {
            carry = 0;
        } else {
            carry = 1;
            value -= 10;
        }
        Node<Integer> node = new Node<>(0);
        node.data = value;
        node.next = addListRecur(n1, n2, carry);
        return node;
    }

    public static void addList(Node<Integer> n1, Node<Integer> n2) { 
        Node<Integer> ans = new Node<>(0);
        int carry = 0;
        int v1 = 0;
        int v2 = 0;
        while (true) {
            if (n1 == null && n2 == null) {
                if (carry != 0) {
                    ans.appendToTail(carry);
                }
                break;
            }
            if (n1 != null) {
                v1 = n1.data;
                n1 = n1.next;
            } else {
                v1 = 0;
            }
            if (n2 != null) {
                v2 = n2.data;
                n2 = n2.next;
            } else {
                v2 = 0;
            }
            int sum = v1 + v2 + carry;
            if (sum < 10) {
                carry = 0;
                ans.appendToTail(sum);
            } else {
                carry = 1;
                ans.appendToTail(sum - 10);
            }
        }
        ans = ans.next;
        ans.showList();
    }
}
