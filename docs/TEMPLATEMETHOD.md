# Template Method (Head First)

## Intent
Define the **skeleton of an algorithm** in a method, deferring some steps to subclasses.

## In this project
- `CaffeineBeverage.prepareRecipe()` is the template method.
- `brew()` and `addCondiments()` are primitive operations (subclasses implement them).
- `customerWantsCondiments()` is a hook.

## Run
```bash
./gradlew run
```
If the Gradle wrapper isn’t present, copy `gradlew`, `gradlew.bat`, and the `gradle/` folder from an existing project (e.g. Strategy), then run again.
