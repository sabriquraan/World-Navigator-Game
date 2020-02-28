package Generator;

import Game.Orientation;
import Maze.Room;
import Walls.Wall;

import java.util.Random;

public class RoomGenerator {

  private Room room;

  private void haveLight(int roomNum){
    double random=Math.random();
    if (roomNum>5) {
      if(random<0.6) {
        room.setLight(true);
        room.setLit(true);
      } else if(random <0.8){
        room.setLight(true);
        room.setLit(false);
      }
      else if(random <=1){
        room.setLight(false);
        room.setLit(false);
      }
    }
    else { if(random<0.6) {
        room.setLight(true);
        room.setLit(true);
      } else {
        room.setLight(true);
        room.setLit(false);
      }
    }

  }

  public Room generateRoom(Wall []walls,int roomNum){
    room =new Room(walls,roomNum);
    haveLight(roomNum);
    int random=new Random().nextInt(4);
    room.setWallOrientation(random,Orientation.north);
    room.setWallOrientation(++random%4,Orientation.south);
    room.setWallOrientation(++random%4,Orientation.east);
    room.setWallOrientation(++random%4,Orientation.west);

    return room;
  }

}
