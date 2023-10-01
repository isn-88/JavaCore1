package core.two.lesson5.task2.body;

import java.util.Arrays;


public class Planet extends SpaceBody implements Orbital {

  private final double orbitalRadius;
  private final boolean isLife;
  private final Satellite[] satellites;


  public Planet(String name,
                int diameter,
                double weight,
                double orbitalRadius,
                boolean isLife,
                Satellite[] satellites) {
    super(name, diameter, weight);
    this.orbitalRadius = orbitalRadius;
    this.isLife = isLife;
    this.satellites = satellites;
  }

  public Planet(String name,
                int diameter,
                double weight,
                double orbitalRadius,
                boolean isLife) {
    this(name, diameter, weight, orbitalRadius, isLife, new Satellite[0]);
  }

  @Override
  public double getOrbitalRadius() {
    return orbitalRadius;
  }

  public boolean isLife() {
    return isLife;
  }

  public Satellite[] getSatellites() {
    return Arrays.copyOf(satellites, satellites.length);
  }

  @Override
  public String toString() {
    return "Planet{" +
           "name=" + getName() +
           ", diameter=" + getDiameter() +
           ", isLife=" + isLife +
           ", satellites=" + Arrays.toString(satellites) +
           '}';
  }
}
