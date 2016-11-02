package njit.cs698.wenbin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class Record<E extends Number> implements Comparable<Record<E>>, WritableComparable<Record<E>> {
  private E value;
  private String key="";

  Record(E value, String key) {
    this.value = value;
    this.setKey(key);
  }

  public Record() {
 
  }

  @Override
  public int compareTo(Record<E> rc) {
    if (this.value.doubleValue() > rc.value.doubleValue()) {
      return 1;
    } 
    else if (this.value.doubleValue() <rc.value.doubleValue()){
      return -1;
    }
    else {
      return (this.getKey().compareTo(rc.getKey()));
    }
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = new String(key);
  }

  @Override
  public void write(DataOutput out) throws IOException {
    WritableUtils.writeString(out, key);
    out.writeInt(value.intValue());
  }

  @SuppressWarnings("unchecked")
  @Override
  public void readFields(DataInput in) throws IOException {
    key = WritableUtils.readString(in);
    Integer i = in.readInt();
    setValue((E) i);
  }
}