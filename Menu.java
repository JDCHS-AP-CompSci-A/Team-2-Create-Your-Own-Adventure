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
    
    Menu(Player new_player, Crypt new_crypt) {
        this.new_player = new_player;
        this.new_crypt = new_crypt; 
    }
    
    //function to type in commands
    public String input_command() { 
        String input_command = sc.nextLine();        
        return input_command; 
    }
    
    //function to type in a numbered selection
    public int input_selection() {       
        String input_selection = sc.nextLine();
        //convert String input_selection to integer
        Integer result = Integer.valueOf(input_selection);
        return result; 
    }
    
    //introduction menu
    public void intro_menu() {
        System.out.println("Introduction in progress");
        System.out.println("'@' = A monster"); 
        System.out.println("'X' = Player position\n");
        main_menu(); 
    }
     
    //main menu commands
    public void main_menu() {
        
        /*if room/tile where player is on has monster, go to battle_menu(), else continue below
        
        if(      ) {
            battle_menu() 
        }
        else {
            continue;
        }
        */
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
        //leads to move menu
        else if (selection.equalsIgnoreCase("MOVE")) {
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
    
    //battle menu
    public void battle_menu() {
        //later will change so that actual monster name is displayed
        System.out.println("A monster has approached you. Would you like to 'ATTACK', 'INSEPCT' the monster, or 'RUN'?");
        
        String selection = input_command(); 

        
        if (selection.equalsIgnoreCase("ATTACK")) {
            if (new_player.inventory.isEmpty()) {
                System.out.println("You do not have any weapons to attack.");
                battle_menu(); 
            }
            else {
                Item selected_weapon = weapon_selection(new_player); 
                //attack menu based on game controller   
            }
        }
        
        else if (selection.equalsIgnoreCase("INSPECT")) {
            //print the description of the monster
            battle_menu();
        }
        
        else if (selection.equalsIgnoreCase("RUN")) {
            System.out.println("You have ran away.");
            main_menu(); 
        }
        
        else {
            System.out.println("That is an invalid command."); 
            battle_menu(); 
        }
    }
    
    //pick up item
    public void pickup_item(Item item) {
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
        
        if (/*monster exists*/) {
            battle_menu();  
      
        }
        if (/*item exists*/) {
            System.out.println("There is a " /*+ Item name */ + "in this room.");
            System.out.println("Would you like to pick up " /*+ Item name */ + "?");
            
            String command = input_command(); 
            
            if (command.equalsIgnoreCase("YES")) {
                pickup_item(item); 
            }
            
            else if (command.equalsIgnoreCase("NO")) {
                room_scenario(); 
            }
            
            else {
                System.out.println("That is an invalid command."); 
            }            
        }
    
        if (/*potion exists*/) {
            System.out.println("There is a potion in this room.");
            System.out.println("Would you like to pick up the potion?"); 
            
            String command = input_command(); 
            
            if (command.equalsIgnoreCase("YES")) {
                add_potion(new_player);
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
    
    //use a potion
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
    //movement menu
    public void move_menu() {
        
        System.out.println("\nWould you like to move 'FOWARD', 'BACKWARDS', or 'ENTER ROOM'?\n"); 
        
        String selection = input_command(); 
        
        //move foward
        if (selection.equalsIgnoreCase("FOWARD")) {
            new_player.position++; 
        }
        
        //move backwards
        if (selection.equalsIgnoreCase("BACKWARDS")) {
            new_player.position--;
        }
        
        //enter room
        if (selection.equalsIgnoreCase("ENTER ROOM")) {                        
            //check if room
            //call room 
            room_scenario(); 
        }
    }
    
    //allows player to select a weapon for battle, will only be called if there is at least on item in inventory
    public Item weapon_selection(Player new_player) {
        int size = new_player.inventory.size(); 

        System.out.println("\nSelect what weapon you want to use: (Input number next to item)" );
        
        Item selected = new Item(); 
        System.out.println(new_player.toString()); 
        int selection = input_selection(); 
        
        //select first item
        if (selection == 1) {
            System.out.println("You selected " + new_player.inventory.get(0).name() + ".");
            selected = new_player.inventory.get(0); 
        }  
        
        //select second item if exist
        else if (selection == 2) {
            if (size >= 2) {
                System.out.println("You selected " + new_player.inventory.get(1).name() + ".");
                selected = new_player.inventory.get(1); 
            }
            else {
                System.out.println("That is an invalid selection.");
                weapon_selection(new_player); 
            }
        }  
        
        //select third item if exist
        else if (selection == 3) {
            if (size >= 3) {
                System.out.println("You selected " + new_player.inventory.get(2).name() + ".");
                selected = new_player.inventory.get(3); 
            }
            else {
                System.out.println("That is an invalid selection.");
                weapon_selection(new_player); 
            }           
        }  
        
        //select fourth item if exist
        else if (selection == 4) {
            if (size >= 4) {
                System.out.println("you selected " + new_player.inventory.get(3).name() + ".");
                selected = new_player.inventory.get(4); 
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
        return selected; 
    }
    
    
    
    //menu to drop an item 
    public void drop_item_menu(Player new_player) {
        
        System.out.println("\nWhich item would you like to drop? (Input number next to item)");
        new_player.toString(); 
            
        int selection = input_selection(); 
        
        //allows player to select a number to drop item
        switch (selection) {
            case 1:
                new_player.remove_item(0);
                break;
            case 2:
                new_player.remove_item(1);
                break;
            case 3:
                new_player.remove_item(2);
                break;
            case 4:
                new_player.remove_item(3);
                break;
            default:
                System.out.println("That is an invalid command.");
                break; 
        }
        
        System.out.println("\nHere is your updated inventory: ");
        new_player.toString(); 
        
        main_menu();    
    }   
    
    //add potion to potion inventory
    public int add_potion(Player new_player) {
        new_player.potion_inventory = new_player.potion_inventory + 1; 
        int potion_count = new_player.potion_inventory;
        return potion_count;
    }
    
    public int subtract_potion(Player new_player) {
        new_player.potion_inventory = new_player.potion_inventory - 1; 
        int potion_count = new_player.potion_inventory;
        return potion_count; 
    }
    
    //basic raise health by 25 
    public int raise_health(Player new_player) {        
        new_player.health = new_player.health +25; 
        return new_player.health;
    }
    
    //basic lower health by 1 
    public int lower_health(Player new_player) {        
        new_player.health --; 
        return new_player.health;
    }
    
    //print the map 
    public void view_map(Crypt new_crypt, Player new_player) {
        new_crypt.printMap();
    } 
}
