package org.rhea.structure;

/**
 * Stores the data of an argument.
 * @param type The type.
 * @param arg The value.
 */
public record RheaArgument(RheaArgumentType type, Double arg) {}
