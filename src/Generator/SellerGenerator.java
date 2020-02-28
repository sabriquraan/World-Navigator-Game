package Generator;

import Items.ItemGeneratorForSeller;
import Items.Items;
import KeyManeger.Key;
import Walls.Seller;

public class SellerGenerator {

  private Seller seller;
  private int numOfItem;

  private void generateNumberOfItem() {

    double random = Math.random();
    if (random >= 0 && random <= 0.2)
      numOfItem=2;
    else if (random > 0.2 && random <= 0.4)
      numOfItem=3;
    else if (random > 0.4 && random <= 0.8)
      numOfItem=4;
    else if (random > 0.8 && random <= 1)
      numOfItem=5;
  }

  private void generateItemWithSeller() {
    for (int i = 0; i < numOfItem; i++) {
      Items items=ItemGeneratorForSeller.getInstance().generateGift();
      if(items instanceof Key)
      seller.addItem(items);
      else seller.setFlashLight(true);
    }
  }

  private void generateRandomName(){
    double random=Math.random();
    String name = null;
    if(random>=0 && random <=0.1)
    name= String.valueOf(RandomName.Ahmed);
    else if(random>=0.1 && random <=0.2)
      name= String.valueOf(RandomName.Ali);
    if(random>=0.2 && random <=0.3)
      name= String.valueOf(RandomName.Amal);
    if(random>=0.3 && random <=0.4)
      name= String.valueOf(RandomName.Fahed);
    if(random>=0.4 && random <=0.5)
      name= String.valueOf(RandomName.Mohammad);
    if(random>=0.5 && random <=0.6)
      name= String.valueOf(RandomName.Rami);
    if(random>=0.6 && random <=0.7)
      name= String.valueOf(RandomName.Sabri);
    if(random>=0.7 && random <=0.8)
      name= String.valueOf(RandomName.Omar);
    if(random>=0.8 && random <=0.9)
      name= String.valueOf(RandomName.Own);
    if(random>=0.9 && random <=1)
      name= String.valueOf(RandomName.Sara);

    seller.setName(name);
  }

  public Seller generateSeller(){
    seller=new Seller();
    generateNumberOfItem();
    generateItemWithSeller();
    generateRandomName();

    return seller;

  }


}
