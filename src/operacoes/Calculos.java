package operacoes;

public class Calculos {

    //<editor-fold defaultstate="collapsed" desc="Constants for calcula_1 (PTNO -> BitByte)">
    private static final int PTNO_MAX_INPUT = 36096;

    // SOSTAT Range (Analog points)
    private static final int SOSTAT_RANGE_START = 0;
    private static final int SOSTAT_RANGE_END = 2047;

    // 2-Way without Timestamp Range
    private static final int PTNO_2W_NO_TS_START = 10000;
    private static final int PTNO_2W_NO_TS_END = 11023;
    private static final int PTNO_2W_NO_TS_OFFSET = 10000;

    // 2-Way with Timestamp Range
    private static final int PTNO_2W_TS_START = 15000;
    private static final int PTNO_2W_TS_END = 16023;
    private static final int PTNO_2W_TS_OFFSET = 15000;
    private static final int PTNO_2W_TS_RESULT_OFFSET = 2048;


    // 4-Way with Timestamp Range
    private static final int PTNO_4W_TS_START = 25000;
    private static final int PTNO_4W_TS_END = 25063;
    private static final int PTNO_4W_TS_OFFSET = 25000;
    private static final int PTNO_4W_TS_RESULT_OFFSET = 4608;


    // Latch with Timestamp Range
    private static final int PTNO_LATCH_TS_START = 36000;
    private static final int PTNO_LATCH_TS_END = 36063;
    private static final int PTNO_LATCH_TS_OFFSET = 36000;
    private static final int PTNO_LATCH_TS_RESULT_OFFSET = 5632;


    // Partial Latch with Timestamp Range
    private static final int PTNO_LATCH_TS_PARTIAL_START = 36088;
    private static final int PTNO_LATCH_TS_PARTIAL_END = 36095;
    private static final int PTNO_LATCH_TS_PARTIAL_OFFSET = 36064;
    private static final int PTNO_LATCH_TS_PARTIAL_RESULT_OFFSET = 5760;

    // Unused ranges for PTNO
    private static final int UNUSED_PTNO_1_START = 2048;
    private static final int UNUSED_PTNO_1_END = 9999;
    private static final int UNUSED_PTNO_2_START = 11024;
    private static final int UNUSED_PTNO_2_END = 14999;
    private static final int UNUSED_PTNO_3_START = 16024;
    private static final int UNUSED_PTNO_3_END = 24999;
    private static final int UNUSED_PTNO_4_START = 25064;
    private static final int UNUSED_PTNO_4_END = 35999;
    private static final int UNUSED_PTNO_5_START = 36064;
    private static final int UNUSED_PTNO_5_END = 36087;


    // Common calculation constants
    private static final int DIVISOR_8 = 8;
    private static final int MULTIPLIER_16 = 16;
    private static final int MULTIPLIER_2 = 2;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constants for calcula_2 (BitByte -> PTNO)">
    private static final int BITBYTE_MAX_INPUT = 8192;

    // 2-Way without Timestamp Range for BitByte
    private static final int BITBYTE_2W_NO_TS_START = 0;
    private static final int BITBYTE_2W_NO_TS_END = 2047;
    private static final int BITBYTE_2W_NO_TS_OFFSET = 10000;

    // 2-Way with Timestamp Range for BitByte
    private static final int BITBYTE_2W_TS_START = 2048;
    private static final int BITBYTE_2W_TS_END = 4095;
    private static final int BITBYTE_2W_TS_OFFSET = 27952;


    // 4-Way with Timestamp Range for BitByte
    private static final int BITBYTE_4W_TS_START = 4608;
    private static final int BITBYTE_4W_TS_END = 5119;
    private static final int BITBYTE_4W_TS_OFFSET = 20392;


