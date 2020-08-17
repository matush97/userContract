package sk.stuba.fei.zadanie3.contract.lifeInsurence;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.contract.Contract;
import sk.stuba.fei.zadanie3.user.User;

@NoArgsConstructor
public abstract class LifeInsurence extends Contract {
    //TODO Zivotne poistenie
    protected User insured; //poisteny
//    public LifeInsurence(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment) {
//        super(id, date, user, startDate, endDate, amaunt, monthlyPayment);
//    }


    public LifeInsurence(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment, User insured) {
        super(id, date, user, startDate, endDate, amaunt, monthlyPayment);
        setInsured(insured);
    }

    public User getInsured() {
        return insured;
    }

    public void setInsured(User insured) {
        if(insured == null){
            throw new IllegalArgumentException("insured is null");
        }
        this.insured = insured;
    }
}
