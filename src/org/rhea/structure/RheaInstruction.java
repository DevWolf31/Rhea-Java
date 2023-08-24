package org.rhea.structure;

import java.util.*;

/**
 * Stores the data of an instruction.
 * @param type The type.
 * @param args The arguments.
 */
public record RheaInstruction(RheaInstructionType type, List<RheaArgument> args) {}
