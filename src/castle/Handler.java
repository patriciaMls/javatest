package castle;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/15 12:03
 * @version: 1.0
 * @modified By:
 */
public class Handler {
    protected Game game;

    public Handler(Game game){
        this.game = game;
    }
    public void doCmd(String word){

    }
    public boolean isBye(){
        return false;
    }
}
