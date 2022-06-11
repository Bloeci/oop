package mendels_land;

/**
 * Butterfly class with their corresponding attributes.
 */
public class Butterfly {
    private String pattern;
    private String wingColor;
    private String wingShape;

    /**
     * Constructor of a new butterfly with his specific attributes
     * pattern, wing color and wing shape. The attributes cannot be
     * changed during the existence of the butterfly.
     * @param pattern   String of the butterfly pattern
     * @param wingColor String of the butterfly wing color
     * @param wingShape String of the butterfly wing shape
     */
    public Butterfly (String pattern, String wingColor, String wingShape){
        this.pattern = pattern;
        this.wingColor = wingColor;
        this.wingShape = wingShape;
    }

    /**
     * Getter for the butterfly pattern.
     * @return pattern  String of the butterfly pattern
     */
    public String getPattern(){
        return this.pattern;
    }

    /**
     * Getter for the butterfly wing color.
     * @return wingColor  String of the butterfly wing color
     */
    public String getWingColor(){
        return this.wingColor;
    }

    /**
     * Getter for the butterfly wing shape.
     * @return wingShape  String of the butterfly wing shape.
     */
    public String getWingShape(){
        return this.wingShape;
    }

    /**
     * Generate a string containing the attributes of the butterfly as name.
     * @return butterfly name
     */
    @Override
    public String toString(){
        return getPattern() + ", " + getWingColor() + ", " + getWingShape();
    }

    /**
     * Method to compare two butterflies by their attributes. Only returns
     * true of all attributes are equal.
     * @param butterfly comparing butterfly
     * @return  boolean
     */
    public boolean equals(Butterfly butterfly){
        return this.toString().equals(butterfly.toString());
    }
}
