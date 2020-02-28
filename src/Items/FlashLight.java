package Items;

public class FlashLight implements Items {

  private int betray;
  public FlashLight() {
    betray =(int)(Math.random()*100);
  }

  @Override
  public String toString() {
    return "FlashLight";
  }
}
