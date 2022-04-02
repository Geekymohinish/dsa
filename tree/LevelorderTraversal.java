import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
	left = null;
	right = null;
    }
}

// We have used queue to store all the nodes a level
class LevelorderTraversal {
   public static void traverse(Node root){
	Queue<Node> q = new LinkedList<>();
	q.add(root);
	Iterator<Node> itr = q.iterator();
	while(!q.isEmpty()) {
	    Node node = q.remove();
	    System.out.print(node.data +" ");
	    if(node.left!=null)
		    q.add(node.left);
	    if(node.right!=null)
		    q.add(node.right);
	}
    }

   //driver program
   public static void main(String args[]) {
       Node node = new Node(1);       //        1
       node.left = new Node(2);       //       / \
       node.right = new Node(3);      //      2   3
       node.left.left = new Node(4);  //     /\   /\
       node.left.right = new Node(5); //    4  5 6  7
       node.right.left = new Node(6); //   /
       node.right.right = new Node(7);//  8
       node.left.left.left = new Node(8);
       traverse(node);
   }
}
