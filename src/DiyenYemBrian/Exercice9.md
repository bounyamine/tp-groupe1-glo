# Exercice 9:

On ajoute maintenant à la classe B la méthode suivante:
```java
void f(B o) {
    System.out.println("void f(B o) dans B");
}
```

Est-ce une redéfinition ou une surcharge ? Qu'affiche alors le fragment de programme de l'exercice 8 ?

## Solution

### Redéfinition ou surcharge ?

Il s'agit d'une surcharge et non d'une redéfinition. Une surcharge consiste à définir plusieurs méthodes avec le même nom mais des signatures différentes (paramètres différents) dans la même classe.

Une redéfinition (override) implique qu'une méthode de la classe enfant remplace une méthode de la classe parente avec exactement la même signature.

Ici, void f(B o) dans la classe B est une surcharge de void f(A o) qui existe déjà dans la classe B, car les signatures sont différentes (le type du paramètre change).

### Résultat du programme

Analysons à nouveau chaque appel:

1. `a.f(a)`:
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - **Affichage**: `void f(A o) dans A`

2. `a.f(ab)`:
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de A.f(A)
   - **Affichage**: `void f(A o) dans A`

3. `a.f(b)`:
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de A.f(A)
   - **Affichage**: `void f(A o) dans A`

4. `ab.f(a)`:
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

5. `ab.f(ab)`:
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

6. `ab.f(b)`:
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

7. `b.f(a)`:
   -  Type statique de `b` est `B`, donc recherche de f(A) dans la classe B
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - **Affichage**: `void f(A o) dans B`

8. `b.f(ab)`:
   - Type statique de b est B, donc recherche de `f(A)` dans la classe `B`
   - Type dynamique de b est B, donc exécution de `B.f(A)`
   - **Affichage**: `void f(A o) dans B`

9. b.f(b):
   - Type statique de b est B, donc recherche de f(B) dans la classe B (la résolution de la surcharge se fait à la compilation)
   - Type dynamique de b est B, donc exécution de B.f(B)
   - Affichage: void f(B o) dans B

Le résultat complet sera donc:
```java
void f(A o) dans A
void f(A o) dans A
void f(A o) dans A
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(B o) dans B  // seule différence par rapport à l'exercice 8
```