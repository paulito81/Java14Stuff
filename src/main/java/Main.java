import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static String userInput;

    public static void main(String[] args) {
        menu(menuSelection());
    }
    private static String menuSelection(){
        System.out.print("""
                -----------------------------
                Welcome to this Java 14 demo.
                -----------------------------
                Please select from the menu:\s
                
                1: ObjectNullPointer
                2: StringNullPointer
                3: Switch (old ver) expressions
                4: Switch (NEW ver) expressions
                5: Switch New Food switch
                6: Pattern matching v.1
                7: Text blocks    
                8: Records demo
                9: Records demo 'breaking'
                
                Select: """);
        scanner = new Scanner(System.in);
        return userInput = scanner.nextLine();
    }

    private static void menu(String choice){
        switch (choice) {
            case "1" -> objectNullpointer();
            case "2" -> stringNullpointer();
            case "3" -> {
                System.out.print("""
                        
                        ---------[3].SWITCH OLD-------
                        Choose a month: Ex. jan, feb:  
                        
                        Select:""");
                userInput = scanner.nextLine();
                oldSwitch(userInput.toLowerCase());
            }
            case "4" -> {
                System.out.print(""" 
                        
                        ---------[4].NEW-SWITCH-------
                        Choose a month: Ex. jan = 1, feb = 2:
                        
                        Select:""");
                userInput = scanner.nextLine();
                newSwitch(userInput);
            }
            case "5" -> {
                System.out.print("""      
                        ---------[5].NEW-FOOD-SWITCH-------
                        Choose a meal. Ex. burger, donut, cheese, pizza: 
                        
                        Select: """);
                userInput = scanner.nextLine();
                newFoodSwitcher(userInput.toLowerCase());
            }
            case "6" -> {
                //TODO fix why return values is never 0?
                System.out.print("""
                        
                        ---------[6].PATTERN MATCHING-------
                        Write in two doubles. Ex. 1.5 2.5 
                        
                        Type:""");
                userInput = scanner.nextLine();
                double s = oldPatternMatch(new BigDecimal("0.5"));
                double f = newPatternMatch(new BigDecimal("1.6"));
                if(s > 0 && f > 0) {
                    System.out.println("Pattern match is true");
                }else{
                    System.out.println("Pattern match is false");
                }
            }
            case "7" -> {
                System.out.print("""
                        
                        ---------[7].TEXT BLOCKS-------
                        """);
                try {
                    textBlock();
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
            case "8" -> {
                System.out.print("""
                        
                        ---------[8].USING RECORDS------
                        """);
                javaRecords();
            }
            case "9" -> {
                System.err.print("""
                        
                        ---------[9].USING RECORDS 'breaking'------
                        """);
                try {
                    javaRecordsBreak();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            default -> System.err.println("You selected a unknown choice: " + choice);
        }
    }

    private static void objectNullpointer(){
        System.out.println("\n---------[1].OBJECT NULL POINTER -------");
        Object myObject = null;
        myObject.toString().hashCode();
    }
    private static void stringNullpointer(){
        System.out.println("\n---------[2].STRING NULL POINTER -------");
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

    private static int oldPatternMatch(Object o){
        // can be replaced with pattern.
        if(o instanceof BigDecimal){
            BigDecimal b = (BigDecimal) o;
            return b.precision();
        }
        else
            return 0;
    }

    private static int newPatternMatch(Object o){
        if(o instanceof BigDecimal b){
            return b.precision();
        }
        else
            return 0;
    }

    private static void textBlock() throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String s = (String) engine.eval("""
                function getString() {  \
                 return ('"A JS String!"');  \
                } \
                  \
                getString()""");
        System.out.println(s);
    }

    private static void javaRecords() {
        Course course = new Course("What's new in Java 14", Duration.ofHours(1), 5);
        Course course2 = new Course("What's new in Java 14", Duration.ofHours(1), 5);
        System.out.println("Is the object  similar? -> " + (course == course2));
        System.out.println("Is the content similar? -> " + (course.equals(course2)));
        System.out.println("---------------------------------");
    }

    private static void javaRecordsBreak() throws InterruptedException {
        // GIVES A RUNTIME EXCEPTION BREAK BECAUSE VALUE IS +5
        // NB! Records has Final values
        // Sleep methods used to render String correctly
        try {
            Thread.sleep(100);
            new Course("What's new in Java 15", Duration.ofHours(2), 6);
        }catch (IllegalArgumentException | InterruptedException e){
            Scanner scanner = new Scanner(System.in);
            System.err.print("Input value is above 5!");
            Thread.sleep(100);
            System.out.print("""
                     Please rate again! (Ex. 1-5)
                    Rate: """);
            System.out.println("\n"+new Course("What's new in Java 15", Duration.ofHours(2),scanner.nextInt()));
        }
    }
}
