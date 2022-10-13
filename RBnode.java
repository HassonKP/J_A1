package com.company;
/*Name: Killian Hasson      Date: 08/27/2021    Class: CS202
*
* This class is essentially for "orders" each RBnode represents an order placed by a user, each RBnode will contain a
* food object, a name, a color for making sure heights are adjusted, a previous pointer for checking parental
* relationships, a left and a right relationship to a RBnode as well.
* */

public class RBnode {
    private Food data;
    private String Name;
    private int color;
    private RBnode prev;
    private RBnode left;
    private RBnode right;

    public RBnode(Food temp, String name) {
        this.data = temp;
        this.Name = name;
        this.color = 1;
        this.prev = null;
        this.left = null;
        this.right = null;
    }

    public Food getData() {
        return this.data;
    }

    public String getName(){
        return this.Name;
    }

    public double getPrice(){
        return this.data.getPrice();
    }

    public Food getOrder() {
        return this.data;
    }

    public RBnode getPrev() {
        return this.prev;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public void setData(Food temp) {
        this.data = temp;
    }

    public void setPrev(RBnode pn) {
        this.prev = pn;
    }

    public void setLeft(RBnode lt) {
        this.left = lt;
    }

    public void setRight(RBnode rt) {
        this.right = rt;
    }

    public RBnode getLeft() {
        return this.left;
    }

    public RBnode getRight() {
        return this.right;
    }
}


