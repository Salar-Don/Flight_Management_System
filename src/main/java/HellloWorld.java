import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class HellloWorld {
    public static <exception> void main(String args[]) throws IOException {
        int Option = -1;
        Booking B = new Booking();
        Scanner Scan = new Scanner(System.in);
        FlightManagementSys FMS = new FlightManagementSys();
        Customer C = new Customer();
        FMS.populate();
        //THE MAIN MENU
        while(Option != 0) {
            System.out.println("Welcome to Salar Airways :) \n");
            System.out.println("Please Tell us what you desire :)\n");
            System.out.println("1. See flight Schedule");
            System.out.println("2. Book A Flight");
            Option = Scan.nextInt();
            //IF OPTION 1 IS SELECTED
            if (Option == 1) {
                int ScheduleOption = -1;
                int SchOption = 0;
                System.out.println("Select one of the following to filter down your searches\n");
                System.out.println("1. Filter by City of Departure and Arrival");
                System.out.println("2. Filter by Date of Flight");
                System.out.println("3. Fiter by Type of AirPlane");
                System.out.println("4. No Filtering, Show all Flights");
                SchOption = Scan.nextInt();
                if (SchOption == 1) {
                    String Dep;
                    String Arr;
                    System.out.println("Enter the City of Departure");
                    Dep = Scan.next();
                    try
                    {
                        checkManzil(Dep);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Sorry!, We dont fly there " + e);
                        break;
                    }
                    System.out.println("Enter the City of Arrival");
                    Arr = Scan.next();
                    try
                    {
                        checkManzil(Arr);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Sorry! we dont fly to there " + e);
                        break;
                    }
                    FMS.getFltSch().ScheduleByCity(Dep, Arr);

                }
                if (SchOption == 2) {
                    String Date = "";
                    System.out.println("Enter Date in D/M/Y Format");
                    Date = Scan.next();
                    try
                    {
                        checkDate(Date);
                    }
                    catch(Exception e)
                    {
                        System.out.println("You entered an invalid date " + e);
                    }
                    FMS.getFltSch().ScheduleByDate(Date);

                }
                if (SchOption == 3) {
                    String Aero = "";
                    System.out.println("Enter The AirCraft you wish to travel on");
                    Aero = Scan.next();
                    try
                    {
                        checkJahaaz(Aero);
                    }
                    catch(Exception e)
                    {
                        System.out.println("That AirCraft is not avaiable " + e);
                    }
                    FMS.getFltSch().ScheduleByAirCraft(Aero);
                }
                if (SchOption == 4)
                {
                    FMS.getFltSch().DisplaySchedule();
                }
            }
            if(Option == 2)
            {
                String Data = "";
                System.out.println("Great! Before we get you on board, we need you to enter your personal information");
                String Sample = "";
                int Sample2 = 0;
                System.out.println("Enter your Passport Number");
                Sample = Scan.next();
                C.setPassport_Number(Sample);
                Data += Sample;
                Data += " ";
                System.out.println("Enter you Name");
                Sample = Scan.next();
                C.setCustomer_Name(Sample);
                Data += Sample;
                Data += " ";
                System.out.println("Enter you Age");
                Sample2 = Scan.nextInt();
                try {
                    checkAge(Sample2);
                }
                catch (Exception e)
                {
                    System.out.println("Invalid Age Entered " + e);
                    break;
                }
                C.setAge(Sample2);
                Data += String.valueOf(Sample2);
                Data += " ";
                System.out.println("Enter your Gender");
                Sample = Scan.next();
                C.setGender(Sample);
                Data += Sample;
                Data += " ";
                System.out.println("Enter you Address");
                Sample = Scan.next();
                C.setAddress(Sample);
                Data += Sample;
                Data += " ";
                System.out.println("Collected");
                Sample = Scan.next();
                C.setPassport_Number(Sample);
                Data += Sample;
                System.out.println("Thank you for sharing your information with us " + C.getCustomer_Name() + " :).");
                System.out.println("Where will you be flying too with Salar AirWays");
                String Manzil = "";
                String Makaan = "";
                Manzil = Scan.next();
                try {
                    checkManzil(Manzil);
                }
                catch(Exception e)
                {
                    System.out.println("Sorry! Salar Airways does not fly there" + e);
                    break;
                }
                System.out.println("Where will you be catching the flight from?");
                Makaan = Scan.next();
                try{
                    checkManzil(Makaan);
                }
                catch(Exception e)
                {
                    System.out.println("Sorry! Salar Airways does not floy from here" + e);
                    break;
                }
                //DECLARING THE PLANE DATE AND OPTION SELECTED
                int Marzi = 0;
                String Tareekh = "";
                String Jahaaz = "";
                System.out.println("Do you want to specify the date you want to travel on? Or display Flights for the coming 5 days");
                System.out.println("1. Yes");
                System.out.println("2. No");
               Marzi = Scan.nextInt();
                if(Marzi == 1)
                {
                    System.out.println("Enter the Date.");
                    Tareekh = Scan.next();
                    try{
                        checkDate(Tareekh);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Date is Invalid :( " + e);
                        break;
                    }
                }
                else
                {
                    Tareekh = "NONE";
                }
                System.out.println("Do you want to Specify the AirCraft you want to travel on?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                Marzi = Scan.nextInt();
                if(Marzi == 1)
             {
                    System.out.println("Enter the Plane you want to hop in");
                    Jahaaz = Scan.next();
                    try
                    {
                        checkJahaaz(Jahaaz);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Sorry, Salar Airways does not have " + Jahaaz + " in its fleet" + e);
                        break;
                }
                    System.out.println("Here are some Flights that will get you going");

                }
                else
                {
                    Jahaaz = "NONE";
                }
               boolean check = FMS.getFltSch().FindAFlight(Manzil,Makaan,Tareekh,Jahaaz);
                if(check == false)
                {
                    int fl1,fl2;
                    System.out.println("Enter the Flight Number you want to book");
                    fl1 = Scan.nextInt();
                    C.BookFlight(fl1-1);
                    System.out.println("Enter the second flight number you want to book");
                    fl2 = Scan.nextInt();
                    C.BookFlight(fl2-1);
                    System.out.println("You have booked the Following Flights");
                    FMS.getFltSch().Flt[(C.getFlights_Index().get(0))].Display();
                    FMS.getFltSch().Flt[(C.getFlights_Index().get(1))].Display();
                    String S = FMS.getFltSch().ReturnFlight(fl1-1);
                    B.MakeBooking(Data);
                    B.MakeBooking(S);
                     S = FMS.getFltSch().ReturnFlight(fl2-1);
                    B.MakeBooking(S);

                }
                if(check == true)
                {
                    int fl1;
                    System.out.println("Enter the Flight Number you want to book");
                    fl1 = Scan.nextInt();
                    C.BookFlight(fl1-1);
                    FMS.getFltSch().Flt[(C.getFlights_Index().get(0))].Display();
                    String S = FMS.getFltSch().ReturnFlight(fl1-1);
                    B.MakeBooking(Data);
                    B.MakeBooking(S);
                }




;
            }

        }
    }
    static void checkDate(String Date) throws DateException{
        if((Date.compareTo("01/01/2021") != 0) && (Date.compareTo("02/01/2021") != 0) && (Date.compareTo("03/01/2021") != 0) && (Date.compareTo("04/01/2021") != 0) && (Date.compareTo("05/01/2021") != 0));
        {
            throw new DateException ("Flight Dates span from 01/01/2021 to 05/01/2021");
        }

    }
    static void checkAge(int Age) throws AgeException
    {
        if(Age < 18)
        {
        throw new AgeException("You must be above 18years to Book a flight");

        }
        else
        {
            System.out.println("Thank you for disclosing your age");
        }
    }
    static void checkManzil(String M) throws FlightException
    {
        if((M.compareTo("KHI") != 0) && (M.compareTo("ISL") != 0) && (M.compareTo("LHR") != 0) && (M.compareTo("GIL") != 0))
        {
            throw new FlightException("Enter a place we fly to next time! Sorry for the dissapointment");
        }
        else
        {
            System.out.println("Great");
        }
    }
    static void checkJahaaz(String Plane) throws AirCraftException {
        if((Plane.compareTo("ATR") !=0) && (Plane.compareTo("AirBus A320") != 0) && (Plane.compareTo("Boeing 777") != 0) )
        {
            throw new AirCraftException("Salar Airways has Boeing 777, ATR and AirBus A320 in its versatile fleet");
        }
        else {
            System.out.println("Good choice!q");
        }
    }


}

