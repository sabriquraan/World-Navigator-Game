package Game;

import KeyManeger.KeyManager;

import java.io.IOException;
import java.util.Scanner;

public class RunGame {

  public static void main(String[] args) throws IOException {
    Game game = new Game();
    game.start();
    game.listCommand();
    Scanner in=new Scanner(System.in);
    boolean win=false;
    long start = System.currentTimeMillis();
    int delay=game.getMaze().getNumOfRooms()/2;
    long end = start + 60*1000*delay; // 60 seconds * 1000 ms/sec
    while (System.currentTimeMillis() < end) {

      System.out.println("Enter the Command:");
      String command=in.nextLine().toLowerCase();
      if(command.equalsIgnoreCase("quit"))
      { game.quit();
        break;}

      switch (command){
        case "right": game.getNavigationCommands().right(); break;
        case "left": game.getNavigationCommands().left(); break;
        case "forward": win=game.getNavigationCommands().Forward();
          if(win)
          { game.win();
            end=System.currentTimeMillis();}
          break;
        case "backward": win=game.getNavigationCommands().backward();
          if(win){
            game.win();
            end=System.currentTimeMillis();}
          break;
        case "look":
          System.out.println(game.getCommands().look()); break;
        case "check mirror": game.getCommands().check("mirror"); break;
        case "check painting": game.getCommands().check("painting"); break;
        case "check chest": game.getCommands().check("chest"); break;
        case "check door": game.getCommands().check("door"); break;
        case "open": game.getCommands().Open();
        case "use flashlight": game.getCommands().useFlashlight(); break;
        case "switchlights": game.getCommands().switchLights(); break;
        case "quit": System.out.println("\n**************GameOver**************\n");
          game.quit();  break;
        case "restart": game.restart(); break;
        case "listcommand": game.listCommand(); break;
        case "playerstatus": game.getNavigationCommands().playerStatus(); break;
        case "printkey": KeyManager.getInstance().printCache();
          System.out.println("********************");
          KeyManager.getInstance().printLock();
          break;
        case "trade":
          try {
            game.getCommands().trade();
          } catch (CloneNotSupportedException e) {
            e.printStackTrace();
          }
          break;
        default:
          if(command.matches("use <key\\d*> key")) {
            String name=command.substring(5,command.lastIndexOf('>'));
            System.out.println(name);
            game.getCommands().useKey(name);
          } else  System.out.println("You enter wrong command , try again!\n");
      }
    }



  }

}
