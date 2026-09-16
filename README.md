# AI-Generated Java Code Testing

## Overview

This project evaluates AI-generated Java code by testing its behaviour against expected requirements. This was the prompt given:


  Task-4: Club
  The doorman Bruno at the popular night club Heaven is having a hard time
  fulfilling his duties. He was told by the owner that when the club is full,
  the number of women and men let into the club should be roughly the same.
  When the night club opens, people wanting to enter the club are already
  lined up in a queue, and Bruno can only let them in one-by-one. He lets
  them in more-or-less in the order they are lined up. He can however decide
  to let the second person in the queue cut the line and slip into the club
  before the person in front. This will no doubt upset the person first in
  line, especially when this happens multiple times, but Bruno is quite a
  big guy and is capable of handling troublemakers.
 
  Unfortunately though, he is not that strong on mental calculations under
  these circumstances. He finds keeping track of the difference of the number
  of women and number of men let into the club a challenging task. As soon
  as the absolute difference gets too big, he loses track of his counting
  and must declare to the party people remaining in the queue that the club
  is full.
 
  Input: A string containing a positive integer (describing the largest
  absolute difference between the number of women and number of men let
  into the club that Bruno can handle) followed by a comma and then a
  string consisting solely of the characters ’W’ and ’M’ of length at
  most 100, describing the genders of the people in the queue, in order
  of their arrival. The first character of this string is the gender
  of the person first in line. You may assume that the club is large
  enough to hold all the people in the queue.
 
  Output: The maximum number of people Bruno can let into the club
  without losing track of his counting.

The project focuses on identifying incorrect behaviour, missing validation, and edge cases through unit testing.

## Functionality Tested

The implementation contains:

- A `Bruno` class for tracking the number of men and women admitted.
- A `QueueHandler` class for managing the queue and processing admissions.
- A queue implemented using Java’s `LinkedList`.
- Logic for admitting the first or second person in the queue.
- Methods for checking whether a person can be admitted.
- Methods for counting admitted people.
- JUnit tests for constructors, queue processing, admission logic, and invalid inputs.

## Testing Approach

JUnit 5 was used to test both expected and unexpected behaviour.

The tests included:

- Constructor tests.
- Tests for valid `W` and `M` inputs.
- Tests for empty and single-person queues.
- Tests for maximum and minimum integer values.
- Tests for invalid characters, including lowercase letters, spaces, and random characters.
- Tests for negative values.
- Tests for queue processing when everyone could be admitted.
- Tests for queue processing when nobody could be admitted.
- Tests for boundary and edge cases.
- Tests that deliberately failed when the implementation did not reject invalid input.

Some tests were written as **expected-failure tests**. These tests demonstrated that the implementation accepted values that should have been rejected, such as negative limits or invalid gender characters. The failures helped identify weaknesses in the AI-generated implementation.


## Learning Outcomes

This project provided experience in:

- Writing unit tests with JUnit.
- Testing normal, invalid, and boundary cases.
- Analysing failures in AI-generated code.
- Identifying missing input validation.
- Comparing expected behaviour with actual behaviour.
- Understanding why generated code requires human review.
- Using tests to evaluate code quality and reliability.

## Note

This project was created for educational testing purposes. The implementation contains intentional weaknesses so that they could be identified through unit tests. It should not be treated as production-ready without further validation, refactoring, and input handling.
