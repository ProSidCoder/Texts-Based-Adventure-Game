MyProgram.java:
--------------
import java.util.Scanner;
import java.util.Random;

public class MyProgram
{
    public static void main(String[] args)
    {
        // instantiate wolf, donkey, and sheep here 
        Random rand = new Random();
        Wolf wolf = new Wolf(rand.nextInt(20), rand.nextInt(20));
        Donkey donkey = new Donkey(rand.nextInt(20), rand.nextInt(20));      
        Sheep sheep = new Sheep(rand.nextInt(20), rand.nextInt(20));
    
        System.out.println("There are " + Animal.getTotalAnimals() + " animals on the farm.");
        System.out.println(" ");
        System.out.println("Your name is Sly Wolf.");
        System.out.println("Your mission is to eat the donkey and the sheep before you starve.");
        System.out.println("The pen is 20x20 in size and you can move one square up, down, left, or right each move.");
         System.out.println(" ");
        System.out.println("You can do one of three things each turn:");
        System.out.println("1. Move (indicate up, down, left, or right)");
        System.out.println("2. Attack (if you are within one square of an animal)");
        System.out.println("3. Ask for current position of animals in pen.");
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println(" ");
        while (wolf.getHealth() > 0)
        {
            System.out.println("What would you like to do? (1. move 2. attack 3. ask for position) ");
            choice = input.nextInt();
            if (choice == 1) 
            {
                System.out.println("Would you like to move Up, Down, Left, or Right? (u,d,l,r)");
                char direction = input.next().charAt(0);
                // Verify the user's choice for direction
                while (direction != 'u' && direction != 'd' && direction != 'l' && direction != 'r')
                {
                    System.out.println("Invalid direction. Enter u, d, l, or r.");
                    direction = input.next().charAt(0);
                }
                // Move the wolf based on the user's choice
                wolf.move(direction);
            } else if (choice == 2)
            
            {
                wolf.attack(donkey);
                wolf.attack(sheep);
            } else
            
            {
                System.out.println("Health and Position of the animals:");
                System.out.println("Wolf: " + wolf.toString());
                System.out.println("Donkey: " + donkey.toString());
                System.out.println("Sheep: " + sheep.toString());
            }
            wolf.setHealth(wolf.getHealth() - 1);
            donkey.moveRandom();
            sheep.moveRandom();
            donkey.kick(wolf);
            sheep.bleat(wolf);
        }
    }
}
            
            // move the sheep and donkey to random new position using move_random()
            
        // end while (true)
        
    // end main()
    
 // end MyProgram
Animal.java:
-----------
public class Animal
{
    private String species;
    private int health;
    private int x;
    private int y;
    private static int totalAnimals;
    // Parameter Constructor
    public Animal(String species, int x, int y) 
    {
        this.species = species;
        this.health = 10;
        this.x = x;
        this.y = y;
        totalAnimals++;
    }
    // Getters and Setters
    public String getSpecies()
    {
        return species;
    }
    public void setSpecies(String species) 
    {
        this.species = species;
    }
    public int getHealth() 
    {
        return health;
    }
    public void setHealth(int health) 
    {
        this.health = health;
    }
    public int getX()
    {
        return x;
    }
    public void setX(int x) 
    {
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y) 
    {
        this.y = y;
    }
    public static int getTotalAnimals() 
    {
        return totalAnimals;
    }
    // Move method
    public void move(char direction) 
    {
        // Move logic here based on the direction (up/down/left/right)
    }
    // Move random method
    public void moveRandom() 
    {
        // Move random logic here
    }
    // Eat method
    public void eat() 
    {
        this.health++;
    }
    // toString method
    public String toString() 
    {
        return "Species: " + species + ", Health: " + health + ", Position: (" + x + ", " + y + ")";
    }
    // Equals method
    public boolean equals(Animal other)
    {
        return this.species.equals(other.getSpecies());
    }
}

Donkey.java:
-----------
public class Donkey extends Animal
{
    public Donkey(int x, int y)
    {
        super("Donkey",x,y);
    }
        
    public void kick(Animal other)
    {
        // there is a 50% probability that the donkey's kick reduces the other
        // animal's health by 1. Add code here.
        
    }
    
    
}

Sheep.java:
----------
public class Sheep extends Animal
{
    public Sheep(int x, int y)
    {
        super("Sheep", x, y);
    }

    // add parameter constructor using super keyword here
 
    public void bleat(Animal other)
    {
        // print out statement showing that sheep is bleating for master

        // send wolf back to square (0,0) with 50% probability
        
    }
 
    
}

Wolf.java:
---------
public class Wolf extends Animal 
{
    private int health;

    public Wolf(int x, int y)
    {
        super("Wolf", x, y);
        this.setHealth(20);
    }

    public void attack(Animal other) 
    {
        if (Math.abs(this.getX() - other.getX()) < 2 && Math.abs(this.getY() - other.getY()) < 2) {
            if (Math.random() < 0.5) 
            {
                this.setHealth(this.getHealth() + 5);
                other.setHealth(other.getHealth() - 5);
                System.out.println("Attack successful - Wolf's health: " + this.getHealth() + ", " + other.getSpecies() + "'s health: " + other.getHealth());
            }
            else
            {
                System.out.println("No luck! They got away!");
            }
        } else 
            {
                System.out.println(other.getSpecies() + " is not in the vicinity of the wolf.");
            }
    }
}

