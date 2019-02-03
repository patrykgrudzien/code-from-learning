package com.jurik99.AbstractFactory;

public interface AbstractFactory<R, T> {

    R create(final T type);
}
