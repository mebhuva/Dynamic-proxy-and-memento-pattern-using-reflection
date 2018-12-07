# CSX42: Assignment 4
## Name: Mehul Bhuva

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in airportSecurityState/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile airportSecurityState/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile airportSecurityState/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile airportSecurityState/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=DEBUG_LEVEL

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Flow of the project:-

1. Driver takes 3 arguments as input filename , output file name and debug level
2. Driver checks if input file present or not
3. Driver checks if debug level is in between the 0 to 4 and integer value 
4. Driver calls reads file line by line and calls seurity factor to process line and calculate avgtraffc and acgprohibited items then this object pass to the airport context which set the state and add resilt string into the result object
5. then after whole file processed and given result object to the mylogger which writes te result into the write file
6. before writing it also check if file is empty or not




Data Structure: -

ArrayList to store Days, Prohibited Items, Traveler and Result


Time complexity :- O(nlogn) 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 11/11/2018


