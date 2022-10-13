package com.company;
import java.util.Scanner;

/*Name: Killian Hasson      Date: 08/20/21      Class: CS202
*
* Currently this class creates a Doubly linked list of food items from the menus, my navigate function doesnt work as
* intended yet you can navigate through the DLL but it wont always show the first item or the last item unless you
* navigate towards them.
* */

public class FoodDLL {
    Scanner userInput = new Scanner(System.in);
    private Food head;


    public FoodDLL(){
        this.head = null;
    }

    public int add(Menu obj){
        Food temp = null;
        if(head == null) {
            head = new Food(obj.getChoice1(), 2.50);
        }
        if(head != null){
            temp = new Food(obj.getChoice2(), 3.50);
            head.setNext(temp);
            temp.setPrevious(head);
        }
        if(temp != null){
           Food temp2 = new Food(obj.getChoice3(),4.50);
           temp.setNext(temp2);
           temp2.setPrevious(temp);
        }
        return 1;
    }

    public Food navigate(){

        if(head == null){
            System.out.println("This Menu is empty");
            return null;
        }
        return navigate(head);
    }

    public Food navigate(Food head){
        int resp;

        if (head.getPrevious() != null) {
            System.out.println(head.getPrevious().getFood());
        }

        System.out.println(head.getFood() + "<");

        if (head.getNext() != null){
            System.out.println(head.getNext().getFood());
        }


        System.out.println("Enter 1 to order item, 2 for next item, 3 for previous item, 4 to go back to previous menus: ");
        resp = userInput.nextInt();
        if(resp == 1){
            return head;
        }
        if (resp == 2){
            return navigate(head.getNext());
        }
        if (resp == 3){
            return navigate(head.getPrevious());
        }
        if (resp == 4){
            return null;
        }
        return head;
    }


    public void display() {
        if(head == null) {
            System.out.println("Menu is empty!");
            return;
        }
        display(head);
    }

    public void display(Food head){
        if(head == null){
            return;
        }
        if(head != null){
            head.display();
        }
        display(head.getNext());
    }
}
