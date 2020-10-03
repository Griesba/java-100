package com.letevil.mastermind;

import java.util.HashMap;
import java.util.Map;

public class ColorManager {
    final protected int nrColors;
    final protected Map<Color, Color> successor = new HashMap<Color, Color>();
    private Color first;

    public ColorManager(int nbColors) {
        this.nrColors = nbColors;
    }

    protected Color newColor(){
        return new Color();
    }

    private Color[] createColors() {
        Color[] colors = new Color[nrColors];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = newColor();
        }
        return colors;
    }

    private void createOrdering() {
        Color[] colors = createColors();
        first = colors[0];
        for (int i = 0; i < nrColors - 1; i++) {
            successor.put(colors[i], colors[i + 1]);
        }
    }

    public Color firstColor() {
        return first;
    }

    boolean thereIsNextColor(Color color) {
        return successor.containsKey(color);
    }

    public Color nextColor(Color color) {
        return successor.get(color);
    }

    public int getNbColors() {
        return nrColors;
    }

    public Map<Color, Color> getSuccessor() {
        return successor;
    }

    public Color getFirst() {
        return first;
    }

    public void setFirst(Color first) {
        this.first = first;
    }
}
