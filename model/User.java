package dnr.model;

public class User {

    protected String name;
    protected Position position;

    public User(String name, int x, int y) {
        this.name = name;
        this.position = new Position(x, y);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name
    }

    public Position getPosition() {
        return this.position;
    }
}
