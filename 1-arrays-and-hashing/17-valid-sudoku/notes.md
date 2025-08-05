# Problem Restate:
We are given a 9x9 sudoku board with some numbers filled in (from 1 to 9). We are to return true or false as to whether the sudoku board is valid. A board is valid when each row, column, and 3x3 grid within the board contains only unique digits.

# Key Design question:
We can use a set to check for duplicates in each row, column, and 3x3 mini grid. We iterate through and check for a duplicate, returning false if a duplicate is found, and true if we make it to the end with no duplicates after completing all 3 checks. I’ve broken the solution down into 3 clear sections.

# Complexities:
This solution uses O(n^2) time complexity and O(n^2) space complexity, which is efficient given the constraints of a sudoku board.

# What I learned:
I learnt how order matters when iterating over rows and columns in a 2D array. I also learnt how to divide the grid into sub-grids and be able to manage those values independently to other sub-grids.

# Mistakes Made:
- Using integers in the in the HashSet instead of characters -> must keep logic aligned with char[][] - data is already in char form
- Forgetting to check for values without a digit (`.`)
