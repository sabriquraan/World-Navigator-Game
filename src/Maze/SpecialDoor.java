package Maze;

import Walls.Door;

public  class SpecialDoor {
private static Door door;

 public static Door getDoor() {
   return door;
 }

  public static void setDoor(Door door) {
    SpecialDoor.door = door;
  }
}
