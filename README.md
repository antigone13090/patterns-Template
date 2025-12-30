# Pattern Template Method (Head First Design Patterns)

Implémentation Java/Gradle du pattern **Template Method** (Tea/Coffee + Hook).

## Objectif
Définir le **squelette** d’un algorithme dans une super-classe et laisser certaines étapes aux sous-classes, sans changer l’ordre global.

## Structure
- `src/main/java/headfirst/designpatterns/templatemethod/`
  - `CaffeineBeverage` : méthode template `prepareRecipe()`
  - `Tea`, `Coffee` : implémentations des étapes variables
  - `CoffeeWithHook` : hook (condiments optionnels)
  - `BeverageTestDrive` : démo

## Lancer
Java 17 requis.

```bash
./gradlew run

### 3) Créer le dossier docs
```bash
mkdir -p docs
cat > docs/TEMPLATEMETHOD.md <<'EOF'
# Template Method — explication détaillée (FR)

## Intention
Le pattern **Template Method** définit la structure d’un algorithme dans une classe abstraite et délègue certaines étapes aux sous-classes.

## Problème résolu
Quand plusieurs classes suivent le **même scénario** (mêmes étapes dans le même ordre) mais avec des variations, on évite la duplication.

## Rôles des classes
- **`CaffeineBeverage`** : contient `prepareRecipe()` (ordre imposé)
  - étapes communes : `boilWater()`, `pourInCup()`
  - étapes variables : `brew()`, `addCondiments()`
  - hook : `customerWantsCondiments()`
- **`Tea` / `Coffee`** : implémentent les étapes variables
- **`CoffeeWithHook`** : rend l’ajout de condiments optionnel
- **`BeverageTestDrive`** : exécute les scénarios

## Flux d’exécution
Client → `prepareRecipe()` → étapes communes → étape(s) abstraite(s) (polymorphisme) → hook optionnel.

## Pièges
- Ne pas casser l’ordre : template potentiellement `final`.
- Hook : attention aux entrées bloquantes en non-interactif (CI/Gradle).
