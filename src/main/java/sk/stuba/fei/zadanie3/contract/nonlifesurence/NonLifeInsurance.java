package sk.stuba.fei.zadanie3.contract.nonlifesurence;

import lombok.NoArgsConstructor;
import sk.stuba.fei.zadanie3.contract.Contract;
import sk.stuba.fei.zadanie3.user.Adress;
import sk.stuba.fei.zadanie3.user.User;

@NoArgsConstructor
public abstract class NonLifeInsurance extends Contract {
    //TODO Nezivotne poistenie
    private TypeProperty typeProperty;
    private Adress adress;
    private int valueProperty; //hodnota nehnutelnosti €
    private int valueHouseholdEquipment; //hodnota zariadenia domácnosti €

    public NonLifeInsurance(int id, String date, User user, String startDate, String endDate, int amaunt, int monthlyPayment, TypeProperty typeProperty, Adress adress, int valueProperty, int valueHouseholdEquipment) {
        super(id, date, user, startDate, endDate, amaunt, monthlyPayment);
        setTypeProperty(typeProperty);
        setAdress(adress);
        setValueProperty(valueProperty);
        setValueHouseholdEquipment(valueHouseholdEquipment);
    }

    //public NonLifeInsurance() {
     //   super();
    //}

    //GETTRE A SETTRE
    public TypeProperty getTypeProperty() { return typeProperty; }
    public void setTypeProperty(TypeProperty typeProperty) {
        if (typeProperty == null){
            throw  new IllegalArgumentException("Property type is null");
        }
        this.typeProperty = typeProperty;
    }

    public Adress getAdress() { return adress; }
    public void setAdress(Adress adress) {
        if (adress == null){
            throw  new IllegalArgumentException("adress is null");
        }
        this.adress = adress;
    }

    public int getValueProperty() { return valueProperty; }
    public void setValueProperty(int valueProperty) {
        if (valueProperty < 0){
            throw  new IllegalArgumentException("Prize of value property have to be positive");
        }
        this.valueProperty = valueProperty;
    }

    public int getValueHouseholdEquipment() { return valueHouseholdEquipment; }
    public void setValueHouseholdEquipment(int valueHouseholdEquipment) {
        if (valueHouseholdEquipment < 0){
            throw  new IllegalArgumentException("Prize od value house equipment have to be positive");
        }
        this.valueHouseholdEquipment = valueHouseholdEquipment;
    }
}
