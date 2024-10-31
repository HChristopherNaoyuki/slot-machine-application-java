# Slot Machine Application

A Java-based Slot Machine application featuring both Classic and Fruit variants. This project showcases fundamental programming concepts in Java, including object-oriented design and unit testing.

## Features

- **Classic Slot Machine**: Spin to win with various symbols.
- **Fruit Slot Machine**: Special rules for Saturday evening wins.
- **Randomized Reel Generation**: Symbols are generated randomly for each spin.
- **User Interaction**: Players can bet, spin, and cash out.
- **Unit Testing**: Comprehensive tests to ensure functionality.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven (optional for dependency management)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/HChristopherNaoyuki/slot-machine-application-java.git
   cd slot-machine
   ```

2. Compile and run the application:

   ```bash
   javac SlotMachineApp.java
   java SlotMachineApp
   ```

### Running Tests

To run the unit tests, you can use a testing framework like JUnit:

```bash
javac -cp .:junit-4.13.2.jar SlotMachineAppTest.java
java -cp .:junit-4.13.2.jar org.junit.runner.JUnitCore SlotMachineAppTest
```

## Usage

- Start the application and follow the on-screen prompts.
- Bet an amount and press ENTER to spin the reels.
- Cash out by entering 'C' when desired.

## Contributing

Feel free to submit issues or pull requests for improvements or new features.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
