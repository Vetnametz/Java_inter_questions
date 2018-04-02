package com.lukyan.examples.jcommander;

import com.beust.jcommander.Parameter;
import lombok.Data;

@Data
public class Args {

    @Parameter(names = "-c", splitter = SpaceParameterSplitter.class, description = "Class for analyze", required = true)
    private String object;

}
