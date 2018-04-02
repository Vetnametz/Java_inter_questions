#!/bin/bash
DEBUG=" -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 "
java $DEBUG -jar ./target/java-inter-questions-0.1.0-SNAPSHOT.jar -c A
