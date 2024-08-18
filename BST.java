package Tree;
class Node{
	int data;
	Node left;
	Node right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
class Queue{
	Node[] queue;
	int front;
	int rear;
	Queue(){
		queue=new Node[30];
		front=rear=-1;
	}
	public void enqueue(Node curr) {
		if(rear==-1) {
			front++;
			rear++;
			queue[rear]=curr;
		}
		else
			queue[++rear]=curr;
	}
	public Node dequeue() {
		if(front==-1)
			return null;
		else if(front==rear)
		{
			Node v=queue[front];
			front=rear=-1;
			return v;
		}
		return queue[front++];
	}
}
public class BinarySearchTree {
	static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		insert(10);
		insert(9);
		insert(30);
		insert(40);
		insert(50);
		insert(60);
		//inorder(root);
		BFS();
	}
	public static void insert(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=newNode;
		}
		else {
			Node curr=root;
			while(true) {
				if(data<curr.data) {
					if(curr.left==null) {
						curr.left=newNode;
						break;
					}
					else {
						curr=curr.left;
					}
				}
				else {
					if(curr.right==null)
					{
						curr.right=newNode;
						break;
					}
					else {
						curr=curr.right;
					}
				}
			}
		}
	}
	public static void inorder(Node curr) {
		if(curr==null)
			return;
		System.out.print(curr.data+" ");
		inorder(curr.left);
		inorder(curr.right);
	}
	public static void BFS() {
		Node curr;
		Queue q=new Queue();
		q.enqueue(root);
		curr=q.dequeue();
		while(curr!=null) {
			System.out.print(curr.data+" ");
			if(curr.left!=null)
				q.enqueue(curr.left);
			if(curr.right!=null)
				q.enqueue(curr.right);
			curr=q.dequeue();
		}
	}
}
