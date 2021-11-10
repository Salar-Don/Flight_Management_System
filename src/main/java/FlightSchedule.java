import java.io.*;
import java.util.Scanner;
public class FlightSchedule {
    Flight[] Flt = new Flight[100];
    void FlightSchedule()
    {

    }
    String ReturnFlight(int Index)
    {
        String S = "";
        int temp;
       temp = (Flt[Index].getFlight_Number());
       S += String.valueOf(temp);
       S += " ";
       temp = Flt[Index].getTotal_Seats();
       S += String.valueOf(temp);
        S += " ";
        S += Flt[Index].getOrigin();
        S += " ";
        S += Flt[Index].getDestination();
        S += " ";
        S += Flt[Index].getDepartureTime();
        S += " ";
        S += Flt[Index].getArrivalTime();
        S += " ";
        S += Flt[Index].getDate();
        return S;
    }

    //--------- DISPLAYS THE ENTIRE SCHEDULE----------//
    boolean FindAFlight(String To, String From, String Date, String AirPlane)
    {
        boolean flag = false;
    if(Date.compareTo("NONE") != 0) {
        if (AirPlane.compareTo("NONE") != 0) {
            for (int i = 0; i < 80; i++) {
                if ((To.compareTo(Flt[i].getDestination())) == 0) {
                    if ((From.compareTo(Flt[i].getOrigin())) == 0) {
                        if ((Date.compareTo(Flt[i].getDate())) == 0) {
                            if ((AirPlane.compareTo(Flt[i].getAirPlane())) == 0) {
                                flag = true;
                                Flt[i].Display();
                            }
                        }
                    }
                }
            }
        }
        if(Date.compareTo("NONE") == 0) {
            if (AirPlane.compareTo("NONE") != 0) {
                for (int i = 0; i < 80; i++) {
                    if ((To.compareTo(Flt[i].getDestination())) == 0) {
                        if ((From.compareTo(Flt[i].getOrigin())) == 0) {
                                if ((AirPlane.compareTo(Flt[i].getAirPlane())) == 0) {
                                    flag = true;
                                    Flt[i].Display();
                                }
                        }
                    }
                }
            }
        }
        if(AirPlane.compareTo("NONE") == 0) {
            if (Date.compareTo("NONE") != 0) {
                for (int i = 0; i < 80; i++) {
                    if ((To.compareTo(Flt[i].getDestination())) == 0) {
                        if ((From.compareTo(Flt[i].getOrigin())) == 0) {
                            if ((Date.compareTo(Flt[i].getDate())) == 0) {
                                    flag = true;
                                Flt[i].Display();
                            }
                        }
                    }
                }
            }
        }
        // FINDING FLIGHT IF NO AIRPLANE IS SPECIFIED
    }
        if(AirPlane.compareTo("NONE") == 0)
        {
            if (Date.compareTo("NONE") == 0)
            {
                    for (int i = 0; i < 70; i++) {
                        if ((To.compareTo(Flt[i].getDestination())) == 0) {
                            if ((From.compareTo(Flt[i].getOrigin())) == 0) {
                                flag = true;
                               Flt[i].Display();
                            }
                        }
                    }
                }
            }
        //IF NO DIRECT FLIGHT FOUND
        if(flag == false)
        {
            System.out.println("NO Direct Flights were found for your travels");
            System.out.println("Here are some Indirect Flights that May Assist you");

            for(int i=0;i<80;i++)
            {
                for(int j=0;j<80;j++)
                {
                    if((From.compareTo(Flt[i].getOrigin())) == 0)
                    {
                        if((To.compareTo(Flt[j].getDestination()))==0)
                        {
                            if((Flt[i].getDestination().compareTo(Flt[j].getOrigin())) == 0)
                            {
                                if((Flt[i].getDate().compareTo(Flt[j].getDate()) )== 0)
                                {
                                    Flt[i].Display();
                                    Flt[j].Display();
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
        }

    void DisplaySchedule()
    {
         for(int FlightIndex = 0 ; FlightIndex < 80 ; FlightIndex++) {
            Flt[FlightIndex].Display();
         }
    }
    //--------- DISPLAYING SCHEDULE BY DEPARTURE CITY AND ARRIVAL CITY----------//
    void ScheduleByCity(String Arr,String Dep)
    {
        for(int FlightIndex = 0 ; FlightIndex < 80 ; FlightIndex++) {
           // System.out.println(Arr + " " +  Flt[FlightIndex].getOrigin() + " " + Dep + " " + Flt[FlightIndex].getDestination());
            if ((Arr.compareTo(Flt[FlightIndex].getOrigin())) == 0) {
                if ((Dep.compareTo(Flt[FlightIndex].getDestination())) == 0) {
                  Flt[FlightIndex].Display();
                }
            }
        }
    }
    void ScheduleByDate(String Dt)
    {
        for(int FlightIndex = 0 ; FlightIndex < 80 ; FlightIndex++) {
            // System.out.println(Arr + " " +  Flt[FlightIndex].getOrigin() + " " + Dep + " " + Flt[FlightIndex].getDestination());
            if ((Dt.compareTo(Flt[FlightIndex].getDate())) == 0) {
                   Flt[FlightIndex].Display();
            }
        }

    }
    void ScheduleByAirCraft(String AC)
    {
        for(int FlightIndex = 0 ; FlightIndex < 80 ; FlightIndex++) {
            // System.out.println(Arr + " " +  Flt[FlightIndex].getOrigin() + " " + Dep + " " + Flt[FlightIndex].getDestination());
            if ((AC.compareTo(Flt[FlightIndex].getAirPlane())) == 0) {
            Flt[FlightIndex].Display();
            }
        }

    }


    //--------- CREATING SCHEDULE BY READING FROM FILE---------//
    void SetSchedule()
    {
        //TIME FOR FILE HANDLING
        System.out.println("trying to populate schedule \n");
        Flt = new Flight[100];
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\AVM Noor Abbas\\Desktop\\FlightScheduleFinal.txt"));
            String S;
            int FlightIndex = 0;
            while((S = br.readLine()) != null) {
                int i = 0;
                int j = 0;
                //  System.out.println(S);
                String FlightNo = "";
                String TotSeats = "", ori = "", Des = "", TakeOff = "", Landing = "", Fare = "";
                String Date = "";
                while (i < S.length()) {
                    if (S.charAt(i) == ' ') {
                        j++;
                        i++;
                    }
                    if (j == 0) {
                        FlightNo += S.charAt(i);
                    }
                    if (j == 1) {
                        TotSeats += S.charAt(i);
                    }
                    if (j == 2) {
                        ori += S.charAt(i);
                    }
                    if (j == 3) {
                        Des += S.charAt(i);
                    }
                    if (j == 4) {
                        Fare += S.charAt(i);
                    }
                    if (j == 5) {
                        TakeOff += S.charAt(i);
                    }
                    if (j == 6) {
                        Landing += S.charAt(i);
                    }
                    if (j == 7) {
                        Date += S.charAt(i);
                    }
                    i++;
                }
                if(FlightIndex < 80) {
                    Flt[FlightIndex] = new Flight();
                    Flt[FlightIndex].setFlight_Number(Integer.parseInt(FlightNo));
                    Flt[FlightIndex].setTotal_Seats(Integer.parseInt(TotSeats));
                    Flt[FlightIndex].setOrigin(ori);
                    Flt[FlightIndex].setDestination(Des);
                    Flt[FlightIndex].setFare(Integer.parseInt(Fare));
                    Flt[FlightIndex].setDepartureTime(TakeOff);
                    Flt[FlightIndex].setArrivalTime(Landing);
                    Flt[FlightIndex].setDate(Date);
                    if(TotSeats.compareTo("100") == 0)
                    {
                        Flt[FlightIndex].setAirPlane("ATR");
                    }
                    if(TotSeats.compareTo("200") == 0)
                    {
                        Flt[FlightIndex].setAirPlane("AirBus A320");
                    }
                    if(TotSeats.compareTo("300") == 0)
                    {
                        Flt[FlightIndex].setAirPlane("Boeing 777");
                    }
                   // System.out.println(Flt[FlightIndex].getFlight_Number() + " " + Flt[FlightIndex].getTotal_Seats() + " " + Flt[FlightIndex].Origin + " " + Flt[FlightIndex].getDestination() + " " + Flt[FlightIndex].Fare + " " + Flt[FlightIndex].DepartureTime + " " + Flt[FlightIndex].ArrivalTime + " " + Flt[FlightIndex].Date);
                    FlightIndex++;
                }
            }
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   Scanner Reader = new Scanner(Schedule);

    }

}
