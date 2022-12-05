
### Q. Hangman: Build a terminal version of the classic game Hangman.
- It is a one-player game. The computer chooses a word randomly from a pool of words, this is the word that needs to be guessed by the player. 
- The computer displays the number of letters using a series of underscores(see example below). If there are any vowels, computer prepopulates them.
- The player is assigned a fixed number of chances, equal to the number of letters present in the word to be guessed). 
- The player then guesses a letter, if the letter is present in the word, the computer displays all the places where it is present. Else the player loses a chance. 
- The computer keeps displaying the already guessed letters after each turn. 
- The game continues until the player wins or the number of chances becomes zero.
- The game needs to be case insensitive
Ex. The word chosen is java and the number of chances is 5, the computer displays

_ _ _ _ 
5 chances left
(Player inputs a)

_ a _ a
5 chances left
(Player input c)

_ a _ a
4 chances left
(Player input j)

j a _ a
4 chances left
