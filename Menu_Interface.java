package com.company;

/*This current file is where the array of doubly linked lists is built and managed. The only data member here is a array
* of doubly linked lists. The only real function I implemented in here is the navigate function which calls the DLL
* navigate function in order to traverse through a specific menu of items.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Menu_Interface {
    private Scanner userInput = new Scanner(System.in);
    private ArrayList<FoodDLL> food = new ArrayList<FoodDLL>();

    public Menu_Interface(FoodDLL a, FoodDLL b, FoodDLL c){
    food.add(a);
    food.add(b);
    food.add(c);
    }

    public void DisplayAll(){
        for(int i = 0; i < food.size(); i++){
            if(i == 0){
                System.out.println("American Menu");
            }
            if(i == 1){
                System.out.println("\n");
                System.out.println("Asian Menu");
            }
            if(i == 2){
                System.out.println("\n");
                System.out.println("Mexican Menu");
            }
        food.get(i).display();
        }
    }

    public Food navigate(){
        Food temp;
        int num = 1;
        if(food == null) {
            return null;
        }
        int resp;
        System.out.println("Please enter which menu to browse 1 for American, 2 for Asian, 3 for Mexican: ");
        resp = userInput.nextInt();
        if(resp == 1)
        {
            return temp = food.get(0).navigate();
        }
        if (resp == 2)
        {
            return temp = food.get(1).navigate();
        }
        if (resp == 3)
        {
            return temp = food.get(2).navigate();
        }
        return null;
    }


}
