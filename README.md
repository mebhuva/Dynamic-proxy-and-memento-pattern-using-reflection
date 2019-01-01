# Dynamic-proxy-and-memento-pattern-using-reflection
Serializing and Deserializing of object using Dynamic proxy , Reflection and memento pattern
# CSX42: Assignment 5
## Name: Mehul Bhuva

-----------------------------------------------------------------------
-----------------------------------------------------------------------
https://netjs.blogspot.com/2017/08/invoking-getters-and-setters-using-reflection-java.html

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in genericCheckpointing/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile genericCheckpointing/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile genericCheckpointing/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile genericCheckpointing/src/build.xml run -Darg0=mode -Darg1=NUM_OF_OBJECTS -Darg2=checkpoint.txt

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Flow of the project:-

1. Drivercalls proxy creator and use write ob ect and read object to invoke storerestore handler
2. invoke method then calls overloaded method processInput wchich is used to serialize and writing to file and deserialize means reading from the file
3. then we check if both the objects are same or not




Data Structure: -

ArrayList to store Serializable objects


Time complexity :- O(nlogn) 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 12/09/2018


