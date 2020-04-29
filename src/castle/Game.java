package castle;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:Game主类，用于构建与game有关的命令，地图等
 * @author: Patricia
 * @date: Created in 2020/4/15 10:34
 * @version: 1.0
 * @modified By:
 */
public class Game {
    private Room currentRoom;
    private HashMap<String,Handler> handlers = new HashMap<String, Handler>();

    public Game(){
        handlers.put("bye",new HandlerBye(this));
        handlers.put("help",new HandlerHelp(this));
        handlers.put("go",new HandlerGo(this));
        createRooms();
    }

    public void createRooms(){
        /**
         * @descript :game地图详情
         * @author :Patricia
         * @date :2020/4/15 12:51
         * @param :[]
         * @return :void
         * @throws :
         * @since :
         */

        Room outside, lobby, pub, study, bedroom;

        //制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        //初始化房间入口
        outside.setExit("east",lobby);
        outside.setExit("south",study);
        outside.setExit("west",pub);
        lobby.setExit("west",outside);
        pub.setExit("east",outside);
        study.setExit("north",outside);
        study.setExit("west",bedroom);
        bedroom.setExit("west",study);
        lobby.setExit("up",pub);
        pub.setExit("down",lobby);

        currentRoom = outside;//从城堡门外开始
    }

    public void printWelcome(){
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入'help'。");
        System.out.println();

        showPrompt();
    }

    //以下为用户命令

    public void goRoom(String direction){
        /**
         * @descript :执行go命令的具体操作
         * @author :Patricia
         * @date :2020/4/15 12:51
         * @param :[direction]
         * @return :void
         * @throws :
         * @since :
         */

        Room nextRoom=currentRoom.getExit(direction);

        if (nextRoom == null){
            System.out.println("那里没有门！");
        }else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void showPrompt(){
        /**
         * @descript :当前位置出口描述
         * @author :Patricia
         * @date :2020/4/15 12:53
         * @param :[]
         * @return :void
         * @throws :
         * @since :
         */

        System.out.println("你在："+currentRoom);
        System.out.print("出口有：");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
    }

    public void play(){
        /**
         * @descript :判断执行哪一个命令的方法
         * @author :Patricia
         * @date :2020/4/15 12:54
         * @param :[]
         * @return :void
         * @throws :
         * @since :
         */

        Scanner in = new Scanner(System.in);
        while (true){
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);//具体执行某个命令
            String value = "";
            if (words.length > 1){
                value=words[1];
            }
            if (handler != null){
                handler.doCmd(value);//得到执行go命令的方向
                if (handler.isBye()){
                    break;
                }
            }
        }
        in.close();
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.printWelcome();
        game.play();

        System.out.println("感谢您的光临。再见！");

    }

}
