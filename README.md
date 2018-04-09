# Team-2-Create-Your-Own-Adventure


## Project summary: 

Introduction and explanation of game is displayed for the player.

A floorplan will be built and displayed of a main hallway, called a crypt. 

Along both sides of the hallway, there are randomly generated rooms that the player can choose to "enter" (player will not physically enter room - only will be called), or the player can move down the hallway. 

Rooms will randomly generate items that the player can collect (weapons), or monsters that the player will fight. Defeating a monster will award the player a potion.

Throughout the hallway, there are additional monsters that player must fight. 

Battle sequence will automatically begin when a player runs into a monster, but a player may run away. However, the player must defeat the monster if they want to proceed (in the hall) or if they want to collect the item (in the room). 

The goal is for the player to move down the hallway, fighting monsters and making it as far as the player can until player runs 
out of health. The game will indefinitely continue, generating new floors/levels, monsters, and items until player dies or quits. 

### Misc. project specifics:

Combat: 

player can select different weapons to use to fight against a monster (like Pokemon)

if player is defeated, player loses health. 


Inventory: 

weapons will have durability and attack strength (percentage hit)

there will be a limited inventory of 4 slots (player can choose to switch out items if find a new one)


Health:

health can be restored out of battle with potions, measured by a simple int count.


### Main objects: 

1. Crypt
2. Desc
2. Floor
3. Room
4. Monster
5. Weapon
6. Menu
7. Tile
