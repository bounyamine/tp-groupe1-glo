# Exercice 1:
## La classe SlantedRectangle

```java
public class SlantedRectangle extends Rectangle {
    private double angle; // Angle d'inclinaison en radians

    public SlantedRectangle (Point origin, int width, int height, double angle) {
        super(origin, width, height);
        this.angle = angle;
    }

    // Constructeur avec angle par défaut (0)
    public SlantedRectangle(Point origin, int width, int height) {
        this(origin, width, height, 0);
    }
}
```
