package sudoku

fun isValidSudoku(grid: MutableList<MutableList<Char>>): Boolean {
    val n = grid.size
    //Check rows size
    for (i in 0 until n) {
        if (grid[i].size != n) {
            return false
        }
    }
    // Check rows for duplicates
    for ( i in  0 until n)
        {
            val freq =mutableMapOf<Char, Int>()
            for (c in grid[i]) {
                if( c. isDigit() && c in freq)
                {
                    return false
                }
                freq[c] = freq.getOrDefault(c, 0) + 1
            }
        }
    // Check columns for duplicates
    for (j in 0 until n) {
        val freq = mutableMapOf<Char, Int>()
        for (i in 0 until n) {
            val c = grid[i][j]
            if (c.isDigit() && c in freq)
            {
                return false
            }
            freq[c] = freq.getOrDefault(c, 0) + 1
        }
    }

    val subGrid = Math.sqrt(n.toDouble()).toInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (n - j >= subGrid && n - i >= subGrid) {
                val freq = mutableMapOf<Char, Int>()
                for (row in i until i + subGrid) {
                    for (col in j until j + subGrid) {
                        if(grid[row][col].isDigit() && grid[row][col] in freq)
                        {
                            return false
                        }
                        freq[grid[row][col]] = freq.getOrDefault(grid[row][col], 0) + 1
                    }
                }

            }
        }
        }

    for( i in  0 until n ) {
        for (j in 0 until n) {
            if(grid[i][j]=='-' || (grid[i][j] >= '1' && grid[i][j] <=n.toChar())) {
                continue
            }
            else
            {
                return false
            }
        }
    }

    return true



}
