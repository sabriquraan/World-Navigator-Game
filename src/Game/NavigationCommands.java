package Game;

import Items.FlashLight;
import Items.Items;
import KeyManeger.Key;
import Maze.Maze;
import Maze.Room;
import Walls.Door;


class NavigationCommands {

  private Maze maze;
  private Player player;

  NavigationCommands(Maze maze, Player player) {
    this.maze = maze;
    this.player = player;
  }

  void left(){
    if(player.getSideLook()==Orientation.north)
      player.changeSide(Orientation.west);
    else if(player.getSideLook()==Orientation.west)
      player.changeSide(Orientation.south);
    else if(player.getSideLook()==Orientation.south)
      player.changeSide(Orientation.east);
    else if(player.getSideLook()==Orientation.east)
      player.changeSide(Orientation.north);
  }

  void right(){
    if(player.getSideLook()==Orientation.north)
      player.changeSide(Orientation.east);
    else if(player.getSideLook()==Orientation.east)
      player.changeSide(Orientation.south);
    else if(player.getSideLook()==Orientation.south)
      player.changeSide(Orientation.west);
    else if(player.getSideLook()==Orientation.west)
      player.changeSide(Orientation.north);
  }

  void playerStatus() {
    System.out.println("***************playerStatus***************");
    System.out.printf("You look to %s direction.\n", player.getSideLook());
    System.out.printf("You have %d Gold.\n", player.getAmountOfGold());
    System.out.printf("You have %d keys.\n", player.getCountOfKey());
    if(player.haveFlashLight())
      System.out.print("You have FlashLight.\n");
    else
      System.out.print("You don't have FlashLight.\n");
    if (player.getCountOfKey() == 0) {
      System.out.println("You Don't have any item yet.\n");
      return;
    }
    for (int i = 0; i < player.getCountOfKey(); i++)
    {
      Items item=player.getItem(i);
      String name="";
      if(item instanceof FlashLight)
        name="FlashLight";
      else if (item instanceof Key)
        name=((Key) item).getName();
      System.out.printf("The item Number %d is : %s .\n",i+1,name);

    }
    System.out.println("***************playerStatus***************");

  }

  boolean Forward(){
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    if(room.getItemByOrientation(sideLook) instanceof Door){
      Door door= (Door) room.getItemByOrientation(sideLook);

      if(door.isOpen() && door.isSpecialDoor()) {
        return true;
      }
      else if(door.isOpen() )
        player.setPreviousRoom(currentRoom);
        player.setCurrentRoom(door.getNextRoom());
    }



    return false;
  }

  private Orientation invertSide(Orientation side){
    if (side==Orientation.north)
      return Orientation.south;
    else if(side==Orientation.south)
      return Orientation.north;
    else if(side==Orientation.east)
      return Orientation.west;
    else return Orientation.east;

  }
  boolean  backward(){
    int currentRoom =player.getPreviousRoom();
    Orientation sideLook=player.getSideLook();
    Orientation backSide=invertSide(sideLook);
    Room room=maze.getRoom(currentRoom);

    if(room.getItemByOrientation(backSide) instanceof Door ) {
      Door door= (Door) room.getItemByOrientation(backSide);
      if(door.isOpen() && door.isSpecialDoor()){
        return true;
      }
      else if(door.isOpen() )
        player.setCurrentRoom(door.getNextRoom());
        player.setPreviousRoom(currentRoom);
    }



    return false;
  }

  void restart(Maze maze1, Player player1){
    player=null;
    maze=null;
    player=player1;
    maze=maze1;

  }

  }
