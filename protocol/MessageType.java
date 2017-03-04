public enum MessageType {
    CONNECTION("@connect"),
    PRIVATE("@private"),
    PUBLIC("@public");

    private String string;

    MessageType(String string) {
        this.string = string;
    }

    public String toString() {
        return this.string;
    }
}
