import java.util.ArrayList;

public class Customer {
    int Age;

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassport_Number() {
        return Passport_Number;
    }

    public void setPassport_Number(String passport_Number) {
        Passport_Number = passport_Number;
    }

    public String getFlying_From() {
        return Flying_From;
    }

    public void setFlying_From(String flying_From) {
        Flying_From = flying_From;
    }

    public String getFlying_To() {
        return Flying_To;
    }

    public void setFlying_To(String flying_To) {
        Flying_To = flying_To;
    }

    String Customer_Name;
    String Gender;
    String Address;
    String Passport_Number;
    String Flying_From;
    String Flying_To;

    public ArrayList<Integer> getFlights_Index() {
        return Flights_Index;
    }

    public void setFlights_Index(ArrayList<Integer> flights_Index) {
        Flights_Index = flights_Index;
    }

    ArrayList<Integer> Flights_Index = new ArrayList<Integer>();
   public Customer() {
        Customer_Name = "";
        Gender = "";
        Address = "";
        Passport_Number = "";
        Flying_From = "";
        Flying_To = "";
        Age = 0;
    }
    void BookFlight(int X)
    {
        Flights_Index.add(X);
    }
}
