package sk.stuba.fei.zadanie3.contract.nonlifesurence;

import lombok.Getter;

@Getter
public enum TypeProperty {
    FLAT("flat"),
    HOUSE_BRICK("house brick"),
    HOUSE_WOOD("house wood");


    private String name;

    TypeProperty(String name) {
        this.name = name;
    }


}
