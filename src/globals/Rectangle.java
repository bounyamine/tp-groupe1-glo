public class Rectangle {
    private Point basGauche;
    private double largeur;
    private double hauteur;
    private static int nbr = 0;

    // Constructeur avec 2 points (bas-gauche et haut-droite)
    public Rectangle(Point basGauche, Point hautDroite) {
        this.basGauche = basGauche;
        this.largeur = hautDroite.getAbs() - basGauche.getAbs();
        this.hauteur = hautDroite.getOrd() - basGauche.getOrd();
        nbr++;
    }

    // Constructeur avec 1 point et 2 longueurs
    public Rectangle(Point basGauche, double larg, double haut) {
        this.basGauche = basGauche;
        this.largeur = larg;
        this.hauteur = haut;
        nbr++;
    }

    // Constructeur avec 4 longueurs (coordonnées x, y du point bas-gauche, largeur,
    // hauteur)
    public Rectangle(double x, double y, double larg, double haut) {
        this.basGauche = new Point(x, y);
        this.largeur = larg;
        this.hauteur = haut;
        nbr++;
    }

    // Getters et setters
    public Point getBasGauche() {
        return basGauche;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public static int getNbr() {
        return nbr;
    }

    // Méthode pour calculer la surface du rectangle
    public double surface() {
        return largeur * hauteur;
    }

    // Méthode pour déplacer le rectangle
    public void translate(double dx, double dy) {
        basGauche.setAbs(basGauche.getAbs() + dx);
        basGauche.setOrd(basGauche.getOrd() + dy);
    }

    // Méthode qui teste si un point est à l'intérieur du rectangle
    public boolean contains(Point p) {
        double x = p.getAbs();
        double y = p.getOrd();
        return x >= basGauche.getAbs() && x <= (basGauche.getAbs() + largeur) &&
                y >= basGauche.getOrd() && y <= (basGauche.getOrd() + hauteur);
    }

    // Méthode qui teste si un rectangle est à l'intérieur du rectangle
    public boolean contains(Rectangle r) {
        // Vérifie si les coins inférieur gauche et supérieur droite du rectangle r sont dans ce rectangle
        Point pointBasGauche = r.getBasGauche();
        Point pointHautDroite = new Point(pointBasGauche.getAbs() + r.getLargeur(), pointBasGauche.getOrd() + r.getHauteur());

        return this.contains(pointBasGauche) && this.contains(pointHautDroite);
    }

    // Méthode qui teste l'égalité de deux rectangles
    public boolean sameAs(Rectangle r) {
        return basGauche.getAbs() == r.getBasGauche().getAbs() &&
                basGauche.getOrd() == r.getBasGauche().getOrd() &&
                this.largeur == r.getLargeur() &&
                this.hauteur == r.getHauteur();
    }

    // Méthode qui calcule le rectangle englobant d'un ensemble de rectangles
    public static Rectangle hull(Rectangle[] rectangles) {
        if (rectangles.length == 0) {
            return null;
        }

        // Initialisation avec les valeurs du premier rectangle
        double minX = rectangles[0].getBasGauche().getAbs();
        double minY = rectangles[0].getBasGauche().getOrd();
        double maxX = minX + rectangles[0].getLargeur();
        double maxY = minY + rectangles[0].getHauteur();

        // Recherche des coordonnées du rectangle englobant
        for (int i = 1; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            double x = r.getBasGauche().getAbs();
            double y = r.getBasGauche().getOrd();

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x + r.getLargeur());
            maxY = Math.max(maxY, y + r.getHauteur());
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

}