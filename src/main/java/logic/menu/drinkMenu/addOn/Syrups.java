package logic.menu.drinkMenu.addOn;

public enum Syrups {
    /*
    honey
    lavender
    lechera
    rose
    vanilla
    chocolate
    strawberry
    hazelnut
    caramel
    */
    HONEY("Honey"),
    LAVENDER("Lavender"),
    LECHERA("Lechera"),
    ROSE("Rose"),
    VANILLA("Vanilla"),
    CHOCOLATE("Chocolate"),
    STRAWBERRY("Strawberry"),
    HAZELNUT("Hazelnut"),
    CARAMEL("Caramel");


    private String description;

    public String getDescription() {
        return description;
    }


    Syrups(String description) {

        this.description = description;
    }
}
