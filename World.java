import java.util.ArrayList;
import java.util.Scanner;

public class World {

        // Print title screen and introduction text
        void titleScreen() {
            System.out.println("+-----------------+");
            System.out.println("| s t u y r u l e |");
            System.out.println("+-----------------+");
            System.out.println();
            System.out.println("Muni | Sean | Lucas");
            System.out.println("Pro Animis Potestateque Sapientiaque");
            System.out.println();
        }

        // Special commands

        // Load player inventory
        static Inventory inventory = new Inventory();
    
    
        // Start game
         void roomOne(Link l, Zelda z) {
			Battle b = new Battle();
			Doorfight d = new Doorfight();
			//Chair chair = new Chair();
			//Chair chair = new Chair();
			//Door Frank = new Door();
			//Teacher teacher = new Teacher();
            // Load room one
            Room roomOne = new Room();
            roomOne.setIndex(1);
            roomOne.setName("Homeroom");
            roomOne.setDescription("You've just entered your homeroom. There are other freshmen in here who are just as stringy looking as you are.");
            roomOne.setCount(1);
            ArrayList<String> roomOneItems = new ArrayList<String>();
	    ArrayList<String> roomOneEnemies = new ArrayList<String>();
            roomOneItems.add("Pencil");
            roomOneItems.add("Red Bull");
	    roomOneEnemies.add("chair");
	    roomOneEnemies.add("teacher");
	    roomOne.setEnemies(roomOneEnemies);
            roomOne.setItems(roomOneItems);

            // Display room one description and items
            System.out.println(roomOne.getDescription());
            roomOne.printItems(roomOneItems);
	    roomOne.printEnemies(roomOneEnemies);

            // Get input and play room 1
            String input = Stuyrule.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomOne.getDescription());
                    roomOne.printItems(roomOneItems);
		    roomOne.printEnemies(roomOneEnemies);
                }
                // Get ID
                else if (input.equals("get pencil")
                        && roomOneItems.contains("Pencil")) {
                    roomOneItems.remove("Pencil");
                    this.inventory.add("Pencil");
                } 
		else if (input.equals("get pencil")
                        && !roomOneItems.contains("Pencil")) {
                    System.out.println("You already have a pencil!!");
                }
	    
                // Get Schedule
                else if (input.equals("get red bull")
                        && roomOneItems.contains("Red Bull")) {
                    roomOneItems.remove("Red Bull");
                    this.inventory.add("Red Bull");
                } 
		else if (input.equals("get red bull")
                        && !roomOneItems.contains("Red Bull")) {
                    System.out.println("You already have Red Bull...");
                }
		
		else if (input.equals("use Red Bull") || input.equals("look Red Bull")
                        || input.equals("eat Red Bull")) {
                    if (Stuyrule.gender == 1) {
			System.out.println("You received wings, but not really, you got a bit faster.");
			l.speed *= 1.5;
		    }
		    else if (Stuyrule.gender == 2) {
			System.out.println("You received wings, but not really, you got a bit faster.");
			z.speed *= 1.5;
		    }
		}

                else if (input.equals("leave")) {
		     Door Frank = new Door();
		     if (roomOneItems.contains("Pencil")) {
			     System.out.println("You'll need a weapon... at least grab that pencil!");
			 }
			 else {
			     if (Stuyrule.gender == 1) {
			 d.doorbattle(l, Frank);
			     }
			 else if (Stuyrule.gender == 2){
			 d.doorbattle(z, Frank);
				    }
                         this.roomTwo(l,z);
			 }
		}
			 
	       
		else if (input.equals("fight chair")) {
		    if (roomOneItems.contains("Pencil")){
			     System.out.println("You'll need a weapon... at least grab that pencil!");
			 }
			 else {
			if ( !roomOneEnemies.contains ("chair")) {
				System.out.println("You have already defeated chair!");
					}
				else {
					Chair chair = new Chair();
				    if (Stuyrule.gender == 1) {
					//Chair chair = new Chair();
					b.battle(l, chair);
				    }
				    else if (Stuyrule.gender == 2){
					//Chair chair = new Chair();
					b.battle(z, chair);
				    }
					roomOneEnemies.remove("chair");
				}
			 }
		}
	 	     			
	       
		else if (input.equals("fight teacher")) {
		    if (roomOneItems.contains("Pencil")){
			     System.out.println("You'll need a weapon... at least grab that pencil!");
			 }
			    else {
				if (!roomOneEnemies.contains ("teacher")) {
				System.out.println("You have already defeated teacher!");
					}
				else {
					Teacher teacher = new Teacher();
					if (Stuyrule.gender == 1) {
					b.battle(l, teacher);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, teacher);
				    }
					roomOneEnemies.remove("teacher");
				}
					roomOneEnemies.remove("teacher");
			    }
		}
		 
                // Catch-all for unavailable actions
                else if (!Stuyrule.isGameCommand(input)) {
                    System.out.println("Silly freshman.");
                }
                input = Stuyrule.getInput();
            }

	 }

