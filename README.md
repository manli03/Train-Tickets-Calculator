# Train Tickets Calculator

## Description

This project is a simple Java Swing application designed to calculate train ticket prices. It allows users to input passenger information and determine the total cost of their train tickets.

## Installation

To set up and run this project, you will need:
*   Java Development Kit (JDK) 21
*   Apache Ant (if building from the command line)
*   NetBeans IDE (recommended for easy setup and development)

### Using NetBeans IDE

1.  Download the project files in zip format from [the GitHub repository](https://github.com/manli03/Train-Tickets-Calculator/archive/refs/heads/master.zip).
2.  Open NetBeans IDE.
3.  Go to `File` > `Import Project` > `From ZIP...`.
4.  Browse the `Train-Tickets-Calculator-master.zip`, choose it and click `Import`.
5.  NetBeans should automatically recognize it as a Java project.

### Building with Apache Ant (Command Line)

1.  Ensure you have JDK and Apache Ant installed and configured in your system's PATH.
2.  Navigate to the project's root directory in your terminal:
    ```bash
    cd "c:/Users/User/OneDrive/Documents/NetBeansProjects/Train Tickets Calculator"
    ```
3.  Run the Ant build command:
    ```bash
    ant jar
    ```
    This will compile the project and create a JAR file in the `dist` directory.

## Usage

### Running from NetBeans IDE

1.  After opening the project in NetBeans, right-click on the project in the `Projects` window.
2.  Select `Run` or press `F6`.

### Running the JAR file (after Ant build)

1.  Navigate to the `dist` directory in your terminal:
    ```bash
    cd "path-to-project/Train Tickets Calculator/dist"
    ```
2.  Run the executable JAR file:
    ```bash
    java -jar "Train Tickets Calculator.jar"
    ```
    (Note: The exact JAR file name might vary slightly based on your build configuration, but it will typically be named after the project.)

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/YourFeature`).
3.  Make your changes.
4.  Commit your changes (`git commit -m 'Add some feature'`).
5.  Push to the branch (`git push origin feature/YourFeature`).
6.  Open a Pull Request.

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.
