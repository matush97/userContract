package sk.stuba.fei.zadanie3.contract.nonlifesurence;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.user.Adress;
import sk.stuba.fei.zadanie3.user.User;

@NoArgsConstructor
public class HouseholdInsurance extends NonLifeInsurance {
    // TODO Poistenie domácnosti


    public HouseholdInsurance(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment, TypeProperty typeProperty, Adress adress, int valueProperty, int valueHouseholdEquipment) {
        super(id, date, user, startDate, endDate, amaunt, monthlyPayment, typeProperty, adress, valueProperty, valueHouseholdEquipment);
    }

    @Override
    public String toString() {
        return "HouseholdInsurance{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amaunt=" + amaunt +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
