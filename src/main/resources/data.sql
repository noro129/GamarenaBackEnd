--INSERT INTO game (id, game_name, game_likes_number, game_players_number) VALUES
--(1, 'Worduess', 0, 0),
--(2, 'Sudoku', 0, 0),
--(3, 'Twins-Hunt', 0, 0),
--(4, '2048', 0, 0),
--(5, 'Minesweeper', 0, 0),
--(6, 'Snake', 0, 0);

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(0, 1, 1, 'You have to guess a secret five-letter word.'),
--(1, 1, 2, 'You have six attempts to guess the correct word.'),
--(2, 1, 3, 'Each guess must be a valid five-letter word.'),
--(3, 1, 4, 'After each guess, the color of the tiles will change to show how close your guess was.'),
--(4, 1, 5, 'A green tile means the letter is in the correct position.'),
--(5, 1, 6, 'A yellow tile means the letter is in the word but in the wrong position.'),
--(6, 1, 7, 'A red tile means the letter is not in the word at all.');

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(7 ,2, 1, 'The Sudoku grid consists of 81 cells arranged in 9 rows and 9 columns.'),
--(8 ,2, 2, 'The grid is divided into nine 3x3 sub-grids, also called boxes or regions.'),
--(9 ,2, 3, 'Each row, column and 3x3 box must contain the digits from 1 to 9 with no repetitions.'),
--(10 ,2, 4, 'You cannot change the numbers that are pre-filled at the start of the puzzle.'),
--(11 ,2, 5, 'You may use pencil marks to temporarily note possible numbers in empty cells.');

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(12, 3, 1, 'The game board contains a grid of hidden tiles, each with a color.'),
--(13, 3, 2, 'Each color appears exactly twice on the board.'),
--(14, 3, 3, 'Click on two tiles to reveal them.'),
--(15, 3, 4, 'If the tiles match, they stay revealed.'),
--(16, 3, 5, 'If they don’t match, they are hidden again.'),
--(17, 3, 6, 'The goal is to find all matching pairs.');

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(18, 4, 1, 'The game starts with a 4x4 grid containing one numbered tile.'),
--(19, 4, 2, 'Swipe in any direction to slide all tiles.'),
--(20, 4, 3, 'When two tiles with the same number collide, they merge into one.'),
--(21, 4, 4, 'The resulting tile value is the sum of the merged tiles.'),
--(22, 4, 5, 'A new tile (usually 2 or 4) appears after every move.'),
--(23, 4, 6, 'The goal is to create a tile with the number 2048.'),
--(24, 4, 7, 'The game ends when no moves are possible.');

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(25, 5, 1, 'The game board consists of a grid of covered cells, some containing hidden viruses.'),
--(26, 5, 2, 'Clicking a cell reveals either a number or a virus.'),
--(27, 5, 3, 'A number indicates how many viruses are adjacent to that cell.'),
--(28, 5, 4, 'Use the numbers to deduce the locations of viruses.'),
--(29, 5, 5, 'activate flag button to place a flag where you suspect a virus.'),
--(30, 5, 6, 'The goal is to reveal all safe cells without triggering any viruses.');

--INSERT INTO game_instruction (id, game_id, instruction_number, instruction) VALUES
--(31, 6, 1, 'You control a snake that moves in a continuous direction.'),
--(32, 6, 2, 'Use arrow keys to change the snake’s direction.'),
--(33, 6, 3, 'Eat food items that appear on the grid to grow longer.'),
--(34, 6, 4, 'Avoid colliding with your own body.'),
--(35, 6, 5, 'The game ends if the snake crashes into itself or a wall.'),
--(36, 6, 6, 'The goal is to achieve the highest score by collecting food.');
