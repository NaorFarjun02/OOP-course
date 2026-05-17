public class Player implements Moveable {

    private int position = 0;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void moveLeft() {
        this.setPosition(position - 1);
    }

    @Override
    public void moveRight() {
        this.setPosition(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position;
    }


    @Override
    public String toString() {
        return "The player " + this.name + " is in position: " + this.getPosition();
    }

}
