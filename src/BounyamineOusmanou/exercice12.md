# Exercice 12:

Dans la classe Rectangle a été définie une méthode boolean contains(Rectangle). Cette méthode doit-elle être redéfinie dans la classe SlantedRectangle ? Quels cas ne sont pas couverts par cette redéfinition ?

On ajoute alors une méthode boolean contains(SlantedRectangle) dans les classes Rectangle et SlantedRectangle. Quels cas ne sont toujours pas couverts par ces ajouts ?

## Solution

### Redéfinition de contains(Rectangle) dans SlantedRectangle

Oui, la méthode boolean contains(Rectangle) doit être redéfinie dans la classe SlantedRectangle car le comportement est différent quand un rectangle incliné contient un autre rectangle.

Dans la classe Rectangle, la méthode vérifie simplement si les coordonnées des coins inférieur gauche et supérieur droite du rectangle r sont dans le rectangle courant.

Dans SlantedRectangle, cette logique ne fonctionne plus directement. Il faut soit:
- Transformer les coordonnées du rectangle passé en paramètre par une rotation inverse
- Vérifier si chaque coin du rectangle passé en paramètre est à l'intérieur du rectangle incliné

Voici ce qu'on propose:
```java
@Override
public boolean contains(Rectangle r) {
    if (r instanceof SlantedRectangle) {
        SlantedRectangle sr = (SlantedRectangle) r;
        
        // Si les angles sont différents, c'est plus complexe
        if (this.angle != sr.angle) {
            // Pour simplifier, on peut vérifier les quatre coins du rectangle après les avoir transformés selon l'angle
            Point[] corners = new Point[4];
            corners[0] = rotatePoint(sr.getHautGauche(), this.angle);
            corners[1] = rotatePoint(sr.getHautDroite(), this.angle);
            corners[2] = rotatePoint(sr.getBasDroite(), this.angle);
            corners[3] = rotatePoint(sr.getBasGauche(), this.angle);
            for (Point corner : corners) {
                if (!super.contains(corner)) {
                    return false;
                }
            }
            return true;
        } else {
            // Si les angles sont identiques, on peut utiliser la méthode de la classe parent après avoir fait une rotation inverse
            Rectangle rotatedR = new Rectangle(rotatePoint(sr.getHautGauche(), -this.angle), rotatePoint(sr.getBasDroite(), -this.angle));
            return super.contains(rotatedR);
        }
    } else {
        // Vérifier si chaque coin du rectangle r est contenu dans ce rectangle
        // En pratique, il faudrait transformer les coordonnées des coins
        Point[] corners = new Point[4];
        corners[0] = rotatePoint(r.getHautGauche(), this.angle);
        corners[1] = rotatePoint(r.getHautDroite(), this.angle);
        corners[2] = rotatePoint(r.getBasDroite(), this.angle);
        corners[3] = rotatePoint(r.getBasGauche(), this.angle);
        for (Point corner : corners) {
            if (!super.contains(corner)) {
                return false;
            }
        }
        return true;
    }
}
```
### Cas non couverts par cette redéfinition

Même avec la redéfinition de contains(Rectangle) dans SlantedRectangle, certains cas ne sont pas couverts:

1. Le cas où un rectangle incliné contient un autre rectangle incliné:
   - La méthode contains(Rectangle) ne peut pas traiter correctement ce cas car le paramètre est de type Rectangle.
   - Si on passe un SlantedRectangle à cette méthode, l'information sur l'angle d'inclinaison du paramètre sera perdue à cause du polymorphisme de paramètre.

2. Vérification des formes non rectangulaires à l'intérieur:
   - Vérifier si un rectangle incliné contient un rectangle non-incliné (parallèle aux axes) est plus complexe qu'une simple vérification de coins.
   - Un rectangle incliné peut contenir un rectangle parallèle aux axes même si certains coins du rectangle incliné sont en dehors du rectangle parallèle aux axes.

### Ajout de contains(SlantedRectangle)

L'ajout d'une méthode boolean contains(SlantedRectangle) dans les classes Rectangle et SlantedRectangle permet de traiter correctement le cas où le rectangle à tester est incliné.

### Cas toujours non couverts

Même avec ces ajouts, certains cas ne sont toujours pas couverts:

1. Nouveaux types de rectangles:
   - Si on ajoute une nouvelle sous-classe de Rectangle, par exemple ColoredRectangle, les méthodes existantes ne pourront pas traiter correctement les objets de cette classe.
   - Il faudrait ajouter des méthodes contains(ColoredRectangle) dans toutes les classes existantes.

2. Types plus génériques:
    - Si on introduit une interface ou une classe abstraite plus générique, comme Shape, pour représenter différentes formes géométriques, les méthodes existantes ne pourront pas traiter correctement les objets de ce type.
    - Il faudrait ajouter des méthodes contains(Shape) dans toutes les classes existantes.

3. Double dispatch:
   - Le problème fondamental est que Java utilise le type statique (déclaré) du paramètre pour déterminer quelle méthode appeler, mais pour les opérations comme contains, on a besoin de connaître à la fois le type de l'objet récepteur et le type du paramètre.
   - Pour résoudre ce problème de manière élégante, il faudrait utiliser le pattern "double dispatch" ou le pattern "visitor".
