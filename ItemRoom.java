
public class ItemRoom extends Desc {
    public void fill_room(){
    Crypt crypt3 = new Crypt();
    crypt3.fill_Wcat();
    this.item = crypt3.Weapon_db.get(0);    
    }
}
