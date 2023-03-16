public class IncorrectWeightException extends IllegalArgumentException{
  public IncorrectWeightException(int n) {
    super("Вес не может быть отрицательным: "+n);
  }
}
