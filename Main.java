package com.company;

/*Name: Killian Hasson      Date: 08/27/2021        Class: CS202
This file is a basic main, it does have issues as I am still not good with user input or the use of the Scanner class
* that Java seems to utilize. I ended up working on my main almost last in all honesty I started with it but ended up
* writing basic test code that I commented out and left on the bottom.*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code
        Scanner userInput = new Scanner(System.in);
        int resp = 0;
        int resp3 = 0;
        float resp2 = 0;
        String Name = null;
        MenuAmerican obj = new MenuAmerican();
        MenuAsian obj1 = new MenuAsian();
        MenuMexican obj2 = new MenuMexican();

        FoodDLL obj5 = new FoodDLL();
        obj5.add(obj);
        FoodDLL obj6 = new FoodDLL();
        obj6.add(obj1);
        FoodDLL obj7 = new FoodDLL();
        obj7.add(obj2);

        Menu_Interface test = new Menu_Interface(obj5, obj6, obj7);

        RBTree main = new RBTree();
        do {
            System.out.println("Enter 1 to display all menus, 2 to navigate menus to order, 3 to display all orders, 4 to retrieve an order, 5 to delete all orders, 0 to cancel");
            resp = userInput.nextInt();
            if (resp == 1) {
                test.DisplayAll();
            }
            if (resp == 2) {
                Food temp = test.navigate();
                do {
                    System.out.println("Enter 1 to submit order, 2 to customize order");
                    resp = userInput.nextInt();
                    if (resp == 1) {

                        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
                        System.out.print("Enter a Name: ");
                        Name = sc.nextLine();              //reads string

                        main.insert(temp,Name);
                        System.out.println("Order total: $" + temp.getPrice() + "\n");
                        resp = -1;
                    }
                    if (resp == 2) {
                        temp.customize();
                    }
                } while (resp != -1);
            }
            if(resp == 3){
                main.display();
            }
            if(resp == 4){
                System.out.println("Enter 1 to submit order, 2 to customize order");
                resp2 = userInput.nextFloat();
                RBnode temp2 = main.find(resp2);
                System.out.println("Is your name: " + temp2.getName() + "?(1 for Yes / 2 for No)");
                resp = userInput.nextInt();
                if(resp == 1) {
                    System.out.println("Enter 1 to Customize");
                    resp3 = userInput.nextInt();
                    if(resp3 == 1){
                        temp2.getData().customize();
                    }
                }

            }
            if(resp == 5){
                main.delete();
            }

        } while (resp != 0);
    }
/*
    //TESTING FOR STUFF
    Food temp = new Food("Hot Dog", 3.50);
    Food temp1 = new Food("French Fries", 1.50);
    Food temp2 = new Food("Pizza", 1.45);
    Food temp3 = new Food("Cheese", 2.50);
    Food temp4 = new Food("Steak",23.50);
    Food temp5 = new Food("Carrot", 0.25);
    Food temp6 = new Food("P",5.00);
    Food temp7 = new Food("j", 0.30);
    Food temp8 = new Food("k", 23.50);
    Food temp9 = new Food("Poo", 0.1);

    main.insert(temp,"Name1");
    main.insert(temp1,"Name2");
    main.insert(temp2,"Name3");
    main.insert(temp3,"Name4");
    main.insert(temp4,"Name5");
    main.insert(temp5,"Name6");
    main.insert(temp6,"Name7");
    main.insert(temp7,"Name8");
    main.insert(temp8,"Name9");
    main.insert(temp9,"Name10");

    main.display();

    RBnode test2 = main.find(5.00);
    System.out.println("Name found: " + test2.getName());

    main.delete();
    main.display();
    }*/
}





