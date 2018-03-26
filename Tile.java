
public class Tile {

    boolean FTE = true;
    boolean Room;
    Monster monster;
    Player player;
    Weapon weapon;
    Desc RoomL;
    Desc RoomR;
    int Pos;
    
    
    public void addMonster(Monster monster){
        this.monster = monster;
    }
    public void addPlayer(Player player){
        this.player = player;
    }
    public void addItem(Weapon item){
        this.weapon = item;
    }
    
    public void removePlayer(Player player){
        this.player=null;
    }
    
    public String toString() {
        String R="   ";
        String L="   ";
        if (RoomR != null){
            if (RoomR.monster!=null){
                R="[@]";
            }
            else if(RoomR.weapon!=null){
            R="[?]";
            }
            else {
                R="[ ]";
            }
        }
        if (RoomL!=null){
            if (RoomL.monster!=null){
                L="[@]";
            }
            else if(RoomL.weapon!=null){
            L="[?]";
            }
            else{
                L="[ ]";
            }
        }
        if (player != null){
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
