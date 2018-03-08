
public class Tile {

    boolean FTE = true;
    boolean Room;
    Monster monster;
    Player player;
    Item item;
    Desc RoomL;
    Desc RoomR;
    
    
    public void addMonster(Monster monster) {
        this.monster = monster;
    }
    public void addPlayer(Player player){
    this.player = player;
    }
    public void addItem(Item item){
    this.item = item;
    }
    
    public String toString()
    {      
        String R="   ";
        String L="   ";
        if (RoomR != null){
player_position
            R="[ ]";
        }
        if (RoomL!=null){
            L="[ ]";
        }
        if (player != null){
            return L+"[X]" + R;

            if (RoomR.monster!=null){
        R="[░]";
            }
            else if(RoomR.item!=null){
            R="[Ï]";
            }
            else {
                R="[ ]";
        }
        }
        if (RoomL!=null){
            if (RoomL.monster!=null){
        L="[░]";
            }
            else if(RoomL.item!=null){
            L="[Ï]";
            }
            else{
            L="[ ]";
            }
        }
        if (player != null)
        {
        return L+"[ߐ]" + R;
master
        }
        else if(monster== null){
            return L+"[ ]"+R;
        }
        else {
 player_position
            return L+"[@]" +R;

        return L+"[Ӝ]" +R;
 master
        }
        
        
    }

}
