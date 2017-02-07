package ctci;

//https://www.hackerrank.com/challenges/ctci-linked-list-cycle
public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n5 = new Node(5);
		Node n4 = new Node(4,n5);
		Node n3 = new Node(3,n4);
		Node n2 = new Node(2,n3);
		Node n1 = new Node(1,n2);
		
		n5.next = n2;
		Node head = n1;
		System.out.println(hasCycle(head));
	}

	static boolean hasCycle(Node head) {

		Node slow = new Node();
		Node fast = new Node();
		if (head != null) {
			slow = head;
			fast = head;
		} else {
			return false;
		}
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}


}
class Node {
	int data;
	Node next;
	Node(){
		
	}
	Node(int d){
		data=d;
	}
	Node(int d,Node n){
		data=d;
		next=n;
	}
}
