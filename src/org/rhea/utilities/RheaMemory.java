package org.rhea.utilities;

import java.util.*;

/**
 * Stores values in an array and supplies easy conversion methods.
 */
public class RheaMemory {
    private Map<Integer, Double> internal;

    /**
     * Creates a new instance of {@link RheaMemory this} class.
     */
    public RheaMemory() {
        internal = new HashMap<>();
    }

    /**
     * Get a value as an <i>int</i>.
     * @param index The index of the value.
     * @return The value as an <i>int</i>.
     */
    public int getInt(int index) {
        return internal.get(index).intValue();
    }

    /**
     * Get a value as a <i>char</i>.
     * @param index The index of the value.
     * @return The value as a <i>char</i>.
     * @implNote The <i>char</i> returned is <b>UTF-8</b> only.
     */
    public char getChar(int index) {
        return Character.toChars(internal.get(index).intValue())[0];
    }

    /**
     * Get a value as a <i>long</i>.
     * @param index The index of the value.
     * @return The value as a <i>long</i>.
     */
    public long getLong(int index) {
        return internal.get(index).longValue();
    }

    /**
     * Get a value as a <i>float</i>.
     * @param index The index of the value.
     * @return The value as a <i>float</i>.
     */
    public float getFloat(int index) {
        return internal.get(index).floatValue();
    }

    /**
     * Get a value as a <i>short</i>.
     * @param index The index of the value.
     * @return The value as a <i>short</i>.
     */
    public short getShort(int index) {
        return internal.get(index).shortValue();
    }

    /**
     * Get a value as a <i>double</i>.
     * @param index The index of the value.
     * @return The value as a <i>double</i>.
     */
    public double getDouble(int index) {
        return internal.get(index);
    }

    /**
     * Set a value as an <i>int</i>.
     * @param index The index of the value.
     * @param value The value as an <i>int</i>.
     */
    public void setInt(int index, int value) {
        internal.put(index, (double) value);
    }

    /**
     * Set a value as a <i>char</i>.
     * @param index The index of the value.
     * @param value The value as a <i>char</i>.
     */
    public void setChar(int index, char value) {
        internal.put(index, (double) value);
    }

    /**
     * Set a value as a <i>long</i>.
     * @param index The index of the value.
     * @param value The value as a <i>long</i>.
     */
    public void setLong(int index, long value) {
        internal.put(index, (double) value);
    }

    /**
     * Set a value as a <i>float</i>.
     * @param index The index of the value.
     * @param value The value as a <i>float</i>.
     */
    public void setFloat(int index, float value) {
        internal.put(index, (double) value);
    }

    /**
     * Set a value as a <i>short</i>.
     * @param index The index of the value.
     * @param value The value as a <i>short</i></i>.
     */
    public void setShort(int index, short value) {
        internal.put(index, (double) value);
    }

    /**
     * Set a value as a <i>double</i>.
     * @param index The index of the value.
     * @param value The value as a <i>double</i></i>.
     */
    public void setDouble(int index, double value) {
        internal.put(index, value);
    }

    /**
     * Remove a value.
     * @param index The index of the value.
     */
    public void remove(int index) {
        internal.remove(index);
    }
}
