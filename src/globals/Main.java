public class Main {
    public static void main(String[] args) {
        // Création des points
        Point p1 = new Point(3, 3);
        Point p2 = new Point(6, 5);

        // Création des rectangles
        Rectangle r1 = new Rectangle(p1, p2);
        Rectangle r2 = new Rectangle(new Point(7, 1), 2, 1);
        Rectangle r3 = new Rectangle(2, 1, 3, 3);

        // Test de la méthode surface
        System.out.println("Surface de r1 : " + r1.surface());
        System.out.println("Surface de r2 : " + r2.surface());
        System.out.println("Surface de r3 : " + r3.surface());

        // Test de la méthode translate
        r1.translate(1, 1);
        System.out.println("Nouveau point bas-gauche de r1 : (" + r1.getBasGauche().getAbs() + ", " + r1.getBasGauche().getOrd() + ")");

        // Test de la méthode contains
        Point p = new Point(7, 5);
        System.out.println("Le point (" + p.getAbs() + ", " + p.getOrd() + ") est-il dans r1 ? " + (r1.contains(p) ? "Oui" : "Non"));

        // Test de la méthode contains avec un rectangle
        System.out.println("Le rectangle r2 est-il dans r1 ? " + (r1.contains(r2) ? "Oui" : "Non"));

        // Test de la méthode sameAs
        Rectangle r4 = new Rectangle(new Point(1, 1), new Point(5, 5));
        System.out.println("Les rectangles r1 et r4 sont-ils identiques ? " + (r1.sameAs(r4) ? "Oui" : "Non"));

        // Test de la méthode hull
        Rectangle[] rectangles = { r1, r2, r3 };
        Rectangle hull = Rectangle.hull(rectangles);
        System.out.println("Rectangle englobant : Origine=(" + hull.getBasGauche().getAbs() + ", " + hull.getBasGauche().getOrd() + ")" + " largeur=" + hull.getLargeur() + " et hauteur" + hull.getHauteur());
    }
}