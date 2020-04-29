package castle;

/**
 * @description:执行help命令
 * @author: Patricia
 * @date: Created in 2020/4/15 12:21
 * @version: 1.0
 * @modified By:
 */
public class HandlerHelp extends Handler{
    public HandlerHelp(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word) {
        System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：/go east");
    }
}
