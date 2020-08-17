package sk.stuba.fei.zadanie3.contract;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.user.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@NoArgsConstructor
public abstract class Contract {
    protected int id;

    protected String date; //datum vzniku
    protected User user; //referencia na pouzivatela
    protected  String startDate; //dátum začiatku  poistenia
    protected String endDate;   //dátum konca poistenia
    protected int amaunt;   // výšku poistného plnenia(suma, na ktorú sa poisťuje),
    protected int monthlyPayment; //výšku mesačnej splátky


    public Contract(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment) {
        setId(id);
        setDate(date);
        setUser(user);
        setStartDate(startDate);
        setEndDate(endDate);
        setAmaunt(amaunt);
        setMonthlyPayment(monthlyPayment);
    }


    public int getId() {return id; }
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id have to be positive");
        this.id = id;
    }

    public String getDate() { return date; }
    public void setDate(String date) {
        if (date == null) throw new IllegalArgumentException("date is null");
        this.date = date;
    }

    public User getUser() { return user; }
    public void setUser(User user) {
        if (user == null) throw new IllegalArgumentException("user is null");
        this.user = user;
    }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) {
        if (startDate == null) throw new IllegalArgumentException("Start date is null");
        this.startDate = startDate;
    }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) {
        if (endDate == null) throw new IllegalArgumentException("Final date is null");
        this.endDate = endDate;
    }

    public int getAmaunt() { return amaunt; }
    public void setAmaunt(int amaunt) {
        if (amaunt < 0) throw new IllegalArgumentException("amount have to be positive");
        this.amaunt = amaunt;
    }

    public int getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(int monthlyPayment) {
        if (monthlyPayment < 0 ) throw new IllegalArgumentException("Monthly payment have to be positive");
        this.monthlyPayment = monthlyPayment;
    }
}
