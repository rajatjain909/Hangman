import kotlin.random.Random

// List of words for the game
val words =
    listOf("images", "components", "Android", "apps", "users", "may", "need", "simple", "layout", "that", "contains")
var word = ""  // The selected word for the game
val guesses = arrayListOf<Char>()  // List to store the guesses (initially empty underscores)
var remainingGuesses = 6  // Number of incorrect guesses allowed
var mistakeCounter = 0  // Counter for the number of mistakes made

fun main(args: Array<String>) {
    setupGame()
}

// This function sets up the game, including selecting a random word and starting the loop
private fun setupGame() {
    // Randomly select a word from the list and set it to uppercase
    val randomWordIndex = Random.nextInt(words.size)
    word = words[randomWordIndex].uppercase()

    // Initialize the list of guesses with underscores (one for each letter of the word)
    for (i in word.indices) guesses.add('_')

    var gameOver = false  // Flag to track if the game is over

    do {
        printGameStatus()  // Print the current status of the game, also handle the initial status
        println("\nPlease enter a letter:")
        val input = readlnOrNull() ?: ""

        // Check if the input is blank or invalid
        if (input.isBlank()) {
            println("Not a valid input. Please try again.")
        } else {
            val letter: String = input[0].uppercase()  // Get the uppercase version of the input
            if (word.contains(letter)) {  // If the letter is in the selected word
                // Update the guesses with the correct letter
                for (i in word.indices) {
                    if (word[i] == letter[0]) {
                        guesses[i] = letter[0]
                    }
                }
                // Check if the game is won (all letters guessed correctly)
                if (!guesses.contains('_')) {
                    gameOver = true
                }
            } else {
                // If the letter is not in the word, decrement the remaining guesses
                println("Not the part of word")
                remainingGuesses--
                mistakeCounter++  // Increase the mistake counter
                if (mistakeCounter == 6) gameOver = true  // End the game if too many mistakes
            }
        }
    } while (!gameOver)

    // If the game ended due to too many mistakes
    if (mistakeCounter == 6) {
        printGameStatus()  // Show the final status
        println("You lost. Word was: $word")  // Inform the player that they lost
    } else {
        // If the game ended because the player guessed the word
        println("\nCongratulations. You WON!!!\nWord was: $word")
    }
}

// Function to print the current game status
private fun printGameStatus() {
    // Display the hangman state based on the number of mistakes
    when (mistakeCounter) {
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }

    // Print the current state of the word with correct guesses
    print("\nWord:")
    for (element in guesses) print(" $element")

    // Print the remaining guesses
    println("\nYou have $remainingGuesses guess(es) left")
}

// These functions print different hangman stages based on mistakes made
private fun print0Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print1Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |         ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print2Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print3Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print4Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      /|\\ ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print5Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |     /| ")
    println(" /|\\      ")
    println("/ | \\     ")
}

private fun print6Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |     /|\\")
    println(" /|\\      ")
    println("/ | \\     ")
}
