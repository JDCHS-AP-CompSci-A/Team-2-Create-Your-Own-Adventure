
public class Monster {
  double health;
  String name;
  double damage;
  double hit_chance;
  
  public double attack() {
       double roll = Math.random();
    
       if (roll >= this.hit_chance) {
           return this.damage;
       }
       else {
           return 0.00;
       }

  }
    
  
}

