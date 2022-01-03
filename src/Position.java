public class Position {
    int x;

    public Position() {
        this.x =0;
    }
    public Position(String position) {
        this.x =Integer.parseInt(position);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void moveX(int x){
        this.x+=x;
    }
}
