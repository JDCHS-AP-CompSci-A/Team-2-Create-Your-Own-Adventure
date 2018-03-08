# Team-2-Create-Your-Own-Adventure


## Project summary: 

At the beginning of the game, player can select player class (warrior, ranged, mage). 

Player class have different specialties.

A floorplan will be built of a main hallway. 

Along both sides of the hallway, there are rooms that the player can choose to enter, or the player can move down the hallway. 

Rooms will randomly generate items that the player can collect (such as weapons), or monsters that the player will fight.

Throughout the hallway, there are additional monsters that player must fight. 

The goal is for the player to move down the hallway, fighting monsters and making it as far as the player can until player runs 
out of health. The game will indefinitely continue, generating new floors/levels, monsters, and items until player dies or quits. 
(If have time: Player progess is recorded by the amount of experience points earned.)

Levels will become more difficult/hallways will become longer the farther the player goes.

### Misc. project specifics:

Combat: 

player can select different attacks to use to fight against a monster (like Pokemon)

if player defeats monster, player is awarded (ex. an item)

if player is defeated, player loses health


Inventory: 

weapons will have durability and attack strength (percentage hit)

there will be a limited inventory (player can choose to switch out items if find a new one)


Health:

health can be restored out of battle with potions 


### Main objects: 

1. Player
2. Floor
3. Room
  - 5 types
    - items
    - monsters
    - items & monsters
    - empty
    - “curse”
4. Monster
5. Item

### Dev notes:

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

- Kyllie: currently working on trying to get the player to move/print on map 
Edward and Hayden's To Do list:
Flesh out Monster and Room Templates 
