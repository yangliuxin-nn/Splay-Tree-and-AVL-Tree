package dsa.impl;

import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;

public class TreePrinterHeight<T> {
    ITree<T> tree;
    String output = "";
    LinkedQueue<Integer> heights = new LinkedQueue<>();

    TreePrinterHeight(ITree<T> tree) {
        this.tree = tree;
        this.visit(tree.root(), "");
    }

    private void visit(IPosition<T> position, Object data) {
        AVLTree.AVLPosition avlPosition = (AVLTree.AVLPosition) position;
        this.output = this.output + data.toString() + (position.element() == null ? "[]" : (position.element() +"("+avlPosition.height+")")) + "\n";
        heights.enqueue(avlPosition.height);
        IIterator it = this.tree.children(position);

        while(it.hasNext()) {
            this.visit((IPosition)it.next(), data.toString() + "\t");
        }

    }

    public String getString() {
        return this.output;
    }

    public static <T> void printTree(ITree<T> t) {
        System.out.println((new TreePrinterHeight<>(t)).getString());
    }

    public LinkedQueue<Integer> getHeights() {
        return heights;
    }
}
