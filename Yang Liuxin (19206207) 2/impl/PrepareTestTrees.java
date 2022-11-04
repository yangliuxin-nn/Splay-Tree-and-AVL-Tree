package dsa.impl;


public class PrepareTestTrees {

    /*
    This class prepares trees for further testing.

    avlTree1() prepares the tree for AVLTest1
    avlTree2() prepares the tree for AVLTest2
    avlTree3() prepares the tree for AVLTest4
    avlTree4() prepares the tree for AVLTest5
    splayTree1() prepares the tree for SplayTest1
    splayTree2() prepares the tree for SplayTest2
     */

    public static AVLTree avlTree1(){

        // This method prepares the first AVL tree of type Integer

        AVLTree avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(6);
        avlTree.insert(7);

        // after insertion, restructure the non-root node with left rotation
        avlTree.insert(8);

        // after insertion, restructure the root node with left rotation
        avlTree.insert(10);
        avlTree.insert(3);

        // after insertion, restructure the non-root node with right rotation
        avlTree.insert(1);

        // after insertion, restructure the non-root node with right rotation
        avlTree.insert(0);

        // test whether duplicate value can be automatically ignored, ie. if the node found is external, then I can expand it
        avlTree.insert(4);
        avlTree.insert(2);

        // after insertion, restructure the root node with right rotation
        avlTree.insert(-2);

        // after insertion, restructure the non-root node with double rotation (left rotation + right rotation)
        avlTree.insert(-1);

        // after insertion, restructure the non-root node with double rotation (right rotation + left rotation)
        avlTree.insert(9);

        // after removing an internal node with two external children, restructure the non-root node with double rotation (left rotation + right rotation)
        avlTree.remove(2);
        avlTree.remove(10);

        // after removing an internal node with two internal children, restructure the non-root node with right rotation
        avlTree.remove(0);

        avlTree.remove(-2);
        // after removing an internal node with two external children, restructure the root node with right rotation
        // if the height of two children is the same, then choose the single rotation
        avlTree.remove(1);

        // after removing an internal node with one external and internal child, restructure the root node with double rotation (left rotation + right rotation)
        avlTree.remove(9);

        return avlTree;
    }

    public static AVLTree avlTree2(){

        // This method prepares the second AVL tree of type Char

        AVLTree avlTree = new AVLTree();
        avlTree.insert('Y');
        avlTree.insert('C');
        avlTree.insert('f');
        avlTree.insert('A');
        avlTree.insert('G');
        avlTree.insert('a');
        avlTree.insert('h');
        avlTree.insert('E');
        avlTree.insert('Z');
        avlTree.insert('d');
        avlTree.insert('n');
        avlTree.insert('b');

        // Test whether removal operation may result in multiple restructuring
        // The first restructuring is to restructure a non-root node with double rotation (left rotation + right rotation)
        // The first restructuring is to restructure a root node with double rotation (right rotation + left rotation)
        avlTree.remove('A');

        // After insertion, restructure the non-root node with right rotation
        avlTree.insert('B');

        // Contains method of AVLTree will not trigger restructure
        avlTree.contains('C');

        return avlTree;
    }

    public static AVLTree avlTree3(){
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.remove(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(10);
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(8);
        avlTree.contains(25);
        avlTree.remove(8);
        avlTree.remove(5);

        // removing an element that is not in the tree will be ignored
        avlTree.remove(75);

        avlTree.insert(15);
        avlTree.insert(38);
        avlTree.insert(39);
        return avlTree;
    }

    public static AVLTree avlTree4(){
        // This method prepares the fourth AVL tree of type Character
        AVLTree avlTree = new AVLTree();

        avlTree.insert("44");
        avlTree.insert("17");
        avlTree.insert("78");
        avlTree.insert("32");
        avlTree.insert("50");
        avlTree.insert("88");
        avlTree.insert("48");
        avlTree.insert("62");

        // restructure the non-root node with double rotation left right
        avlTree.insert("54");

        return avlTree;
    }

    public static SplayTree splayTree1(){

        // This method prepares the first AVL tree of type int

        SplayTree splayTree = new SplayTree();

        splayTree.insert(2);

        // zig operation
        splayTree.insert(-1);

        // zig-zig operation
        splayTree.insert(5);

        // zig-zag operation from left to right
        splayTree.insert(3);

        // zig-zag operation from left to right + zig operation (to splay 1 to the root)
        splayTree.insert(1);

        // zig-zag operation from right to left + zig operation (to splay 4 to the root)
        splayTree.insert(4);

        // zig-zag operation from right to left + zig operation from right to left (to splay 2 to the root)
        splayTree.contains(2);

        // zig-zig operation from right to left
        splayTree.contains(5);

        // if element not found, use parent of ending external node, its parent is already the root node
        splayTree.contains(6);


        // if element not found, use parent of ending external node
        // splay -1 to the root: zig-zig operation from left to right + zig-zig operation from left to right
        splayTree.contains(-2);

        // zig-zig operation from left to right + zig operation from right to left (to splay 0 to the root)
        splayTree.insert(0);


        // use the parent of the internal node that was actually removed from the tree, its (1) parent is already the root node
        splayTree.remove(0);

        // use the parent of the internal node that was actually removed from the tree
        // splay its parent: 4 to the root
        // zig-zig operation from right to left
        splayTree.remove(2);


        return splayTree;
    }

    public static SplayTree splayTree2(){

        // This method prepares the first AVL tree of type Double

        SplayTree splayTree = new SplayTree();

        splayTree.insert(2.0);

        // zig operation from right to left
        splayTree.insert(0.1);

        // zig-zag operation from left to right
        splayTree.insert(1.3);

        // zig-zig operation from right to left
        splayTree.insert(3.4);

        // test removal an element which is not stored in the tree will be ignored
        splayTree.remove(1.9);

        // use the parent of the internal node that was actually removed from the tree
        // zig operation from left to right
        splayTree.remove(1.3);

        // if element is found, splay that node
        // zig operation from left to right
        splayTree.contains(0.1);

        // zig-zag operation from right to left
        splayTree.insert(1.8);

        return splayTree;
    }

}
