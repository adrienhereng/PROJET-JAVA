#!/bin/bash

javac -d logger/bin $(find logger/src -name *.java)
javac -classpath logger/bin -d banking/bin $(find banking/src -name *.java)
javac -classpath banking/bin:logger/bin -d testframework/bin $(find testframework/src -name *.java) -Xlint
