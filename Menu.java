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
    
    private Scanner sc = new Scanner(System.in); 
    private Player new_player; 
    private Crypt new_crypt = new Crypt(); 
    
    /**
     * Constructor takes in a player and a crypt
     * @param new_player the same player used throughout the game 
     * @param new_crypt the same crypt created and used throughout the game 
     */
    Menu(Player new_player, Crypt new_crypt) {
        this.new_player = new_player;
        this.new_crypt = new_crypt; 
    }
    
    /**
     * Takes in a string (command) that player types in 
     * @return the string typed in by player
     */
    public String input_command() { 
        String input_command = sc.nextLine();        
        return input_command; 
    }
    
    /**
     * Takes in and return an integer that player types in (string because player must type 'enter') 
     * @return the integer typed in by player
     */
    public int input_selection() {       
        String input_selection = sc.nextLine();
        //convert String input_selection to integer
        Integer result = Integer.valueOf(input_selection);
        return result; 
    }
    
    /**
     * Prints introduction, then goes to main_menu()
     */
    public void intro_menu() {
        System.out.println("introduction in progress");
        System.out.println("'@' = a monster"); 
        System.out.println("'X' = player position\n");
        main_menu(); 
    }
    
    /**
     * Checks if there is a monster on the tile that the player is on
     * @param new_player same player used throughout the game
     * @param new_crypt same crypt created and used 
     * @return whether a monster exists or not (true = monster exists) 
     */
    public boolean check_if_monster(Player new_player, Crypt new_crypt) {
        
        int i = new_player.position;
        Tile new_tile = new_crypt.floorplan.get(i);
        
        if (new_tile.monster == null) {
            return false;
        }
        return true;        
    }
    
    public boolean check_if_weapon(Player new_player, Crypt new_crypt) {
        
        int i = new_player.position;
        Tile new_tile = new_crypt.floorplan.get(i);
        
        if (new_tile.weapon == null) {
            return false; 
        }
        
        return true; 
    }
    
    /**
     * Main menu that allows player to input a variety of commands when passive
     */
    public void main_menu() {
        
       
        
        System.out.println(" \nWhat would you like to do? (Type 'HELP' for a list of commands)\n"); 
        
        String selection = input_command(); 
        
        //displays help menu
        if (selection.equalsIgnoreCase("HELP")) {
            System.out.println("\nTo view inventory: 'INVENTORY'");
            System.out.println("To view map: 'MAP'"); 
            System.out.println("To move: 'MOVE'"); 
            System.out.println("To drop an item: 'DROP ITEM'"); 
            System.out.println("To use a potion: 'USE POTION'"); 
            main_menu(); 
        }
        
        //leads to inventory menu
        else if (selection.equalsIgnoreCase("INVENTORY")) {
            System.out.println("\nHere is your inventory: "); 
            System.out.println(new_player.toString()); 
            main_menu();
        }
        
        else if (selection.equalsIgnoreCase("MAP")) {
            System.out.println("\nHere is the map:\n"); 
            view_map(new_crypt); 
            main_menu(); 
        }
        //leads to move menu, only if no monster.
        else if (selection.equalsIgnoreCase("MOVE")) {
            if (check_if_monster(new_player, new_crypt)) {
                battle_menu(new_crypt.floorplan.get(new_player.position).monster,new_player.position);          
            }
            move_menu(); 
        }
        
        //allows player to drop an item if inventory has items
        else if (selection.equalsIgnoreCase("DROP ITEM")) {
             if (new_player.inventory.isEmpty()) {
                System.out.println("Your inventory is empty. You have no items to drop.");
                main_menu(); 
            }
             
            else {
                drop_item_menu(new_player);    
            }
        }
        
        //allows player to use a potion
        else if (selection.equalsIgnoreCase("USE POTION")) {
            use_potion();          
        }
        
        //rejects any other commands player attempts to input
        else {
            System.out.println ("That is not a valid command."); 
            main_menu(); 
        }

    }
    
    /**
     * Sequence to attack the monster, display the description, or to run away. 
     * @param monster the  monster on the current tile the player is on
     * @param pos the integer of the position of the player
     */
    public void battle_menu(Monster monster,int pos) {

        System.out.println("There is a monster. Would you like to 'ATTACK', 'INSPECT', or 'RUN'?");
        
        String selection = input_command(); 

        
        if (selection.equalsIgnoreCase("ATTACK")) {
            if (new_player.inventory.isEmpty()) {
                System.out.println("You do not have any weapons to attack.");
                battle_menu(monster,pos); 
            }
            else {
                Weapon selected_weapon = weapon_selection(new_player);
                double damag = selected_weapon.attack();
                monster.health = monster.health-damag;
                
                //when monster is dead, remove monster from tile and award player with a potion
                if (monster.health<0){
                    new_crypt.floorplan.get(pos).monster = null; 
                    System.out.println("You have killed the monster and gained 1 potion.");
                    add_potion(new_player);
                    main_menu();
                }
                
                else {
                   battle_menu(monster,pos);
                }
            }
        }
        
        else if (selection.equalsIgnoreCase("INSPECT")) {
            //print the description of the monster
            System.out.println(monster.name);
            System.out.println("Health: " + monster.health);
            battle_menu(monster,pos);
        }
        
        else if (selection.equalsIgnoreCase("RUN")) {
            System.out.println("You have ran away.");
            main_menu(); 
        }
        
        else {
            System.out.println("That is an invalid command."); 
            battle_menu(monster,pos); 
        }
    }
    
    /**
     * Adds a weapon to player inventory of weapons
     * @param item the item that the player is going to pick up 
     */
    public void pickup_item(Weapon item) {
        new_player.add_item(item);
    }
    
    //ask to inspect room or leave
    public void room_scenario() {
        
        System.out.println("\nWould you like to 'INSPECT ROOM' or 'LEAVE'?\n");
        
        String command = input_command(); 
        
        if (command.equalsIgnoreCase("INSPECT ROOM")) {
            //items + descriptions and room descriptions 
            inspect_room_menu(); 
        }
        
        else if (command.equalsIgnoreCase("LEAVE")) {
            //go to hall 
        }
        
        else {
            System.out.println("That is an invalid command."); 
            room_scenario(); 
        }
        
    }
    
    //inspect room, if monster, item, or potion exists battle or asks to pick up
    public void inspect_room_menu () {
        
        int i = new_player.position;
        Tile new_tile = new_crypt.floorplan.get(i);
        
        if (check_if_monster(new_player, new_crypt)) {
            battle_menu(new_crypt.floorplan.get(new_player.position).monster,new_player.position);  
      
        }
        if (check_if_weapon(new_player, new_crypt)) {
            System.out.println("There is a " + new_tile.weapon.name + "in this room.");
            System.out.println("Would you like to pick up " + new_tile.weapon.name + "?");
             
            String command = input_command(); 
            
            if (command.equalsIgnoreCase("YES")) {
                new_player.add_item(new_tile.weapon); 
            }
            
            else if (command.equalsIgnoreCase("NO")) {
                room_scenario(); 
            }
            
            else {
                System.out.println("That is an invalid command."); 
            }            
        }
    
        room_scenario(); 
    }
    
    /**
     * Raises player health by 25 and lowers potion count by 1 
     * Ensures that potion can be used only when there are potions
     */
    public void use_potion() {
        if (new_player.potion_inventory > 0) {
            System.out.println("\nA potion has been used.");
           
            //basic health count where health +25 
            raise_health(new_player); 
            subtract_potion(new_player); 
            System.out.println("Health: " + new_player.health);
            main_menu(); 
        }
            
        else {
            System.out.println("\nYou do not have any potions to use.\n");
            main_menu();
        }
    }
    
    /**
     * Allows player to move forward, backwards, or enter a room
     */
    public void move_menu() {
        
        System.out.println("\nWould you like to move 'FORWARD', 'BACKWARDS', or 'ENTER ROOM'?\n"); 
        
        String selection = input_command(); 
        
        //move forward
        if (selection.equalsIgnoreCase("FORWARD")) {
            if (new_player.position > 0) {
                new_player.position--;
                new_crypt.move_foward(new_player, new_player.position);
                view_map(new_crypt);
                main_menu();
            }
            
            else {
                System.out.println("You have made it to the end of the hall.");
            }
        }
        
        //move backwards
        if (selection.equalsIgnoreCase("BACKWARDS")) {
            //check to make sure that can move backwards (not at beginning of hall) 
            if (new_player.position < 10) {
                new_player.position++;
                new_crypt.move_backward(new_player, new_player.position);
                view_map(new_crypt);
                main_menu();
            }  
            
            else {
                System.out.println("You are at the beginning of the hall. You cannot move back.");
                move_menu();
            }
        }
        
        //enter room
        if (selection.equalsIgnoreCase("ENTER ROOM")) {                        
            if (check_if_room(new_player, new_crypt)) {
                room_scenario(); 
            }            
        }
        
        else {
            System.out.println("That is an invalid command. Please try again.");
            move_menu();
        }
    }
    
    /**
     * Checks to see if a room exists directly adjacent to player
     * @param new_player the same player used throughout the game 
     * @param new_crypt the same crypt used throughout the game 
     * @return whether or not the room exists (true = room exists)
     */
    public boolean check_if_room(Player new_player, Crypt new_crypt) {
        int i = new_player.position;
        Tile new_tile = new_crypt.floorplan.get(i);
        
        boolean room_exists = false;
        if (new_tile.RoomL != null) {
            room_exists = true;
        }
        
        if (new_tile.RoomR != null) {
            room_exists = true;
        }
        return room_exists;  
    }
    
    /**
     * Allows player to select a weapon, will only be called if inventory is not null
     * @param new_player the same player used throughout the game 
     * @return the weapon selected
     */
    public Weapon weapon_selection(Player new_player) {
        int size = new_player.inventory.size(); 

        System.out.println("\nSelect what weapon you want to use: (Input number next to item)" );
        
        Weapon selected; 
        System.out.println(new_player.toString()); 
        int selection = input_selection();
        
        
        //select first item
        if (selection == 1) {
            System.out.println("You selected " + new_player.inventory.get(0).name + ".");
            selected = new_player.inventory.get(0);
            return selected;
        }  
        
        //select second item if exist
        else if (selection == 2) {
            if (size >= 2) {
                System.out.println("You selected " + new_player.inventory.get(1).name + ".");
                selected = new_player.inventory.get(1); 
                return selected;
            }
            else {
                System.out.println("That is an invalid selection.");
                weapon_selection(new_player);                 
            }
        }  
        
        //select third item if exist
        else if (selection == 3) {
            if (size >= 3) {
                System.out.println("You selected " + new_player.inventory.get(2).name + ".");

                selected = new_player.inventory.get(3); 

                return selected;
            }
            else {
                System.out.println("That is an invalid selection.");
                weapon_selection(new_player);   
            }           
        }  
        
        //select fourth item if exist
        else if (selection == 4) {
            if (size >= 4) {
                System.out.println("you selected " + new_player.inventory.get(3).name + ".");

                selected = new_player.inventory.get(4); 

                return selected;
            }
            else {
                System.out.println("That is an invalid selection.");
                weapon_selection(new_player); 
            }                 
        }  
        
        else {
            System.out.println("That is an invalid selection.");
            weapon_selection(new_player); 
        }
        return null;
         
    }
    
    /**
     * Allows player to drop an item from inventory (cannot drop if inventory empty) 
     * @param new_player the same player used throughout the game 
     */
    public void drop_item_menu(Player new_player) {
        
        int size = new_player.inventory.size(); 
        
        System.out.println("\nWhich item would you like to drop? (Input number next to item)");
        new_player.toString(); 
            
        int selection = input_selection(); 
        
        //allows player to select a number to drop item
        if (selection == 1) {
            if (size >= 1) {
                new_player.remove_item(0);
            }
            
            else {
                System.out.println("That is an invalid command.");
            }
        }
        
        else if (selection == 2) {
            if (size >= 2) {
                new_player.remove_item(1);
            }
            
            else {
                System.out.println("That is an invalid command.");
            }
        }
        
        else if (selection == 3) {
            if (size >= 3) {
                new_player.remove_item(2);
            }
            
            else {
                System.out.println("That is an invalid command.");
            }
        }
        
        else if (selection == 4) {
            if (size >= 4) {
                new_player.remove_item(3);
            }
            
            else {
                System.out.println("That is an invalid command.");
            }
        }
       
        else {            
            System.out.println("That is an invalid command.");
        }
        
        System.out.println("\nHere is your updated inventory: ");
        new_player.toString(); 
        
        main_menu();    
    }   
    
    /**
     * Adds a potion to the potion inventory by integer count
     * @param new_player the same player used throughout the game 
     * @return the updated potion count
     */
    public int add_potion(Player new_player) {
        new_player.potion_inventory = new_player.potion_inventory + 1; 
        int potion_count = new_player.potion_inventory;
        return potion_count;
    }
    
    /**
     * Subtracts a potion from the potion inventory by integer count
     * Will only be called when potions exist
     * @param new_player the same player used throughout the game 
     * @return the updated potion count
     */
    public int subtract_potion(Player new_player) {
        new_player.potion_inventory = new_player.potion_inventory - 1; 
        int potion_count = new_player.potion_inventory;
        return potion_count; 
    }
    
    /**
     * Raises the player health by double count (25 at a time) 
     * @param new_player the same player used throughout the game 
     * @return the updated health count 
     */
    public double raise_health(Player new_player) {        
        new_player.health = new_player.health +25; 
        return new_player.health;
    }
    
    /**
     * Lowers the player health by double count (1 at a time)
     * @param new_player the same player used throughout the game 
     * @return the updated health count
     */
    public double lower_health(Player new_player) {        
        new_player.health --; 
        return new_player.health;
    }
    
    /**
     * Prints the crypt, includes floor plan, player, and monsters
     * @param new_crypt the same crypt used throughout the game 
     */
    public void view_map(Crypt new_crypt) {
        new_crypt.printMap();
    } 
}
