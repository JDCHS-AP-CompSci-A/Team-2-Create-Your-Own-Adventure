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
public class Weapon {

    public int durability; //how long the weapon will last 
    public double damage;
    public String name;
    public double hit_chance; //chances of the weapon will make a hit 
    public double roll; //this will roll and determines the hit chances of the weapons

    public Weapon(String name, int durability, double damage, double hit_chance) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.hit_chance = hit_chance;

    }

    /**
     *
     * @return The value will always be 0 if it's not a hit
     */
    public double attack() {
        double roll = Math.random(); //if roll is greater than or equal to the hit chance, it would be a hit
        if (roll >= this.hit_chance) {
            this.durability = this.durability - 1;
            System.out.println("HIT");

            if (this.durability <= 0) { //when the durability goes down to 0 or below 0, your weapon is broken

                System.out.println("Your weapon is broken");
                return 0.00;

            }
            return this.damage;

        } else {
            System.out.println("MISS");

            return 0.00;
        }

    }

    /**
     *
     * @return This will give the signs for weapon's damage and durability
     */
    public String toString() {

        return this.name + " " + "\u2694 " + this.damage + " \u2765 " + this.durability; //adding emoj to represent weapon's damage and durability

    }
}

class Potion {

    Player player;
    int health_recovery = 25;
    String name;

    /**
     *
     * @param player player will consume potion to increase their health
     * @param name name of the potion will be shown for you to pick
     */
    public Potion(Player player, String name) { //constructor for name and player 
        this.player = player;
        this.name = name;
      
    }

    public void consume() { //consume function which help the player to consume health potion to increase their health 
        double new_health = (this.player.health + this.health_recovery);
        System.out.println("You drink a " + this.name + ". Your health recovered from " + this.player.health + " to " + new_health);
        this.player.health += this.health_recovery;
    }

}
