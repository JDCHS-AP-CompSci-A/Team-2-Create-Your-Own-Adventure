 import java.util.Random;
public class MonsterRoom extends Desc {
   
    public void fill_room(){
        Monster m = null;
        Random rand= new Random();
int r2 = rand.nextInt(100)+1;
Crypt crypt2 = new Crypt();
                if (r2<31){
                m = crypt2.monster_db.get(7);
                }
                else if (r2>30 && r2<51){
                m = crypt2.monster_db.get(0);
                }
                else if (r2>50 && r2<66){
                m = crypt2.monster_db.get(1);
                }
                else if (r2>65 && r2<76){
                m = crypt2.monster_db.get(2);
                }
                else if (r2>75 && r2<86){
                m = crypt2.monster_db.get(4);
                }
                else if (r2>85 && r2<91){
                m = crypt2.monster_db.get(5);
                }
                else if (r2>90 && r2<96){
                m = crypt2.monster_db.get(3);
                }
                else if (r2>95 && r2<101){
                m = crypt2.monster_db.get(6);
                }

}
}
