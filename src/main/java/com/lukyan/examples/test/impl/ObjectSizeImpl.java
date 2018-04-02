package com.lukyan.examples.test.impl;

import com.lukyan.examples.test.api.ObjectSize;
import com.lukyan.examples.helper.Serializer;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class ObjectSizeImpl<T extends Serializable> implements ObjectSize<T> {
    @Override
    public long getSize(T t) {
        byte[] data = Serializer.instance().toByteArray(t);
        log.info("data.length is {}", data.length);
        return data.length;
    }

    @Override
    public long getSize(T t, boolean deep) {
        return 0;
    }

}
