public class Pizza {

  private String title;
  private int weight;
  public static int maxWeight;

  public static void setMaxWeight(int maxWeight) {
    Pizza.maxWeight = maxWeight;
  }

  public Pizza(String title, int weight) {
    if (weight < 0) {
      throw new IncorrectWeightException(weight);
    } else {
      this.weight = weight;
    }
    this.title = title;
  }

  @Override
  public String toString() {
    return "Пицца '" + title + "' весом " + weight + " г";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Pizza otherPizza)) {
      return false;
    }
    return title.equals(otherPizza.title) && weight == otherPizza.weight;
  }

  @Override
  public int hashCode() {
    return 31 * weight * title.hashCode();
  }
}