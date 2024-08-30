import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}


class BinaryTree{
    int index = -1;

    Node buildTree(int []nodes){
        index++;

        if(nodes[index] == -1){
            return null;
        }
        Node node = new Node(nodes[index]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;

    }
    void preorder(Node root ){
        if(root ==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data+" ");
    }

    void levelorder(Node root){

        if(root == null){
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node == null){
                System.out.println();
                if(queue.isEmpty()){
                    return;
                }else{
                    queue.add(null);
                }
            }else{
                System.out.print(node.data+" ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

    }

    void levelorder2(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node present = queue.remove();
            System.out.print(present.data +" ");
            if(present.left!=null){
                queue.add(present.left);
            }
            if(present.right!=null){
                queue.add(present.right);
            }
        }
    }

    int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = countOfNodes(root.left);
        int rightsum = countOfNodes(root.right);

        return leftsum+rightsum+1;
    }

    int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);

        return leftsum+rightsum+root.data;
    }

    int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = heightOfTree(root.left);
        int rightheight = heightOfTree(root.right);

        return Math.max(leftheight,rightheight)+1;

    }

    int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftdiameter = heightOfTree(root.left);
        int rightdiameter = heightOfTree(root.right);
        int diameter3 = leftdiameter+rightdiameter+1;

        return Math.max(leftdiameter,Math.max(rightdiameter,diameter3));

    }


}
public class Trees {
    public static void main(String[] args) {

        //Building Treee------
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node node = tree.buildTree(nodes);
        System.out.println(node.data);

        // Traversing Tree--------
        //Preorder----------------
        tree.preorder(node);
        System.out.println();

        //inorder -------------------
        tree.inorder(node);
        System.out.println();
        //Postorder------------------
        tree.postorder(node);
        System.out.println();
        //Level order traversal------------------
        tree.levelorder(node);

        //count of Node ----------------------using recursion
        int n = tree.countOfNodes(node);
        System.out.println(n);

        // sum of nodes ---------------------------------;
        int sum = tree.sumOfNodes(node);
        System.out.println(sum);

        int height = tree.heightOfTree(node);
        System.out.println(height);


        int diameter = tree.diameterOfTree(node);
        System.out.println(diameter);

        tree.levelorder2(node);
    }
}
