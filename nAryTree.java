package N_ArrayTree;
import java.util.*;
class Node{
	int data;
	List<Node> children;
	Node(int d){
		data=d;
		children=new ArrayList<>();
	}
}
class ntree {
	static Node root;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		Queue<Node> q = new LinkedList<>();
		int n=sc.nextInt();
		int max=sc.nextInt();
		int c=0;
		int v=sc.nextInt();
		Node newNode=new Node(v);
		q.add(newNode);
		Node curr=q.remove();
		if(root==null)
			root=newNode;
		for(int i=1;i<n;i++) {
			if(c==max) {
				c=0;
				Node d=q.remove();
				System.out.println("d:"+d.data);
				curr=d;
				
			}
			int v1=sc.nextInt();
			System.out.println(v1);
			Node newNode1=new Node(v1);
			curr.children.add(newNode1);
			q.add(newNode1);
			c++;
		}
		display(root);
	}
	public static void display(Node root) {
		if(root!=null) {
			
			if(root.children!=null) {
				for(Node child:root.children) {
					
					display(child);
				}
			}
			System.out.print(root.data+" ");
		}
	}
}
