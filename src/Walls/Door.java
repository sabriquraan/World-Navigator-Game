package Walls;

import KeyManeger.Key;

public class Door implements WallItems {

  private Key key;
  private boolean locked;
  private boolean specialDoor=false;
  private int currentRoom;
  private int nextRoom;

  public int getNextRoom() {
    return nextRoom;
  }

  public Door(int currentRoom, int nextRoom) {
    this.currentRoom = currentRoom;
    this.nextRoom = nextRoom;
  }

  void print(){
    if (this.locked)
      System.out.println("\nThe Key of Door is : " + getKeyName());
    else {
      System.out.println("Open Door\n");
    }
    System.out.println("\nThe locked : "+locked);

  }

  public Key getKey() {
    return key;
  }
  public boolean isSpecialDoor(){
    return specialDoor;
  }
  public boolean isOpen(){
    return !locked;
  }
  private String getKeyName(){
    if(key.getName()==null)
      return "Open Door";
    return key.getName();
  }

  public int getCurrentRoom() {
    return currentRoom;
  }

  public void openDoor(Key key){
    if(isOpen())
      return;
    if(this.key.equals(key))
    { System.out.println("Door open successfully!\n");
    locked=false;}
    else
    System.out.println("Door still close , try another key.\n");

  }
  public void setSpecialDoor(boolean specialDoor) {
    this.specialDoor = specialDoor;
  }
  public void setKey(Key key) {
    this.key = key;
  }
  public void setLocked(boolean locked) {
    this.locked = locked;
  }




}
