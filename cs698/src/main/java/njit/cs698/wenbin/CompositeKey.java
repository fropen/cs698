package njit.cs698.wenbin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class CompositeKey implements WritableComparable<CompositeKey> {

  private String first;
  private String second;

  public CompositeKey() {
  }

  public CompositeKey(String left, String right) {

    this.first = left;
    this.second = right;
  }

  @Override
  public String toString() {

    return (new StringBuilder()).append(first).append(' ').append(second).toString();
  }

  @Override
  public void readFields(DataInput in) throws IOException {

    first = WritableUtils.readString(in);
    second = WritableUtils.readString(in);
  }

  @Override
  public void write(DataOutput out) throws IOException {

    WritableUtils.writeString(out, first);
    WritableUtils.writeString(out, second);
  }

  @Override
  public int compareTo(CompositeKey o) {

    int result = first.compareTo(o.first);
    if (0 == result) {
      result = second.compareTo(o.second);
    }
    return result;
  }
  
  public String getFirstWord() {
    
    return first;
    }
     
    public void setFirstWord(String str) {
     
    this.first = str;
    }
     
    public String getSecondWord() {
     
    return second;
    }
     
    public void setSecondWord(String wd) {
     
    this.second = wd;
    }

    public void setWord(String left, String right) {
      // TODO Auto-generated method stub
      this.first = left;
      this.second = right;
    }
}
