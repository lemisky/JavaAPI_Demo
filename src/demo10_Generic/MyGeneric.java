package demo10_Generic;

/**
 * 泛型一般使用 E 表示，使用其他名命都可以
 * @param <E>
 */
public class MyGeneric<E> {
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
