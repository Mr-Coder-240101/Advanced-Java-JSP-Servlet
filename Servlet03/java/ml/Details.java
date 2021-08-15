package ml;

public class Details {
    
    String fname;
    String lname;
    long mobileno;
    String email;
    int age;
    String city;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    } 

    @Override
    public String toString() {
        return "Details{" + "fname=" + fname + ", lname=" + lname + ", mobileno=" + mobileno + ", email=" + email + ", age=" + age + ", city=" + city + '}';
    }
    
    
}
