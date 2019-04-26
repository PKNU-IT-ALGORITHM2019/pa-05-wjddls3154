package tree;

public class binarytree {
	protected static class Node{
		protected String word;
		protected String c;
		protected String ex;
		protected Node parent;
		protected Node left;
		protected Node right;
		
		public Node (String word,String c,String ex) {
			this.word=word;
			this.c=c;
			this.ex=ex;
			parent=null;
			left=null;
			right=null;
		}
		public String toString() {
			return word.toString();
		}
	}
	protected Node root;
	
	//삽입
	public void insert(Node k) {
		Node now=root;
		Node pre=null;
		while(now!=null) {
			pre=now;
			if(((String) k.word).compareTo((String) now.word)>0) {
				now=now.right;
			}
			else
				now=now.left;
		}
		if(pre==null)
		{
			root=k;
		}
		else if(((String) k.word).compareTo((String) pre.word)>0) {
			pre.right=k;
			k.parent=pre;
		}
		else {
			pre.left=k;
			k.parent=pre;
		}
	}
	//검색
	public Node search(Node k) {
		Node now=root;
		while(now!=null) {
			if( k.word.compareTo( now.word)==0) {
				return now;
			}
			else if( k.word.compareTo( now.word)>0) {
				now=now.right;
			}
			else
				now=now.left;
		}
		return null;
	}
	
	//삭제
	public Node delete(Node k) {
		if(k==null)
			return null;
		if(k.left==null||k.right==null) {
			Node a= k;
			Node b;
			if(k.left!=null)
				b=k.left;
			else
				b=k.right;
			if(b!=null)
				b.parent=a.parent;
			if(a.parent==null)
				root=k;
			else if(a.parent.left==k) 
				a.parent.left=b;
			else
				a.parent.right=b;
		}
		else {
			Node a= successor(k);
			exchage(k,a);
			delete(a);
		}
		return k;
	}
	//교환
	public void exchage(Node k,Node n) {
		k.word=n.word;
	}
	
	public Node successor(Node k){
		if(k.right!=null)
		{
			k=k.right;
			while(k.left!=null) {
				k=k.left;
			}
			return k;
		}
		else {
			Node p=k.parent;
			while(p.left!=k) {
				k=p;
				p=p.parent;
				if(p==null)
					return null;
			}
			return p;
		}
	}
}