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
class TopViewTraversal {
   public static void traverse(Node root){
	Queue<DistancePair> q = new LinkedList<>(); // queue will be used for storing node and its distance
	Map<Integer,Integer> topView = new TreeMap<>(); // TreeMap will store data in sorted order
	q.add(new DistancePair(0,root)); // add initial pair of root distance and root node in queue 
	topView.put(0,root.data);  //insert distance 0 -> node data

	while(!q.isEmpty()) {
	    DistancePair pair = q.remove();
	    
	    if(pair.node.left!=null) {
		    q.add(new DistancePair(pair.hd-1, pair.node.left));
		    if(!topView.containsKey(pair.hd-1))
			    topView.put(pair.hd-1, pair.node.left.data);
	    }
	    if(pair.node.right!=null) {
		    q.add(new DistancePair(pair.hd+1, pair.node.right));
		    if(!topView.containsKey(pair.hd+1))
			    topView.put(pair.hd+1, pair.node.right.data);
	    }
	}
	for (Map.Entry<Integer,Integer> entry : topView.entrySet()) {
		System.out.print(entry.getValue() + " ");
	}
    }
   
   static class DistancePair {
	   int hd;
	   Node node;

	   DistancePair(int hd, Node node) {
		   this.hd = hd;
		   this.node = node;
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
