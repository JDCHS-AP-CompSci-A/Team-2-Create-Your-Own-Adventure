/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner; 

/*
@author kylliefurukawa
*/
public class Menu {
    Scanner sc = new Scanner(System.in); 
    Player new_player; 
    
    Menu(Player new_player){
        this.new_player = new_player; 
    }
    
    public String input_command() { 
    
        String input_command = sc.nextLine();
        
        return input_command; 
    }
    
    public int input_selection() {
        
        int input_selection = sc.nextInt();
        
        return input_selection; 
    }
    
    public void main_menu() {
        System.out.println("What would you like to do? (Type 'HELP' for a list of commands)"); 
        
        String selection = input_command(); 
        
        if (selection.equalsIgnoreCase("HELP")) {
            System.out.println("to view inventory: 'INVENTORY'");
            System.out.println("to move: 'MOVE'"); 
            main_menu(); 
        }
        
        else if (selection.equalsIgnoreCase("INVENTORY")) {
            System.out.println("Here is your inventory: "); 
            System.out.println(new_player.toString()); 
            inventory();
        }
        
        else if (selection.equalsIgnoreCase("MOVE")) {
            //move function 
        }
        
        else {
            System.out.println ("That is not a valid command."); 
            main_menu(); 
        }

    }
    
    public void move_menu() {
        
        System.out.println("Would you like to move 'FOWARD', 'BACKWARDS', or 'ENTER ROOM'?"); 
        
        String selection = input_command(); 
        
        if (selection.equalsIgnoreCase("FOWARD")) {
            //player position++
        }
        
        if (selection.equalsIgnoreCase("BACKWARDS")) {
            //player position--           
        }
        
        if (selection.equalsIgnoreCase("ENTER ROOM")) {
            //check if room
            //call room 
        }
    }
    public void weapon_selection() {
        
        System.out.println("Select your primary weapon:" );
        
        System.out.println(new_player.toString()); 
        int selection = input_selection(); 
        
        if (selection == 1) {
            System.out.println("you selected " + new_player.inventory.get(0).name() + ".");
        }        
    }
    
    public void inventory() {
        System.out.println("Would you like to 'DROP ITEM' or 'USE POTION'?");
        
        String selection = input_command(); 
        if (selection.equalsIgnoreCase("DROP ITEM")) {
            drop_item_menu();          
        }
        
        if (selection.equalsIgnoreCase("USE POTION")) {
            System.out.println("used potion");
            //for future
        }
    }
    
    public void drop_item_menu() {
        
        System.out.println("Which item would you like to drop?");
        new_player.toString(); 
            
        int selection = input_selection(); 
        
        if (selection == 1) {
            new_player.remove_item(1);
        }
        
        //use switch for this 
        
        System.out.println("Here is your new inventory: ");
        new_player.toString(); 
    
             
    }
    
    
}
