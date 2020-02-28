package Walls;

import Generator.ChestGenerator;
import Generator.SellerGenerator;

public class WallGenerator {

  public Wall generateWall(int roomNum){
    Wall wall = new Wall();
    double random=Math.random();
    if(random>=0 && random<0.2)
      wall.setWallItems(new Mirror());
    else if(random>=0.2 && random<0.4)
      wall.setWallItems(new Painting());
    else if(random>=0.4 && random<0.6)
      wall.setWallItems(new SellerGenerator().generateSeller());
    else if(random>=0.6 && random<0.9)
      wall.setWallItems(new ChestGenerator().generateChest(roomNum));
    else wall.setWallItems(null);

    return wall;

  }

}
