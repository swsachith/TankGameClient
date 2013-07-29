TankGameClient
==============

This is a TankGame client which connects to a Remote server and plays the game on its own. 
Concepts Used:
1. Uses Java Sockets to communicate between the server and the client.
2. Uses Observer Design pattern to retrieve data once the server sends the data
3. Uses A* searching Algorithm together with Value iteration to make the decision
4. Main Objective is winning the game destroying other tanks. The path to finding the nearest tank
   is done by prioritizing paths with Bounty	