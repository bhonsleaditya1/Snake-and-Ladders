import java.util.ArrayList;
import java.util.List;

public class Board {
    int boardSize;
    GameObject[] board;
    List<Player> players;
    Player currentPlayer;
    GameState gameState;
    Dice dice;
    int limit;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.limit = boardSize*boardSize-1;
        this.board = new GameObject[limit+1];
        this.players = new ArrayList<>();
        this.currentPlayer = null;
        this.dice = new Dice();
        this.gameState = GameState.RESET;
    }

    public void addPlayer(Player player){
      players.add(player);
    }

    public void addGameObject(String position,String type,String finalPosition){
        Integer pos = Integer.parseInt(position);
        this.board[pos] = validationGameObject(pos,new GameObject(Type.valueOf(type.toUpperCase()),new Position(finalPosition)));
    }

    public void updatePlayer(Player player) throws Exception {
        if(!gameState.equals(GameState.INPROGRESS)){
            throw new Exception("Game not in progress");
        }
        int diceValue = dice.rollDice();
        System.out.println(player.Id+" rolls dice: "+ diceValue);
        int position = player.getPosition();
        position+= diceValue;
        if(position>limit){
            position -= diceValue;
            System.out.println(player.Id+" Dice value more than "+(limit-position)+" Try again on next turn");
        }
        else if(position==limit){
            player.updatePosition(position);
            gameState = GameState.END;
            System.out.println(player.Id+" wins!!");
        }

        else{
            player.updatePosition(position);
            GameObject gameObject = board[position];
            if(gameObject!=null){
                System.out.println(gameObject.type+" found at "+position);
                position = gameObject.getFinalPosition();
                player.updatePosition(position);
            }
        }
    }

    public void play() throws Exception {
        if(players.size()<2){
            throw new Exception("Less than 2 players");
        }
        gameState = GameState.INPROGRESS;

        int i=0;
        while(!gameState.equals(GameState.END)){
            currentPlayer = players.get(i);
            updatePlayer(currentPlayer);
            i = (i+1)%players.size();
        }
        System.out.println("Game Has Ended.");
    }

    private GameObject validationGameObject(int position, GameObject gameObject) {
        if(gameObject.type.equals(Type.SNAKE)){
            if(gameObject.finalPosition.x > position){
                System.out.println("Final Position of Snake should be less than Current Position");
                return null;
            }
        }
        if(gameObject.type.equals(Type.LADDER)){
            if(gameObject.finalPosition.x<position){
                System.out.println("Final Position of Ladder should be greater than Current Position");
                return null;
            }
        }
        return gameObject;
    }
}

