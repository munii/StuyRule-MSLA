import java.util.*
public class Door extends Enemy {
    public Door () {
	maxHP = 250.0;
	HP = 250.0;
	accuracy = 95;
	speed = 1;
	damage = 50.0;
	multiplier = 1.0;
    }

    public void fall(Link c) {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 10){
	    if (3 * damage * multiplier - c.defense > 0){
		if (c.HP - (3 * damage * multiplier - c.defense) >= 0){
		    c.HP-=( damage * multiplier - c.defense);
		    System.out.println("Door fell on you to deal" + " " + ( 3 * damage * multiplier - c.defense) + " " + "points of damage");
		}
		else{
		    System.out.println("Door fell on you to deal" + " " + c.HP + " " + "points of damage");
		    c.HP = 0;
		}
	    }
	}
	else{
	    System.out.println("The Door missed a wild charging attack! You're safe... for now...")
	}
    }



}
