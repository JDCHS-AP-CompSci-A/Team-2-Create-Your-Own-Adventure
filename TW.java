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

        Player new_player = new Player();
        Item test = new Item("Weapons");
        
        
        Weapon weapon = new Weapon("Sword", 40, 25, .3);
        Weapon weapon2= new Weapon("Gun", 55, 45, .6);
        Weapon weapon3= new Weapon("Dagger", 65,53,.8);
        System.out.println(weapon.attack());
        new_player.add_item(weapon);
        new_player.add_item(weapon2);
        Crypt new_crypt = new Crypt();
        Menu new_menu = new Menu(new_player, new_crypt);
        new_player.potion_inventory = 5;

        new_crypt.genWorld();
        new_crypt.fill_cat();
        new_crypt.fill_Rcat();
        new_crypt.printMap();
        new_menu.intro_menu();
    }

}
