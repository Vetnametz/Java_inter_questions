package com.lukyan.examples.test.api;

import java.io.Serializable;

public interface ObjectSize<T extends Serializable> {
    long getSize(T t);

    long getSize(T t, boolean deep);
}
