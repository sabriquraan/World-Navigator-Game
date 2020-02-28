package Maze;

import Generator.DoorGenerator;
import Generator.RoomGenerator;
import KeyManeger.KeyManager;
import Walls.Door;
import Walls.Wall;
import Walls.WallBuilder;
import Walls.WallGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.UnexpectedException;

public class MazeGenerator {

  public Maze createMaze() throws IOException {
    Maze maze = new Maze();
    File file = new File("map.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    int numOfRoom=Integer.parseInt(br.readLine());

    for (int roomNum=0;roomNum<numOfRoom*2;roomNum++)
      KeyManager.getInstance().generateKey();


   for (int roomNum=0; roomNum<numOfRoom;roomNum++){
     int numOfDoor=Integer.parseInt(br.readLine());
     Wall[]walls=new Wall[4];
     for (int j=0; j<numOfDoor;j++){
       String path=br.readLine();
       String[] roomsNum = path.split(",");
       int currentRoom= Integer.parseInt(roomsNum[0]);
       if(currentRoom!=roomNum)
         throw new UnexpectedException("Door current room must same of the room number.\n");

       int nextRoom=Integer.parseInt(roomsNum[1]);
       Door door=new DoorGenerator().generateDoor(currentRoom,nextRoom);
       walls[j]= new WallBuilder().createWall(door);
     }
     for (int j=numOfDoor; j<4;j++) {
       walls[j]=new WallGenerator().generateWall(roomNum);
     }

     Room room=new RoomGenerator().generateRoom(walls,roomNum);
     maze.addRoom(room);
     }
      Room room=maze.getRoom(numOfRoom-1);
      room.setSpecialDoor();

      MazeInitialState.setInstance(maze);


   return maze;
  }

}
