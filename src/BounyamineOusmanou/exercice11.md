# Exercice 11: Opérateur instanceof

Qu'affiche le fragment de programme suivant ?
```java
System.out.println(a instanceof A);
System.out.println(ab instanceof A);
System.out.println(b instanceof A);
System.out.println(a instanceof B);
System.out.println(ab instanceof B);
System.out.println(b instanceof B);
```

## Solution

L'opérateur `instanceof` évalue si l'objet (à gauche) est une instance de la classe (à droite) ou d'une de ses sous-classes.

1. ``a instanceof A``:
   - `a` est une instance de la classe `A`
   - Résultat: ``true``

2. ``ab instanceof A``:
   - ``ab`` est une instance de la classe ``B`` qui est une sous-classe de ``A``
   - Résultat: ``true``

3. ``b instanceof A``:
   - ``b`` est une instance de la classe ``B`` qui est une sous-classe de ``A``
   - Résultat: ``true``

4. ``a instanceof B``:
   - ``a`` est une instance de la classe ``A`` qui n'est pas une sous-classe de ``B``
   - Résultat: ``false``

5. ``ab instanceof B``:
   - ``ab`` est une instance de la classe ``B``
   - Résultat: ``true``

6. ``b instanceof B``:
   - ``b`` est une instance de la classe ``B``
   - Résultat: ``true``

Le résultat complet sera donc:
```java
true
true
true
false
true
true
```