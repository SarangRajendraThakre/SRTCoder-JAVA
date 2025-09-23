
class BinaryTree<E> {
    Node<E> root;

    static class Node<E> {
        E ele;
        Node<E> left, right;

        Node(E ele) {
            this.ele = ele;
            this.left = null;
            this.right = null;
        }
    }

    public void preOrder(Node<E> root)
    {
        if(root==null) return;
        System.out.print(root.ele+" ");
        preOrder(root.left);
        preOrder(root.right);
        
    }
    public void postOrder(Node<E> root)
    {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
       System.out.print(root.ele+" ");

    }

    public void Inorder(Node<E> root)
    {
        if(root == null) return ;
        Inorder(root.left);
        System.out.print(root.ele+" ");
        Inorder(root.right);

    }

}
public class TreeDriver2 {

    public static void main(String[] args) {

        BinaryTree<Character> tree = new BinaryTree<>();

        tree.root = new BinaryTree.Node<>('A');

        tree.root.left = new BinaryTree.Node<>('B');
        tree.root.right = new BinaryTree.Node<>('C');

        tree.root.left.left = new BinaryTree.Node<>('D');
        tree.root.left.right = new BinaryTree.Node<>('E');

        
        tree.root.right.left = new BinaryTree.Node<>('F');
        tree.root.right.right = new BinaryTree.Node<>('G');

        tree.root.left.left.left = new BinaryTree.Node<>('H');
        tree.root.left.right.left = new BinaryTree.Node<>('I');


     
        System.out.print("\n---------------PreOrder--------------------\n");
        tree.preOrder(tree.root);
        System.out.print("\n---------------PostOrder--------------------\n");
        tree.postOrder(tree.root);
        System.out.print("\n---------------InOrder--------------------\n");
        tree.Inorder(tree.root);




    }
}