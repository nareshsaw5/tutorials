package functional.generic;

@FunctionalInterface
public interface GenericFunctional<T, R> {

    public R execute(T type);
}
