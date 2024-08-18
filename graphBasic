package Graph;
import java.util.*;
class Queue1{
	int arr[];
	int f;
	int r;
	Queue1(int n){
		arr=new int[n];
		f=-1;
		r=-1;
	}
	void enqueue(int data) {
		if(r==-1) {
			f++;
			r++;
			arr[r]=data;	
		}
		else {
			arr[++r]=data;
		}
	}
	int dequeue() {
		if(f==-1)
			return -1;
		if(f==r) {
			int v=arr[f];
			f=r=-1;
			return v;
		}
		return arr[f++];
	}
}
public class Graph1 {
	static List<ArrayList<Integer>> list;
	public static void main(String[] args) {
		addVertex(6);
		addEdge(1,2);
		addEdge(1,3);
		addEdge(3,4);
		addEdge(4,5);
		addEdge(5,2);
		display();
		BFS();
	}
	public static void addVertex(int n) {
		list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<>());
		}
	}
	public static void addEdge(int s,int d) {
		list.get(s).add(d);
		list.get(d).add(s);
	}
	public static void display() {
		for(int i=1;i<6;i++) {
			System.out.print(i+" connected to: ");
			for(int v:list.get(i)) {
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
	public static void BFS() {
		Queue1 q=new Queue1(6);
		int vertex[]=new int[7];
		q.enqueue(1);
		int curr=q.dequeue();
		int k=0;
		vertex[k++]=curr;
		while(curr!=-1) {
			System.out.print(curr+" ");
			for(int nei:list.get(curr) ) {
				int f=0;
				for(int j=0;j<vertex.length;j++) {
					if(vertex[j]==nei) {
						f=1;
						break;
					}
				}
				if(f==0) {
					vertex[k++]=nei;
					q.enqueue(nei);
				}
			}
			curr=q.dequeue();
		}
	}

}
