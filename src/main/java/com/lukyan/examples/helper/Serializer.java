package com.lukyan.examples.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Serializer {

    private final static Logger log = LoggerFactory.getLogger(Serializer.class);

    private Serializer() {
    }

    public static Serializer instance() {
        return SingletonHolder.INSTANCE;
    }

    public Object fromByteArray(byte[] bytes) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new ByteArrayInputStream(bytes));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            //TODO may be implement exception
            throw new RuntimeException(e);
        }
    }

    public byte[] toByteArray(Serializable serializable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            //TODO may be implement exception
            throw new RuntimeException(e);
        }
    }

    private static class SingletonHolder {
        public static final Serializer INSTANCE = new Serializer();
    }
}