# High-Speed Server Log Analyzer

## Overview

High-Speed Server Log Analyzer is a Java console application that analyzes server log files using Java Streams and Regular Expressions. It provides quick insights into server activity by reading log entries from a text file and generating useful statistics such as total log entries, HTTP status code frequencies, and requested destinations.

---

## Features

* Display all server log entries
* Count the total number of log records
* Analyze HTTP status code frequencies
* Count requested destinations (URLs)
* Menu-driven console interface
* Efficient file processing using Java Streams
* Pattern matching using Regular Expressions

---

## Technologies Used

* Java
* Java NIO (`Files`, `Path`)
* Java Streams API
* Regular Expressions (Regex)
* Collections Framework

---

## Project Structure

```
High-Speed-Server-Log-Analyzer/
│
├── Main.java              # Main application with menu interface
├── LogAnalyzer.java       # Log analysis methods
├── server_logs.txt        # Sample server log file
├── Main.class
├── LogAnalyzer.class
└── README.md
```

---

## Sample Log Format

```
2025-06-20 GET /home 200
2025-06-20 POST /login 401
2025-06-20 POST /payment 500
```

Each log entry contains:

* Date
* HTTP Method
* Requested Destination
* HTTP Status Code

---

## How to Run

### 1. Compile the project

```bash
javac Main.java LogAnalyzer.java
```

### 2. Run the application

```bash
java Main
```

---

## Menu Options

```
===== High-Speed Server Log Analyzer =====

1. Display Logs
2. Count Total Logs
3. Count Status Codes
4. Count Requested Destinations
5. Exit
```

---

## Sample Output

### Count Total Logs

```
Total Log Entries : 20
```

### Status Code Frequency

```
Status Code Frequency

200 -> 12
201 -> 1
401 -> 2
404 -> 2
500 -> 3
```

### Destination Requests

```
Destination Requests

/home -> 3
/products -> 4
/login -> 2
/payment -> 2
/dashboard -> 2
...
```

---

## Concepts Demonstrated

* File Handling using Java NIO
* Java Streams
* Lambda Expressions
* Functional Programming
* Regular Expressions
* HashMap and Collectors
* Exception Handling
* Object-Oriented Programming

---

## Future Improvements

* Search logs by date
* Filter logs by status code
* Display most frequently accessed endpoint
* Export analysis reports to CSV
* Visualize statistics using charts
* Support large log files with parallel streams

---

## Author

Developed as a Java project to demonstrate efficient log file analysis using Java Streams, Regex, and modern Java programming practices.
