/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kylliefurukawa
 */
public class TW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Set up player and first weapon 
        Player new_player = new Player();
        new_player.potion_inventory = 5;
        Weapon first_weapon = new Weapon("Sword", 40, 25, .3);
        new_player.add_item(first_weapon);

        //Set up crypt 
        Crypt new_crypt = new Crypt();
        new_crypt.genWorld();       
        new_crypt.printMap();
        
        //Set up menu 
        Menu new_menu = new Menu(new_player, new_crypt);      
        
        //Begin game 
        new_menu.intro_menu();
    }

}
