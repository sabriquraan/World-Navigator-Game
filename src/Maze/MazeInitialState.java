package Maze;

public class  MazeInitialState {

  private  static Maze maze;

  public static Maze getMaze(){
    return maze;
  }

  private MazeInitialState(Maze maze) {
    MazeInitialState.maze = maze;
  }

  private static MazeInitialState instance = null;



  public static MazeInitialState setInstance(Maze maze) {
    if ( instance == null) {
      instance = new MazeInitialState(maze);
    }
    return instance;
  }

}
