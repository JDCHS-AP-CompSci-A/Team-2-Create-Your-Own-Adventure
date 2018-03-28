import java.util.ArrayList;
import java.util.Random;


public class Crypt {
    
    Player new_player = new Player();
    
    ArrayList<Tile> floorplan = new ArrayList<Tile>(); 
    ArrayList<Monster> monster_db = new ArrayList<Monster>();
    ArrayList<Desc> Desc_db = new ArrayList<Desc>();
    ArrayList<Weapon> Weapon_db = new ArrayList<Weapon>();
    public void genWorld(){
        this.fill_cat();
        this.fill_Wcat();
        this.fill_Rcat();
        for (int i = 0; i < 10; i++){
            Random rand = new Random();
            int r = rand.nextInt(10);
            Tile new_tile = new Tile();

            Monster m = null;
            if (r<5){
                int r2 = rand.nextInt(100)+1;
                if (r2<31){
                    m = monster_db.get(7);
                }
                else if (r2>30 && r2<51){
                    m = monster_db.get(0);
                }
                else if (r2>50 && r2<66){
                    m = monster_db.get(1);
                }
                else if (r2>65 && r2<76){
                    m = monster_db.get(2);
                }
                else if (r2>75 && r2<86){
                    m = monster_db.get(4);
                }
                else if (r2>85 && r2<91){
                    m = monster_db.get(5);
                }
                else if (r2>90 && r2<96){
                    m = monster_db.get(3);
                }
                else if (r2>95 && r2<101){
                    m = monster_db.get(6);
                }
                
                

            }  
            new_tile.addMonster(m);
            r = rand.nextInt(10);
            int t = rand.nextInt(3);
            if (r<6) {
            
            }
            else if (r<9){
                int tf = rand.nextInt(2);
                if(tf==0){
                    new_tile.RoomL= this.Desc_db.get(t);
                    new_tile.RoomL.fill_room();
                }
                else {
                    new_tile.RoomR= this.Desc_db.get(t);
                    new_tile.RoomR.fill_room();
                }
            }
            else{
                new_tile.RoomL=this.Desc_db.get(t);
                new_tile.RoomR=this.Desc_db.get(t);
                new_tile.RoomR.fill_room();
                new_tile.RoomL.fill_room();
            }
            new_tile.Pos=i;
            floorplan.add(new_tile);
        }
        Tile new_tile = new Tile();
        new_tile.addPlayer(new_player);
        floorplan.add(new_tile);
    }
    
    /**
     * Physically move player forward to next tile 
     * @param new_player the current player 
     * @param i new position of the player  
     */
    public void move_foward(Player new_player, int i) { 
        floorplan.get(i).addPlayer(new_player);
        floorplan.get(i+1).removePlayer(new_player);     
    }
    
    /**
     * Physically move player back a tile
     * @param new_player the current player
     * @param i new position of the player
     */
    public void move_backward(Player new_player, int i) {
        floorplan.get(i).addPlayer(new_player);
        floorplan.get(i-1).removePlayer(new_player);
    }
    
    public void fill_cat(){
        this.monster_db.add(new Skeleton());
        this.monster_db.add(new Zombie());
        this.monster_db.add(new Spider());
        this.monster_db.add(new Spirit());
        this.monster_db.add(new Goblin());
        this.monster_db.add(new Imp());
        this.monster_db.add(new Ghoul());
        this.monster_db.add(new Slime());
    }
    
    public void fill_Rcat(){
        this.Desc_db.add(new EmptyRoom());
        this.Desc_db.add(new MonsterRoom());
        this.Desc_db.add(new ItemRoom());
    
    }
    public void fill_Wcat(){
        Weapon GodSword = new Weapon("God Sword", 1000, 1000, .3);
        this.Weapon_db.add(GodSword);
    }
    
    /**
     * Prints the crypt tile by tile with any player/monster on the tile
     */
    public void printMap(){
        for (int i = 0; i<this.floorplan.size(); i++){
            Tile tile = this.floorplan.get(i);
            System.out.println(tile);
        }
    }
}
