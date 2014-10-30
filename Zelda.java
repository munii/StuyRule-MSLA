import java.util.*;
public class Zelda extends Player{
    public Zelda(String n, int c) {
	defense = 50.0;
	damage = 25.0;
	name = n;
        color = c;
	accuracy = 95;
	multiplier = 1.5;
	HP = 200.0;
	speed = 10;
	maxHP = 200.0;
    	if (color == 1) {
    		HP += 20.0;
    		maxHP += 20.0;
    	}
    	else if (color == 2) {
    		damage += 20.0;
    	}
    	else if (color == 3) {
    		speed += 5;
    	}
    	else {
    		defense += 20.0;
    	}
    }
}