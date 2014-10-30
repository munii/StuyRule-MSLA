import java.util.*;
public class Doorfight {
	public void doorbattle(Player l, Door m) {
		System.out.println("You Stand before the almighty door, the sole obstacle in your path");
		System.out.println("..."); 
		System.out.println("I will destroy you Door!"); 
		System.out.println("...");
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		while (l.HP != 0.0 && m.HP != 0.0) { //placeholder HP
			String LinkHP = "Your HP:" + l.HP + "/" + l.maxHP;
			String EnemyHP = "Enemy's HP:" + m.HP + "/" + m.maxHP;
			System.out.println (LinkHP);
			System.out.println (EnemyHP);
			System.out.println ("What will you do? Enter the number that corresponds to the action of your choice");
			System.out.println ("1. Attack");
			System.out.println ("2. Double-Edged Swing"); //Should we incorporate explanations of theses actions somehow?
			System.out.println ("3. Strong Attack");
			System.out.println ("4. Sneak Attack");
			//System.out.println ("5. Use Item");
			int x = sc.nextInt();
			//Runtime.getRuntime().exec("clear");
			//System.out.print("\033\143");
			for (int i = 0; i < 150; i++){
				System.out.println("\b");
			}
			if (x == 1) {
			l.attack(m);
			}
			else if (x == 2) {
			l.doubleEdge(m);
			}
			else if (x == 3) {
			l.strongAttack(m);
			}
			else{
			l.sneakAttack(m);
			}//There should be items usage here but Im not sure what to do for it right now
			int thing = r.nextInt(99);
			if (thing <= 26) {
			  m.fall(l);
			  }
			else {m.attack (l);
			}
			}
		if (l.HP == 0) {
			System.out.println("Game Over");
			System.out.println("You Lose");
			//Can add more depending on if there is a save function
			System.exit(0);
			}
		else {
			System.out.println("The Door lies shattered at your feet");
			System.out.println("...");
			}
		}
	}
			
			
	
