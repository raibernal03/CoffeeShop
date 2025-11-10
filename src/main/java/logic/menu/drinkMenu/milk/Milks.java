package logic.milk;

public enum Milks {
    WHOLE("Whole Milk"), SOY("Soy Milk"), ALMOND("Almond Milk"), NONFAT("Non-Fat Milk");
    private String description;
    private Milks(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
