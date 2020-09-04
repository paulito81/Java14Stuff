import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static String userInput;

    public static void main(String[] args) {
        menu(menuSelection());
    }
    private static String menuSelection(){
        System.out.println("\nWelcome to this Java 14 demo. Please select from the menu: " +
                "\n1: ObjectNullPointer" +
                "\n2: StringNullPointer" +
                "\n3: Switch (old ver) expressions" +
                "\n4: Switch (NEW ver) expressions"+
                "\n5: Switch New Food switch");
        System.out.print("\nSelect:");
        scanner = new Scanner(System.in);
        return userInput = scanner.nextLine();
    }

    private static void menu(String choice){
        switch (choice) {
            case "1" -> objectNullpointer();
            case "2" -> stringNullpointer();
            case "3" -> {
                String welcome = "---------[3].JAVA SWITCH OLD-------";
                System.out.print(welcome + "\nSelect a month: Ex. jan, feb:  ");
                userInput = scanner.nextLine();
                oldSwitch(userInput.toLowerCase());
            }
            case "4" -> {
                String welcome = "---------[4].JAVA NEW-SWITCH-------";
                System.out.print(welcome + "\nSelect a month: Ex. jan = 1, feb = 2:  ");
                userInput = scanner.nextLine();
                newSwitch(userInput);
            }
            case "5" -> {
                String welcome = "---------[5].JAVA NEW-FOOD-SWITCH-------";
                System.out.print(welcome + "\nSelect a meal. Ex. burger, donut, cheese, pizza: ");
                userInput = scanner.nextLine();
                newFoodSwitcher(userInput.toLowerCase());
            }
            default -> System.err.println("You selected a unknown choice: " + choice);
        }
    }

    private static void objectNullpointer(){
        System.out.println("---------[1].OBJECT NULL POINTER -------");
        Object myObject = null;
        myObject.toString().hashCode();
    }
    private static void stringNullpointer(){
        System.out.println("---------[2].STRING NULL POINTER -------");
        String nullValue = null;
        nullValue.toString().length();
    }

    private static void oldSwitch(String month){
        switch (month) {
            case "jan", "january", "1" -> System.out.println("January is selected");
            case "feb", "february", "2" -> System.out.println("February is selected");
            default -> System.err.println("You selected a unknown choice: " + month);
        }
    }
    private static void newSwitch(String month) {
        // yield return av value from a case
        String monthName = switch (Integer.parseInt(month)) {
            case 1 -> {
                yield "January";
            }
            case 2 -> {
                yield "February";
            }
            case 3 -> {
                yield "March";
            }
            case 4 -> {
                yield "April";
            }
            case 5 -> {
                yield "May";
            }
            case 6 -> {
                yield "June";
            }
            case 7 -> {
                yield "July";
            }
            case 8 -> {
                yield "August";
            }
            case 9 -> {
                yield "September";
            }
            case 10 -> {
                yield "October";
            }
            case 11 -> {
                yield "November";
            }
            case 12 -> {
                yield "December";
            }
            default -> {
                yield "Unknown value: " + month;
            }
        };
        if (monthName.startsWith("Unknown value")) {
            System.err.println("An error occurred while you selected the " + monthName);
        } else {
            System.out.println("You have selected: " + monthName);
        }
    }

    private static void newFoodSwitcher(String food){
        // -> implies that we use a yield with one return value
        Locale locale = switch (food) {
            case "burger", "donut" -> Locale.US;
            case "cheese" -> Locale.forLanguageTag("nl");
            case "maple syrup" -> Locale.CANADA;
            case "pizza" -> Locale.ITALY;
            default -> Locale.getDefault();
        };
        System.out.println("\nYou selected: " + food + "which belongs in " +locale);
    }

}
