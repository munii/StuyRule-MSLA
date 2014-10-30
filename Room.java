import java.util.ArrayList;
import java.util.Scanner;

public class Room {
        private int index;
        private int count = 0;
        private String name;
        private String description;
        private ArrayList<String> items;
        private ArrayList<String> commands;
	private ArrayList<String> enemies;

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int aIndex) {
            this.index = aIndex;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int aCount) {
            this.count = aCount;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String aName) {
            this.name = aName;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String aDescription) {
            this.description = aDescription;
        }

        public ArrayList<String> getItems() {
            return this.items;
        }

        public void setItems(ArrayList<String> aItems) {
            this.items = aItems;
        }

        public void setEnemies(ArrayList<String> aEnemies) {
            this.enemies = aEnemies;
        }

        public ArrayList<String> getCommands() {
            return this.commands;
        }

        public ArrayList<String> getEnemies() {
	    return this.enemies;
	}

        public void setCommands(ArrayList<String> aCommands) {
            this.commands = aCommands;
        }

        void printItems(ArrayList<String> roomItems) {
            if (roomItems.size() > 0) {
                System.out.print("You see a ");
                if (roomItems.size() == 1) {
                    System.out.println(roomItems.get(0) + ".");
                }
                if (roomItems.size() == 2) {
                    System.out.println(roomItems.get(0) + " and a "
                            + roomItems.get(1) + ".");
                }
                if (roomItems.size() == 3) {
                    System.out.println(roomItems.get(0) + ", "
                            + roomItems.get(1) + " and a " + roomItems.get(2)
                            + ".");
                }
            }
        }
    
        void printEnemies(ArrayList<String> roomEnemies) {
            if (roomEnemies.size() > 0) {
                System.out.print("You could fight a ");
                if (roomEnemies.size() == 1) {
                    System.out.println(roomEnemies.get(0) + ".");
                }
                if (roomEnemies.size() == 2) {
                    System.out.println(roomEnemies.get(0) + " or a "
                            + roomEnemies.get(1) + ".");
                }
                if (roomEnemies.size() == 3) {
                    System.out.println(roomEnemies.get(0) + ", "
                            + roomEnemies.get(1) + " or a " + roomEnemies.get(2)
                            + ".");
                }
            }
        }

    
        void count() {
            this.count++;
        }
}

