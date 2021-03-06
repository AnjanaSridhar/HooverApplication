## This is a Spring boot application using Maven as the build tool.
## How to build : 
* The project can be built with the command 'mvn clean install compile package'
## Deploying the application : 
* The class 'Application' can be run after that to bring up the hoover application.
* A call can be made to the endpoint to call the service with JSON payload as part of request.

## Tests
* There are unit tests for HooverController class and HooverServiceImpl class.

## Problem Statement
This is a service that navigates a imaginary robotic hoover (much like a Roomba) through an equally imaginary room based on:

room dimensions as X and Y coordinates, identifying the top right corner of the room rectangle. This room is divided up in a grid based on these dimensions; a room that has dimensions X: 5 and Y: 5 has 5 columns and 5 rows, so 25 possible hoover positions. The bottom left corner is the point of origin for our coordinate system, so as the room contains all coordinates its bottom left corner is defined by X: 0 and Y: 0.
locations of patches of dirt, also defined by X and Y coordinates identifying the bottom left corner of those grid positions.
an initial hoover position (X and Y coordinates like patches of dirt)
driving instructions (as cardinal directions where e.g. N and E mean "go north" and "go east" respectively)
The room will be rectangular, has no obstacles (except the room walls), no doors and all locations in the room will be clean (hoovering has no effect) except for the locations of the patches of dirt presented in the program input.

Placing the hoover on a patch of dirt ("hoovering") removes the patch of dirt so that patch is then clean for the remainder of the program run. The hoover is always on - there is no need to enable it.

Driving into a wall has no effect (the robot skids in place).

Goal
The goal of the service is to take the room dimensions, the locations of the dirt patches, the hoover location and the driving instructions as input and to then output the following:

The final hoover position (X, Y)
The number of patches of dirt the robot cleaned up
Input
Program input will be received in a json payload with the format described here.

Example:

{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}
Output
Service output should be returned as a json payload.

Example (matching the input above):

{
  "coords" : [1, 3],
  "patches" : 1
}
