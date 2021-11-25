package com.github.hahahehejun.jdk.lazy;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wu
 * @date 2021/11/4 9:58
 */
public class Lazy<T> implements Supplier<T> {

    private final Supplier<? extends T> supplier;

    private T value;

    private Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier) {
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {
        if (value == null) {
            T newValue = supplier.get();
            if (newValue == null) {
                throw new IllegalStateException("Lazy value can not be null!");
            }
            value = newValue;
        }
        return value;
    }

    public <S> Lazy<S> map(Function<? super T, ? extends S> function) {
        return Lazy.of(() -> function.apply(get()));
    }

    public <S> Lazy<S> flatMap(Function<? super T, Lazy<? extends S>> function) {
        return Lazy.of(() -> function.apply(get()).get());
    }
}

