# Aquent-Coding-Challenge

# How to run the program:
Download the jar file from https://drive.google.com/file/d/1Maaz8S8REJHDQj3yf3IZGECjUpGj5t_d/view?usp=sharing and then run the java application.

java -jar target/AquentCodingChallenge-0.0.1-SNAPSHOT.jar “INPUT FILE PATH/LOCATION” “OUT FILE PATH/LOCATION” 

This will run the program and output will be written in the OUT FILE 

# All assumptions
1) There can be any number of orders in One Epoch Time. But in each Epoch time there can be only one type of order (like Pizza,burger).

2) Human Reader data in written in the output file. Epoch time is converted into dd/MM/yyyy HH:mm:ss format. 

3) Program is designed to consume RESTapi for future reference and all the layers are setup. The programmer has the setup the database connectivity and use Spring Boot as mentioned in the Repo layer. 

4) There should at least 2 command line arguments one for the input file location and other should be out file location. If you doesn’t provide these two the program will not execute the expected results. You can see the error in the command line.

5) Input File and Output should exists in the machine for reading and writing the file. The program will not generate new file by itself.

# Design Patters Followed:
1) Dependency Injection
2) Factory Based Injection
3) MVC

# Design Design: 
I have made the data processing as a different bean so that when ever the developer needs it for the future purpose can use it by changing the logic little bit. 
I have choose TreeMap and TreeSet for lexicographically sorting the data easily.  
I have followed MVC design pattern to make basic layer of RESTapi.

# Aquent-Coding-Challenge
