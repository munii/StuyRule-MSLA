import java.util.ArrayList;
import java.util.Scanner;

public class Stuyrule {
    static int gender;
    // Main Method
    public static void main(String[] args) {
	
        // Create world
        World world = new World();

        // Load title screen
        world.titleScreen();
	
	//Load info prompt
	Scanner s = new Scanner( System.in );
	String n;
	int color;
	System.out.println("Are you a \n (1) Boy \n (2) Girl");
	gender = s.nextInt();
	System.out.println("Please enter your name:");
	n = s.nextLine();
	System.out.println("Welcome to Stuyrule, " + n + "! Last question before you go to homeroom- what's your favorite color out of these four? \n (1) Green \n (2) Red \n (3) Blue \n (4) Purple");
	color = s.nextInt();
	while ((color != 1) && (color != 2) && (color != 3) && (color != 4)){
	    System.out.println("Please enter a valid number from 1-4");
	    color = s.nextInt();
	}
	System.out.println("You're on your way!");

    
    // Load room one
    world.roomOne(n, color);
    }
    
    // **** INPUT BLOCK ****

    // Receives input from User
    public static String getInput() {

        // Prompt and read input
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // Format input
        input = formInput(input);

        // Re-prompt if input is empty or gibberish
        while (isInputDumb(input)) {
            System.out.print("> ");
            input = in.nextLine();
            input = formInput(input);
        }

        // If system command is typed, send to systemCommandResponses method
        if (isGameCommand(input)) {
            gameCommandResponse(input);
        }

        return input;
    }

    public static boolean isInputDumb(String input) {

        // If command is valid, input is not empty or gibberish
        if (input.length() > 0
                && (isActionCommand(input) || isGameCommand(input))) {
            return false;
        }
        // Otherwise, provide responses if empty or gibberish
        else if (input.isEmpty()) {
            System.out.println("You mute or something? Type 'help' to cure your condition.");
        } else {
            System.out.println("Are you incapable of rational thought? Type 'help' if not.");
        }

        return true;
    }

    // Corrects erroneous user input
    public static String formInput(String input) {

        // Convert to lower case
        input = input.toLowerCase();

        // Remove extra spaces
        input = input.replaceAll("\\s+", " ");
        input = input.replaceAll("^\\s+|\\s+$", "");

        return input;
    }

    // Tests if a command is an action or game command
    public static boolean isActionCommand(String input) {

        // Extract command from input (all letters before space)
        if (input.contains(" ")) {
            input = input.substring(0, input.indexOf(' '));
        }

        // Define valid action commands
        String[] actionCommands = { "look", "get", "read",
				    "talk", "open", "attack","take","pull", "leave", "fight" };

        // Check for valid action command
        for (int i = 0; i < actionCommands.length; i++) {
            if (input.equals(actionCommands[i])) {
                return true;
            }
        }

        return false;
    }

    // Game command stuff
    public static boolean isGameCommand(String input) {

        // Extract command from input (all letters before space)
        if (input.contains(" ")) {
            input = input.substring(0, input.indexOf(' '));
        }

        // Define valid system commands
        String[] systemCommands = { "help", "inventory", "inv", "i", "load",
				    "save", "restart", "quit", "exit", "menu", "m"};

        // Check for valid system command
        for (int i = 0; i < systemCommands.length; i++) {
            if (input.equals(systemCommands[i])) {
                return true;
            }
        }

        return false;
    }

    // Provides responses to game commands
    public static void gameCommandResponse(String input) {

        // Display help information
        if (input.equals("help")) {

            System.out.println("[Help]");
            System.out
                    .println(" Command syntax: <command>(space)<something>, e.g. get book");
            System.out
                    .println(" Action commands: look, get, talk, move, leave, etc.");
            System.out
                    .println(" System commands: help, inventory, menu, load, save, restart, quit");
            System.out
                    .println(" Tips: Typing \"i\" is a shortcut to view your inventory.");
	    System.out.println(" Tips: Typing \"m\" is a shortcut to view your stats.");
        }

        // Display inventory contents
        else if (input.equals("i") || input.equals("inv")
                || input.equals("inventory")) {
            World.inventory.print();
        }

	// Display player stats
	else if ((input.equals("m") || (input.equals("menu")))) {
	    System.out.println("[Stats]");
	    if (gender == 1) {
		System.out.println("Name: " + Link.name);
		System.out.println("Gender: Male");
		if (Link.color == 1) {
		    System.out.println("Color: Green");
		}
		else if (Link.color == 2) {
		    System.out.println("Color: Red");
		}
		else if (Link.color == 3) {
		    System.out.println("Color: Blue");
		}
		else if (Link.color == 4) {
		    System.out.println("Color: Purple");
		}
		System.out.println("Attack: " + Link.damage);
		System.out.println("Hit Points: " + Link.HP);
		System.out.println("Damage: " + Link.defense);
		System.out.println("Speed: " + Link.speed);
		System.out.println("Accuracy: " + Link.accuracy);
	    }
	    else {
		System.out.println("Name: " + Zelda.name);
		System.out.println("Gender: Female");
		if (Zelda.color == 1) {
		    System.out.println("Color: Green");
		}
		else if (Zelda.color == 2) {
		    System.out.println("Color: Red");
		}
		else if (Zelda.color == 3) {
		    System.out.println("Color: Blue");
		}
		else if (Zelda.color == 4) {
		    System.out.println("Color: Purple");
		}
		System.out.println("Attack: " + Zelda.damage);
		System.out.println("Hit Points: " + Zelda.HP);
		System.out.println("Damage: " + Zelda.defense);
		System.out.println("Speed: " + Zelda.speed);
		System.out.println("Accuracy: " + Zelda.accuracy);
	    }}
		

        // Exit game
        else if (input.equals("exit") || input.equals("quit")) {
            System.out.print("Are you sure? (y/n): ");
            Scanner in = new Scanner(System.in);
            String confirmExit = in.nextLine();
            confirmExit = confirmExit.toLowerCase();
            while (!confirmExit.equals("y") && !confirmExit.equals("n")) {
                System.out.println("Invalid response.");
                System.out
                        .print("Are you sure you want to exit the game? (y/n): ");
                confirmExit = in.nextLine();
                confirmExit = confirmExit.toLowerCase();
            }
            if (confirmExit.equals("y")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
        }

        // Add load, save, restart functionality
    }

}
   
    
