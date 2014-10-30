import java.util.*;
public class Player{
	protected static String name;
    protected static double defense;
    protected static double HP;
    protected static double maxHP;
    protected static double damage;
    protected static double multiplier;
    protected static int accuracy;
    protected static int speed;
    
    public static int color;
    //Constructors
	public Player() {
	name = "Trainee";
	maxHP = 3.0;
	HP = 3.0;
	damage = .5;
	multiplier = 1.5;
	accuracy = 85;
	defense = .25;
    }
    public Player(String n, int c) {
	defense = 100.0;
	damage = 100.0;
	name = n;
    color = c;
	accuracy = 95;
	multiplier = 2.0;
	HP = 100.0;
	maxHP = 100.0;
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
	public void attack( Guy c ) {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (c.HP - (damage * multiplier - c.defense) >= 0){
		c.HP-=( damage * multiplier - c.defense);
		System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier - c.defense) + " " + "points of damage to" + " " + c.name);
	    }
	    else{
	    	System.out.println(this.name + " " + "dealt" + " " + c.HP + " " + "points of damage to" + " " + c.name);
		c.HP = 0;
	    }
	}
	else{
	    System.out.println(this.name + " " + "missed!");
	}
    }
    
    public void heal(int x){
	if (x + HP >= maxHP){
	    HP = maxHP;
	}
	else{
	    HP += x;
	}
    }

    public String toString() {
	String s = name + " ";
	s+= "\n" + "HP = " + HP + " ";
	s+= "\n" + "MaxHP = " + maxHP + " ";
	s+= "\n" + "damage = " + damage + " ";
	s+= "\n" + "multiplier = " + multiplier + " ";
	s+= "\n" + "accuracy = " + accuracy + " ";
	return s;
    }

    public void doubleEdge(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (e.HP - damage * multiplier * 1.5 >= 0){
		e.HP-=( damage * multiplier * 1.5);
		System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier * 1.5) + " " + "points of damage to" + " " + e.name);
	    }
	    else{
	    	System.out.println(this.name + " " + "dealt" + " " + e.HP + " " + "points of damage to" + " " + e.name);
		e.HP = 0;
	    }
	    HP -= (damage * multiplier / 4 - defense);
	    System.out.println(this.name + "'s ferocious attack recoiled and did" + " " + (damage * multiplier / 4 - defense) + " " + "points of self inflicted damage (masochist)");
	}
	else{
	    System.out.println(this.name + " " + "missed bad");
	}
	
    }
    
    public void strongAttack(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 10){
	    if (e.HP - ((damage + .5) * multiplier - e.defense) >= 0){
		e.HP-=( (damage + .5) * multiplier - e.defense);
		System.out.println(this.name + " " + "dealt" + " " + ( (damage + .5) * multiplier - e.defense) + " " + "points of damage to" + " " + e.name);
	    }
	    else{
	    	System.out.println(this.name + " " + "dealt" + " " + e.HP + " " + "points of damage to" + " " + e.name);
		e.HP = 0;
	    }
	}
	else{
	    System.out.println(this.name + " " + "missed... :(");
	}	
    }
	
    public void sneakAttack(Guy e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 15){
	    if (e.HP - (damage * multiplier) >= 0){
		e.HP-=( damage * multiplier);
		System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier) + " " + "points of damage to" + " " + e.name);
	    }
	    else{
	    	System.out.println(this.name + " " + "dealt" + " " + e.HP + " " + "points of damage to" + " " + e.name);
		e.HP = 0;
	    }
	}
	else{
	    System.out.println(this.name + " " + "missed... :(");
	}	
    }
}
