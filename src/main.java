import java.util.Scanner;
public class main {
    static Scanner scanner = new Scanner(System.in);
    static int remaining_water = 400;
    static int remaining_milk = 540;
    static int remaining_coffee_beans = 120;
    static int remaining_disposable_cups = 9;
    static int remaining_money = 550;

    public static void main(String[] args) {
        do {
            System.out.println();
            action();
        } while (true);
    }

    public static void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String input = scanner.next();
        switch (input) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> System.exit(0);
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffee_type = scanner.next();
        System.out.println();
        switch (coffee_type) {
            case "1" -> {
                int espresso_water = 250;
                int espresso_coffee_beans = 16;
                int espresso_cost = 4;
                if (remaining_disposable_cups >= 1) {
                    if (remaining_water >= espresso_water) {
                        if (remaining_coffee_beans >= espresso_coffee_beans) {
                            remaining_water -= espresso_water;
                            remaining_coffee_beans -= espresso_coffee_beans;
                            remaining_money += espresso_cost;
                            remaining_disposable_cups--;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                    }
                } else {
                    System.out.println("Sorry, not enough cups!");
                }
            }
            case "2" -> {
                int latte_water = 350;
                int latte_milk = 75;
                int latte_coffee_beans = 20;
                int latte_cost = 7;
                if (remaining_disposable_cups >= 1) {
                    if (remaining_water >= latte_water) {
                        if (remaining_milk >= latte_milk) {
                            if (remaining_coffee_beans >= latte_coffee_beans) {
                                remaining_water -= latte_water;
                                remaining_milk -= latte_milk;
                                remaining_coffee_beans -= latte_coffee_beans;
                                remaining_money += latte_cost;
                                remaining_disposable_cups--;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                        } else {
                            System.out.println("Sorry, not enough milk!");
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                    }
                } else {
                    System.out.println("Sorry, not enough cups!");
                }
            }
            case "3" -> {
                int cappuccino_water = 200;
                int cappuccino_milk = 100;
                int cappuccino_coffee_beans = 12;
                int cappuccino_cost = 6;
                if (remaining_disposable_cups >= 1) {
                    if (remaining_water >= cappuccino_water) {
                        if (remaining_milk >= cappuccino_milk) {
                            if (remaining_coffee_beans >= cappuccino_coffee_beans) {
                                remaining_water -= cappuccino_water;
                                remaining_milk -= cappuccino_milk;
                                remaining_coffee_beans -= cappuccino_coffee_beans;
                                remaining_money += cappuccino_cost;
                                remaining_disposable_cups--;
                            } else {
                                System.out.println("Sorry, not enough coffee beans!");
                            }
                        } else {
                            System.out.println("Sorry, not enough milk!");
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                    }
                } else {
                    System.out.println("Sorry, not enough cups!");
                }
            }
            case "back" -> action();
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int add_water = scanner.nextInt();
        remaining_water += add_water;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int add_milk = scanner.nextInt();
        remaining_milk += add_milk;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int add_coffee_beans = scanner.nextInt();
        remaining_coffee_beans += add_coffee_beans;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int add_cups = scanner.nextInt();
        remaining_disposable_cups += add_cups;
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $" + remaining_money);
        System.out.println();
        remaining_money = 0;
    }

    public static void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(remaining_water + " ml of water");
        System.out.println(remaining_milk + " ml of milk");
        System.out.println(remaining_coffee_beans + " g of coffee beans");
        System.out.println(remaining_disposable_cups + " disposable cups");
        System.out.println("$" + remaining_money + " of money");
    }
}
