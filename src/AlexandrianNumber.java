import java.util.ArrayList;

class AlexandrianNumber {

  private ArrayList<Integer> list;

  AlexandrianNumber() {
    list = new ArrayList();
  }

  public ArrayList<Integer> find(int n) {
    int x = 0;
    boolean tag = true;
    int result = 0;
    for(int p = 1; p <= n ; p++) {
      x = p * p + 1;
      for(int d = 2; d <= x ; d++) {
        //System.out.print(p + " " + x + " " + d + "\n");
        if ( (x % d) == 0) {
          result = (int) (p * (p + d) * (p + (Math.pow(p,2) + 1) / d));
          for(int k = 0; k < list.size(); k++) {
            if (result == list.get(k)) {
              tag = false;
            }
          }
          if (tag) {
            list.add(result);
          }
          tag = true;
        }
      }
    }
    return list;
  }

  public void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(list.get(arr[i] - 1));
    }
  }

  public static void main(String[] args) {
    int[] input = {1, 3, 4, 5};
    AlexandrianNumber test = new AlexandrianNumber();
    test.find(5);
    test.print(input);
  }

}
