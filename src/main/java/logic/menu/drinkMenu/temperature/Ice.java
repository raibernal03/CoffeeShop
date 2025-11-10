package logic.menu.drinkMenu.temperature;

public enum Ice {
    REGULAR("Regular Ice"),
    EXTRA("Extra Ice"),
    EASY("Easy Ice"),
    NOICE("No Ice");

    private String description;

    Ice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
