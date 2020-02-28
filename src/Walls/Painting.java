package Walls;

import KeyManeger.Key;
import KeyManeger.KeyManager;

public class Painting implements WallItems{

  private boolean hasKey;
  private Key key;

  public boolean isHasKey() {
    return hasKey;
  }

  public Key getKey() {
    return key;
  }

   Painting() {
     if(KeyManager.getCountOfKeyCache()>0){
      hasKey=true;
      key= KeyManager.getInstance().getFromCache();
      if(key==null)
        hasKey=false;
    }
    else {
      hasKey=false;
      key= null;
    }

  }
}
