package io.github.ekardnam.sertraline.data;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

public abstract class AbstractVector implements Iterable<Double> {

    public abstract int getDimension();

    public abstract double get(int i);

    public abstract AbstractVector add(AbstractVector other);

    public abstract AbstractVector subtract(AbstractVector other);

    public abstract AbstractVector multiply(double scalar);

    public abstract AbstractVector divide(double scalar);

    public abstract AbstractVector multiplyOneToOne(AbstractVector other);

    public abstract double dot(AbstractVector other);

    public abstract AbstractVector copy();

    public abstract AbstractMatrix matrixify(int rows);

    public abstract AbstractVector map(Function<Double, Double> map);

    public double square() {
        return dot(copy());
    }

    public double length() {
        return Math.sqrt(square());
    }

    public boolean hasEqualDimension(AbstractVector other) {
        return getDimension() == other.getDimension();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AbstractVector)) return false;
        AbstractVector other = (AbstractVector) object;
        if (hasEqualDimension(other)) return false;
        for (int i = 0; i < getDimension(); i++) if (get(i) != other.get(i)) return false;
        return true;
    }

    //TODO("Check this thing here")
    @Override
    public int hashCode() {
        return Double.hashCode(dot(new Vector(getDimension(), v -> (double) 1)));
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getDimension();
            }

            @Override
            public Double next() {
                index++;
                return get(index - 1);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (double d : this) {
            sb.append(d + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(")");
        return sb.toString();
    }

}
