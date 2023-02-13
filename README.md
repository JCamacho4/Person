Note: This README file was created by OpenAI's language model, ChatGPT.

# Person 

This project contains a `Person` class and a static method `averageAgePerGender` that operates on a list of `Person` objects.

## Person Class
The `Person` class represents a person with a name, age, and gender. It contains a constructor that throws a `BadArgumentsException` if any of the following conditions are met:
- The name is empty
- The age is negative
- The gender is empty
- The gender is not "Male" or "Female"

## averageAgePerGender Method
The `averageAgePerGender` method calculates the average age for male and female persons in a list of `Person` objects. It returns an array of two double values, where the first value represents the average age of males and the second value represents the average age of females. If the list is null, the method returns `Double.NaN` for both values. If there are no males or no females in the list, the corresponding value will be `Double.NaN`.
