package Maze;
import java.util.ArrayList;

public class Maze {

  private ArrayList<Room> rooms;
  private int numOfRooms;

  Maze() {
    this.rooms = new ArrayList<>();
    this.numOfRooms = 0;
  }

  void addRoom(Room room){
    rooms.add(room);
    numOfRooms++;
  }

 public Room getRoom(int index){
    if(index>=0 && index<numOfRooms)
      return rooms.get(index);

    return null;
  }

  public int getNumOfRooms() {
    return numOfRooms;
  }

  public void print(){
    System.out.println("\nnumOfRooms = "+numOfRooms+" \n");
    for (int i=0;i<numOfRooms;i++){
      System.out.println("Room Number  "+i+" \n");
      rooms.get(i).printDetails();
      System.out.println("------------------------------");
    }

  }

}
