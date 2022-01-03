public class GameObject {
    Type type;
    Position finalPosition;

    public GameObject(Type type, Position finalPosition) {
        this.type = type;
        this.finalPosition = finalPosition;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getFinalPosition() {
        return finalPosition.getX();
    }

    public void setFinalPosition(Position finalPosition) {
        this.finalPosition = finalPosition;
    }

    public void updateGameObject(Type type, Position finalPosition) {
        this.type = type;
        this.finalPosition = finalPosition;
    }
}