    // Latch with Timestamp Range for BitByte
    private static final int BITBYTE_LATCH_TS_START = 5632;
    private static final int BITBYTE_LATCH_TS_END = 6143;
    private static final int BITBYTE_LATCH_TS_OFFSET = 30368;
    // Sub-ranges
    private static final int BITBYTE_LATCH_TS_SUB_START_1 = 5632;
    private static final int BITBYTE_LATCH_TS_SUB_END_1 = 5639;
    private static final int BITBYTE_LATCH_TS_SUB_START_2 = 5648;
    private static final int BITBYTE_LATCH_TS_SUB_END_2 = 5655;
    private static final int BITBYTE_LATCH_TS_SUB_START_3 = 5664;
    private static final int BITBYTE_LATCH_TS_SUB_END_3 = 5671;
    private static final int BITBYTE_LATCH_TS_SUB_START_4 = 5680;
    private static final int BITBYTE_LATCH_TS_SUB_END_4 = 5687;
    private static final int BITBYTE_LATCH_TS_SUB_START_5 = 5696;
    private static final int BITBYTE_LATCH_TS_SUB_END_5 = 5703;
    private static final int BITBYTE_LATCH_TS_SUB_START_6 = 5712;
    private static final int BITBYTE_LATCH_TS_SUB_END_6 = 5719;
    private static final int BITBYTE_LATCH_TS_SUB_START_7 = 5728;
    private static final int BITBYTE_LATCH_TS_SUB_END_7 = 5735;
    private static final int BITBYTE_LATCH_TS_SUB_START_8 = 5744;
    private static final int BITBYTE_LATCH_TS_SUB_END_8 = 5751;
    private static final int BITBYTE_LATCH_TS_SUB_START_9 = 5792;
    private static final int BITBYTE_LATCH_TS_SUB_END_9 = 5799;
    private static final int BITBYTE_LATCH_TS_SUB_START_10 = 5808;
    private static final int BITBYTE_LATCH_TS_SUB_END_10 = 5815;
    private static final int BITBYTE_LATCH_UNUSED_START = 5816;
    private static final int BITBYTE_LATCH_UNUSED_END = 6143;


    // Pseudo Range
    private static final int PSEUDO_RANGE_START = 7000;
    private static final int PSEUDO_RANGE_END = 8192;

    // Unused Ranges
    private static final int UNUSED_BITBYTE_1_START = 4096;
    private static final int UNUSED_BITBYTE_1_END = 4607;
    private static final int UNUSED_BITBYTE_2_START = 5120;
    private static final int UNUSED_BITBYTE_2_END = 5631;
    private static final int UNUSED_BITBYTE_3_START = 6144;
    private static final int UNUSED_BITBYTE_3_END = 6999;
    //</editor-fold>


