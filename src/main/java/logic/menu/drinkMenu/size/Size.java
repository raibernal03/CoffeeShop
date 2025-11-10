package logic.menu.drinkMenu.size;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String size;

    private Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
