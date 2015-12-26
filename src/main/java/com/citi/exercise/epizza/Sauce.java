package com.citi.exercise.epizza;

public enum Sauce {

    MARGARITA {
        public double getCost() {
            return 0;
        }
    },
    MEXICAN_SALSA {
        public double getCost() {
            return 0;
        }
    };
    
    public abstract double getCost();
}