public class main {
    public void main(String[] args) {
        Moveable[] moveables = new Moveable[3];
        moveables[0] = new Car();
        moveables[1] = new Player("Naor");
        moveables[2] = new Ball();

        System.out.println("################ CREATE ################");
        printMoveables(moveables);
        System.out.println("################ MOVE ################");
        Move(moveables);
        printMoveables(moveables);
        System.out.println("################ END ################");

    }


    public void printMoveables(Moveable[] moveables) {
        for (Moveable moveable : moveables) {
            System.out.println(moveable);
        }
    }

    public void Move(Moveable[] moveables) {
        for (Moveable moveable : moveables) {
            int random = (int) (Math.random() * 10);
            for (int i = 0; i < random; i++) {
                moveable.moveLeft();
            }
            random = (int) (Math.random() * 10);
            for (int i = 0; i < random; i++) {
                moveable.moveRight();
            }
        }
    }
}
