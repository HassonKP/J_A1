package com.company;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * All three of the derived menu classes ended up basically being designed with the sole purpose of reading out form
 * their respective menu .txt files. I wanted to include little things in here like "Chopsticks" "Teriyaki sauce" "soy
 * sauce" but ended up really running into issues with the other classes so i had to keep these as is.
 * */

public class MenuAsian extends Menu{
private String choice1;
private String choice2;
private String choice3;

    public MenuAsian(){
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\killi\\IdeaProjects\\PROGRAM4.5\\src\\com\\company\\AsianMenu"));
            choice1 = br.readLine();
            choice2 = br.readLine();
            choice3 = br.readLine();
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public String getChoice1() {
        return choice1;
    }
    @Override
    public String getChoice2() {
        return choice2;
    }
    @Override
    public String getChoice3() {
        return choice3;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    @Override
    public void display(){
        System.out.println("The choices for today's Asian Menu are: ");
        System.out.println(choice1);
        System.out.println(choice2);
        System.out.println(choice3);
    }
}
