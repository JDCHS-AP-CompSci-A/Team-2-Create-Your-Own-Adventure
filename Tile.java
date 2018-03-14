
public class Tile {

    boolean FTE = true;
    boolean Room;
    Monster monster;
    Player player;
    Item item;
    Desc RoomL;
    Desc RoomR;
    int Pos;
    
    
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
            if (RoomR.monster!=null){
        R="[@]";
            }
            else {
                R="[ ]";
        }
        }
        if (RoomL!=null){
            if (RoomL.monster!=null){
        L="[@]";
            }
            else{
            L="[ ]";
            }
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
