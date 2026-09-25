package main.java.Encapsulation.assigment_problems;

public class Character {
    private final int Maxhealth;

    private int health;

    public Character(int Maxhealth){
        this.Maxhealth= Maxhealth;
        this.health=Maxhealth;
    }

    public void takeDamage(int amount){

        health -= amount; 

        if(health < 0){
         health = 0;
        }
         System.out.println("health after damage: "+ health);
      
    }


    public void heal(int amount){

        health += amount;

         if(health >= Maxhealth){
            health=Maxhealth;
         }
         System.out.println("health after heal: "+ health);
    }

    public void health(){
        System.out.println("final health: "+ health);
    }
    public static void main(String[] args){
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
        c.health();
    }
}


