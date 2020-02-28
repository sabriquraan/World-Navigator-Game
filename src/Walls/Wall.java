package Walls;

import Game.Orientation;

public class Wall {

  private Orientation wallOrientation;
  private WallItems wallItems;

  public WallItems getWallItems() {
    return wallItems;
  }
  void setWallItems(WallItems wallItems) {
    this.wallItems = wallItems;
  }
  public void setWallOrientation(Orientation wallOrientation) {
    this.wallOrientation = wallOrientation;
  }
  public Orientation getWallOrientation() {
    return wallOrientation;
  }
  public String getItemOfWall(){
    if(wallItems instanceof Chest)
      return "Chest";
    else if(wallItems instanceof Mirror)
      return "Mirror";
    else if(wallItems instanceof Painting)
      return "Painting";
    else if(wallItems instanceof Seller)
     return "Seller";
    else if(wallItems instanceof Door)
      return "Door";
  return "Wall";
  }
  public void print(){
    System.out.println("\n wall Orientation ="+wallOrientation);
    if(wallItems instanceof Chest)
      System.out.println("\n wall Item = Chest");
    else if(wallItems instanceof Mirror)
      System.out.println("\n wall Item = Mirror");
    else if(wallItems instanceof Painting)
      System.out.println("\n wall Item = Painting");
    else if(wallItems instanceof Seller)
      System.out.println("\n wall Item = Seller");
    else if (wallItems instanceof Door) {
      System.out.println("\n wall Item = Door");
      Door door=(Door)wallItems;
      door.print();
    } else
      System.out.println("\n wall Item = Empty");


  }

}
