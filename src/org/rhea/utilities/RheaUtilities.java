package org.rhea.utilities;

import java.io.*;
import java.util.*;

import org.rhea.exception.*;
import org.rhea.structure.*;

/**
 * Contains various utility methods.
 */
public class RheaUtilities {
    /**
     * Check if a file is valid.
     * @param file The file to check.
     * @throws Exception When the file is invalid
     */
    public static void doFileChecks(File file) throws Exception {
        if (!file.exists()) {
            throw new RheaException("File or folder not found.");
        } else {
            if (file.isDirectory()) {
                throw new RheaException("File expected, not folder.");
            } else {
                if (!file.canRead()) {
                    throw new RheaException("Unreadable file.");
                }
            }
        }
    }

    /**
     * Convert a file into a list of {@link RheaInstruction RheaInstruction}.
     * @param file The file to convert.
     * @return The result of the conversion.
     * @throws Exception When something went wrong.
     */
    public static List<RheaInstruction> doFileProcessing(File file) throws Exception {
        RheaUtilities.doFileChecks(file);

        var var_0 = new ArrayList<RheaInstruction>();
        var var_1 = new Scanner(file);

        while(var_1.hasNextLine()) {
            var var_2 = var_1.nextLine();

            if(!var_2.isBlank()) {
                var_2 = var_2.stripLeading();

                if(!var_2.startsWith(";;")) {
                    if(var_2.contains(";;")) {
                        var_2 = var_2.split(";;")[0];
                    }

                    var_2 = var_2.stripTrailing();

                    var var_4 = var_2;
                    var var_5 = new ArrayList<String>();

                    if(var_2.contains(" ")) {
                        var var_3 = var_2.split("\\s");

                        var_4 = var_3[0];

                        if(var_3.length > 1) {
                            var_5.addAll(Arrays.asList(var_3).subList(1, var_3.length));
                        }
                    }

                    var var_6 = RheaUtilities.doInstructionClassification(var_4);
                    var var_7 = new ArrayList<RheaArgument>();

                    for(var var_8: var_5) {
                        var_7.add(new RheaArgument(RheaUtilities.doArgumentClassification(var_8.substring(0, 2)), Double.valueOf(var_8.substring(2))));
                    }

                    var var_9 = new RheaInstruction(var_6, var_7);

                    var_0.add(var_9);
                }
            }
        }

        return var_0;
    }

    /**
     * Classifies an instruction based on his type.
     * For example: If <i>type</i> is <i>"def"</i>, the return value should be {@link RheaInstructionType#RHEA_DEF RHEA_DEF}.
     * @param type The instruction type.
     * @return The instruction classification.
     * @throws Exception When there is an invalid instruction.
     *
     */
    public static RheaInstructionType doInstructionClassification(String type) throws Exception {
        switch(type.toLowerCase()) {
            case "def" -> {
                return RheaInstructionType.RHEA_DEF;
            }
            case "void" -> {
                return RheaInstructionType.RHEA_VOID;
            }
            case "pull" -> {
                return RheaInstructionType.RHEA_PULL;
            }
            case "push" -> {
                return RheaInstructionType.RHEA_PUSH;
            }
            case "mov" -> {
                return RheaInstructionType.RHEA_MOV;
            }
            case "add" -> {
                return RheaInstructionType.RHEA_ADD;
            }
            case "sub" -> {
                return RheaInstructionType.RHEA_SUB;
            }
            case "mul" -> {
                return RheaInstructionType.RHEA_MUL;
            }
            case "div" -> {
                return RheaInstructionType.RHEA_DIV;
            }
            case "mod" -> {
                return RheaInstructionType.RHEA_MOD;
            }
            case "not" -> {
                return RheaInstructionType.RHEA_NOT;
            }
            case "or" -> {
                return RheaInstructionType.RHEA_OR;
            }
            case "and" -> {
                return RheaInstructionType.RHEA_AND;
            }
            case "xor" -> {
                return RheaInstructionType.RHEA_XOR;
            }
            case "lsht" -> {
                return RheaInstructionType.RHEA_LSHT;
            }
            case "rsht" -> {
                return RheaInstructionType.RHEA_RSHT;
            }
            case "eq" -> {
                return RheaInstructionType.RHEA_EQ;
            }
            case "uq" -> {
                return RheaInstructionType.RHEA_UQ;
            }
            case "lt" -> {
                return RheaInstructionType.RHEA_LT;
            }
            case "gt" -> {
                return RheaInstructionType.RHEA_GT;
            }
            case "labl" -> {
                return RheaInstructionType.RHEA_LABL;
            }
            case "jmp" -> {
                return RheaInstructionType.RHEA_JMP;
            }
            case "jmpt" -> {
                return RheaInstructionType.RHEA_JMPT;
            }
            case "jmpf" -> {
                return RheaInstructionType.RHEA_JMPF;
            }
            case "syso" -> {
                return RheaInstructionType.RHEA_SYSO;
            }
            case "sysi" -> {
                return RheaInstructionType.RHEA_SYSI;
            }
            case "sysm" -> {
                return RheaInstructionType.RHEA_SYSM;
            }
            case "sysl" -> {
                return RheaInstructionType.RHEA_SYSL;
            }
            case "arrg" -> {
                return RheaInstructionType.RHEA_ARRG;
            }
            case "arrs" -> {
                return RheaInstructionType.RHEA_ARRS;
            }
            default -> throw new RheaException("Invalid instruction type: " + type);
        }
    }

    /**
     * Classifies an argument based on his type.
     * For example: If <i>type</i> is <i>"c/"</i>, the return value should be {@link RheaArgumentType#RHEA_CONST RHEA_CONST}.
     * @param type The argument type.
     * @return The argument classification.
     * @throws Exception When there is an invalid argument.
     */
    public static RheaArgumentType doArgumentClassification(String type) throws Exception {
        switch(type.toLowerCase()) {
            case "c/" -> {
                return RheaArgumentType.RHEA_CONST;
            }
            case "v/" -> {
                return RheaArgumentType.RHEA_VALUE;
            }
            case "l/" -> {
                return RheaArgumentType.RHEA_LABEL;
            }
            default -> throw new RheaException("Invalid argument type: " + type);
        }
    }

    /**
     * Check if a value is valid.
     * @param arg The value to check.
     * @throws Exception When the value is invalid.
     */
    public static void doValueChecks(double arg) throws Exception {
        if(arg < 0D) {
            throw new RheaException("Invalid value reference: " + arg);
        }
    }

    /**
     * Check if a label is valid.
     * @param arg The label to check.
     * @throws Exception When the label is invalid.
     */
    public static void doLabelChecks(double arg) throws Exception {
        if(arg < 0D) {
            throw new RheaException("Invalid label reference: " + arg);
        }
    }
}