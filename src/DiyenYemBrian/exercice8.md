# Exercice 8:

On considère les définitions de classes suivantes:

```java
class A {
    void f(A o) {
        System.out.println("void f(A o) dans A");
    }
}

class B extends A {
    void f(A o) {
        System.out.println("void f(A o) dans B");
    }
}
```

Qu'affiche le fragment de programme suivant ?

```java
A a = new A();
A ab = new B();
B b = new B();

a.f(a);
a.f(ab);
a.f(b);
ab.f(a);
ab.f(ab);
ab.f(b);
b.f(a);
b.f(ab);
b.f(b);
```

## Solution

Pour comprendre ce programme, il faut distinguer:
- Le type statique (déclaré) de la variable, qui détermine quelle méthode est accessible en compilation
- Le type dynamique (réel) de l'objet, qui détermine quelle implémentation de la méthode est appelée à l'exécution

Analysons les variables:
- `a`: type statique `A`, type dynamique `A`
- `ab`: type statique `A`, type dynamique `B`
- `b`: type statique `B`, type dynamique `B`

Analysons maintenant chaque appel de méthode:

1. `a.f(a)`: 
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - **Affichage**: `void f(A o) dans A`

2. `a.f(ab)`: 
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - **Affichage**: `void f(A o) dans A`

3. `a.f(b)`: 
   - Type statique de `a` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `a` est `A`, donc exécution de `A.f(A)`
   - **Affichage**: `void f(A o) dans A`

4. `ab.f(a)`:
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

5. `ab.f(ab)`
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

6. `ab.f(b)`:
   - Type statique de `ab` est `A`, donc recherche de `f(A)` dans la classe `A`
   - Type dynamique de `ab` est `B`, donc exécution de `B.f(A)` (redéfinie dans `B`)
   - **Affichage**: `void f(A o) dans B`

7. `b.f(a)`:
   - Type statique de `b` est `B`, donc recherche de `f(A)` dans la classe `B`
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - **Affichage**: `void f(A o) dans B`

8. `b.f(ab)`:
   - Type statique de `b` est `B`, donc recherche de `f(A)` dans la classe `B`
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - **Affichage**: `void f(A o) dans B`

9. `b.f(b)`:
   - Type statique de `b` est `B`, donc recherche de `f(A)` dans la classe `B`
   - Type dynamique de `b` est `B`, donc exécution de `B.f(A)`
   - **Affichage**: `void f(A o) dans B`

Le résultat complet sera:
```
void f(A o) dans A
void f(A o) dans A
void f(A o) dans A
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
void f(A o) dans B
```
