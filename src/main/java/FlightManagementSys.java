public class FlightManagementSys {
    public static FlightSchedule getFltSch() {
        return FltSch;
    }

    public static void setFltSch(FlightSchedule fltSch) {
        FltSch = fltSch;
    }

    public Customer getC() {
        return C;
    }

    public void setC(Customer c) {
        C = c;
    }

    private static FlightSchedule FltSch;
    Customer C;
        static void FlightManagementSys()
        {

        }
        void populate()
        {
            System.out.println("We here in FMS populate \n");
            FltSch = new FlightSchedule();
            FltSch.SetSchedule();
        }
}
