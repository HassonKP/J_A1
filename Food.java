package com.company;
import java.util.Scanner;

/*Name: Killian Hasson      Date: 08/27/2021    Class: CS202
*
* This class is for the food objects each food object has a name, a option for extra info, a price, a next relation and
* a preivous relation with other food objects. This is basically a Doubly linked list node for allowing the menu
* interface to navigate through a DLL.
* */

public class Food {
    private String Name;
    private String extras;
    private double price;
    private Food next;
    private Food previous;

    public Food(String Name, double price){
        this.Name = Name;
        this.price = price;
        this.extras = "";
        this.next = null;
        this.previous = null;
    }

    public Food(Food obj){
        this.Name = obj.Name;
        this.price = obj.price;
        this.extras = obj.extras;
        this.next = null;
        this.previous = null;
    }

    public void setPrevious(Food previous) {
        this.previous = previous;
    }

    public void setNext(Food next) {
        this.next = next;
    }

    public Food getNext() {
        return next;
    }

    public Food getPrevious() {
        return previous;
    }

    public String getName() {
        return Name;
    }

    public double getPrice(){
        return price;
    }

    public void display(){
        String line = this.Name + " Price: " + this.price + this.extras;
        System.out.println(line);
    }

    public String getFood(){
        String line = this.Name + " Price: " + this.price;
        return line;
    }

    public void customize(){
        int resp = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter 1 for Extra protein(2.50 extra), 2 for Extra Sauce(0.50 extra), 3 for other (allergies/enter NA for Not any): ");
        resp = userInput.nextInt();
        if(resp == 1){
            this.extras = "Add protein";
            this.price = this.price + 2.50;
        }
        if(resp == 2){
            this.extras = "Add extra sauces";
            this.price = this.price + 0.50;
        }
        if(resp == 3){
            System.out.print("Enter in your request: ");
            if (userInput.hasNextLine()) {
                this.extras = userInput.nextLine();
            }
        }

    }
}
