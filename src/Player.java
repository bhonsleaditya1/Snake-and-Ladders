public class Player {
    int Id;
    Position position;

    public Player(int playerSerial) {
        this.Id = playerSerial;
        this.position = new Position();
    }

    public int getPosition(){
        return position.getX();
    }
    public void updatePosition(int x){
        position.setX(x);
        System.out.println(Id+" moves to "+ (x+1));
    }
    public void movePosition(int x){
        position.moveX(x);
        System.out.println(Id+" moves to "+ (x+1));
    }
}
