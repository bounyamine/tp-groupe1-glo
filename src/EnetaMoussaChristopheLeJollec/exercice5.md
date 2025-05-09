# Exercice 5:

Est-ce que la classe `Dessin` définie précédemment peut contenir des rectangles inclinés ? Est-ce que les méthodes `surface`, `contains` et `hull` de la classe `Dessin` fonctionnent encore correctement ?

## Solution

### Peut-on ajouter des rectangles inclinés dans un `Dessin` ?

Oui, la classe `Dessin` peut contenir des rectangles inclinés si elle manipule des objets de type `Rectangle`. Comme `SlantedRectangle` hérite de `Rectangle`, on peut ajouter des instances de `SlantedRectangle` dans un tableau de `Rectangle` (principe de substitution de Liskov).

On peut alors ajouter indifféremment des `Rectangle` et des `SlantedRectangle`:

```java
Dessin dessin = new Dessin(10);
dessin.add(new Rectangle(new Point(0, 0), 5, 3));
dessin.add(new SlantedRectangle(new Point(1, 1), 4, 2, Math.PI/4));
```

### Fonctionnement des méthodes

1. **Méthode `surface()`**:
   - Cette méthode fonctionne correctement car elle appelle la méthode `surface()` sur chaque rectangle du dessin.
   - Comme nous n'avons pas redéfini `surface()` dans `SlantedRectangle` (car la surface d'un rectangle ne change pas quand on le fait pivoter), le calcul reste correct.

2. **Méthode `contains()`**:
   - Si cette méthode teste si un point est à l'intérieur d'au moins un des rectangles du dessin, elle fonctionne correctement grâce au polymorphisme:

3. **Méthode `hull()`**:
   - Cette méthode pourrait ne pas fonctionner correctement car elle calcule le rectangle englobant de tous les rectangles du dessin.
   - Pour un rectangle incliné, son rectangle englobant (parallèle aux axes) est différent de lui-même.
   - La méthode utilise les coordonnées minimales et maximales des rectangles, elle ne prends pas en compte l'inclinaison.
