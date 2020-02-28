package KeyManeger;

import Items.Items;

import java.util.Objects;

public class Key implements Items {
  String name;
  int id;

  @Override
  public String toString() {
    return getName();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return this.name.equals(key.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public Object clone() {
    Key key = null;
    key.name=this.name;
    key.id=this.id;
    return key;
  }
}
