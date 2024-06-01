# Minutes Alive Calculator

This simple Kotlin application calculates the number of minutes you have been alive since your date of birth. Just enter your date of birth, and the app will do the rest!

## Features

- Input your date of birth.
- Calculates the total number of minutes you have been alive.

## Installation

1. Clone the repository:

2. Open the project in your preferred IDE (such as Android Studio).

## Usage

1. Build and run the application on your device or emulator.
2. Enter your date of birth.
3. The app will display the total number of minutes you have been alive.

## ScreenShots
 ![WhatsApp Image 2024-06-01 at 11 33 07_57909e60](https://github.com/Adithya-Merugu/Age_In_Minutes/assets/120652724/a73d7e80-3a02-415a-9b22-4678073c28db)

 ![WhatsApp Image 2024-06-01 at 11 33 08_28e5c09a](https://github.com/Adithya-Merugu/Age_In_Minutes/assets/120652724/ed5ebc44-29f9-4ed2-aed1-9d56fac8f9b7)


## Code Overview

```kotlin
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
 val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 println("Enter your date of birth (yyyy-MM-dd): ")
 val dobInput = readLine()!!
 val dob = LocalDate.parse(dobInput, formatter)
 val currentDateTime = LocalDateTime.now()
 val dobDateTime = dob.atStartOfDay()
 
 val minutesAlive = ChronoUnit.MINUTES.between(dobDateTime, currentDateTime)
 println("You have been alive for $minutesAlive minutes.")
}
