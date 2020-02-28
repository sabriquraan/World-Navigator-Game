## World Navigator-Game
World Navigator is console game where the user issues commands
to navigate and act on a map made of a graph of Rooms.

## Authors
Mohammed Al-Quraan

## Installation
Download the World Navigator folder that contains the java project.

## Usage
1) Edit the map.txt and write the map with a certain format.
(This certain format will be illustrated in ## FileFormat)
2) Open World Navigator project in IDE.
3) Open Game package.
4) Run the Main in RunGame class.
5) Enjoy with Game.

## FileFormat

The first line contains one integer (n) --> Number of Room in map.
For each room will write one integer in line (m) --> Number of Door in Room.
Next (m) line have two integer number separated by comma like this: Num1,Num2 -->
Where:
Num1 --> the current room to this door.
Num2 --> the next room to this door.


restriction on this file:

1)The last room must have at least one door to be the exit door,
maybe have more of one door and one of them will be the exit door.
2)You must build the path to reach the last room to make game winnable.
3)Doors in Room(i) must have the current room (i) 
example: Door in room0
must be    ---> 0,1
not can be ---> 1,2
the first number must be same of the current room number.


Example of file:
3   ----> number of room.
1   ----> number of door in room 0.
0,1 ----> this door move you from room0 to room1.
2   ----> number of door in room 1.
1,2 ----> this door move you from room1 to room2.
1,0 ----> this door move you from room1 to room0.
1   ----> number of door in room 2.
2,0 ----> this the exit door.


## Test
I write two test map :
map.txt
map1.txt


## Note
You can run GUI class to keep look to valid commands.
File format take care about the number of doors in the room,
another wall item in the room will generated randomly.
