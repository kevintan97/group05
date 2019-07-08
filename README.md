----------------Instructions to compile the Java Application----------------


Use IntelliJ or any IDE that supports Java compiling 

!!!!THE PROGRAM HAS BEEN TESTED ONLY ON WINDOWS OS
PLEASE USE WINDOWS TO COMPILE AND RUN IT


**************
How to compile the program in an integrated development environment (IDE):
**************

All the folders (res and src) must be imported in the working IDE project.
To allow the project to compile using IntelliJ, follow these steps.

-File > Project Structure > Project > In this dialog, select java 1.8 as the 
SDK, select language level as 8 and enter your out file path (right click your
out folder in the project view and select copy path) into project compiler output field.
Click apply.

-File > Project Structure > Modules > Sources > In this dialog right click src 
and set as sources then right click res and set as resources

-File > Project Structure > Libraries > In this dialog click the + symbol in the 
top left corner and select java then navigate to the res/lib folder of the project
and select both jar files (hold ctrl while clicking to select both simultaneously) click ok.
Click OK again and finally click apply in the bottom right corner.


Once imported the program can be run by running the MainActivity.java class.


MainActivity.java class can be found by opening the src and then the Main folder.


Dependencies needed for the program to be compiled:

The application uses two external libraries which can be found in  res > lib folder.

The jar files are: jcommon-1.0.23 and jfreechart-1.0.19


The program should now be running normally and it can be executed by running the MainActivity.java class.

**************
How to run the JAR file:
**************

Simply run java -jar Ce201-05.jar or double click the jar icon using explorer.
