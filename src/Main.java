import java.util.Scanner;
import java.util.ArrayList;

public class Main
{

    static Scanner userInput;

    //initiate ArrayList
    static ArrayList<String> incomeName = new ArrayList<String>();
    static ArrayList<Float> incomeCash = new ArrayList<Float>();
    static ArrayList<String> outcomeName = new ArrayList<String>();
    static ArrayList<Float> outcomeCash = new ArrayList<Float>();

    public static void main(String[] args) {

        userInput = new Scanner(System.in);
        System.out.println("Thirdy Financial Management System");
        initiateIncomeOutCome(); //Store Income Name and Income Cash
        homePage();

    }

    private static void initiateIncomeOutCome() {
        incomeName.add("Allowance");
        incomeCash.add(200f);
        incomeName.add("Net Income");
        incomeCash.add(2000f);
        incomeName.add("Freelance");
        incomeCash.add(1500f);
        incomeName.add("Bonus");
        incomeCash.add(2300f);
        incomeName.add("May nagbayad Utang");
        incomeCash.add(100f);

        outcomeName.add("Pamasahe");
        outcomeCash.add(20f);
        outcomeName.add("Jolibee");
        outcomeCash.add(90f);
        outcomeName.add("Red Horse");
        outcomeCash.add(120f);
        outcomeName.add("Wifi PLDT");
        outcomeCash.add(120f);
    }

    public static void homePage(){
        //VARIABLE
        int chooseFeatures;
        boolean wrongInput = true;

        //DO WHILE STATEMENT
        do {
            wrongInput = false;
            System.out.println("Current Cash: " +  (totalCash(incomeCash) - totalCash(outcomeCash)));

            System.out.println("\nOption: ");
            System.out.println("[1] Income");
            System.out.println("[2] Expenses");
            System.out.println("[3] Exit");

            System.out.println("\nType >");
            chooseFeatures = userInput.nextInt();
            //SWITCH STATEMENT
            switch(chooseFeatures){
                case 1:
                    income();
                    break;
                case 2:
                    outcome();
                    break;
                case 3:
                    System.exit(0);
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

        //DO WHILE STATEMENT
        do {
            wrongInput = false;
            System.out.println("Total Income: " + totalCash(incomeCash));
            System.out.println("========================");

            viewHistory("incomes");

            System.out.println("\n\nOption: ");
            System.out.println("[1] Add Income");
            System.out.println("[2] Back To Menu");
            System.out.println("\nType >");
            chooseFeaturesIncome = userInput.nextInt();
            //SWITCH STATEMENT
            switch(chooseFeaturesIncome){
                case 1:
                    add("incomes");
                    break;
                case 2:
                    homePage();
                    break;
                default:
                    System.out.println("Wrong!! Try Again");
                    wrongInput = true;
            }
        }while (wrongInput == true);
    }

    public static void outcome(){
        int chooseFeaturesOutcome;
        boolean wrongInput = true;
        do {
            wrongInput = false;
            System.out.println("Total Expenses: " + totalCash(outcomeCash));
            System.out.println("========================");

            viewHistory("outcomes");

            System.out.println("\n\nOption: ");
            System.out.println("[1] Add Expenses");
            System.out.println("[2] Back To Menu");
            System.out.println("\nType >");
            chooseFeaturesOutcome = userInput.nextInt();
            //SWITCH STATEMENT
            switch(chooseFeaturesOutcome){
                case 1:
                    add("outcomes");
                    break;
                case 2:
                    homePage();
                    break;
                default:
                    System.out.println("Wrong!! Try Again");
                    wrongInput = true;
            }
        }while (wrongInput == true);
    }

    public static void viewHistory(String transaction){

        //NESTED IF ELSE
        if(transaction.equals("incomes")){

            if(incomeCash.size() == 10){
                System.out.println("You Reached 10 list of Income! Keep It up!\n");
            } else if (incomeCash.size() == 20) {
                System.out.println("You Reached 20 list of Income! Keep It up!\n");
            }

            System.out.println("Income History\n");
            printHistory(incomeName, incomeCash);

        }else if(transaction.equals("outcomes")){
            System.out.println("Outcome History\n");
            printHistory(outcomeName, outcomeCash);
        }else{
            System.out.println("Error");
            homePage();
        }
    }

    public static void printHistory(ArrayList<String> y, ArrayList<Float> x){
        System.out.println("Name\t\t\t\t\t\tPrice");

        //FOR LOOP
        for(int i = 0; i<y.size(); i++){
            System.out.println(y.get(i) + "\t\t\t\t" + x.get(i));
        }
    }

    public static void add(String transaction){
        Scanner userInputTitle  = new Scanner(System.in);
        Scanner userInputCash  = new Scanner(System.in);

        boolean nameValid = true, cashValid = true;
        String inputName = "";
        float inputPrice;

        String statement = transaction.equals("incomes") ?  "Income Title: " : "Expenses Title: ";
        System.out.println(statement);

        inputName = userInputTitle.nextLine() ;
        nameValid =  !inputName.equals("") ?  true : false;

        //WHILE LOOP
        while (nameValid == false){
            System.out.println("Please input Title");
            //TERNARY CONDITION
            statement = transaction.equals("incomes") ?  "Income Title: " : "Expenses Title: ";
            System.out.println(statement);
            inputName = userInput.nextLine();

            //IF STATEMENT
            if(!inputName.equals("")){
                nameValid = true;
            }

        }


        System.out.println("Cash: ");
        inputPrice = userInputCash.nextFloat();
        //TERNARY CONDITION
        cashValid =  inputPrice > 0f ?  true : false;

        //WHILE LOOP
        while (cashValid == false){
            System.out.println("Please input Cash");
            System.out.println("Cash: ");
            inputPrice = userInput.nextFloat();

            //IF STATEMENT
            if(inputPrice > 0f){
                cashValid = true;
            }

        }

        //IF ELSE STATEMENT
        if(transaction.equals("incomes")){
            incomeName.add(inputName);
            incomeCash.add(inputPrice);
            income();
        }else if(transaction.equals("outcomes")){
            outcomeName.add(inputName);
            outcomeCash.add(inputPrice);
            outcome();
        }
    }

    //Compute total Income
    public static float totalCash(ArrayList<Float> x){
          float total = 0f;
          //FOR LOOP
           for(int i = 0; i< x.size(); i++){
               total += x.get(i);
          }
           return  total;
    }


}    

    


