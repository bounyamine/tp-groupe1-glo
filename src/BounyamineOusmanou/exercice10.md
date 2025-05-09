# Exercice 10: Ajout d'une autre méthode

On ajoute finalement à la classe A la méthode suivante:
```java
void f(B o) {
    System.out.println("void `f(B o)` dans `A`");
}
```
Est-ce une redéfinition ou une surcharge ? Qu'affiche alors le fragment de programme de l'exercice 8 ?

## Solution

### Redéfinition ou surcharge ?

Il s'agit d'une surcharge et non d'une redéfinition. Dans la classe A, nous avons maintenant deux méthodes avec le même nom mais des signatures différentes:
- `void f(A o)`
- `void f(B o)`

### Résultat du programme

Analysons à nouveau chaque appel:

1. `a.f(a)`:
   - Type statique de `a` est `A`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `A.f(A)`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - Affichage: `void f(A o) dans A`

2. `a.f(ab)`:
   - Type statique de `a` est `A`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `A.f(A)`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - Affichage: `void f(A o) dans A`

3. `a.f(b)`:
   - Type statique de `a` est `A`, type statique du paramètre est `B`
   - Résolution de la surcharge: appel à `A.f(B)` (plus spécifique)
   - Type dynamique de `a` est `A`, donc exécution de `A.f(B)`
   - Affichage: `void f(B o) dans A`

4. `ab.f(a)`:
   - Type statique de `ab` est `A`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `A.f(A)`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - Affichage: `void f(A o) dans B`

5. `ab.f(ab)`:
   - Type statique de `ab` est `A`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `A.f(A)`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans B)
   - Affichage: `void f(A o) dans B`

6. `ab.f(b)`:
   - Type statique de `ab` est `A`, type statique du paramètre est `B`
   - Résolution de la surcharge: appel à `A.f(B)` (plus spécifique)
   - Type dynamique de `ab` est `B`, mais `f(B)` n'est pas redéfinie dans `B`, donc exécution de `A.f(B)`
   - Affichage: `void f(B o) dans A`

7. `b.f(a)`:
   - Type statique de `b` est `B`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `B.f(A)`
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - Affichage: `void f(A o) dans B`

8. `b.f(ab)`:
   - Type statique de `b` est `B`, type statique du paramètre est `A`
   - Résolution de la surcharge: appel à `B.f(A)`
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - Affichage: `void f(A o) dans B`

9. `b.f(b)`:
   - Type statique de `b` est `B`, type statique du paramètre est `B`
   - Résolution de la surcharge: appel à B.f(B) (plus spécifique)
   - Type dynamique de `b` est `B`, donc exécution de `b`.f(B)
   - Affichage: `void f(B o) dans B`

Le résultat complet sera donc:
```java
void `f(A o)` dans `A`
void `f(A o)` dans `A`
void `f(B o)` dans `A`  // différence par rapport à l'exercice 8
void `f(A o)` dans `B`
void `f(A o)` dans `B`
void `f(B o)` dans `A`  // différence par rapport à l'exercice 8
void `f(A o)` dans `B`
void `f(A o)` dans `B`
void f(B o) dans B  // différence par rapport à l'exercice 8
```
Remarquez que les différences par rapport à l'exercice 8 concernent les appels où le paramètre est de type statique B.
