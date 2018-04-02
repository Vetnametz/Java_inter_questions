package com.lukyan.examples.jcommander;

import com.beust.jcommander.converters.IParameterSplitter;

import java.util.Arrays;
import java.util.List;

public class SpaceParameterSplitter implements IParameterSplitter {
    @Override
    public List<String> split(String value) {
        return Arrays.asList(value.split(" "));
    }
}
