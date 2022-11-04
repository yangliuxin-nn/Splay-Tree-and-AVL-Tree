package dsa.impl;

import dsa.example.AVLTreeStructureTest;
import dsa.iface.IBinarySearchTree;
import dsa.util.TreePrinter;

public class SplayTest3 {
    /*
    This class uses four kinds of traversals (preorder, inorder, postorder, layer) to compare shape to test the tree structure
    This class tests the tree operation using reading file.
     */

    public static void main(String[] args) {
        SplayTree splayTree = new SplayTree();
        ReadFile.readFile(splayTree, "textSplay");

        Traversal traversal = new Traversal();

        Integer[] preorder = new Integer[] {4, 1, -1, 3, 5};
        Integer[] inorder = new Integer[] {-1, 1, 3, 4, 5};
        Integer[] postorder = new Integer[] {-1, 3, 1, 5, 4};
        Integer[] layer = new Integer[] {4, 1, 5, -1, 3};

        System.out.println("Test Splay Tree3:");

        // use preorder traversal to test the tree structure
        System.out.println("Is the Splay Tree3 in the expected shape using the preorder traversal: " + traversal.testPreorderStructure(splayTree, preorder));

        // use inorder traversal to test the tree structure
        System.out.println("Is the Splay Tree3 in the expected shape using the inorder traversal: " + traversal.testInorderStructure(splayTree, inorder));

        // use postorder traversal to test the tree structure
        System.out.println("Is the Splay Tree3 in the expected shape using the postorder traversal: " + traversal.testPostorderStructure(splayTree, postorder));

        // use layer traversal to test the tree structure
        System.out.println("Is the Splay Tree3 in the expected shape using the layer traversal: " + traversal.testLayerStructure(splayTree, layer));

        // use the provided areEqual function to test the tree structure
        IBinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        for ( int v : layer )
            t2.insert( v );
        System.out.println( "Is the Splay Tree3 in the expected shape using the provided areEqual function to test the tree structure? " + (AVLTreeStructureTest.areEqual(splayTree, splayTree.root(), t2, t2.root()) ? "YES! :-D" : "No! :-(" ) );

        System.out.println();
        System.out.println("Shape of the Splay Tree3:");
        TreePrinter.printTree(splayTree);
    }
}
