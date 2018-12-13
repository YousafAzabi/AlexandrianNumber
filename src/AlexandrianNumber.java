import java.util.ArrayList;

class AlexandrianNumber {

  private ArrayList<Integer> list;

  AlexandrianNumber() {
    list = new ArrayList();
  }

  public ArrayList<Integer> find(int n) {
    boolean tag = true;
    int p = 1, count = 1, x, result;
    while (count < n) {
      x = p * p + 1;
      for(int d = 2; d <= x ; d++) {
        if ( (x % d) == 0) {
          result = (int) (p * (p + d) * (p + (Math.pow(p,2) + 1) / d));
          for(int item : list) {
            if (result == item) {
              tag = false;
              break;
            }
          }
          if (tag) {
            list.add(result);
            count++;
          }
          tag = true;
        }
      }
      p++;
    }
    return list;
  }

  public void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(list.get(arr[i] - 1));
    }
  }

  public static void main(String[] args) {
    int[] input = {7, 3, 4, 5};
    AlexandrianNumber test = new AlexandrianNumber();
    test.find(10);
    test.print(input);
  }

}
