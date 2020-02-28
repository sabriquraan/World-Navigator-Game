package Game;

import Items.FlashLight;
import Items.Gold;
import Items.Items;
import KeyManeger.Key;
import Walls.Chest;

import java.util.ArrayList;

class Player {

  private int amountOfGold;
  private Orientation sideLook;
  private ArrayList<Key> playerKeys;
  private int countOfKey;
  private int currentRoom;
  private int previousRoom;

  int getPreviousRoom() {
    return previousRoom;
  }

  void setPreviousRoom(int previousRoom) {
    this.previousRoom = previousRoom;
  }

  private boolean  flashLight=false; //if is exist
  private boolean  flashlightStatus=false;

  Player() {
    this.amountOfGold = 1000;
    this.sideLook = Orientation.north;
    countOfKey =0;
    currentRoom=0;
    this.playerKeys = new ArrayList<Key>();
  }

  int getAmountOfGold() {
    return amountOfGold;
  }
  boolean haveFlashLight() {
    return flashLight;
  }
  boolean isFlashlightOn() {
    return flashlightStatus && flashLight;
  }
  void useFlashLight(){
    if (flashlightStatus)
      turnOffFlashLight();
    else
      turnOnFlashLight();
  }


  private  void turnOnFlashLight() {
    if (flashLight)
    this.flashlightStatus = true;
  }
  private void turnOffFlashLight() {
    if (flashLight)
      this.flashlightStatus = false;
  }
  void buyItem(int price){
    this.amountOfGold-=price;
  }

  boolean haveKey(String key){
    for(Items item:playerKeys) {
      Key key1= (Key) item;
      if(key.equals(key1.getName()))
        return true;
    }
     return false;
  }
  private Key getKeyByName(String key){
    for(Items item:playerKeys) {
      Key key1= (Key) item;
      if(key.equals(key1.getName()))
        return key1;
    }
    return null;
  }
  void setCurrentRoom(int currentRoom) {
    this.currentRoom = currentRoom;
  }

  private void addGold(int amount){
    this.amountOfGold=this.amountOfGold+amount;
  }

  void addKey(Key Key){
    this.playerKeys.add(Key);
    countOfKey++;
  }

  void changeSide(Orientation side) {
    this.sideLook=side;

  }

  int getCountOfKey() {
    return countOfKey;
  }

  void setFlashLight(boolean flashLight) {
    this.flashLight = flashLight;
  }

  void collectItemsChest(Chest chest){

    Items[] items= chest.collectGift();


    for (Items items1:items)
    {


      if (items1 instanceof Gold){
        Gold gold=(Gold)items1;
        int amount=gold.getAmountOfGold();
        addGold(amount);
      }
      else if (items1 instanceof FlashLight)
        this.flashLight=true;
      else if (items1 instanceof Key)
        addKey((Key)items1);

    }
    chest.clearItems();
  }

  Orientation getSideLook() {
    return sideLook;
  }

  boolean findKey(Key key){
    return playerKeys.contains(key);
  }
  int getCurrentRoom() {
    return currentRoom;
  }

  Items getItem(int index){
    return playerKeys.get(index);
  }
  private int keyPrices(Key key){
    return (key.getId() * 156567)%2000;
  }

  Items sellItem(String itemName){
    if (itemName.equalsIgnoreCase("flashlight") && this.flashLight)
    {
      this.amountOfGold+=300;
      this.flashLight=false;
      return new FlashLight();
    }else if (this.haveKey(itemName)) {
      Key key=this.getKeyByName(itemName);
      Key tmp= (Key) key.clone();
      System.out.println("Key name =="+key.getName()+"\n");
      System.out.println("Tmp name =="+tmp.getName()+"\n");

      this.amountOfGold+=keyPrices(key);
      playerKeys.remove(key);
      countOfKey--;
      return tmp;
    } else {
      System.out.println("You don't have this item.\n");
    }
      return null;
  }

}
