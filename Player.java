/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList; 
/**
 *
 * @author kylliefurukawa
 */
public class Player {
    
    int position = 10; 
    int health = 100;
    int potion_inventory = 0; 
    ArrayList <Weapon> inventory = new ArrayList <Weapon>(); 
    
    
    Player(){ 
    }
    
    public void add_GS(){
        Weapon GodSword = new Weapon("God Sword", 1000, 1000, 100);
    this.inventory.add(GodSword);
    }
            
    /**
     * Adds item to player's weapon inventory
     * @param item the item to be added to the inventory
     */
    public void add_item(Weapon item) {
        inventory.add(item); 
    }
       
    /**
     * Removes an item from the player's weapon inventory
     * @param i the integer selected by player that corresponds with the weapon in inventory
     */
    public void remove_item(int i) {
        inventory.remove(i); 
    }
    
    /**
     * Prints the complete weapon inventory as well as potion count 
     * @return a space after printing inventory
     */
    public String toString() {
        
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i+1) + ".) " + inventory.get(i).name); 
        }
        
        //print "empty" if empty
        if (inventory.size() == 0) {
            System.out.println("(Weapons inventory empty)"); 
        }
        
        System.out.println("Potion count: " + potion_inventory);
        return "  "; 
    }
     
}
