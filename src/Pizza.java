public class Pizza {

  private String title;
  private int weight;

  public Pizza(String title, int weight) {
    this.title = title;
    if (weight < 0) {
      throw new IncorrectWeightException(weight);
    } else {
      this.weight = weight;
    }
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