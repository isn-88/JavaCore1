package core.two.lesson6.practice;


public final class PairUtil {

  private PairUtil() {}

  public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
    return new Pair<>(pair.getSecond(), pair.getFirst());
  }

}
