package sk.stuba.fei.zadanie3.contract.lifeInsurence;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.user.User;

@NoArgsConstructor
public class TravelInsurence  extends LifeInsurence {

    private boolean inEurope; //inEurope == true
    private  PurposeOfTrip purposeOfTrip;//číselníková hodnota


    public TravelInsurence(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment, User insured, boolean inEurope, PurposeOfTrip purposeOfTrip) {
        super(id, date, user, startDate, endDate, amaunt, monthlyPayment, insured);
        setInEurope(inEurope);
        setPurposeOfTrip(purposeOfTrip);
    }

    //GETTRE A SETTRE
   public boolean isInEurope() { return inEurope; }
    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public PurposeOfTrip getPurposeOfTrip() { return purposeOfTrip; }
    public void setPurposeOfTrip(PurposeOfTrip purposeOfTrip) {
        if (purposeOfTrip == null){
            throw new IllegalArgumentException("Purpose must be numbre 1,2,3");
        }
        this.purposeOfTrip = purposeOfTrip;
    }

    @Override
    public String toString() {
        return "TravelInsurence{" +
                "inEurope=" + inEurope +
                ", purposeOfTrip=" + purposeOfTrip +
                ", id=" + id +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amaunt=" + amaunt +
                ", monthlyPayment=" + monthlyPayment +
                ", insured=" + insured +
                '}';
    }
}
