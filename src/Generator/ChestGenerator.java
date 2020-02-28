package Generator;

import Items.ItemGeneratorForChest;
import Items.Items;
import KeyManeger.KeyManager;
import Walls.Chest;

public  class ChestGenerator {

 private Chest chest;

 private void lockChest() {
   chest.setKey(KeyManager.getInstance().getKey());
   chest.setLocked(true);

 }
 private void openChest() {
   chest.setKey(null);
   chest.setLocked(false);
 }
 private void generateNumberOfItem() {
    double random = Math.random();
     if (random >= 0 && random <= 0.3)
      chest.setItems(new Items[2]);
    else if (random > 0.3 && random <= 0.7)
      chest.setItems(new Items[3]);
    else if (random > 0.7 && random <= 1)
       chest.setItems(new Items[4]);
 }
 private void generateItemInChest() {
   for (int i = 0; i < chest.getItemsLength(); i++) {
     chest.addItem(ItemGeneratorForChest.getInstance().generateGift(), i);
   }
 }
 public Chest generateChest(int roomNum) {

   chest = new Chest();
   double randomLock = Math.random();
   if (roomNum>5) {
   if (randomLock >= 0 && randomLock <= 0.2 || randomLock >= 0.5 && randomLock <= 1) {
     lockChest();
   } else {
     openChest(); }
   } else {
     if (randomLock >= 0 && randomLock <= 0.2) {
       lockChest();
     } else {
       openChest(); }
   }


   generateNumberOfItem();
   generateItemInChest();
   chest.setEmpty(false);
   return chest;

  }
 public ChestGenerator(){ }


 }



