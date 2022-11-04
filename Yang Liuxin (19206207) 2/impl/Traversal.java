package dsa.impl;

public class Traversal<T extends Comparable<T>> extends BinarySearchTree<T> {
    /*
    This class provides four kinds of traversals: preorder, inorder, postorder, and layer traversal.
    Moreover, this class provides testing traversal structure method for tree shape comparison.
     */

    //preorder traversal
    public LinkedQueue preorder(BinarySearchTree tree){
        LinkedQueue<T> elements = new LinkedQueue();
        preorder(tree.root, elements);
        return elements;
    }
    private void preorder(BTPosition x, LinkedQueue elements){
        if (x == null)
            return;
        elements.enqueue(x.element);
        if ( !isExternal(x.left))
            preorder(x.left, elements);
        if ( !isExternal(x.right))
            preorder(x.right, elements);
    }

    //inorder traversal
    public LinkedQueue inorder(BinarySearchTree tree){
        LinkedQueue<T> elements = new LinkedQueue();
        inorder(tree.root, elements);
        return elements;
    }
    private void inorder(BTPosition x, LinkedQueue elements){
        if (x == null)
            return;
        if ( !isExternal(x.left))
            inorder(x.left, elements);
        elements.enqueue(x.element);
        if ( !isExternal(x.right))
            inorder(x.right, elements);
    }

    //postorder traversal
    public LinkedQueue postorder(BinarySearchTree tree){
        LinkedQueue<T> elements = new LinkedQueue();
        postorder(tree.root, elements);
        return elements;
    }
    private void postorder(BTPosition x, LinkedQueue elements){
        if (x == null)
            return;
        if ( !isExternal(x.left))
            postorder(x.left, elements);
        if ( !isExternal(x.right))
            postorder(x.right, elements);
        elements.enqueue(x.element);
    }

    //layer traversal
    public LinkedQueue<T> layerTraversal(BinarySearchTree tree){
        LinkedQueue<T> elements = new LinkedQueue<>();
        LinkedQueue<BTPosition> positions = new LinkedQueue<>();
        positions.enqueue(tree.root);
        while( !positions.isEmpty()){
            BTPosition n = positions.dequeue();
            elements.enqueue(n.element);
            if ( !isExternal(n.left))
                positions.enqueue(n.left);
            if ( !isExternal(n.right))
                positions.enqueue(n.right);
        }
        return elements;
    }

    public boolean testPreorderStructure(BinarySearchTree tree, T[] preorder){
        LinkedQueue preElements = new Traversal<>().preorder(tree);
        int index = 0;
        boolean flagPreorder = true;
        while ( !preElements.isEmpty() && flagPreorder) {
            if ( !preElements.dequeue().equals(preorder[index++]))
                flagPreorder = false;
        }
        return flagPreorder;
    }

    public boolean testInorderStructure(BinarySearchTree tree, T[] inorder){
        LinkedQueue inElements = new Traversal<>().inorder(tree);
        int index = 0;
        boolean flagInorder = true;
        while ( !inElements.isEmpty() && flagInorder) {
            if ( !inElements.dequeue().equals(inorder[index++]))
                flagInorder = false;
        }
        return flagInorder;
    }

    public boolean testPostorderStructure(BinarySearchTree tree, T[] postorder){
        LinkedQueue postElements = new Traversal<>().postorder(tree);
        int index = 0;
        boolean flagPostorder = true;
        while ( !postElements.isEmpty() && flagPostorder) {
            if ( !postElements.dequeue().equals(postorder[index++]))
                flagPostorder = false;
        }
        return flagPostorder;
    }

    public boolean testLayerStructure(BinarySearchTree tree, T[] layer){
        LinkedQueue layerElements = new Traversal<>().layerTraversal(tree);
        int index = 0;
        boolean flagLayer = true;
        while ( !layerElements.isEmpty() && flagLayer) {
            if ( !layerElements.dequeue().equals(layer[index++]))
                flagLayer = false;
        }
        return flagLayer;
    }

}
