package Items;

public class Gold implements Items {

  private int amountOfGold;

  Gold() {
    this.amountOfGold=(int)(Math.random()*1500);
  }

  @Override
  public String toString() {
    return amountOfGold+" Gold.";
  }

  public int getAmountOfGold() {
    return amountOfGold;
  }
}
