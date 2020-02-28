package Game;

import Items.Items;
import KeyManeger.Key;
import Maze.Maze;
import Maze.Room;
import Walls.*;

import java.util.Scanner;


class Commands {
  private Maze maze;
  private Player player;

  Commands(Maze maze, Player player) {
    this.maze = maze;
    this.player = player;
  }

  String look(){
    int currentRoom=player.getCurrentRoom();
    System.out.println("room number = "+currentRoom);
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);
    if (room.isDarkRoom()) {
      return("Dark");
    }
    return room.getItemNameByOrientation(sideLook);

  }

  void trade() throws CloneNotSupportedException {
    String WallItem=look();
    if(!WallItem.equalsIgnoreCase("Seller")) {
      System.out.println("You don't face Seller right know, try another command\n");
      return;
    }
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Seller seller= (Seller) room.getItemByOrientation(sideLook);
    seller.listItems();
    boolean tradeMoodOn=true;
    while (tradeMoodOn){
      Scanner in=new Scanner(System.in);
      System.out.println("Enter the SubCommand:");
      String command=in.nextLine().toLowerCase();

       if(command.matches("buy <flashlight>")){
        buy(seller,"flashlight");
      } else if(command.matches("buy <[a-zA-Z\\d]*>")) {
        String itemName=command.substring(5,command.lastIndexOf(">"));
        buy(seller,itemName);
      } else if(command.equalsIgnoreCase("Finish")) {
        tradeMoodOn = false;
      } else if(command.equalsIgnoreCase("List")){
        seller.listItems();
    } else if(command.matches("sell <[a-zA-Z\\d]*>")) {
        String itemName=command.substring(6,command.lastIndexOf(">"));
         System.out.println("in sell ==="+itemName);
        sell(seller,itemName);
      }

  }

  }
  private void sell(Seller seller, String itemName) throws CloneNotSupportedException {
    Items items = player.sellItem(itemName);
    if (items!=null)
    seller.sellItem(items);
    else
    System.out.println("Invalid sell item.\n");

  }
  private void buy(Seller seller,String itemName){
    if(itemName.matches("flashlight")) {
      if (player.getAmountOfGold() < 300) {
        System.out.println("return when you have enough gold\n");
      } else {
        player.buyItem(300);
        player.setFlashLight(true);
        seller.setFlashLight(false);
      }

    } else {
      Items item =seller.buyItem(itemName);
      if (item instanceof Key) {
        Key key=(Key)item;
        int price=seller.keyPrices(key);
        if (player.getAmountOfGold() < price) {
          System.out.println("return when you have enough gold\n");
        } else {
          player.buyItem(price);
          player.addKey(key);
          seller.removeKey(key);
        }

      }
    }
  }

  void check(String item){
    if (item.equalsIgnoreCase("Mirror"))
      checkMirror();
    else if (item.equalsIgnoreCase("Painting"))
      checkPainting();
    else if (item.equalsIgnoreCase("Chest"))
      checkChest();
    else if (item.equalsIgnoreCase("Door"))
      checkDoor();
  }
  private void checkDoor() {

    String item=look();
    if(!item.equalsIgnoreCase("Door"))
    { System.out.println("You don't face Door right know, try another command\n");
      return;}
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Door door= (Door) room.getItemByOrientation(sideLook);

    if(!door.isOpen()) {
      System.out.println("The door is locked, you need this key ---> " + door.getKey().getName() + "\n");
      return;
    }
    System.out.println("Door is open\n");


  }
  private void checkChest() {

    String item=look();
    if(!item.equalsIgnoreCase("Chest")) {
      System.out.println("You don't face Chest right know, try another command\n");
      return;
    }
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Chest chest= (Chest) room.getItemByOrientation(sideLook);

    if(chest.isLocked()) { System.out.println("The chest is locked, you need this key ---> "+chest.getKey().getName()+"\n");
    return;
    }

    if(chest.isEmpty()) {
      System.out.println("Empty chest!:\n");
      return;
    }
    System.out.println("You get this items:\n");
    chest.print();
    player.collectItemsChest(chest);

  }
  private void checkPainting() {
    String item=look();
    if(!item.equalsIgnoreCase("Painting"))
    { System.out.println("You don't face Painting right know, try another command\n");
      return;}
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Painting painting= (Painting) room.getItemByOrientation(sideLook);
    if(painting.isHasKey()) {
      player.addKey(painting.getKey());
      System.out.println("You get this key --> " + painting.getKey().getName()+"\n");
    }
    else
    System.out.println("No key behind the painting.\n");

  }
  private void checkMirror() {
    String item=look();
    if(!item.equalsIgnoreCase("Mirror"))
    { System.out.println("You don't face mirror right know, try another command\n");
      return;}
    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Mirror mirror= (Mirror) room.getItemByOrientation(sideLook);
    if(mirror.isHasKey()) {
      player.addKey(mirror.getKey());
      System.out.println("You get this key --> " + mirror.getKey().getName()+"\n");
      mirror.collect();
    }
    else
    System.out.println("No key behind the mirror.\n");

  }

  void Open(){
    String item=look();
    if (!item.equalsIgnoreCase("door"))
    { System.out.println("You don't face door right know, try another command\n");
      return;}

    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);

    Door door= (Door) room.getItemByOrientation(sideLook);

    if(!door.isOpen()) {
      Key key=door.getKey();
      if(player.findKey(key))
        room.openDoor(key,sideLook);
      return;
    }

    System.out.println("Door is open\n");

  }

  void useFlashlight(){

    if (player.haveFlashLight())
      player.useFlashLight();

    int currentRoom=player.getCurrentRoom();
    Room room=maze.getRoom(currentRoom);
    if (room.isDarkRoom() && player.isFlashlightOn())
      room.setLit(true);
    else if( !room.isDarkRoom() && !player.isFlashlightOn())
      room.setLit(false);

  }
  void switchLights(){
    int currentRoom=player.getCurrentRoom();
    Room room=maze.getRoom(currentRoom);
    room.switchLight();

  }

  void useKey(String key){

    String item=look();
    if(item.equalsIgnoreCase("Door"))  {
      int currentRoom=player.getCurrentRoom();
      Orientation sideLook=player.getSideLook();
      Room room=maze.getRoom(currentRoom);
      Door door= (Door) room.getItemByOrientation(sideLook);
      String name1=door.getKey().getName();
      if(!player.haveKey(name1))
        return;

      if (key.equalsIgnoreCase(name1) && door.isOpen())
        door.setLocked(true);
      else if (key.equalsIgnoreCase(name1) && !door.isOpen())
        door.setLocked(false);
      else {
        System.out.println("Wrong Key! door.\n");
      }

    } else if(item.equalsIgnoreCase("Chest")) {

    int currentRoom=player.getCurrentRoom();
    Orientation sideLook=player.getSideLook();
    Room room=maze.getRoom(currentRoom);
    Chest chest= (Chest) room.getItemByOrientation(sideLook);
      String name1=chest.getKey().getName();
      if(!player.haveKey(name1))
        return;
    if (key.equalsIgnoreCase(name1) && chest.isLocked())
      chest.setLocked(false);
    else if (key.equalsIgnoreCase(name1) && !chest.isLocked())
      chest.setLocked(true);
    else {
      System.out.println("Wrong Key! chest.\n");
    }

    }

  }

  void restart(Maze maze1, Player player1){
    player=null;
    maze=null;
    player=player1;
    maze=maze1;

  }

}
