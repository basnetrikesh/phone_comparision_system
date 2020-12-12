package com.company;
import java.lang.reflect.Array;
import java.time.LocalDateTime; // for getting the datetime
import java.time.format.DateTimeFormatter; // for formatting the datetime
import java.util.Arrays;
import java.util.Scanner;

public class App {

    //these are the variables to store the usage details

    private int callLength; //to store the call length in second
    private int totalCall; //to store the total no of call

    private int totalSms; //to store the total no of sms

    private int totalData;//to store the total data usage

    private float[] cost={0.0f,0.0f,0.0f}; //to store the total cost

    private static Scanner in=new Scanner(System.in);



    public void mainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("");
        System.out.println("Please select from the menu");
        System.out.println("1.Enter Usage Details");
        System.out.println("2.Display Cost Under Provider 1");
        System.out.println("3.Display Cost Under Provider 2");
        System.out.println("4.Display Cost Under Provider 3");
        System.out.println("5.Clear Usage Details");
        System.out.println("6.Exit System");
        System.out.println("");
        byte choice=getSelection();
        while(choice<1||choice>6) {
            System.out.println("Value must be between 1 and 6.Please try again.");
            choice = getSelection();
        }
        switch (choice){
            case 1:
                //enter usage details
                enterUsageDetails();
                break;
            case 2:
                //display cost under provider 1
                displayCostProviderOne();
                break;
            case 3:
                //display cost under provider 2
                displayCostProviderTwo();
                break;
            case 4:
                //display cost under provider 3
                displayCostProviderThree();
                break;
            case 5:
                //clear usage details
                clearUsageDetails();
                break;
            case 6:
                //exit the system
                exitApp();
                break;
            default:
                //exception
                System.out.println("Unexpected input!!! System is exiting......");
                in.nextLine();
                System.exit(0);

        }



    }
    public void enterUsageDetails(){
        System.out.println("ENTER USAGE DETAILS MENU");
        System.out.println("");
        System.out.println("Please select an option from the menu:");
        System.out.println("1.Phone Call");
        System.out.println("2.SMS");
        System.out.println("3.Data Usage");
        System.out.println("4.Return to main menu");
        byte choice=getSelection();
        while(choice<1||choice>4){
            System.out.println("Value must be between 1 and 4.Please try again.");
            choice=getSelection();

        }
        switch (choice){
            case 1:
                //phone calls
                phoneCalls();
                break;
            case 2:
                //sms
                sms();
                break;
            case 3:
                //data usage
                dataUsage();
                break;
            case 4:
                //return to main
                mainMenu();
                break;
            default:
                System.out.println("Unexpected input!!! System is exiting....");
                in.nextLine();
                System.exit(0);
        }

    }
    public void phoneCalls(){
        int x; //local variable to store callLength
        System.out.print("Enter call length in seconds:");
        x=in.nextInt();
        while(x<0){
            System.out.println("Enter a valid call length");
            System.out.print("Enter call length in seconds:");
            x=in.nextInt();

        }
        callLength=callLength+x;
        totalCall=totalCall+1;
        System.out.println("Total no of calls so far= "+totalCall);
        in.nextLine();
        in.nextLine();
        enterUsageDetails();

    }
    public void sms(){
        totalSms=totalSms+1;
        System.out.println("Total no of SMS so far= "+totalSms);
        in.nextLine();
        in.nextLine();
        enterUsageDetails();


    }
    public void dataUsage(){
        int d; //local variable to store the entered data usage
        System.out.print("Enter the amount of data in MB:");
        d=in.nextInt();
        while(d<0){
            System.out.println("enter the valid data");
            d=in.nextInt();
        }
        totalData=totalData+d;
        System.out.println("Data amount so far "+totalData+"MB");
        in.nextLine();
        in.nextLine();
        enterUsageDetails();

    }
    public void displayCostProviderOne(){
        System.out.println("Cost under Provider 1");
        cost[2]=costDisplayFormat(0.20f,0.03f,0.10f,0.02f);
        in.nextLine();
        in.nextLine();
        mainMenu();

    }
    public void displayCostProviderTwo(){
        System.out.println("Cost under Provider 2");
        cost[1]=costDisplayFormat(0.15f,0.04f,0.12f,0.04f);
        in.nextLine();
        in.nextLine();
        mainMenu();
    }
    public void displayCostProviderThree(){
        System.out.println("Cost under Provider 3");
        cost[2]=costDisplayFormat(0.1f,0.02f,0.2f,0.08f);
        in.nextLine();
        in.nextLine();
        mainMenu();
    }


    public float costDisplayFormat(float a,float b,float c,float d){
        printAsterisk();
        System.out.println("Number of calls ="+totalCall+"\t\t\t\t\t\t\t$"+totalCall*a);
        System.out.println("Total call time(secs) ="+callLength+"\t\t\t\t\t$"+callLength*b);
        System.out.println("Number of SMS ="+totalSms+"\t\t\t\t\t\t\t$"+totalSms*c);
        System.out.println("Data Usage (MB) ="+totalData+"\t\t\t\t\t\t\t$"+totalData*d);
        printAsterisk();
        float x=(totalCall*a)+(callLength*b)+(totalSms*c)+(totalData*d); //calculating the total cost
        System.out.println("TOTAL COST\t\t\t\t\t\t\t\t\t"+"$"+x);
        return x;


    }

    public void clearUsageDetails()
    {
        totalCall=0;
        callLength=0;
        totalSms=0;
        totalData=0;
        printAsterisk();
        System.out.println("ALL USAGE DETAILS HAVE BEEN RESET TO 0");
        printAsterisk();
        in.nextLine();
        in.nextLine();
        mainMenu();
    }
    public void exitApp(){
        printAsterisk();
        float p1=cost[0];
        float p2=cost[1];
        float p3=cost[2];
        Arrays.sort(cost);
        if(p1==p2&&p2==p3){
            System.out.println("All provider are same");
            printAsterisk();
            in.nextLine();
            in.nextLine();
            System.exit(0);
        }
        if(cost[0]==p1){
            System.out.println("Provider 1 is cheapest");
        }
        if(cost[0]==p2){
            System.out.println("Provider 2 is cheapest");
        }
        if(cost[0]==p3){
            System.out.println("Provider 3 is cheapest");
        }
        if(cost[2]==p1){
            System.out.println("Provider 1 is expensive");
        }
        if(cost[2]==p2){
            System.out.println("Provider 2 is expensive");
        }
        if(cost[2]==p3){
            System.out.println("Provider 3 is expensive");
        }
        printAsterisk();
        in.nextLine();
        in.nextLine();
        System.exit(0);
    }














    //this method is to store the phone calls
    //this method is to get the usage details
    //this method is to get the user selection
    public byte getSelection(){
        System.out.print("\n Enter your selection:");
        byte ch; //for string the choice
        ch=in.nextByte();
        return  ch;

    }
    //this method is to print asterisk
    public void printAsterisk(){
        for(int i=0;i<100;i++){
            System.out.print("*");
        }
        System.out.print("\n");
    }
    //this method is to display the welcome menu
    public void welcomeMenu(){
        printAsterisk();
        System.out.println("WELCOME TO PHONE COMPARISON SYSTEM");
        System.out.println("");
        System.out.println("Developed by");
        System.out.println("\t Name1,student Ids:Id1");
        System.out.println("\t Name2,student Ids:Id2");
        System.out.println("\t Name3,student Ids:Id3");
        System.out.println("\t Name4,student Ids:Id4");
        System.out.println("OODP101 Object Oriented Design and Programming");
        LocalDateTime myDateObj = LocalDateTime.now(); //getting current date and time
        DateTimeFormatter myDateFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //for formatting
        System.out.println(myDateObj.format(myDateFormatObj));
        printAsterisk();

    }
}
