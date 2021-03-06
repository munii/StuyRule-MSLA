import java.util.*;

public class Guy {
	
    protected static String name;
    protected static double defense;
    protected static double HP;
    protected static double maxHP;
    protected static double damage;
    protected static double multiplier;
    protected static int accuracy;
    protected static int speed;
    
    public Guy() {
	name = "Trainee";
	maxHP = 75.0;
	HP = 75.0;
	damage = 20.0;
	multiplier = 1.5;
	accuracy = 90;
	defense = 10.0;
    }
    
    public Guy( String n ) {
	name = n;
	maxHP = 75.0;
	HP = 75.0;
	damage = 20.0;
	multiplier = 1.5;
	accuracy = 90;
	defense = 10.0;
    }

   public void attack( Player c) {
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy){
	    if (damage * multiplier - c.defense > 0){
		if (c.HP - (damage * multiplier - c.defense) >= 0){
		    c.HP-=( damage * multiplier - c.defense);
		    System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier - c.defense) + " " + "points of damage to" + " " + c.name);
		}
		else{
		    System.out.println(this.name + " " + "dealt" + " " + c.HP + " " + "points of damage to" + " " + c.name);
		    c.HP = 0;
		}
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

     public void doubleEdge(Player e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 10){
	    if (damage * multiplier * 1.5 - e.defense > 0){
		if (e.HP - (damage * multiplier * 1.5 - e.defense) >= 0){
		    e.HP-=( damage * multiplier * 1.5);
		    System.out.println(this.name + " " + "dealt" + " " + ( damage * multiplier * 1.5 -e.defense) + " " + "points of damage to" + " " + e.name);
		}
		else{
		    System.out.println(this.name + " " + "dealt" + " " + e.HP + " " + "points of damage to" + " " + e.name);
		    e.HP = 0;
		}
	    }
	    if ((damage * multiplier / 4 - defense) > 0){
			HP -= (damage * multiplier / 4 - defense);
			System.out.println(this.name + "'s ferocious attack recoiled and did" + " " + (damage * multiplier / 4 - defense) + " " + "points of self inflicted damage (masochist)");
		    }
	}
	else{
	    System.out.println(this.name + " " + "missed bad");
	}

    }
    
    public void strongAttack(Player e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 20){
	    if ((damage * (multiplier + .5) - e.defense) > 0){
		if (e.HP - (damage * (multiplier + .5) - e.defense) >= 0){
		    e.HP -= (damage * (multiplier + .5) - e.defense);
		    System.out.println(this.name + " " + "dealt" + " " + (damage * (multiplier + .5) - e.defense) + " " + "points of damage to" + " " + e.name);
		}
		else{
		    System.out.println(this.name + " " + "dealt" + " " + e.HP + " " + "points of damage to" + " " + e.name);
		    e.HP = 0;
		}
	    }
	}
	else{
	    System.out.println(this.name + " " + "missed... :(");
	}
    }
	
    public void sneakAttack(Player  e){
	Random rand = new Random();
	if (rand.nextInt(100) + 1 <= accuracy - 20){
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
