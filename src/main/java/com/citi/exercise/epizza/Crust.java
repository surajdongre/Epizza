package com.citi.exercise.epizza;

public enum Crust {

    NORMAL {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 5.0;
            else if (size.equals(Size.MEDIUM))
                return 5.0 * 1.25;
            else
                return 5.0 * 1.5;
        }
    },
    PAN {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 6.0;
            else if (size.equals(Size.MEDIUM))
                return 6.0 * 1.25;
            else
                return 6.0 * 1.5;
        }
    },
    THIN {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 6.0;
            else if (size.equals(Size.MEDIUM))
                return 6.0 * 1.25;
            else
                return 6.0 * 1.5;
        }
    },
    CHEESY_BITES {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 7.0;
            else if (size.equals(Size.MEDIUM))
                return 7.0 * 1.25;
            else
                return 7.0 * 1.5;
        }
    };

    public abstract double getCost(Size size);

}