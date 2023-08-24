package org.rhea;

import java.io.*;

import org.rhea.runtime.*;
import org.rhea.exception.*;
import org.rhea.utilities.RheaUtilities;

/**
 * The <b>Rhea</b> main class.
 */
public class Rhea {
    /**
     * The <b>Rhea</b> main method.
     * @param args The arguments provided by the console.
     * @throws Exception When something went wrong.
     */
    public static void main(String[] args) throws Exception {
        if(args.length >= 1) {
            switch (args[0]) {
                case "-h", "--help" -> Rhea.help();
                case "-i", "--info" -> Rhea.info();
                case "-r", "--run" -> {
                    if (args.length >= 2) {
                        var var_0 = args[1];

                        if (var_0.startsWith("\"")) {
                            if (var_0.endsWith("\"")) {
                                var_0 = var_0.substring(1, var_0.length() - 1);
                            } else {
                                throw new RheaException("Missing enclosing '\"' on the path.");
                            }
                        }

                        var var_1 = new File(var_0);

                        RheaUtilities.doFileChecks(var_1);
                        RheaRuntime.run(var_1);
                    } else {
                        throw new RheaException("Too few arguments.");
                    }
                }
                default -> throw new RheaException("Unrecognized argument '" + args[0] + "'.");
            }
        } else {
            throw new RheaException("Too few arguments.");
        }
    }

    /**
     * Print the help.
     */
    public static void help() {

    }

    /**
     * Print the info.
     */
    public static void info() {

    }
}
