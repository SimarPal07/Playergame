Simple Game Character Manager
A command-line Java game where users create and manage player characters, battle monsters, level up, and track stats.

Features
Create multiple player characters with customizable names

Simulate simple fights against monsters (Goblin)

Players can attack monsters, take damage, and level up

View detailed player stats at any time

Interactive command-line interface with menu options

Object-oriented design using classes and ArrayList to manage players

How to Play
Run the program.

Use the menu to:

Create new players

Select a player to fight a monster

View a player’s stats

Exit the game

When attacking a monster:

Player and monster take turns attacking until one is defeated.

If the player defeats the monster, they level up (increasing attack power and health).

Monitor your player’s health to avoid defeat.

Code Structure
Player.java: Defines the Player class with attributes (name, health points, attack power, level) and behaviors (attackMonster(), takeDamage(), levelUp(), showStats()).

Monster.java: Defines the Monster class with attributes and behaviors similar to Player.

GameManager.java: Main program containing the command-line interface, player management, fight simulation, and game loop.

Requirements
Java Development Kit (JDK) 8 or higher
