package KeyManeger;

import java.util.Collection;
import java.util.HashMap;

public class KeyManager  {

  private HashMap<Integer,Key> keyCache;
  private HashMap<Integer,Key> keyLock;
  private static int countOfKey=0;
  private static int countOfKeyCache=0;
  private static int countOfKeyTaken=0;
  private static int countOfKeyCacheTaken=0;

  public static int getCountOfKeyCache() {
    return countOfKeyCache;
  }

  private static KeyManager instance = null;

  public static KeyManager getInstance() {
    if ( instance == null) {
      instance = new KeyManager();
    }
    return instance;
  }

  private KeyManager() {
    this.keyCache = new HashMap<>();
    this.keyLock=new HashMap<>();
  }

  public synchronized Key getKey(){
    if(countOfKey<=0)
      return null;

   // int index=new Random().nextInt(countOfKey);
    Key key=keyLock.get(countOfKeyTaken);
    keyLock.remove(countOfKeyTaken);
    countOfKeyTaken++;
    countOfKey--;
    return key;
  }

  public Key getFromCache(){
    if(countOfKeyCache<=0)
      return null;

    //int index=new Random().nextInt(countOfKeyCache);
    int index;
    Key key=null;
    if (countOfKeyTaken>0) {
      index = countOfKeyCacheTaken % countOfKeyTaken;
       key = keyCache.get(index);
      keyCache.remove(index);
    }
    if (key!=null){
    countOfKeyCacheTaken++;
    countOfKeyCache--;}
    return key;
  }

  public synchronized void generateKey(){
    Key key=new Key();
    key.name="Key"+countOfKey;
    key.id=countOfKey;
    keyCache.put(countOfKey,key);
    keyLock.put(countOfKey,key);
    countOfKey++;
    countOfKeyCache++;
  }

  public void printCache(){
    Collection<Key> key =keyCache.values();
    for(Key key1:key)
      System.out.println(key1.getName());
  }
  public void printLock(){
    Collection<Key> key =keyLock.values();
    for(Key key1:key)
      System.out.println(key1.getName());
  }

}
