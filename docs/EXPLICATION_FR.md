# Pattern Template Method — Explication détaillée (FR)

## 1) Intention
Définir le **squelette** d’un algorithme dans une classe mère, en laissant certaines étapes
aux classes filles.

Objectif : **factoriser** la structure commune et n’autoriser la variation que sur des points précis.

---

## 2) Problème typique
Tu as plusieurs recettes proches :
- elles suivent toujours les mêmes grandes étapes
- seules certaines étapes changent (ex: infuser vs filtrer, condiments, etc.)

Sans Template Method :
- duplication
- incohérences (on oublie une étape dans une variante)
- maintenance pénible (changer l’ordre d’étapes partout)

---

## 3) Principe
Une classe abstraite (ou mère) contient :
- une méthode **template** (souvent `final`) : l’algorithme complet, dans l’ordre
- des méthodes “étapes” :
  - certaines communes (déjà implémentées)
  - certaines abstraites (à implémenter)
  - parfois un **hook** (méthode optionnelle que les enfants peuvent surcharger)

---

## 4) Dans ce projet (CaffeineBeverage)
Classes clés :
- `CaffeineBeverage` : définit `prepareRecipe()` (template method)
- `Tea` : implémente les étapes spécifiques au thé
- `Coffee` : implémente les étapes spécifiques au café
- `CoffeeWithHook` : utilise un hook pour demander (optionnellement) les condiments
- `BeverageTestDrive` : `main` qui exécute plusieurs préparations

---

## 5) Déroulé du run
Point d’entrée : `BeverageTestDrive`

Scénario :
1) préparation du thé
2) préparation du café
3) préparation du café “avec hook”

Dans ton correctif, `CoffeeWithHook` est **safe en non-interactif** :
- s’il n’y a pas d’entrée standard (Gradle/IDE), il choisit “non” par défaut
- en interactif tu peux encore tester via un pipe.

---

## 6) Avantages
- grosse réduction de duplication
- ordre des étapes garanti (algorithme centralisé)
- variations contrôlées (points d’extension explicites)
- hooks = extension légère sans imposer une implémentation

---

## 7) Inconvénients
- dépendance à l’héritage (moins flexible que la composition dans certains cas)
- si trop d’étapes variables → hiérarchie lourde

---

## 8) Erreurs classiques
- template method modifiable alors qu’elle devrait être stable (oubli de `final`)
- étapes trop fines → “framework maison” illisible
- hook utilisé comme “porte arrière” pour casser l’ordre

---

## 9) Liens avec d’autres patterns
- **Strategy** : variation d’algorithmes par composition (souvent plus flexible)
- **Factory Method** : peut être utilisé à l’intérieur d’une template method
- **State** : comportement variant selon état ; Template = structure stable, variations ponctuelles