    public static int calcula_1(String t1) {
        int n1;
        int result = 0;

        try {
            n1 = Integer.parseInt(t1);

            if (n1 >= SOSTAT_RANGE_START && n1 <= SOSTAT_RANGE_END) {
                result = n1;
            } else if (n1 >= PTNO_2W_NO_TS_START && n1 <= PTNO_2W_NO_TS_END) {
                result = ((n1 - PTNO_2W_NO_TS_OFFSET) * MULTIPLIER_2);
            } else if (n1 >= PTNO_2W_TS_START && n1 <= PTNO_2W_TS_END) {
                result = (((n1 - PTNO_2W_TS_OFFSET) * MULTIPLIER_2) + PTNO_2W_TS_RESULT_OFFSET);
            } else if (n1 >= PTNO_4W_TS_START && n1 <= PTNO_4W_TS_END) {
                result = (((n1 - PTNO_4W_TS_OFFSET) / DIVISOR_8) * MULTIPLIER_16) + (((n1 - PTNO_4W_TS_OFFSET) % DIVISOR_8) + PTNO_4W_TS_RESULT_OFFSET);
            } else if (n1 >= PTNO_LATCH_TS_START && n1 <= PTNO_LATCH_TS_END) {
                result = (((n1 - PTNO_LATCH_TS_OFFSET) / DIVISOR_8) * MULTIPLIER_16) + (((n1 - PTNO_LATCH_TS_OFFSET) % DIVISOR_8) + PTNO_LATCH_TS_RESULT_OFFSET);
            } else if (n1 >= PTNO_LATCH_TS_PARTIAL_START && n1 <= PTNO_LATCH_TS_PARTIAL_END) {
                result = (((n1 - PTNO_LATCH_TS_PARTIAL_OFFSET) / DIVISOR_8) * MULTIPLIER_16) + (((n1 - PTNO_LATCH_TS_PARTIAL_OFFSET) % DIVISOR_8) + PTNO_LATCH_TS_PARTIAL_RESULT_OFFSET);
            } else {
                return -1;
            }

            return result;
        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    public static int calcula_2(String t2) {
        int n2;
        int result = 0;

        try {
            n2 = Integer.parseInt(t2);

            if (n2 >= BITBYTE_2W_NO_TS_START && n2 <= BITBYTE_2W_NO_TS_END) {
                result = ((n2 / 2) + BITBYTE_2W_NO_TS_OFFSET);
            } else if (n2 >= BITBYTE_2W_TS_START && n2 <= BITBYTE_2W_TS_END) {
                if (n2 % 2 != 0) {
                    return -1;
                } else {
                    result = ((n2 + BITBYTE_2W_TS_OFFSET) / 2);
                }
            } else if (n2 >= UNUSED_BITBYTE_1_START && n2 <= UNUSED_BITBYTE_1_END) {
                return -1;
            } else if (n2 >= BITBYTE_4W_TS_START && n2 <= BITBYTE_4W_TS_END) {
                if ((n2 % 16) > 7) { // Check for unused gaps
                    return -1;
                } else {
                    int block = (n2 - BITBYTE_4W_TS_START) / 16;
                    result = (n2 + BITBYTE_4W_TS_OFFSET) - (8 * block);
                }
            } else if (n2 >= UNUSED_BITBYTE_2_START && n2 <= UNUSED_BITBYTE_2_END) {
                return -1;
            } else if (n2 >= BITBYTE_LATCH_TS_START && n2 <= BITBYTE_LATCH_TS_END) {
                 if (n2 >= BITBYTE_LATCH_TS_SUB_START_1 && n2 <= BITBYTE_LATCH_TS_SUB_END_1) result = (n2 + BITBYTE_LATCH_TS_OFFSET);
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_2 && n2 <= BITBYTE_LATCH_TS_SUB_END_2) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 8;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_3 && n2 <= BITBYTE_LATCH_TS_SUB_END_3) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 16;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_4 && n2 <= BITBYTE_LATCH_TS_SUB_END_4) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 24;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_5 && n2 <= BITBYTE_LATCH_TS_SUB_END_5) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 32;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_6 && n2 <= BITBYTE_LATCH_TS_SUB_END_6) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 40;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_7 && n2 <= BITBYTE_LATCH_TS_SUB_END_7) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 48;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_8 && n2 <= BITBYTE_LATCH_TS_SUB_END_8) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 56;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_9 && n2 <= BITBYTE_LATCH_TS_SUB_END_9) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 80;
                 else if (n2 >= BITBYTE_LATCH_TS_SUB_START_10 && n2 <= BITBYTE_LATCH_TS_SUB_END_10) result = (n2 + BITBYTE_LATCH_TS_OFFSET) - 88;
                 else if (n2 >= BITBYTE_LATCH_UNUSED_START && n2 <= BITBYTE_LATCH_UNUSED_END) {
                    return -1;
                 } else {
                    return -1;
                 }
            } else if (n2 >= UNUSED_BITBYTE_3_START && n2 <= UNUSED_BITBYTE_3_END) {
                return -1;
            } else if (n2 >= PSEUDO_RANGE_START && n2 <= PSEUDO_RANGE_END) {
                result = 0;
            } else {
                return -1;
            }

            return result;

        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    public static int calcula_raw(String tvmin) {
        int vmin;
        try {
            vmin = Integer.parseInt(tvmin);
            return vmin;
        } catch (NumberFormatException erro) {
            return -1;
        }
    }
}
