package org.rhea.runtime;

import java.io.*;
import java.util.*;

import org.rhea.exception.*;
import org.rhea.utilities.*;
import org.rhea.structure.*;

/**
 * Run a <b>Rhea</b> file with the {@link #run run} method.
 */
public class RheaRuntime {
    /**
     * Run a <b>Rhea</b> file.
     * @param source The file to run.
     * @throws Exception When something went wrong.
     */
    public static void run(File source) throws Exception {
        RheaUtilities.doFileChecks(source);

        var var_0 = RheaUtilities.doFileProcessing(source);

        var var_1 = 0.0D;
        var var_2 = new RheaMemory();
        var var_3 = new HashMap<Integer, Integer>();
        var var_13 = 0;
        var var_14 = 0;
        var var_4 = 0;

        while(var_4 < var_0.size()) {
            var var_5 = var_0.get(var_4);

            var var_6 = var_5.type();
            var var_7 = var_5.args();

            switch(var_6) {
                case RHEA_DEF -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_2.setDouble(var_9.intValue(), var_11);
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_VOID -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var_2.remove(var_9.intValue());
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_PULL -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var_1 = var_2.getDouble(var_9.intValue());
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_PUSH -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var_2.setDouble(var_9.intValue(), var_1);
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_MOV -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_2.remove(var_9.intValue());
                            var_2.setDouble(var_9.intValue(), var_2.getDouble(var_11.intValue()));
                            var_2.remove(var_11.intValue());
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_ADD -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getDouble(var_9.intValue()) + var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getDouble(var_9.intValue()) + var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9 + var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9 + var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_SUB -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getDouble(var_9.intValue()) - var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getDouble(var_9.intValue()) - var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9 - var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9 - var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_MUL -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getDouble(var_9.intValue()) * var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getDouble(var_9.intValue()) * var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9 * var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9 * var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_DIV -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        if(var_2.getDouble(var_9.intValue()) == 0) {
                            throw new RheaException("Division by zero.");
                        }

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_2.getDouble(var_9.intValue()) / var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_2.getDouble(var_9.intValue()) / var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        if(var_9 == 0) {
                            throw new RheaException("Division by zero.");
                        }

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_9 / var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_9 / var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_MOD -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        if(var_2.getDouble(var_9.intValue()) == 0) {
                            throw new RheaException("Division by zero.");
                        }

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_2.getDouble(var_9.intValue()) % var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_2.getDouble(var_9.intValue()) % var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        if(var_9 == 0) {
                            throw new RheaException("Division by zero.");
                        }

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_9 % var_2.getDouble(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 == 0) {
                                throw new RheaException("Division by zero.");
                            }

                            var_1 = var_9 % var_11;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_NOT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var_1 = ~ var_2.getLong(var_9.intValue());
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var_1 = ~ var_9.longValue();
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_OR -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getLong(var_9.intValue()) | var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getLong(var_9.intValue()) | var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9.longValue() * var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9.longValue() * var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_AND -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getLong(var_9.intValue()) & var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getLong(var_9.intValue()) & var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9.longValue() & var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9.longValue() & var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_XOR -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getLong(var_9.intValue()) ^ var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getLong(var_9.intValue()) ^ var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9.longValue() ^ var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9.longValue() ^ var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_LSHT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getLong(var_9.intValue()) << var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getLong(var_9.intValue()) << var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9.longValue() << var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9.longValue() << var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_RSHT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_2.getLong(var_9.intValue()) >> var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_2.getLong(var_9.intValue()) >> var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = var_9.longValue() >> var_2.getLong(var_11.intValue());
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = var_9.longValue() >> var_11.longValue();
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_EQ -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_2.getDouble(var_9.intValue()) == var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_2.getDouble(var_9.intValue()) == var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_9 == var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_9.equals(var_11)) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_UQ -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_2.getDouble(var_9.intValue()) != var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_2.getDouble(var_9.intValue()) != var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_9 != var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (!var_9.equals(var_11)) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_LT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_2.getDouble(var_9.intValue()) < var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_2.getDouble(var_9.intValue()) < var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_9 < var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_9 < var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_GT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_2.getDouble(var_9.intValue()) > var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_2.getDouble(var_9.intValue()) > var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            var_1 = (var_9 > var_2.getDouble(var_11.intValue())) ? 1 : 0;
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            var_1 = (var_9 > var_11) ? 1 : 0;
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_LABL -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_LABEL)) {
                        RheaUtilities.doLabelChecks(var_9);

                        var_3.put(var_9.intValue(), var_4);
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_JMP -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_LABEL)) {
                        RheaUtilities.doLabelChecks(var_9);

                        var_4 = var_3.get(var_9.intValue());
                    } else {
                        throw new RheaException("Invalid type.");
                    }
                }
                case RHEA_JMPT -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_LABEL)) {
                        RheaUtilities.doLabelChecks(var_9);

                        if(var_1 == 1) {
                            var_4 = var_3.get(var_9.intValue());
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }
                }
                case RHEA_JMPF -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_LABEL)) {
                        RheaUtilities.doLabelChecks(var_9);

                        if(var_1 == 0) {
                            var_4 = var_3.get(var_9.intValue());
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }
                }
                case RHEA_SYSO -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        if(var_13 == 0) {
                            for(var var_10 = 1; var_10 <= var_2.getInt(var_9.intValue()); ++var_10) {
                                System.out.print(var_2.getChar(var_9.intValue() + var_10));
                            }
                        } else if(var_13 == 1) {
                            for(var var_10 = 1; var_10 <= var_2.getInt(var_9.intValue()); ++var_10) {
                                System.out.print(var_2.getLong(var_9.intValue() + var_10));
                                System.out.print(", ");
                            }
                        } else if (var_13 == 2) {
                            for(var var_10 = 1; var_10 <= var_2.getInt(var_9.intValue()); ++var_10) {
                                System.out.print(var_2.getDouble(var_9.intValue() + var_10));
                                System.out.print(", ");
                            }
                        } else if(var_13 == 3) {
                            System.out.print(var_2.getChar(var_9.intValue()));
                        } else if(var_13 == 4) {
                            System.out.print(var_2.getLong(var_9.intValue()));
                        } else if(var_13 == 5) {
                            System.out.print(var_2.getDouble(var_9.intValue()));
                        } else {
                            throw new RheaException("Invalid mode.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        if(var_13 == 3) {
                            System.out.print(Character.toChars(var_9.intValue())[0]);
                        } else if(var_13 == 4) {
                            System.out.print(var_9.longValue());
                        } else if(var_13 == 5) {
                            System.out.print(var_9);
                        } else {
                            throw new RheaException("Invalid mode.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_SYSI -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = new Scanner(System.in);

                        if(var_13 == 0) {
                            var var_11 = var_10.nextLine();

                            if (var_11.length() > var_14) {
                                var_11 = var_11.substring(0, var_14);
                            }

                            var_2.setInt(var_9.intValue(), var_11.length());

                            for (var var_12 = 1; var_12 <= var_11.length(); var_12++) {
                                var_2.setChar(var_9.intValue() + var_12, var_11.charAt(var_12 - 1));
                            }
                        } else if(var_13 == 1) {
                            var var_11 = new ArrayList<Long>();

                            for(var var_12 = 0; var_12 <= var_14; var_12++) {
                                var_11.add(var_10.nextLong());
                            }

                            var_2.setInt(var_9.intValue(), var_11.size());

                            for (var var_15 = 1; var_15 <= var_11.size(); var_15++) {
                                var_2.setLong(var_9.intValue() + var_15, var_11.get(var_15 - 1));
                            }
                        } else if(var_13 == 2) {
                            var var_11 = new ArrayList<Double>();

                            for(var var_12 = 0; var_12 <= var_14; var_12++) {
                                var_11.add(var_10.nextDouble());
                            }

                            var_2.setInt(var_9.intValue(), var_11.size());

                            for (var var_15 = 1; var_15 <= var_11.size(); var_15++) {
                                var_2.setDouble(var_9.intValue() + var_15, var_11.get(var_15 - 1));
                            }
                        } else if(var_13 == 3) {
                            var var_11 = var_10.nextLine();

                            if(var_11.length() > 1) {
                                throw new RheaException("Only one character is allowed.");
                            }

                            var_2.setChar(var_9.intValue(), var_11.charAt(0));
                        } else if(var_13 == 4) {
                            var var_11 = var_10.nextLong();

                            var_2.setLong(var_9.intValue(), var_11);
                        } else if(var_13 == 5) {
                            var var_11 = var_10.nextDouble();

                            var_2.setDouble(var_9.intValue(), var_11);
                        } else {
                            throw new RheaException("Invalid mode.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_SYSM -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        if(var_2.getDouble(var_9.intValue()) >= 0D && var_2.getDouble(var_9.intValue()) <= 2D) {
                            var_13 = var_2.getInt(var_9.intValue());
                        } else {
                            throw new RheaException("Invalid mode.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        if(var_9 >= 0D && var_9 <= 2D) {
                            var_13 = var_9.intValue();
                        } else {
                            throw new RheaException("Invalid mode.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_SYSL -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        if(!(var_2.getDouble(var_9.intValue()) <= 0D)) {
                            var_14 = var_2.getInt(var_9.intValue());
                        } else {
                            throw new RheaException("The allowed length can't be lesser than or equal to zero.");
                        }
                    } else if(var_8.equals(RheaArgumentType.RHEA_CONST)) {
                        if(!(var_9 <= 0D)) {
                            var_14 = var_9.intValue();
                        } else {
                            throw new RheaException("The allowed length can't be lesser than or equal to zero.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_ARRG -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) > 0) {
                                if(var_2.getDouble(var_11.intValue()) < var_2.getDouble(var_9.intValue())) {
                                    var_1 = var_2.getDouble(var_2.getInt(var_9.intValue()) + var_2.getInt(var_11.intValue()));
                                } else {
                                    throw new RheaException("Invalid index.");
                                }
                            } else {
                                throw new RheaException("Invalid index");
                            }
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 > 0) {
                                if (var_11 < var_2.getDouble(var_9.intValue())) {
                                    var_1 = var_2.getDouble(var_2.getInt(var_9.intValue()) + var_11.intValue());
                                } else {
                                    throw new RheaException("Invalid index.");
                                }
                            } else {
                                throw new RheaException("Invalid index");
                            }
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                case RHEA_ARRS -> {
                    var var_8 = var_7.get(0).type();
                    var var_9 = var_7.get(0).arg();

                    if(var_8.equals(RheaArgumentType.RHEA_VALUE)) {
                        RheaUtilities.doValueChecks(var_9);

                        var var_10 = var_7.get(1).type();
                        var var_11 = var_7.get(1).arg();

                        if(var_10.equals(RheaArgumentType.RHEA_VALUE)) {
                            RheaUtilities.doValueChecks(var_11);

                            if(var_2.getDouble(var_11.intValue()) > 0) {
                                if(var_2.getDouble(var_11.intValue()) < var_2.getDouble(var_9.intValue())) {
                                    var_2.setDouble(var_2.getInt(var_9.intValue()) + var_2.getInt(var_11.intValue()), var_1);
                                } else {
                                    throw new RheaException("Invalid index.");
                                }
                            } else {
                                throw new RheaException("Invalid index");
                            }
                        } else if(var_10.equals(RheaArgumentType.RHEA_CONST)) {
                            if(var_11 > 0) {
                                if (var_11 < var_2.getDouble(var_9.intValue())) {
                                    var_2.setDouble(var_2.getInt(var_9.intValue()) + var_11.intValue(), var_1);
                                } else {
                                    throw new RheaException("Invalid index.");
                                }
                            } else {
                                throw new RheaException("Invalid index");
                            }
                        } else {
                            throw new RheaException("Invalid type.");
                        }
                    } else {
                        throw new RheaException("Invalid type.");
                    }

                    var_4++;
                }
                default -> throw new RheaException("Invalid instruction type: " + var_6);
            }
        }
    }
}