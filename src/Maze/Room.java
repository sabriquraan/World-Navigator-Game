package Maze;

import Game.Orientation;
import KeyManeger.Key;
import Walls.Door;
import Walls.Wall;
import Walls.WallItems;

public class Room {

  private boolean light;
  private boolean lit;
  private Wall[] walls;
  private int roomNum;

  public Room(Wall[] walls, int roomNum) {
    this.walls = walls;
    this.roomNum = roomNum;
  }



  //Walls
  public Orientation getWallOrientation(int index){
    return walls[index].getWallOrientation();
  }
  public void setWallOrientation(int index, Orientation side){
     walls[index].setWallOrientation(side);
  }
  public void setWalls(Wall[] walls) {
    this.walls = walls;
  }


  public String getItemNameByOrientation(Orientation side){

    for (int i=0;i<4;i++)
      if(walls[i].getWallOrientation()==side)
        return walls[i].getItemOfWall();

      return "Error!!";

  }

  public WallItems getItemByOrientation(Orientation side){

    for (int i=0;i<4;i++)
      if (walls[i].getWallOrientation()==side)
        return walls[i].getWallItems();

      return null;

  }

  public boolean isDarkRoom(){
    return !lit;
  }

  boolean haveLight() { return light; }


  public void setLight(boolean light) {
    this.light = light;
  }

  public void setLit(boolean lit) {
    this.lit = lit;
  }


  public void switchLight(){
    if(light)
    this.lit=!this.lit;
  }

  public void printDetails(){
    System.out.println("The light ="+light);
    System.out.println("\nThe lit ="+lit);
  for (int i=0;i<4;i++){
    System.out.println("Wall Number "+i+"\n");
    walls[i].print();
    System.out.println("------------------------------");
  }

  }



   public void openDoor(Key key, Orientation sideLook) {

    Door door= (Door) this.getItemByOrientation(sideLook);
    if(door.isOpen())
      System.out.println("The door is open.\n");
    else {
      door.openDoor(key);
    }
    }

  public void setSpecialDoor() {
    for (int i=0;i<4;i++) {
      if (walls[i].getItemOfWall().equalsIgnoreCase("door")) {
        Door door= (Door) walls[i].getWallItems();
        door.setSpecialDoor(true);
        SpecialDoor.setDoor(door);
        return;
      }

    }
  }
}


