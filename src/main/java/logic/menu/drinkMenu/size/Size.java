package logic.size;

public enum Size {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private String size;

    private Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
