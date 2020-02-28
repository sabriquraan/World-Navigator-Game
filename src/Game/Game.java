package Game;

import Maze.Maze;
import Maze.MazeGenerator;
import Maze.MazeInitialState;

import java.io.IOException;

public class Game {

  private Maze maze;
  private Player player;
  private NavigationCommands navigationCommands;
  private Commands commands;

  NavigationCommands getNavigationCommands() {
    return navigationCommands;
  }

  Commands getCommands() {
    return commands;
  }

  Maze getMaze() {
    return maze;
  }

  void start() throws IOException {
    System.out.println("\n**************Welcome to World Navigator Game**************\n");
    maze = new MazeGenerator().createMaze();
    player=new Player();
    navigationCommands = new NavigationCommands(maze, player);
    commands = new Commands(maze, player);

  }

  void quit() {
    player = null;
    maze = null;
    navigationCommands = null;
    commands = null;
  }

  void restart()  {
    System.out.println("********************GameOver!The Game will restart soon!********************");
    maze = null;
    player = null;
    maze = MazeInitialState.getMaze();
    player = new Player();
    commands.restart(maze, player);
    navigationCommands.restart(maze, player);
    System.out.println("********************Lets star again!********************");
  }

  void listCommand() {
    System.out.println("You can use the following commands:\n");
    System.out.println("1.Right: change orientation of the player to right.\n");
    System.out.println("2.Left: change orientation of the player to left.\n");
    System.out.println("3.Forward: move forward through open doors.\n");
    System.out.println("4.backward: move back through open doors.\n");
    System.out.println("5.look: to know what item is facing you.\n");
    System.out.println("6.Check: this command takes these arguments:.\n");
    System.out.println("A.Check Mirror: if a key is hidden behind the mirror will acquire.\n");
    System.out.println("B.Check Painting: if a key is hidden behind the Painting will acquire.\n");
    System.out.println("C.Check Chest: 1)if the chest is closed show the name of the key.\n"
        + "2)if it is open the items inside the chest are listed and acquired..\n");
    System.out.println("D.Check Door: 1)if the door is closed show the name of the key.\n"
        + "2)if it is open show (Door is open).\n");
    System.out
        .println("7.Open,: will open a door if the player is facing a door if you have the key.\n");
    System.out.println("8.Use flashlight,: will turn flashlight on if it is off and vice versa.\n");
    System.out
        .println("9.Use Use <name> Key,: will open if a door/chest requires the <name> key to open."
            + "and it is locked and will lock the door/chest if it is open.\n");
    System.out.println(
        "10.SwitchLights: if the room has lights it will turn them on if they are off and vice versa.\n");
    System.out.println(
        "12.Trade,: will work only if the player is facing a seller,will list the seller’s available items.\n"
            + "And go to Trade mode with this subcommands:\n");
    System.out.println(
        "A.Buy <item>: if enough gold is with the player will “<item> bought and acquired.\n");
    System.out.println(
        "B.Sell <Item>: The seller will have a price list of any item type that can be on the map and will offer "
            + "that amount for any item that you have.\n");
    System.out.println("C.List: will list seller items again.\n");
    System.out.println("D.Finish Trade, will exit the trade mode.\n");
    System.out.println("13.quit: will exit the game and lose.\n");
    System.out.println(
        "14.Restart:will reset the game to the initial state for the player to restart over the game, even in the middle "
            + "of the game.\n");
    System.out.println("15.ListCommand: to list this menu.\n");

  }

  void win(){
    System.out.println("Congratulations!!!!!!!!!!!! You Win!\n");
   quit();

  }

}


