package Items;
import KeyManeger.Key;
import KeyManeger.KeyManager;

public class ItemGeneratorForChest {

  private static ItemGeneratorForChest instance = null;

  public static ItemGeneratorForChest getInstance() {
    if ( instance == null) {
      instance = new ItemGeneratorForChest();
    }
    return instance;
  }

  private ItemGeneratorForChest(){
  }

  public Items generateGift(){
    double random=Math.random();

    if(random>=0 && random<0.2)
      return new Gold();
    else if(random>=0.2 && random<=0.5)
      return new FlashLight();
    else if(random>0.5 && random<=1)
    {
      Key key= KeyManager.getInstance().getFromCache();
      if(key!= null)
        return key;
      return new Gold();
    }


    return null;

  }

}
