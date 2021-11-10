import java.io.*;
public class Booking {
    public Booking()
    {

    }
    void MakeBooking(String S)  {
       try {
           FileWriter bw = new FileWriter("C:\\Users\\AVM Noor Abbas\\Desktop\\FlightBookings.txt",true);
           bw.write("\n");
           bw.write(S);
           bw.write("\n");
           bw.close();
       }
       catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
