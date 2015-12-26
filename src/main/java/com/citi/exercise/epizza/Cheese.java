package com.citi.exercise.epizza;

public enum Cheese {

    MOZZARELLA {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 0.5;
            else if (size.equals(Size.MEDIUM))
                return 1.0;
            else
                return 1.5;
        }
    },
    CREAM {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 0.5;
            else if (size.equals(Size.MEDIUM))
                return 1.0;
            else
                return 1.5;
        }
    };

    public abstract double getCost(Size size);
}