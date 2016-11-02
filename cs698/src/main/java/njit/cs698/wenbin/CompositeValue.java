package njit.cs698.wenbin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CompositeValue implements WritableComparable<CompositeValue>{

  private Text text = new Text();
  private IntWritable val = new IntWritable();
  @Override
  public void write(DataOutput out) throws IOException {
    text.write(out);
    val.write(out);
    
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    text.readFields(in);
    val.readFields(in);
    
  }
  
  public String toString() {

    return (new StringBuilder()).append(text).append(' ').append(val).toString();
  }

  @Override
  public int compareTo(CompositeValue o) {
    int result = text.compareTo(o.text);
    if (0 == result) {
      result = val.compareTo(o.val);
    }
    return result;
  }

  public Text getText() {
    return text;
  }

  public void setText(Text text) {
    this.text = text;
  }

  public IntWritable getVal() {
    return val;
  }

  public void setVal(IntWritable val) {
    this.val = val;
  }

}
