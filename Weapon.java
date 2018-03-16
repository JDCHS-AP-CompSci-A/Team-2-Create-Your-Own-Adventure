/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.util.ArrayList;
import java.lang.*;

/**
*
* @author yhuynh
*/
public class Weapon  {

   public int durability;
   public double damage;
   public String name;
   public double hit_chance;
   public double roll;

   public Weapon(String name, int durability, double damage, double hit_chance) {
       this.name = name;
       this.damage = damage;
       this.durability = durability;
       this.hit_chance = hit_chance;
     
   }

   public double attack() {
       double roll = Math.random();
       if (roll >= this.hit_chance) {
           this.durability = this.durability - 1;
           System.out.println("HIT");

           if (this.durability <= 0) {

               System.out.println("Your weapon is broken");
               return 0.00;
              
           }
           return this.damage;

       } else {
           System.out.println("MISS");
           return 0.00;
       }

   }

   public String toString() {

       return this.name + " " + "\u2694 " + this.damage + " \u2765 " + this.durability;

   }
}

class Potion {

   Player player;
   int health_recovery = 25;
   String name;

   public Potion(Player player, String name) {
       this.player = player;
       this.name = name;
   }

   public void consume() {
       int new_health = this.player.health + this.health_recovery;
       System.out.println("You drink a " + this.name + ". Your health recovered from " + this.player.health + " to " + new_health);
       this.player.health += this.health_recovery;
   }

}