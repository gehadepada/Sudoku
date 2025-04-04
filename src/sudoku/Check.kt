package sudoku
fun main() {
    println("*******Sudoku Validation Game********")
    println("Enter Number of Rows and Columns: ")

    val number = readLine()?.toInt() ?: 0
    val grid = mutableListOf<MutableList<Char>>()
    println("Enter Your Sudoku Grid To Check If Is Valid ")
    for ( i in 0 until number)
    {
        val input = readLine()?.split(" ") ?: listOf()
        val row = input.map { it.firstOrNull() ?: '-' }.toMutableList()
        grid.add(row)
    }
    // Valid Sudoku Test
    Check(
        "givenValidSudoku_WhenChecked_ThenValidationSuccess",
        isValidSudoku(grid),
        true
    )

    // Invalid Size Test
    Check(
        "givenInvalidSizeSudoku_WhenChecked_ThenValidationFails",
        isValidSudoku(grid),
        false
    )

    // Row Duplicate Test
    Check(
        "givenRowWithDublicateNumbers_WhenChecked_ThenValidationFails",
        isValidSudoku(grid),
         false
    )

    // Column Duplicate Test
    Check(
        "givenColumnWithDublicateNumbers_WhenChecked_ThenValidationFails",
        isValidSudoku(grid),
        false
    )

    // Grid Duplicate Test
    Check(
        "givenGridWithDublicateNumbers_WhenChecked_ThenValidationFails",
        isValidSudoku(grid),
        false
    )

    // Invalid Characters Test
    Check(
        "givenSudokuWithInvalidCharacters_WhenChecked_ThenValidationFails",
        isValidSudoku(grid),
        false
    )



    println("All tests completed.")
}


fun Check(name : String , result : Boolean  , correctResult : Boolean)
{
    if (result ==  correctResult)
    {
        println("Sucess ,$name")
    }
    else
    {
        println("Faild ,$name")
    }
}
