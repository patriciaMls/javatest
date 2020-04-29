package castle;

/**
 * @description:执行go命令
 * @author: Patricia
 * @date: Created in 2020/4/15 12:27
 * @version: 1.-
 * @modified By:
 */
public class HandlerGo extends Handler{
    public HandlerGo(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}
