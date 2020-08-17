package sk.stuba.fei.zadanie3.user;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public   class Adress {
    @NotEmpty
    protected String PSC;
    @NotEmpty
    protected String cityName;
    @NotEmpty
    protected String streetName;
    @NotEmpty
    @Min(0)
    protected String houseNumber;

    public Adress(String PSC, String cityName, String streetName, String houseNumber) {
        setPSC(PSC);
        setCityName(cityName);
        setStreetName(streetName);
        setHouseNumber(houseNumber);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "PSC='" + PSC + '\'' +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    public String getPSC() { return PSC; }
    public void setPSC(String PSC) {
//        if (PSC == null){
//            throw new IllegalArgumentException("bad PSC");
//        }
        this.PSC = PSC;
    }

    public String getCityName() {return cityName; }
    public void setCityName(String cityName) {
//        if (cityName == null){
//            throw new IllegalArgumentException("bad cityName");
//        }
        this.cityName = cityName;
    }

    public String getStreetName() {return streetName; }
    public void setStreetName(String streetName) {
//        if (streetName == null){
//            throw new IllegalArgumentException("bad streetName");
//        }
        this.streetName = streetName;
    }

    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) {
//        if (houseNumber < 0){
//            throw new IllegalArgumentException("bad houseNumber");
//        }
        this.houseNumber = houseNumber;
    }
}
