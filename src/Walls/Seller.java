package Walls;

import Items.FlashLight;
import Items.Items;
import KeyManeger.Key;

import java.util.ArrayList;

public class Seller implements WallItems{

  private ArrayList<Key> keys;
  private boolean flashLight;
  private String name;

  public void setFlashLight(boolean flashLight) {
    this.flashLight = flashLight;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Seller() {
    keys = new ArrayList<>();
  }

  public void setKeys(ArrayList<Key> keys) {
    this.keys = keys;
  }
  public int getItemsLength(){return  keys.size();}

  public void addItem(Items item) {
    if (item!=null)
    keys.add((Key) item);
  }

  public int keyPrices(Key key){
    return (key.getId() * 156567)%2000;
  }

  public void removeKey(Key key){
    keys.remove(key);
  }

  private void printItems(){

    System.out.println("---------------------------------------------------------------");
    System.out.println("These are the items that I sell\n");

      if (flashLight)
        System.out.println("FlashLight : 300 Gold\n");
      else {
        for (Key key:keys)
        {
          System.out.printf("%s : %d Gold\n", key.getName(), keyPrices(key));
        }

      }

      System.out.println("---------------------------------------------------------------");

    }

  public void listItems(){
    System.out.printf("Hi I'am %s , Actually I'm a seller.\n",name);
    printItems();
  }
  private Items findItemByName(String itemName){
    for (Key key: keys)
      if(key.toString().equalsIgnoreCase(itemName))
        return key;

      return null;
  }

  public Items buyItem(String itemName){
    Items item=findItemByName(itemName);
    return item;
  }

  public void sellItem(Items item){
    if (item instanceof FlashLight )
    {
      this.flashLight=true;
    }else if (item instanceof Key) {
      Key key=(Key) item;
      keys.add(key);
    }
  }

  private boolean haveKey(String itemName) {
    for (Key key:keys)
      if(itemName.equalsIgnoreCase(key.getName()))
        return true;

      return false;
  }


}




