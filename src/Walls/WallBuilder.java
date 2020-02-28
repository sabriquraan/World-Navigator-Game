package Walls;

public class WallBuilder {

  public Wall createWall(WallItems wallItems){
    Wall wall = new Wall();
    wall.setWallItems(wallItems);

    return wall;

  }

}
