package juspay;
import java.util.*;
class TreeNode{
	String data;
	TreeNode parant;
	List<TreeNode> children;
	boolean isLocked;
	int lockedBy;
	Set<TreeNode> lockedChildren;
	TreeNode(String d,TreeNode p){
		data=d;
		parant=p;
		children=new LinkedList<>();
		isLocked=false;
		lockedBy=-1;
		lockedChildren=new HashSet<>();
	}
}
class nAryTree{
	TreeNode root=null;
	int n;
	HashMap<String,TreeNode> map;
	nAryTree(int num){
		n=num;
		map=new HashMap<>();
	}
	public void creatTree(List<String> list) {
		if(list.isEmpty())
			return;
		root=new TreeNode(list.get(0),null);
		Queue<TreeNode> q=new LinkedList<>();
		q.add(root);
		map.put(root.data,root);
		int index =1;
		TreeNode p;
		while(!q.isEmpty()&&index<list.size()) {
			p=q.poll();
			for(int i=0;i<n&&index<list.size();i++) {
				TreeNode curr=new TreeNode(list.get(index++),p);
				map.put(curr.data,curr);
				p.children.add(curr);
				q.add(curr);
			}
		}
			
	}
	public static void display(TreeNode node) {
		Queue<TreeNode> q=new LinkedList<>();
		q.add(node);
		TreeNode curr=q.poll();
		while(curr!=null) {
			System.out.print(curr.data+" ");
			for(TreeNode c:curr.children) {
				q.add(c);
			}
			curr=q.poll();
		}
	}
	public void display() {
		display(root);
	}
//	public TreeNode findNode(String val) {
//		Queue<TreeNode> q=new LinkedList<>();
//		q.add(root);
//		TreeNode curr=q.poll();
//		while(curr!=null) {
//			if(curr.data.equals(val))
//				return curr;
//			for(TreeNode c:curr.children) {
//				q.add(c);
//			}
//			curr=q.poll();
//		}
//		return null;
//	}
	public boolean lock(String val,int id) {
		//TreeNode node=findNode(val);
		TreeNode node=map.get(val);
		if(node==null||node.isLocked||node.lockedChildren.size()>0)
			return false;
		TreeNode p=node.parant;
		while(p!=null) {
			if(p.isLocked)
				return false;
			p=p.parant;
		}
		TreeNode par=node.parant;
		while(par!=null) {
			par.lockedChildren.add(node);
			par=par.parant;
		}
		node.isLocked=true;	
		node.lockedBy=id;
		return true;
	}
	public boolean unLock(String val,int id) {
		//TreeNode node=findNode(val);
		TreeNode node=map.get(val);
		if(node==null||!node.isLocked||!(node.lockedBy==id))
			return false;
		TreeNode p=node.parant;
		while(p!=null) {
			p.lockedChildren.remove(node);
			p=p.parant;
		}
		node.isLocked=false;
		node.lockedBy=-1;
		return true;
	}
	public boolean upgrade(String val, int id) {
	    //TreeNode node = findNode(val);
		TreeNode node=map.get(val);
	    if (node == null || node.isLocked || node.lockedChildren.isEmpty())
	        return false;

	    
	    for (TreeNode c : node.lockedChildren) {
	        if (!(c.lockedBy == id))
	            return false;
	    }

	    TreeNode p = node.parant;
	    while (p != null) {
	        if (p.isLocked)
	            return false;
	        p = p.parant;
	    }

	    Set<TreeNode> lockedChildrenCopy = new HashSet<>(node.lockedChildren);
	    
	 
	    for (TreeNode c : lockedChildrenCopy) {
	        unLock(c.data, id);
	    }


	    return lock(node.data, id);
	}

}
public class TreeOfSpace {

	public static void main(String[] args) {

	     Scanner sc = new Scanner(System.in);

	         	
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int q = sc.nextInt();
	        sc.nextLine();
	        nAryTree tree=new nAryTree(m);
	        List<String> list = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            list.add(sc.nextLine());
	        }

	        tree.creatTree(list);
	        

	        for (int i = 0; i < q; i++) {
	            int op = sc.nextInt();
	            String sq = sc.next();
	            int uid = sc.nextInt();

	            switch (op) {
	                case 1:
	                    System.out.println(tree.lock(sq, uid));
	                    break;
	                case 2:
	                    System.out.println(tree.unLock(sq, uid));
	                    break;
	                case 3:
	                    System.out.println(tree.upgrade(sq, uid));
	                    break;
	            }
	}
	}

}
