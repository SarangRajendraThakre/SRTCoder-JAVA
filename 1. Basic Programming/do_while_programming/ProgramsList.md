# Switch Statement Programs

This repository contains a collection of 20 diverse programs demonstrating the effective use of the `switch` statement in various scenarios. Each program highlights different aspects and practical applications of `switch`, ranging from basic educational examples to more complex, interactive, and problem-solving scenarios.

## Table of Contents

- [Introduction](#introduction)
- [Basic & Educational Examples](#basic--educational-examples)
- [Interactive & Fun Applications](#interactive--fun-applications)
- [Practical & Problem-Solving Examples](#practical--problem-solving-examples)
- [Advanced & Niche Uses](#advanced--niche-uses)
- [How to Run (General Instructions)](#how-to-run-general-instructions)

## Introduction

The `switch` statement is a control flow statement that allows a value to be tested for equality against a list of values. Each value is called a case, and the block of code associated with the matching case is executed. It's an excellent alternative to long `if-else if-else` chains when dealing with multiple discrete conditions based on a single variable.

## Basic & Educational Examples

These programs are designed to help you grasp the fundamental concepts of the `switch` statement.

1.  **Day of the Week Detector**
    * **Description:** Takes a number (1-7) as input and outputs the corresponding day of the week (e.g., 1 for Monday).
    * **Highlights:** Basic `case` matching, `default` for invalid input.

2.  **Month Name from Number**
    * **Description:** Takes a number (1-12) and returns the name of the month (e.g., 1 for January).
    * **Highlights:** Extended `case` usage, handling edge cases.

3.  **Basic Calculator**
    * **Description:** Performs basic arithmetic operations (+, -, \*, /) on two numbers based on an operator input.
    * **Highlights:** `switch` on characters/strings, handling division by zero in `default`.

4.  **Grade Converter**
    * **Description:** Converts a letter grade (A, B, C, D, F) into a descriptive evaluation (e.g., "Excellent", "Pass", "Fail").
    * **Highlights:** Case-insensitive input handling (if implemented), multiple `case` labels for the same block (fall-through, or enhanced `switch`).

5.  **Traffic Light Simulator**
    * **Description:** Takes a traffic light color (Red, Yellow, Green) and suggests an action.
    * **Highlights:** Mapping discrete states to actions.

## Interactive & Fun Applications

These examples demonstrate how `switch` can be used to create engaging and interactive programs.

6.  **Simple Menu-Driven Application**
    * **Description:** Presents a numbered menu to the user and performs actions based on their numerical choice.
    * **Highlights:** Looping menus, `switch` as a primary navigation tool.

7.  **Choose Your Own Adventure (Text-Based)**
    * **Description:** Guides a user through a simple text-based story where choices determine the next part of the narrative.
    * **Highlights:** Chaining `switch` statements, simple decision trees.

8.  **Horoscope Generator (Simplified)**
    * **Description:** Provides a generic "horoscope" or personality trait based on the user's birth month.
    * **Highlights:** Mapping numerical input to categorical output.

9.  **Random Fact Generator (Categorized)**
    * **Description:** Allows the user to select a category (e.g., Animals, Space) and then provides a random fact from that category.
    * **Highlights:** Combining `switch` with random number generation.

10. **Simple Dice Roller (Multi-sided Dice)**
    * **Description:** Simulates rolling different types of dice (e.g., d4, d6, d20) and outputs a random result.
    * **Highlights:** `switch` on dice type, `Random` class usage.

## Practical & Problem-Solving Examples

These programs showcase the utility of `switch` in solving common programming problems and building practical utilities.

11. **Currency Converter (Simplified)**
    * **Description:** Converts an amount from a source currency to a target currency using hardcoded exchange rates.
    * **Highlights:** Multiple `case` statements for different currency pairs, nested logic if converting from one base to multiple targets.

12. **Shape Area/Perimeter Calculator**
    * **Description:** Prompts for a shape type (e.g., Circle, Square) and then calculates its area or perimeter based on user-provided dimensions.
    * **Highlights:** Using `switch` to select calculation logic based on shape, potentially nested `switch` for area vs. perimeter.

13. **File Type Classifier**
    * **Description:** Takes a file extension (e.g., `.txt`, `.pdf`, `.jpg`) and classifies it into a common file type description.
    * **Highlights:** `switch` on string values, mapping extensions to descriptions.

14. **Simple Command Processor**
    * **Description:** Simulates processing basic text commands (e.g., "help", "list", "exit") and outputs a corresponding action message.
    * **Highlights:** `switch` for command dispatching, string comparison.

15. **User Role-Based Access (Basic Simulation)**
    * **Description:** Simulates access permissions by taking a user role (e.g., "Admin", "Editor") and listing allowed actions.
    * **Highlights:** Demonstrating different permissions based on roles, potential use of fall-through for inherited permissions.

## Advanced & Niche Uses

These examples delve into more sophisticated applications where `switch` can be a powerful tool in specific architectural patterns.

16. **Finite State Machine (FSM) Simulation**
    * **Description:** Models simple state transitions (e.g., a vending machine's states: Idle, HasMoney, Dispensing) using `switch` to define behavior for each state.
    * **Highlights:** State management, event-driven transitions using `switch`.

17. **Lexer/Tokenization (Simplified)**
    * **Description:** A very basic program that processes input characters and identifies them as different types of "tokens" (e.g., digit, operator, letter).
    * **Highlights:** Character-based `switch` for parsing.

18. **Game Move Validator (e.g., Rock-Paper-Scissors)**
    * **Description:** Determines the winner of a Rock-Paper-Scissors game based on two player inputs.
    * **Highlights:** Nested `switch` statements or `switch` on combined input to determine outcomes.

19. **Simple Configuration Parser (Key-Value Pairs)**
    * **Description:** Reads a configuration key (e.g., "theme", "language") and retrieves or sets its corresponding value.
    * **Highlights:** `switch` for processing configuration settings.

20. **Interactive Quiz/Trivia Game**
    * **Description:** Presents multiple-choice questions and uses `switch` to evaluate the user's selected answer.
    * **Highlights:** `switch` for answer validation, score keeping.

