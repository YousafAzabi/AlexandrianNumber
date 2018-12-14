import java.util.ArrayList;
import java.util.Collections;

class AlexandrianNumber {

  private ArrayList<Double> list;
  private int[] divisorBasic = {1, 2, 5, 10, 13, 17};

  AlexandrianNumber() {
    list = new ArrayList();
  }

  public ArrayList<Double> find(int n) {
    int p = 1, count = 1;
    double result, d, x;
    while (count <= n) {
      x = p * p + 1;
      d = 1;
      int i = 0;
      while (d <= p) {
        if ( (x % d) == 0) {
          result = (double) ( p * (p + d) * (p + ((p * p) + 1) / d) );
          if (!list.contains(result)) {
            list.add(result);
            count++;
            //if (count%10000 == 0)System.out.println(p + " " + d + " " + count + " " + result + " " + i);
          }
        }
        i++;
        d = divisorBasic[i%6] + (24 * (int)(i/6) );
      }
      p++;
    }
    Collections.sort(list);
    return list;
  }

  public void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(list.get(arr[i] - 1));
    }
  }

  public static void main(String[] args) {
    int[] input = {1,2};
    AlexandrianNumber test = new AlexandrianNumber();
    test.find(1000);
    test.print(input);
  }

}
