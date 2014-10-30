import java.util.*;
public class Shriekster extends Enemy {

    public Shriekster () {
	HP = 150.0;
	maxHP = 150.0; //Make this low
	damage =100.0; //High damage
	speed = 5; //Make this slow
	defense = 100; //Tanky
	multiplier = 2.0; //?? Just do whatever
    }
	public void shriek(Player l){
		Random rand = new Random();
		if (rand.nextInt(100) + 1 <= accuracy - 5){
			if (l.HP - (damage * multiplier + 10.0) >= 0){
				System.out.println("The Shriekster's incredible Shrieks deal " + (damage * multiplier + 10.0) + " damage");
				l.HP-=( damage * multiplier + 10.0);
			}
			else{
			System.out.println("The Shriekster's incredible Shrieks deal " + (l.HP) + " damage");
			l.HP = 0;
			}
		}
		else{
		    System.out.println("The Shreikster opens his mouth but the words won't come out. He's choking now...");
	}
}
}
