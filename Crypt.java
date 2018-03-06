import java.util.ArrayList;
import java.util.Random;


public class Crypt {
    ArrayList<Tile> floorplan = new ArrayList<Tile>(); 
    ArrayList<Monster> monster_db = new ArrayList<Monster>();
    ArrayList<Desc> Desc_db = new ArrayList<Desc>();
    public void genWorld(){
        this.fill_cat();
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
            if (r<6) {
            
            }
            else if (r<9){
            int tf = rand.nextInt(2);
            if(tf==0){
                new_tile.RoomL= this.Desc_db.get(r);
            }
            else {
                new_tile.RoomR= this.Desc_db.get(r);
            }
            }
            else{
            new_tile.RoomL=this.Desc_db.get(r);
            new_tile.RoomR=this.Desc_db.get(r);
            }
            floorplan.add(new_tile);
        }
        Tile new_tile = new Tile();
        Player player = new Player();
        new_tile.addPlayer(player);
        floorplan.add(new_tile);
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
    for (int i = 0; i<10; i++){
            EmptyRoom BlankRoom = new EmptyRoom();
            this.Desc_db.add(BlankRoom);
        }
    }
    public void printMap(){
    for (int i = 0; i<this.floorplan.size(); i++){
            Tile tile = this.floorplan.get(i);
            System.out.println(tile);
        }
}
}
