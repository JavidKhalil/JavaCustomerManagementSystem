package Customer;

import file.FileOps;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer implements Serializable {

    private String name;
    private String surname;
    private String company;
    private static int id = 0;

    public Customer() {
        try {
            this.id = (this.id == 0) ? 0 : FileOps.countForLine();
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ;
    
    public Customer(String name, String surname, String company) {
        try {
            this.id = (this.id == 0) ? 1 : FileOps.countForLine();
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
    }

}
