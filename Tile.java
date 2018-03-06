
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
    
    public String toString()
    {
        String R="   ";
        String L="   ";
        if (RoomR != null){
        R="[ ]";
        }
        if (RoomL!=null){
        L="[ ]";
        }
        if (player != null)
        {
        return L+"[X]" + R;
        }
        else if(monster== null){
        return L+"[ ]"+R;
        }
        else {
        return L+"[@]" +R;
        }
        
        
    }

}
