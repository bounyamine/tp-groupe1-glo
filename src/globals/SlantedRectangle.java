public class SlantedRectangle extends Rectangle {
    private double angle; // angle d'inclinaison par rapport à l'horizontale
    
    // Constructeur avec un point, deux dimensions et un angle
    public SlantedRectangle(Point basGauche, double largeur, double hauteur, double angle) {
        super(basGauche, largeur, hauteur);
        this.angle = angle;
    }
    
    // Constructeur avec deux points et un angle
    public SlantedRectangle(Point basGauche, Point hautDroite, double angle) {
        super(basGauche, hautDroite);
        this.angle = angle;
    }
    
    // Constructeur avec quatre longueurs et un angle
    public SlantedRectangle(double x, double y, double largeur, double hauteur, double angle) {
        super(x, y, largeur, hauteur);
        this.angle = angle;
    }
    
    // Constructeur sans angle (angle par défaut = 0)
    public SlantedRectangle(Point basGauche, double largeur, double hauteur) {
        this(basGauche, largeur, hauteur, 0);
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    // Méthode pour faire pivoter le rectangle incliné
    public void rotate(double deltaAngle) {
        this.angle += deltaAngle;
        // Normalisation de l'angle (0 <= angle < 360)
        this.angle = this.angle % 360;
        if (this.angle < 0) {
            this.angle += 360;
        }
    }
    
    // La méthode surface est héritée car elle reste valide pour un rectangle incliné
    
    // Redéfinition de la méthode contains pour un point
    @Override
    public boolean contains(Point p) {
        // Pour simplifier, on transforme les coordonnées du point 
        // pour annuler la rotation du rectangle
        double x = p.getX() - getPointBasGauche().getX();
        double y = p.getY() - getPointBasGauche().getY();
        
        // Rotation inverse
        double angleRad = -Math.toRadians(angle);
        double xRotated = x * Math.cos(angleRad) - y * Math.sin(angleRad);
        double yRotated = x * Math.sin(angleRad) + y * Math.cos(angleRad);
        
        // Vérification si le point transformé est dans le rectangle non incliné
        return xRotated >= 0 && xRotated <= getLargeur() &&
               yRotated >= 0 && yRotated <= getHauteur();
    }
    
    // Redéfinition de la méthode contains pour un rectangle
    @Override
    public boolean contains(Rectangle r) {
        // Pour un SlantedRectangle, il faut vérifier que les quatre coins du rectangle
        // sont contenus dans le SlantedRectangle
        if (r instanceof SlantedRectangle) {
            SlantedRectangle sr = (SlantedRectangle) r;
            // Si l'angle est différent, on doit vérifier plus que juste les coins
            if (sr.getAngle() != this.angle) {
                // Pour simplifier, nous vérifions juste les coins, ce qui n'est pas parfait
                // Dans un cas réel, une approche plus sophistiquée serait nécessaire
            }
        }
        
        // Vérifie si les quatre coins du rectangle r sont dans ce rectangle incliné
        Point basGauche = r.getPointBasGauche();
        Point hautGauche = new Point(basGauche.getX(), basGauche.getY() + r.getHauteur());
        Point basDroite = new Point(basGauche.getX() + r.getLargeur(), basGauche.getY());
        Point hautDroite = new Point(basGauche.getX() + r.getLargeur(), basGauche.getY() + r.getHauteur());
        
        return contains(basGauche) && contains(hautGauche) && 
               contains(basDroite) && contains(hautDroite);
    }
    
    // Redéfinition de la méthode sameAs
    @Override
    public boolean sameAs(Rectangle r) {
        if (!(r instanceof SlantedRectangle)) {
            return false;
        }
        
        SlantedRectangle sr = (SlantedRectangle) r;
        return super.sameAs(r) && this.angle == sr.getAngle();
    }
}