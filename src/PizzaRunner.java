import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class PizzaRunner {


  public static boolean parseArguments(String[] args) {
    if (args.length != 1) {
      System.err.println("Некорректное использование!");
      System.exit(0);
    }
    try {
      int maxWeight = Integer.parseInt(args[0]);
      if (maxWeight < 0) {
        throw new IncorrectWeightException(maxWeight);
      }
      Pizza.setMaxWeight(maxWeight);
      return true;
    } catch (NumberFormatException e) {
      System.err.println("Некорректное использование: " + e.getMessage());
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    if (parseArguments(args)) {
      System.out.printf(
          "\u001B[34mПримечание:\u001B[31m максимально возможный вес %d грамм!\u001B[0m%n",
          Pizza.getMaxWeight());
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.print("Введите количество пицц: ");
      int n = Integer.parseInt(br.readLine());
      Map<Pizza, Integer> pizzas = new HashMap<>();
      for (int i = 0; i < n; ++i) {
        System.out.println("Ввод данных для пиццы номер " + (i + 1) + ":");
        System.out.print("  Введите название: ");
        String title = br.readLine();
        System.out.print("  Введите вес в граммах (целое число): ");
        int weight = Integer.parseInt(br.readLine());

        Pizza tempPizza = new Pizza(title, weight);
        if (!pizzas.containsKey(tempPizza)) {
          pizzas.put(tempPizza, 0);
        }
        int count = pizzas.get(tempPizza);
        pizzas.put(tempPizza, count + 1);
      }

      System.out.println("\nУ нас есть данные про " + pizzas.size() + " уникальных пицц:");
      int k = 1;
      for (Map.Entry p : pizzas.entrySet()) {
        System.out.printf("%d. %s - %s шт.%n", k, p.getKey(), p.getValue());
        ++k;
      }
    } catch (IncorrectWeightException e) {
      System.err.println(e.getMessage());
    }
  }
}