package com.company;
/*Name: Killian Hasson      Date: 08/26/2021        Class: CS202
*
* This class is the main order tree designed as a red/black tree, this meant I needed to include a int to keep track of
* which node was which in terms of overall height and such. The RBtree needed multiple functions to make the insert work
* properly, specifically when needing the subtrees to rotate and such. I realized after building it that it doesnt make
* total sense in terms of sorting by price and that perhaps order numbers would have been better but I managed to atleast
* add in a name to each order or RBnode.
* */

public class RBTree {
        private RBnode root;

        //Basic constructor should have root be null
        public RBTree() {
            this.root = null;
        }

        //The insert function takes a Food object and a orderers name
        public void insert(Food to_add, String Name) {
            //The Food object and the name create a new RBnode which in this case is like an order
            RBnode new_node = new RBnode(to_add,Name);
            //Needed two temp nodes for traversing and comparing
            RBnode temp = null;
            RBnode curr = this.root;

            //Spent sometime figuring out how to do this without a while statement but ran out of time
            while(curr != null) {
                temp = curr;
                //Traverse left
                if (new_node.getPrice() < curr.getPrice()) {
                    curr = curr.getLeft();
                } else {
                    //Traverse right
                    curr = curr.getRight();
                }
            }
            //Connect new node to temp via previous, this lets us work backwards in a way
            new_node.setPrev(temp);
            //If previous is null then this is now root
            if (temp == null) {
                this.root = new_node;
                //If temp is larger set its left pointer to new node since new node would be smaller
            } else if (new_node.getPrice() < temp.getPrice()) {
                temp.setLeft(new_node);
                //Else it has to be larger or equal and we can set it to the right
            } else {
                temp.setRight(new_node);
            }
            //If new node is root, prev is null set its color int to 0
            if (new_node.getPrev() == null) {
                new_node.setColor(0);
                //Else if its not root we need to fix the tree
            } else if (new_node.getPrev().getPrev() != null) {
                this.fixTree(new_node);
            }
        }
    private void fixTree(RBnode new_node) {
            //Loops until new node is pointing to root
        do {
            //Check new nodes previous color
            if (new_node.getPrev().getColor() != 1) {
                this.root.setColor(0);
                return;
            }
            //Temp node for comparing easily and fixing
            RBnode temp;
            //If new node is the child of a right parent
            if (new_node.getPrev() == new_node.getPrev().getPrev().getRight()) {
                //temp for new nodes uncle
                temp = new_node.getPrev().getPrev().getLeft();
                //If the uncle exists and is color 1
                if (temp != null && temp.getColor() == 1) {
                    temp.setColor(0);
                    new_node.getPrev().setColor(0);
                    new_node.getPrev().getPrev().setColor(1);
                    new_node = new_node.getPrev().getPrev();
                } else {
                    //If new node is a child of a left parent
                    if (new_node == new_node.getPrev().getLeft()) {
                        new_node = new_node.getPrev();
                        //rotate right
                        this.rotateR(new_node);
                    }
                    //Make correct changes to colors
                    new_node.getPrev().setColor(0);
                    new_node.getPrev().getPrev().setColor(1);
                    //Rotate Left
                    this.rotateL(new_node.getPrev().getPrev());
                }
            } else {
                //Set temp as the right child of new nodes grandparent
                temp = new_node.getPrev().getPrev().getRight();
                //If temp exists and color is 1
                if (temp != null && temp.getColor() == 1) {
                    //Change color
                    temp.setColor(0);
                    new_node.getPrev().setColor(0);
                    new_node.getPrev().getPrev().setColor(1);
                    new_node = new_node.getPrev().getPrev();
                } else {
                    //Rotate if temp was null or color was 0
                    if (new_node == new_node.getPrev().getRight()) {
                        new_node = new_node.getPrev();
                        //rotate left
                        this.rotateL(new_node);
                    }
                    //Set colors
                    new_node.getPrev().setColor(0);
                    new_node.getPrev().getPrev().setColor(1);
                    //rotate right
                    this.rotateR(new_node.getPrev().getPrev());
                }
            }
        } while(new_node != this.root);

    }

    //Rotate right subtree
    public void rotateR(RBnode new_node) {
        RBnode temp = new_node.getLeft();
        new_node.setLeft(temp.getRight());
        if (temp.getRight() != null) {
            temp.getRight().setPrev(new_node);
        }

        temp.setPrev(new_node.getPrev());
        if (new_node.getPrev() == null) {
            this.root = temp;
        } else if (new_node == new_node.getPrev().getRight()) {
            new_node.getPrev().setRight(temp);
        } else {
            new_node.getPrev().setLeft(temp);
        }

        temp.setRight(new_node);
        new_node.setPrev(temp);
    }

    //rotate the left subtree
    public void rotateL(RBnode new_node) {
        RBnode temp = new_node.getRight();
        new_node.setRight(temp.getLeft());
        if (temp.getLeft() != null) {
            temp.getLeft().setPrev(new_node);
        }

        temp.setPrev(new_node.getPrev());
        if (new_node.getPrev() == null) {
            this.root = temp;
        } else if (new_node == new_node.getPrev().getLeft()) {
            new_node.getPrev().setLeft(temp);
        } else {
            new_node.getPrev().setRight(temp);
        }

        temp.setLeft(new_node);
        new_node.setPrev(temp);
    }

    //Basic display function
    public void display() {
            if(root == null){
                System.out.println("Order Tree is empty!");
            }
        if (this.root != null) {
            System.out.println("Tree for orders:");
            this.display(this.root, "", "");
        }
    }
    //Basic recursive display function
    public void display(RBnode temp, String prefix, String pointer) {
        if (temp != null) {
            if (temp.getData() != null) {
                System.out.println(prefix + pointer + " " + temp.getName() + " " + temp.getColor());
            }

            if (temp.getLeft() != null) {
                this.display(temp.getLeft(), prefix + "   ", temp.getRight() != null ? "├──" : "└──");
            }

            if (temp.getRight() != null) {
                this.display(temp.getRight(), prefix + "   ", "└──");
            }

        }
    }

    //Wrapper function for finding and returning a node by price
    public RBnode find(double price){
            if(root == null){
                return null;
            }
            return find(root,price);
    }

    //Recursive function for finding and returning a node by price
    public RBnode find(RBnode root, double price){
            if(root == null){
                return null;
            }
            if(root.getData().getPrice() == price){
                return root;
            }
            if(root.getData().getPrice() < price){
                return find(root.getRight(),price);
            }
            else {
                return find(root.getLeft(),price);
            }
    }

    public void delete() {
        if (this.root == null) {
            System.out.println("All orders already deleted.");
        }

        this.delete(this.root);
    }

    public void delete(RBnode curr) {
        if (curr.getRight() != null) {
            this.delete(curr.getRight());
        } else if (curr.getLeft() != null) {
            this.delete(curr.getLeft());
        }

        curr.setLeft((RBnode)null);
        curr.setRight((RBnode)null);
        curr.setPrev((RBnode)null);
        this.root = null;
    }

}
