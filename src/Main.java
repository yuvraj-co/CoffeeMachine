import java.util.Scanner;
 class CoffeeMachine{
    static Scanner scan = new Scanner(System.in);
    private double coffee_powder, milk, water;
    private int Coffee_Count = 0;
    public CoffeeMachine(){
        this.coffee_powder=23.0;
        this.milk=19.0;
        this.water=42.0;
    }
    private void SetIngredient(){
        System.out.println("\nFilling...");
        this.coffee_powder = 500.0;
        this.milk = 1;
        this.water= 2;
        System.out.println("Filling Completed.");
    }
    private void GetIngredient(){   //To Get Status
        System.out.println("Available Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
        System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
        System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
    }
    private void CleanMachine(){
        System.out.println("\nCleaning Machine...");
        this.coffee_powder = 0;
        this.milk = 0;
        this.water= 0;
        System.out.println("Cleaning Completed.");
    }
    private void MakeCoffee(){
        System.out.println("\n ------------------ ");
        System.out.println("|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |");
        System.out.println(" ------------------ \n");
        char t = scan.next().charAt(0);
        switch(t){
            case '1':
                this.BlackCoffee();
                break;
            case '2':
                this.MilkCoffee();
                break;
            case '0':
                break;
        }
    }
    private void BlackCoffee(){
        if(this.coffee_powder >= 10 && this.water >= 0.2){
            System.out.println("\nMaking Black Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Black Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please Fill before Making Coffee.");
        }
    }
    private void MilkCoffee(){
        if(this.coffee_powder >= 10 && this.milk >= 0.4 && this.water >= 0.2){
            System.out.println("\nMaking Milk Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.4 Liter of Milk.");
            this.milk = this.milk - 0.4;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Milk Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void start(){
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("|                   Coffee Machine                  |");
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("Currently We Have Following Operations, Select as your Need:- ");
        System.out.println("\nCurrent Status: ");
        this.GetIngredient();
        boolean t = true;
        while(t){
            System.out.println("\n -------------------------------- ");
            System.out.println("|1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |");
            System.out.println(" -------------------------------- \n\n");
            char c = CoffeeMachine.scan.next().charAt(0);
            switch (c) {
                case '1' -> {
                    System.out.println("------------- Status ------------");
                    this.GetIngredient();
                    System.out.println("---------------------------------");
                }
                case '2' -> this.SetIngredient();
                case '3' -> this.CleanMachine();
                case '4' -> this.MakeCoffee();
                case '5' -> System.out.println("\nWe Have Made " + this.Coffee_Count + " Coffees.");
                case '6' -> {
                    System.out.println("\nExiting...\n");
                    t = false;
                }
            }
        }
    }
}
class MakeCoffee{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWants to Start Machine Y or N ?");
        char d;
        d = scan.next().charAt(0);
        if(d == 'Y' || d == 'y'){
            CoffeeMachine cm = new CoffeeMachine();
            cm.start();
            System.out.println("Shutting Down...\n");
        }else
            System.out.println("Shutting Down...\n");
    }
}