void roomTwo(Link l, Zelda z) {
    Battle b = new Battle();
    Shriekster Lost = new Shriekster();
    Shrieksterfight sfight = new Shrieksterfight();
            // Load room two
            Room roomTwo = new Room();
            roomTwo.setIndex(2);
            roomTwo.setName("Math Classroom");
            roomTwo.setDescription("Welcome to room 313, the Pre-Calculus Classroom. You're certainly some sort of genius to be here, you smelly freshman. Of course, the scent of chalk overwhelms your pungent aroma, but it is pure Japanese chalk, unlike you. ");
            roomTwo.setCount(1);
            ArrayList<String> roomTwoItems = new ArrayList<String>();
	    ArrayList<String> roomTwoEnemies = new ArrayList<String>();
            roomTwoItems.add("Bruce Lee Poster");
            roomTwoItems.add("Calculator");
            roomTwo.setItems(roomTwoItems);
	    roomTwoEnemies.add("Math Tribal Master");
	    roomTwoEnemies.add("Halls Cough Drop");
	    roomTwo.setEnemies(roomTwoEnemies);
            roomTwo.setItems(roomTwoItems);

            // Display room one description and items
            System.out.println(roomTwo.getDescription());
            roomTwo.printItems(roomTwoItems);

            // Get input and play room 2
            String input = Stuyrule.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomTwo.getDescription());
                    roomTwo.printItems(roomTwoItems);
                }
                // Get note
                else if (input.equals("get poster")
                        && roomTwoItems.contains("Bruce Lee Poster")) {
                    roomTwoItems.remove("Bruce Lee Poster");
                    this.inventory.add("Bruce Lee Poster");
                } else if (input.equals("get poster")
                        && !roomTwoItems.contains("Bruce Lee Poster")) {
                    System.out.println("You already have the poster...");
                }
                // Mess with poster
                else if (input.equals("use poster") || input.equals("look poster")
                        || input.equals("eat poster")) {
                    if (Stuyrule.gender == 1) {
			System.out.println("A Math Creature awakens from the shadows...");
			sfight.shriekingfight(l, Lost);
		    }
		    else if (Stuyrule.gender == 2) {
			System.out.println("A Math Creature awakens from the shadows...");
			sfight.shriekingfight(z, Lost);
		    }
			    
                }

			else if (input.equals("fight halls")) {
			if ( !roomTwoEnemies.contains ("Halls Cough Drop")) {
				System.out.println("You have already defeated the halls cough drop!");
					}
			//Chair chair = new Chair();
				else {
				    HallsCoughDrop h = new HallsCoughDrop();
				    if (Stuyrule.gender == 1) {
					b.battle(l, h);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, h);
				    }
					roomTwoEnemies.remove("Halls Cough Drop");
				}
			}

			else if (input.equals("fight tribal master")) {
			if ( !roomTwoEnemies.contains ("Math Tribal Master")) {
				System.out.println("You have already defeated chair!");
					}
			//Chair chair = new Chair();
				else {
					MathTribalMaster mtm = new MathTribalMaster();
				    if (Stuyrule.gender == 1) {
					b.battle(l, mtm);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, mtm);
				    }
					roomTwoEnemies.remove("Math Tribal Master");
				}
			}

                // Get calculator
                else if (input.equals("get calculator")
                        && roomTwoItems.contains("Calculator")) {
                    roomTwoItems.remove("Calculator");
                    this.inventory.add("Calculator");
                } else if (input.equals("get calculator")
                        && !roomTwoItems.contains("Calculator")) {
                    System.out.println("You already have the calculator...");
                }
	    
		else if (input.equals("use calculator") || input.equals("look calculator")
                        || input.equals("eat calculator")) {
                    if (Stuyrule.gender == 1) {
			System.out.println("The purity of Math fills you with defense...");
			l.defense *= 2;
		    }
		    else if (Stuyrule.gender == 2) {
			System.out.println("The purity of Math fills you with defense...");
			z.defense *= 2;
		    }
			    
                }

                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomThree(l,z);
                }// Leave to room 3 code goes here

                // Catch-all for unavailable actions
                else if (!Stuyrule.isGameCommand(input)) {
                    System.out.println("You can't do that.");
                }

                input = Stuyrule.getInput();
            }

}

 void roomThree(Link l, Zelda z) {
Battle b = new Battle();
            // Load room two
            Room roomThree = new Room();
            roomThree.setIndex(3);
            roomThree.setName("Cafeteria");
            roomThree.setDescription("Welcome to the Cafeteria, you're only here because you're broke and the line at Ferry's is too long. The cafeteria food isn't as bad as you think it is, but the unrelenting hyperbole maximizes its stench. Kids sit in their cliques and you grab a nearby seat next to some drooling sophomore.");
            roomThree.setCount(1);
            ArrayList<String> roomThreeItems = new ArrayList<String>();
	    ArrayList<String> roomThreeEnemies = new ArrayList<String>();
            roomThreeItems.add("Spork");
            roomThreeItems.add("Milk");
            roomThree.setItems(roomThreeItems);
	    roomThreeEnemies.add("Vomit Pile");
	    roomThreeEnemies.add("Halls Cough Drop v2.0");
	    roomThree.setEnemies(roomThreeEnemies);
            roomThree.setItems(roomThreeItems);

            // Display room one description and items
            System.out.println(roomThree.getDescription());
            roomThree.printItems(roomThreeItems);

            // Get input and play room 2
            String input = Stuyrule.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomThree.getDescription());
                    roomThree.printItems(roomThreeItems);
		    roomThree.printEnemies(roomThreeEnemies);
                }
                 // Get note
                else if (input.equals("get spork")
                        && roomThreeItems.contains("Spork")) {
                    roomThreeItems.remove("Spork");
                    this.inventory.add("Spork");
                } else if (input.equals("get spork")
                        && !roomThreeItems.contains("Spork")) {
                    System.out.println("You already have the spork...");
                }
	    
                // Mess with poster
                else if (input.equals("use spork") || input.equals("look spork")
                        || input.equals("eat spork")) {
                    if (Stuyrule.gender == 1) {
			System.out.println("Plastic tastes good, doesn't it? At least you can fight better.");
			l.damage *= 1.8;
		    }
		    else if (Stuyrule.gender == 2) {
			System.out.println("Plastic tastes good, doesn't it? At least you can fight better.");
			z.damage *= 1.8;
		    }
		}
			    

			else if (input.equals("fight halls")) {
			if ( !roomThreeEnemies.contains ("Halls Cough Drop V2.0")) {
				System.out.println("You have already defeated the halls cough drop!");
					}
			//Chair chair = new Chair();
				else {
				    HallsCoughDrop h = new HallsCoughDrop();
				    if (Stuyrule.gender == 1) {
					b.battle(l, h);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, h);
				    }
					roomThreeEnemies.remove("Halls Cough Drop V2.0");
				}
			}

			else if (input.equals("fight vomit pile")) {
			if ( !roomThreeEnemies.contains ("Vomit Pile")) {
				System.out.println("You have already defeated that pile of vomit...");
					}
			//Chair chair = new Chair();
				else {
					VomitPile v = new VomitPile();
				    if (Stuyrule.gender == 1) {
					b.battle(l, v);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, v);
				    }
					roomThreeEnemies.remove("Vomit Pile");
				}
			}

                // Get calculator
                else if (input.equals("get milk")
                        && roomThreeItems.contains("Milk")) {
                    roomThreeItems.remove("Milk");
                    this.inventory.add("Milk");
                } else if (input.equals("get milk")
                        && !roomThreeItems.contains("Milk")) {
                    System.out.println("You already have some nice, fat-free milk...");
                }
	    
		else if (input.equals("use milk") || input.equals("look milk")
                        || input.equals("eat milk")) {
                    if (Stuyrule.gender == 1) {
			System.out.println("Cow liquid serves you well, boosting your hit points!");
			l.maxHP += 30;
		    }
		    else if (Stuyrule.gender == 2) {
			System.out.println("Cow liquid serves you well, boosting your hit points!");
			z.maxHP += 30;
		    }
		}
			    
                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomFour(l,z);
                }

                // Catch-all for unavailable actions
                else if (!Stuyrule.isGameCommand(input)) {
                    System.out.println("You can't do that.");
                }

                input = Stuyrule.getInput();
            }

 }
 
 void roomFour(Link l, Zelda z) {
     Battle b = new Battle();
     Bowlingking k = new Bowlingking();
	     BowlingKingFight bk = new BowlingKingFight();

            // Load room four
            Room roomFour = new Room();
            roomFour.setIndex(4);
            roomFour.setName("Library");
            roomFour.setDescription("Shh! Better zip your lip, there are kids around here studying. Actually, they're pretty loud as well, but not to worry, the library monitors don't ");
            roomFour.setCount(1);
            ArrayList<String> roomFourItems = new ArrayList<String>();
	    ArrayList<String> roomFourEnemies = new ArrayList<String>();
            roomFourItems.add("CPU Card");
            roomFourItems.add("Overdue Library Book");
            roomFour.setItems(roomFourItems);
	    roomFourEnemies.add("Library Monitor");
	    roomFourEnemies.add("Helicopter");
	    roomFour.setEnemies(roomFourEnemies);
            roomFour.setItems(roomFourItems);

            // Display room one description and items
            System.out.println(roomFour.getDescription());
            roomFour.printItems(roomFourItems);
	    roomFour.printEnemies(roomFourEnemies);

            // Get input and play room 2
            String input = Stuyrule.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomFour.getDescription());
                    roomFour.printItems(roomFourItems);
		    roomFour.printEnemies(roomFourEnemies);
                }

                // Get note
                else if (input.equals("get book")
                        && roomFourItems.contains("Overdue Library Book")) {
                    roomFourItems.remove("Overdue Library Book");
                    this.inventory.add("Overdue Library Book");
                } else if (input.equals("get book")
                        && !roomFourItems.contains("Overdue Library Book")) {
                    System.out.println("You already have that overdue book....");
                }


		else if (input.equals("get CPU card")
                        && roomFourItems.contains("CPU Card")) {
                    roomFourItems.remove("CPU Card");
                    this.inventory.add("CPU Card");
                } else if (input.equals("get CPU Card")
                        && !roomFourItems.contains("CPU Card")) {
                    System.out.println("You already have the CPU Card.");
                }

                // Use CPU Card
                else if (input.equals("use CPU card") || input.equals("use card")
                        || input.equals("look card")) {
                    System.out.println("You insert the CPU Card into your brain, your accuracy increases!");
		    if (Stuyrule.gender == 1) {
			l.accuracy *= 2;
		    }
		    else if (Stuyrule.gender == 2) {
			z.accuracy *= 2;
		    }
                }

			else if (input.equals("fight helicopter")) {
			if ( !roomFourEnemies.contains ("Helicopter")) {
				System.out.println("You have already defeated the helicopter!");
					}
			//Chair chair = new Chair();
				else {
				    Helicopter heli = new Helicopter();
				    if (Stuyrule.gender == 1) {
					b.battle(l, heli);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, heli);
				    }
					roomFourEnemies.remove("Helicopter");
				}
			}

			else if (input.equals("fight monitor")) {
			if ( !roomFourEnemies.contains ("Library Monitor")) {
				System.out.println("You have already defeated that kiss-up!");
					}
				else {
					Monitor mon = new Monitor();
				    if (Stuyrule.gender == 1) {
					b.battle(l, mon);
				    }
				    else if (Stuyrule.gender == 2){
					b.battle(z, mon);
				    }
					roomFourEnemies.remove("Library Monitor");
				}
			}

		// Use book
		else if (input.equals("use book") || input.equals("use overdue book")
                        || input.equals("look book")) {
                    if (Stuyrule.gender == 1){
			System.out.println("Trying to mess with overdue books, eh?");
			bk.Bowlingfight(l, k);
		    }
		    else if (Stuyrule.gender == 2){
			System.out.println("Trying to mess with overdue books, eh?");
			bk.Bowlingfight(z, k);
		    }
                }

                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomFive(l, z);
                }

                // Catch-all for unavailable actions
                else if (!Stuyrule.isGameCommand(input)) {
                    System.out.println("You can't do that.");
                }

                input = Stuyrule.getInput();
            }

 }
 
 void roomFive(Link l, Zelda z) {
	Moranondorf moran = new Moranondorf();
	FinalBossbattle fb = new FinalBossbattle();

            // Load room two
            Room roomFive = new Room();
            roomFive.setIndex(5);
            roomFive.setName("Principal's Office");
            roomFive.setDescription("You're in the Principal's Office, but not for the numerous acts of homicide. Turns out you were caught browsing Reddit (and various other websites) on your phone. Didn't you read the sign when you swiped in? Delinquent. You're never going to go to BMCC now, much less Harvard. Might as well turn in your student ID at this very moment!  Anyways, better enjoy that recliner while you can, even though there aren't any enemies in sigh, Moranondorf stirs in his sleep...");
            roomFive.setCount(1);
            ArrayList<String> roomFiveItems = new ArrayList<String>();
	    ArrayList<String> roomFiveEnemies = new ArrayList<String>();
            roomFiveItems.add("Your Cell Phone");
            roomFiveItems.add("Goddess Sword");
            roomFive.setItems(roomFiveItems);
            roomFive.setItems(roomFiveItems);

            // Display room one description and items
            System.out.println(roomFive.getDescription());
            roomFive.printItems(roomFiveItems);

            // Get input and play room 2
            String input = Stuyrule.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
		    || input.equals("look around")) {
                    System.out.println(roomFive.getDescription());
                    roomFive.printItems(roomFiveItems);
                }
                // Get phone
                else if (input.equals("get phone") || input.equals("get cell phone")
			 && roomFiveItems.contains("Your Cell Phone")) {
                    roomFiveItems.remove("Your Cell Phone");
                    this.inventory.add("Your Cell Phone");
			 }
		else if (input.equals("get phone") || input.equals("get cell phone")
                        && !roomFiveItems.contains("Your Cell Phone")) {
                    System.out.println("You already have your cell phone.");
			 }

                // Use phone
                else if (input.equals("use phone") || input.equals("use cell phone")
                        || input.equals("look phone")) {
		    if (roomFiveItems.contains("Goddess Sword")) {
			    System.out.println("You might wanna get that pretty sword to protect yourself first...");
			}
		    else {
                    if (Stuyrule.gender == 1){
			fb.Finalbossfight(l, moran);
		    }
			else if (Stuyrule.gender == 2) {
			    fb.Finalbossfight(z, moran);
			}	
		    }
		}

                // Get goddess sword
                else if (input.equals("get goddess sword")
                        && roomFiveItems.contains("Goddess Sword")) {
                    roomFiveItems.remove("Goddess Sword");
                    this.inventory.add("Goddess Sword");
                } 
	    
		else if (input.equals("get goddess sword")
			 && !roomFiveItems.contains("Goddess Sword")) {
                    System.out.println("You already have the Goddess Sword!.");
                }
		      
		else if (input.equals("use goddess sword") || input.equals("use sword")
                        || input.equals("look goddess sword")) {
                    System.out.println("It takes effort to swallow the sword whole, but damn are you pretty. Also, your damaged increased.");
		    if (Stuyrule.gender == 1) {
			l.damage *= 3;
		    }
		    else if (Stuyrule.gender == 2) {
			z.damage *= 3;
		    }
                }

                // Catch-all for unavailable actions
                else if (!Stuyrule.isGameCommand(input)) {
                    System.out.println("You can't do that.");
                }
				 
                input = Stuyrule.getInput();
	    }
 }
}

				    
 
