package org.example.appliance;

public class Appliance  {

    private String name;
    private double power;
    private boolean pluggedIn;

    public Appliance(String name, double power) {
        this.name = name;
        this.power = power;
        this.pluggedIn = false;
    }

    public Appliance() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public void plugIn() {
        if (!pluggedIn) {
            pluggedIn = true;
            System.out.println(name + "\u001B[32m увімкнено \u001B[0m");
        } else {
            System.out.println(name + " вже ввімкнено.");
        }
    }

    public void plugOut() {
        if (pluggedIn) {
            pluggedIn = false;
            System.out.println(name + " вимкнено.");
        } else {
            System.out.println(name + " вже вимкнено.");
        }
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
