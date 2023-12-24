public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11; /*the gravitational constant */

    public Planet(double xP, double yP, double xV,double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        /*Compute the distance between supplied planet and the planet */
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        /*Compute the force between supplied planet and the planet */
        double f = (G * mass * p.mass) / (calcDistance(p) * calcDistance(p));
        return f;
    }

    public double calcForceExertedByX(Planet p) {
        /*Compute the force between supplied planet and the planet in x-axis */
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        /*Compute the force between supplied planet and the planet in y-axis */
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] Planets) {
        /*Compute the sum force of the planet in x-axis */
        double xNetForce = 0;
        for (Planet pl: Planets) {
            if (!this.equals(pl))
                xNetForce += calcForceExertedByX(pl);
        }
        return xNetForce;
    }

    public double calcNetForceExertedByY(Planet[] Planets) {
        /*Compute the sum force of the planet in y-axis */
        double yNetForce = 0;
        for (Planet pl : Planets) {
            if (!this.equals(pl))
                yNetForce += calcForceExertedByY(pl);
        }
        return yNetForce;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
}