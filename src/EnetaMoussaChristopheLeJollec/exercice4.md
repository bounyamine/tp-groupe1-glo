# Exercice 4:

Pour chacun des appels de méthode ci-dessous, dire s'il va être compilé correctement et, auquel cas, quelle méthode est appelée effectivement à l'exécution:

```java
Point p = new Point(1,2);
Rectangle r = new Rectangle(p, 2, 3);
Rectangle t = new SlantedRectangle(p, 2, 3);
SlantedRectangle s = new SlantedRectangle(p, 2, 3);

System.out.println(r.surface());
r.rotate(2);
System.out.println(r.contains(p));
System.out.println(t.surface());
t.rotate(2);
System.out.println(t.contains(p));
System.out.println(s.surface());
s.rotate(2);
System.out.println(s.contains(p));
```

## Solution

1. `System.out.println(r.surface());`
   - **Compilation**: Correcte
   - **Exécution**: Appel de la méthode `surface()` de la classe `Rectangle`

2. `r.rotate(2);`
   - **Compilation**: Erreur de compilation
   - La méthode `rotate()` n'existe pas dans la classe `Rectangle`

3. `System.out.println(r.contains(p));`
   - **Compilation**: Correcte
   - **Exécution**: Appel de la méthode `contains(Point)` de la classe `Rectangle`

4. `System.out.println(t.surface());`
   - **Compilation**: Correcte
   - **Exécution**: Si `surface()` est redéfinie dans `SlantedRectangle`, alors c'est cette méthode qui est appelée. Sinon, c'est la méthode héritée de `Rectangle`.
   - Dans notre cas, comme nous n'avons pas redéfini `surface()`, c'est la méthode de `Rectangle` qui est appelée.

5. `t.rotate(2);`
   - **Compilation**: Erreur de compilation
   - La variable `t` est de type `Rectangle`, qui ne possède pas la méthode `rotate()`
   - Le type statique (déclaré) de `t` est `Rectangle`, donc le compilateur vérifie si cette méthode existe dans la classe `Rectangle`

6. `System.out.println(t.contains(p));`
   - **Compilation**: Correcte
   - **Exécution**: Appel de la méthode `contains(Point)` de `SlantedRectangle`
   - Bien que le type statique de `t` soit `Rectangle`, son type dynamique est `SlantedRectangle`, donc c'est la méthode redéfinie qui est appelée (polymorphisme)

7. `System.out.println(s.surface());`
   - **Compilation**: Correcte
   - **Exécution**: Si `surface()` est redéfinie dans `SlantedRectangle`, alors c'est cette méthode qui est appelée. Sinon, c'est la méthode héritée de `Rectangle`.
   - Dans notre cas, comme nous n'avons pas redéfini `surface()`, c'est la méthode de `Rectangle` qui est appelée.

8. `s.rotate(2);`
   - **Compilation**: Correcte
   - **Exécution**: Appel de la méthode `rotate()` de `SlantedRectangle`
   - Le type statique et dynamique de `s` est `SlantedRectangle`

9. `System.out.println(s.contains(p));`
   - **Compilation**: Correcte
   - **Exécution**: Appel de la méthode `contains(Point)` de `SlantedRectangle`
   - Le type statique et dynamique de `s` est `SlantedRectangle`
