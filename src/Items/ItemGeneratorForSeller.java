package Items;
import KeyManeger.Key;
import KeyManeger.KeyManager;

public class ItemGeneratorForSeller {

  private static ItemGeneratorForSeller instance = null;

  public static ItemGeneratorForSeller getInstance() {
    if ( instance == null) {
      instance = new ItemGeneratorForSeller();
    }
    return instance;
  }

  private ItemGeneratorForSeller(){
  }

  public Items generateGift(){
    double random=Math.random();

    if(random>=0 && random<0.2)
      return new FlashLight();
    else if(random>0.2 && random<=1)
    {
      Key key= KeyManager.getInstance().getFromCache();
      if (key!=null)
        return key;
      return new FlashLight();
    }


    return null;

  }

}
