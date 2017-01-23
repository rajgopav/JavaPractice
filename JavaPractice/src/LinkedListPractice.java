public class LinkedListPractice {
	public static void main(String[] args) throws java.lang.Exception {
		LinkedListImplementation stck = new LinkedListImplementation();
		//stck.push(1);
		//stck.push(2);
		//stck.push(4);
		//stck.printStack();
        //System.out.println("Pop out element " + stck.pop());
        //stck.printStack();
		
       stck.insert(1);
       stck.insert(2);
       stck.insert(3);
       stck.insert(4);
       stck.insert(5);
       stck.insert(6);
       stck.insert(7);
       stck.insert(8);
       stck.display();
	}
}

class LinkedListImplementation {
	public NodeLinkedList head;
	public int size = 0;
	
	public LinkedListImplementation() {
		head = null;
	}
	
	public void addAtBeginning(int data) {
		NodeLinkedList newNode = new NodeLinkedList(data);
		newNode.setNext(head);
		head = newNode;
		size++;
	}
	
	public void push(int data) {
		NodeLinkedList newNode = new NodeLinkedList(data);
		if(getSize() == 0) {
			head = newNode;
		} else {
			NodeLinkedList temp = head;
			newNode.setNext(temp);
			head = newNode;
		}
		size++;
	}
	
	public int pop() {
		if(getSize() == 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		NodeLinkedList temp = head;
		head = head.getNext();
		size--;
		return temp.getData();	
	}
	
	public void printStack() {
		NodeLinkedList temp = head;
		if(getSize() == 0) {
			System.out.println("Stack is Empty");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public int getSize() {
		return size;
	}
	
	public NodeLinkedList swapNodesIterative(NodeLinkedList head) {
		NodeLinkedList baseHead = null;
		NodeLinkedList ptrOne_prev = null;
		while(head != null && head.getNext() != null) {
			NodeLinkedList ptrOne = head;
			NodeLinkedList ptrTwo = head.getNext();
			NodeLinkedList ptrTwoNext = ptrTwo.getNext();
			
			ptrOne.setNext(ptrTwoNext);
			
			if(ptrOne_prev != null) {
				ptrOne_prev.setNext(ptrTwo);
			} else {
				baseHead = ptrTwo;
			}
			
			ptrTwo.setNext(head);
			ptrOne_prev.setNext(ptrOne);
			head = ptrTwoNext;
		}
		return baseHead;
	}
	
	public NodeLinkedList swapNodeRecursive(NodeLinkedList head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		
		NodeLinkedList ptrOne = head;
		NodeLinkedList ptrTwo = head.getNext();
		NodeLinkedList ptrTwoNext = ptrTwo.getNext();
		ptrTwo.setNext(head);
		NodeLinkedList newNode = ptrTwo;
		ptrOne.setNext(swapNodeRecursive(ptrTwoNext));
		return newNode;
	}
	
	public NodeLinkedList reverseKGroups(NodeLinkedList head, int k) {
		int x = k;
		NodeLinkedList next = null;
		NodeLinkedList current = head;
		NodeLinkedList prev = null;
		
		while(current != null && x > 0) {
			next = current.getNext();
			current.setNext(prev);
			current = next;
			prev = current;
			x--;
		}
		
		if(next != null)
			next = reverseKGroups(next,k);
		
		return prev;
	}
	
	public void insert(int data) {
		
		if(head == null) {
			addAtBeginning(data);
		} else {
			NodeLinkedList newNode = new NodeLinkedList(data);
			NodeLinkedList temp = head;
			while(temp.getNext() != null)
				temp = temp.getNext();
			
			temp.setNext(newNode);
			size++;
		}
	}
	
	public void display(){
		NodeLinkedList n = head;
		while(n != null){
			System.out.print("->" + n.getData());
			n = n.getNext();
		}
	}	
}

class NodeLinkedList {
	private int data;
	private NodeLinkedList next;
	
	public NodeLinkedList(int data) {
		this.data = data;
		next = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public NodeLinkedList getNext() {
		return next;
	}
	public void setNext(NodeLinkedList next) {
		this.next = next;
	}	
}
