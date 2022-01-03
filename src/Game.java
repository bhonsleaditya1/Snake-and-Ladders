import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    int playerSerial;
    int boardSerial;
    HashMap<Integer,Board> boards;
    List<Player> playerList;
    Board board;

    public Game() {
        this.playerSerial = 0;
        this.boardSerial=0;
        playerList = new ArrayList<>();
        boards = new HashMap<>();
        board = null;
    }
    public void createPlayer(){
        playerList.add(new Player(playerSerial++));
    }
    public void addGameObject(String position,String type,String finalPosition){
        board.addGameObject(position,type,finalPosition);
    }

    public void addPlayerToBoard(Player player){
        board.addPlayer(player);
    }
    public void playGame() throws Exception {
        board.play();
    }

    public int createBoard(int size){
        boards.put(boardSerial++,new Board(size));
        return boardSerial-1;
    }

    public void selectBoard(int s){
        board = boards.get(s);
    }
    public void play() throws Exception {
        for(Player p:playerList)
            addPlayerToBoard(p);
        playGame();
    }
}
