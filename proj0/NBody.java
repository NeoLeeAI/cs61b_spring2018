public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        int N = in.readInt();
		double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] planets = new Planet[N];
        for(int i = 0; i < N; i++) {
            double xP = in.readDouble();
            double yp = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet planet = new Planet(xP, yp, xV, yV, m, img);
            planets[i] = planet;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet planet : planets) {
            StdDraw.picture(planet.xxPos, planet.yyPos, "images/"+planet.imgFileName);
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while(time < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                StdDraw.picture(planet.xxPos, planet.yyPos, "images/"+planet.imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
