package sk.stuba.fei.zadanie3.contract.lifeInsurence;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.user.User;

@NoArgsConstructor
public class AccidentInsurance extends LifeInsurence {
    private int consequencesAccident; //trvalé následky úrazu (poistná suma v eurách)
    private int deathAccident; //Smrť v dôsledku úrazu , €
    private int dailyPayment; //Denné odškodné za hospitalizáciu, €
    private TerritorialValidity territorialValidity;

    public AccidentInsurance(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment, User insured, int consequencesAccident, int deathAccident, int dailyPayment, TerritorialValidity territorialValidity) {
        super(id, date, user, startDate, endDate, amaunt, monthlyPayment, insured);
        setConsequencesAccident(consequencesAccident);
        setDeathAccident(deathAccident);
        setDailyPayment(dailyPayment);
        setTerritorialValidity(territorialValidity);
    }

    //SETTER
    public void setConsequencesAccident(int consequencesAccident) {
        if (consequencesAccident < 0 ){
            throw new IllegalArgumentException("consequencesAccident have to be positive");
        }
        this.consequencesAccident = consequencesAccident;
    }

    public void setDeathAccident(int deathAccident) {
        if (deathAccident < 0 ){
            throw new IllegalArgumentException("deathAccident have to be positive");
        }
        this.deathAccident = deathAccident;
    }

    public void setDailyPayment(int dailyPayment) {
        if (dailyPayment < 0 ){
            throw new IllegalArgumentException("dailyPayment have to be positive");
        }
        this.dailyPayment = dailyPayment;
    }

    public void setTerritorialValidity(TerritorialValidity territorialValidity) {
        if (territorialValidity == null){
            throw new IllegalArgumentException("Number have to be 1(Slovakia),2(world),3(world+Slovakia)");
        }
        this.territorialValidity = territorialValidity;
    }

    public int getConsequencesAccident() {
        return consequencesAccident;
    }

    public int getDeathAccident() {
        return deathAccident;
    }

    public int getDailyPayment() {
        return dailyPayment;
    }

    public TerritorialValidity getTerritorialValidity() {
        return territorialValidity;
    }

    @Override
    public String toString() {
        return "AccidentInsurance{" +
                "consequencesAccident=" + consequencesAccident +
                ", deathAccident=" + deathAccident +
                ", dailyPayment=" + dailyPayment +
                ", territorialValidity=" + territorialValidity +
                ", id=" + id +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amaunt=" + amaunt +
                ", monthlyPayment=" + monthlyPayment +
                ", insured=" + getInsured() +
                '}';
    }
}
