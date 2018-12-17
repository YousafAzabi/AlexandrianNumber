import java.util.ArrayList;
import java.util.Collections;

class AlexandrianNumber {

  private ArrayList<Double> list;
  private int[] divisorBasic = {1, 2, 5, 10, 13, 17};

  AlexandrianNumber() {
    list = new ArrayList<Double>();
  }

  public ArrayList<Double> find(int n) {
    int count = 1;
    long d, x, p = 1;
    double result;
    while (count <= n) {
      x = p * p + 1;
      d = 1;
      int i = 0;
      while (d <= p) {
        if ( (x % d) == 0) {
          result = p * (p + d) * (p + (x) / d);
          if (!list.contains(result)) {
            list.add(result);
            count++;
            if (count%10000 == 0)System.out.println(p + " " + d + " " + count + " " + result + " " + i);
          }
        }
        i++;
        d = divisorBasic[i%6] + (24 * (i/6) );
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
    int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
    AlexandrianNumber test = new AlexandrianNumber();
    test.find(45);
    test.print(input);
  }

}
