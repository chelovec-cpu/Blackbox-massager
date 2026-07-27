package com.blackbox.messenger;

public interface GenericProvider<F, T> {
    T provide(F obj);
}
