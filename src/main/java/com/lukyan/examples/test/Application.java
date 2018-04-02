package com.lukyan.examples.test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.lukyan.examples.jcommander.Args;
import com.lukyan.examples.test.api.ObjectSize;
import com.lukyan.examples.test.data.A;
import com.lukyan.examples.test.data.B;
import com.lukyan.examples.test.impl.ObjectSizeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        Args argsObj = new Args();
        try {
            JCommander.newBuilder()
                    .addObject(argsObj)
                    .build()
                    .parse(args);
        } catch (ParameterException e) {
            log.error(e.getMessage());
            e.usage();
            System.exit(1);
        }

        checkArg(argsObj.getObject());

        ObjectSize objectSize = new ObjectSizeImpl();

        if("A".equals(argsObj.getObject())) {
            A a = new A();
            objectSize.getSize(a);
        } else if("B".equals(argsObj.getObject())){
            B b = new B();
            objectSize.getSize(b);
        }

        System.exit(0);
    }

    private static void checkArg(String arg){
        if(!("A".equals(arg) || "B".equals(arg))){
            log.error("Argument is incorrect - may be A or B");
            System.exit(1);
        }
    }
}