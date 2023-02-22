import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static float totalCash = 0f, income = 0f, outcome = 0f;
    static Scanner userInput;

    // static String[50][3] viewHistoryIncome;
    // static String[50][3] viewHistoryOutcome;
    // static String[50][3] viewHistoryOnlinePayment;

    public static void main(String[] args) {

        userInput = new Scanner(System.in);
        System.out.println("Thirdy Financial Management System Mobile App");
        homePage();
    }

    public static void homePage(){
        int chooseFeatures;
        boolean wrongInput = true;
        do {
            wrongInput = false;
            System.out.println("Total Cash: " + totalCash);
            System.out.println("Debt: " + income);
            System.out.println("Borrower: " + outcome);

            System.out.println("Option: ");
            System.out.println("[1]Income");
            System.out.println("[2]Outcome");
            System.out.println("[3]Online Payment");

            System.out.println("\nType >");
            chooseFeatures = userInput.nextInt();

            switch(chooseFeatures){
                case 1:
                    income();
                    break;
                case 2:
                    outcome();
                    break;
                case 3:
                    budgeting();
                    break;
                case 4:
                    onlinePayment();
                    break;
                default:
                    System.out.println("Wrong!! Try Again");
                    wrongInput = true;
            }
        }while (wrongInput == true);
    }

    public static void income(){
        int chooseFeaturesIncome;
        boolean wrongInput = true;
        do {
            wrongInput = false;
            System.out.println("Total Income: " + income);
            System.out.println("========================");
            System.out.println("Option: ");
            System.out.println("[1]View History");
            System.out.println("[2]Add Income");
            System.out.println("[3]HomePage");
            System.out.println("\nType >");
            chooseFeaturesIncome = userInput.nextInt();
            switch(chooseFeaturesIncome){
                case 1:
                    viewHistory("incomes");
                    break;
                case 2:
                    add("incomes");
                    break;
                case 3:
                    homePage();
                    break;
                default:
                    System.out.println("Wrong!! Try Again");
                    wrongInput = true;
            }
        }while (wrongInput == true);
    }


    public static void viewHistory(String transaction){
        if(transaction.equals("incomes")){

            System.out.println("Income History");
            System.out.println("Date     Name      Price");

            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            System.out.println(cars);
            for(int i = 0; i<cars.size(); i++){
                //   System.out.println(viewHistoryIncomeDate  +  "   "  + viewHistoryIncomeTitle.get(i)   +   "      Php "  + viewHistoryIncomePrice.get(i) );
                System.out.println(cars.get(i));
            }
        }else if(transaction.equals("outcomes")){
            System.out.println("outcome");
        }
    }

    public static void add(String transaction){
        if(transaction.equals("income")){
            System.out.println("income");
        }else if(transaction.equals("outcome")){
            System.out.println("outcome");
        }
    }

    public static void outcome(){
        System.out.println("Outcome");
    }

    public static void budgeting(){
        System.out.println("budgeting");
    }

    public static void onlinePayment(){
        System.out.println("Online Payment");
    }

}    

    


