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


class PostorderTraversal {
   public static void traverse(Node root){
	if(root==null)
            return ;
        //postorder have sequence as LEFT, RIGHT, ROOT
	traverse(root.left);
	traverse(root.right);
	System.out.print(root.data + " ");
    }

   //driver program
   public static void main(String args[]) {
       Node node = new Node(1);    //        1
       node.left = new Node(2);    //       / \
       node.right = new Node(3);   //      2   3
       node.left.left = new Node(4); //   /\   /\
       node.left.right = new Node(5);//  4 5   6 7
       node.right.left = new Node(6);
       node.right.right = new Node(7);
       traverse(node);
   }
}
