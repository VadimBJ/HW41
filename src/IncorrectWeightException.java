public class IncorrectWeightException extends IllegalArgumentException{
  public IncorrectWeightException(int n) {
    super(n<0? "Вес не может быть отрицательным: "+n:"Вес превышает максимальный!");
  }
}
