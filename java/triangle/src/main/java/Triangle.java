public class Triangle {

    private final double x;
    private final double y;
    private final double z;

    public Triangle(final double x, final double y, final double z) throws TriangleException {
        if (isSumOfTwoSidesLessThanOrEqualToThirdSide(x, y, z)
                || isSumOfTwoSidesLessThanOrEqualToThirdSide(z, y, x)
                || isSumOfTwoSidesLessThanOrEqualToThirdSide(z,x, y))
            throw new TriangleException();

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public TriangleKind getKind() {
        if (isEquilateral())
            return TriangleKind.EQUILATERAL;
        else if (isIsosceles())
            return TriangleKind.ISOSCELES;
        else
            return TriangleKind.SCALENE;
    }

    private boolean isSumOfTwoSidesLessThanOrEqualToThirdSide(double firstSide, double secondSide, double thirdSide) {
        return firstSide + secondSide <= thirdSide;
    }

    private boolean isEquilateral() {
        return x == y && y == z;
    }

    private boolean isIsosceles() {
        return x == y || x == z || y == z;
    }
}
