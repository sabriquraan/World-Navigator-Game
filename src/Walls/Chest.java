package Walls;

import Items.Items;
import KeyManeger.Key;

import java.util.Arrays;

public class Chest implements WallItems {

  private Key key;
  private boolean locked;
  private Items[] items;
  private boolean empty;

  public void setEmpty(boolean empty) {
    this.empty = empty;
  }

  public boolean isLocked() {
    return locked;
  }

  public Chest() {

  }

  public Key getKey() {
    return key;
  }

  public void setKey(Key key) {
    this.key = key;
  }
  public void setLocked(boolean locked) {
    this.locked = locked;
  }
  public void setItems(Items[] items) {
    this.items = items;
  }
  public int getItemsLength(){return  items.length;}
  public void addItem(Items items,int index){
    this.items[index]=items;
  }


  private boolean isOpen(){
    return !locked;
  }

  String getKeyName(){
    return key.getName();
  }

  void openChest(Key key){
    if(isOpen())
      return;
    if(this.key.equals(key))
      locked=false;
  }

  public void clearItems(){
    Arrays.fill(items, null);
    empty=true;
  }

  public  boolean isEmpty(){
    return empty;
  }
  public Items[] collectGift(){
    return items;
  }
  public void print(){
    int count=1;
      for (Items item : items)
        System.out.printf("Item Number %d ---> %s \n",count++,item.toString());

    }
}
