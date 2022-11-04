package dsa.impl;

import dsa.example.AVLTreeStructureTest;
import dsa.iface.IBinarySearchTree;
import dsa.util.TreePrinter;

public class SplayTest2 {
    /*
    This class uses four kinds of traversals (preorder, inorder, postorder, layer) to compare shape to test the tree structure
    This class tests the splayTree2 of type Double, which is prepared in the PrepareTestTrees class.
     */

    public static void main(String[] args) {
        SplayTree splayTree2 = PrepareTestTrees.splayTree2();

        Traversal traversal = new Traversal();

        Double[] preorder = new Double[] {1.8, 0.1, 2.0, 3.4};
        Double[] inorder = new Double[] {0.1, 1.8, 2.0, 3.4};
        Double[] postorder = new Double[] {0.1, 3.4, 2.0, 1.8};
        Double[] layer = new Double[] {1.8, 0.1, 2.0, 3.4};

        System.out.println("Test Splay Tree2:");

        // use preorder traversal to test the tree structure
        System.out.println("Is the Splay Tree2 in the expected shape using the preorder traversal: " + traversal.testPreorderStructure(splayTree2, preorder));

        // use inorder traversal to test the tree structure
        System.out.println("Is the Splay Tree2 in the expected shape using the inorder traversal: " + traversal.testInorderStructure(splayTree2, inorder));

        // use postorder traversal to test the tree structure
        System.out.println("Is the Splay Tree2 in the expected shape using the postorder traversal: " + traversal.testPostorderStructure(splayTree2, postorder));

        // use layer traversal to test the tree structure
        System.out.println("Is the Splay Tree2 in the expected shape using the layer traversal: " + traversal.testLayerStructure(splayTree2, layer));

        // use the provided areEqual function to test the tree structure
        IBinarySearchTree<Double> t2 = new BinarySearchTree<>();
        for ( Double v : layer )
            t2.insert( v );
        System.out.println( "Is the Splay Tree2 in the expected shape using the provided areEqual function to test the tree structure? " + (AVLTreeStructureTest.areEqual(splayTree2, splayTree2.root(), t2, t2.root()) ? "YES! :-D" : "No! :-(" ) );

        System.out.println();
        System.out.println("Shape of Splay Tree2:");
        TreePrinter.printTree(splayTree2);
    }
}
