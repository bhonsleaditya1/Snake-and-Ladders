public class ExampleRun {
    public static void main(String[] args) throws Exception {
        Game game= new Game();
        int boardId = game.createBoard(10);
        game.selectBoard(boardId);
        String[][] ex = new String[][]{{"10","Snake","2"},{"5","Ladder","12"},{"98","Snake","45"},{"45","Ladder","90"}};
        for(String[] s : ex){
            game.addGameObject(s[0],s[1],s[2]);
        }
        game.createPlayer();
        game.createPlayer();
        game.createPlayer();
        game.play();
    }
}
