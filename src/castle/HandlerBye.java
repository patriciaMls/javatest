package castle;

/**
 * @description:执行bye命令
 * @author: Patricia
 * @date: Created in 2020/4/15 12:13
 * @version: 1.0
 * @modified By:
 */
public class HandlerBye  extends Handler{
    public HandlerBye(Game game){
        super(game);
    }
    public boolean isBye(){
        return true;
    }
}
