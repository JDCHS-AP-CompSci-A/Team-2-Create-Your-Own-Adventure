
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author yhuynh
 */
public class Weapon extends Item {

    public int durability;
    public double damage;
    public String name;
    public double hit_chance;

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
            System.out.println("");
            return this.damage;

        } else {
            return 0.00;
        }
    }

    public String toString() {

        return name + " " + 50 + 25 + .5;

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

//class Armour extends Item {
//
//    int defense;
//
//    public Armour(Player player, String name, int defense) {
//        super(player, name);
//        this.defense = defense;
//
//    }
//
//    public void consume() {
//        int player_defense= this.player.defense + this.defense;
//     
//        System.out.println("You wear a " + this.name + ".Your defense goes up from " +this.player.defense + " to " + player_defense );
//        this.player.defense +=defense;
//    }
//    
//}
