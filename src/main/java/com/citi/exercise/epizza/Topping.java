package com.citi.exercise.epizza;

public enum Topping {
    CAPSICUM {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    },
    ONION {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    },
    TOMATO {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    },
    PINEAPPLE {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    },
    OLIVE {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    },
    JALAPENO {
        public double getCost(Size size) {
            if (size.equals(Size.SMALL))
                return 1.0;
            else if (size.equals(Size.MEDIUM))
                return 1.5;
            else
                return 2.0;
        }
    };
    public abstract double getCost(Size size);
}