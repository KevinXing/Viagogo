# How to run
1. cd src
2. java Test seed_num, coord_x, coord_y
   seed_num: the number of seeds
   coord_x, coord_y: the coordinate of the input position[-10,10]
   eg. java Test 40 5 3
3. output will be printed out:
    Closest Events to (5,3):
    Event 031 - $8389.26, Distance 1
    Event 035 - $277.27, Distance 3
    Event 038 - $1406.43, Distance 3
    Event 024 - $842.12, Distance 5
    Event 011 - $2360.15, Distance 5
4. the seed data will be stored in data.txt as 
    x, y, event_id, price

# How to compile
I have compiled the project, and you can compile yourself too.
1. cd src
2. javac *.java

# java API doc
/Doc/BasicInfo
/Doc/Query

# Design Specification
Design Specification.pdf