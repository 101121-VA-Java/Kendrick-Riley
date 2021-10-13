public class Calculator{
    public static void main(String[] args) {
        System.out.println("This is my first Calculator");
       // weekday("monday");
        String s = "tuesday";
       // weekday(s);
        
System.out.println(weekday1(s));

    }
    // Values to be placed in Calculator.

    int a = 8;
    int b = 21;

    public static int add(int a, int b){
    return a + b;
    
    }
    public static int subtract(int a, int b){
        return a - b;
    }
    public static double multiply(int a, int b){
        return a * b;
    }
    public static int remainder(int a, int b) {
        return a % b;
    }
public static void weekday(String weekday){
    switch(weekday){
        case "monday":
            System.out.println("Today is monday");
            break;
        case "tuesday":
            System.out.println("It may be tuesday");
            break;
        default:
            System.out.println("I am not sure, it may be satuday");
    }}
    public static String weekday1( String day){
        switch(day){
            case "monday":
                return "Today is monday";
            case "tuesday":
                return "Today is tuesday";
            default:
            return "I am not sure, it may be a weekend";
        }
    }


    }
