package Generator;

import KeyManeger.Key;
import KeyManeger.KeyManager;
import Walls.Door;

public class DoorGenerator {

  private Door door;
  private static int count=0;

  public Door generateDoor(int roomNum,int nextRoom){
    door=new Door(roomNum,nextRoom);

    double randomLock=Math.random();

      if (randomLock >= 0.2 && randomLock <= 0.4 || randomLock >= 0.5 && randomLock <= 1) {
      lockDoor();
    } else {
        openDoor();
      }

   /* double random=Math.random()*100;
    double random2=Math.random()*100;
    double sub=Math.abs(random-random2);
    if(count==0)
    if (sub>=2 && sub >=0) {
      door.setSpecialDoor(true);
      SpecialDoor.setDoor(door);
      count++;
    }*/

    return door;
  }


  private void lockDoor() {
    Key key= KeyManager.getInstance().getKey();
    door.setKey(key);
    door.setLocked(true);
  }
  private void openDoor() {
    door.setLocked(false);
    door.setKey(null);
  }


}
