# Team-2-Create-Your-Own-Adventure


## Project summary: 

Introduction and explanation of game is displayed for the player.

A floorplan will be built and displayed of a main hallway.

Along both sides of the hallway, there are randomly generated rooms that the player can choose to enter, or the player can move down the hallway. 

Rooms will randomly generate items that the player can collect (weapons and potions), or monsters that the player will fight.

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
  - 4 types
    - items
    - monsters
    - items & monsters
    - empty
4. Monster
5. Weapon
6. Menu
7. Tile


### Dev notes: (delete when done) 

Loop 10 times
- Gen random 1-10
- 1-6 nothing
- 7-9 one room
- 10 two rooms
Loop number of rooms
- Generate each room
    - Left or right
    - Set bool room to true
    - Set enemy (random from database)            
        - 1-7 nothing, 8-10 enemy 
    - Set item (random from database)                     
        - 1-9 item, 10 no item
- Generate random description


While (is_alive)

Grab tile at player position

If monster = true

	battle_option()
  
else check if room = true

	if room [1]
  
		print “have room to right”
    
	if room[0]
  
		print “have room left”

input walk forward

	player position++
  
Input inventory 

	inventory()
  
Input move to room

	room_menu()
	
###General Milestone 1:

Get the Crypt building and items in the crypt 

Get the basic movement through game going 

- Edward and Hayden --> Working on gen_world(Crypt) function in Game Controller, if have time work on ability to place items on tiles/rooms

- Kyllie: javadocs for menu 
Edward and Hayden's To Do list:
Flesh out Monster and Room Templates 
