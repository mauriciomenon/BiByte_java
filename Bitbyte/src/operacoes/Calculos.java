package operacoes;

import javax.swing.JOptionPane;

public class Calculos {

    public static int calcula_1(String t1) {
        int n1 = 0, result = 0, error = 0;
        try {
            n1 = Integer.parseInt(t1);

            if (n1 >= 0 && n1 <= 36096) {

                if (n1 >= 0 && n1 <= 2047) {      //2W without TimeStamp
                    result = n1;
                    String message = String.format("Calculadora para SOSTAT, verifique a SOANLG para pontos analógicos");
                    JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
                    error = 0;
                }

                if (n1 >= 10000 && n1 <= 11023) {      //2W without TimeStamp
                    result = ((n1 - 10000) * 2);
                    JOptionPane.showMessageDialog(null, "Resultado para um ponto 2WAY sem TimeStamp");
                    error = 0;
                }

                if (n1 >= 15000 && n1 <= 16023) {      //2W with TimeStamp
                    result = (((n1 - 15000) * 2) + 2048);
                    error = 0;
                }                                                                   //intervalo entre 16025 e 16814 normalmente SCC (BD SCADA)

                if (n1 >= 25000 && n1 <= 25063) {         //4W with TimeStamp       //25063 <-> 4727 (bloco 5)
                    result = (((n1 - 25000) / 8) * 16) + (((n1 - 25000) % 8) + 4608);
                    error = 0;
                }

                if (n1 >= 36000 && n1 <= 36063) {        //Latch with TimeStamp     //36095 <-> 5815 (bloco 5)
                    result = (((n1 - 36000) / 8) * 16) + (((n1 - 36000) % 8) + 5632);
                    error = 0;
                }

                if (n1 >= 36088 && n1 <= 36095) {        //Latch with TimeStamp     //36095 <-> 5815 (bloco 6, parcial)
                    result = (((n1 - 36064) / 8) * 16) + (((n1 - 36064) % 8) + 5760);
                    JOptionPane.showMessageDialog(null, result);
                    error = 0;
                }

                if ((n1 >= 2048 && n1 <= 9999)|| (n1 >= 11024 && n1 <= 14999) || (n1 >= 16024 && n1 <= 24999) || (n1 >= 25064 && n1 <= 35999) || (n1 >= 36064 && n1 <= 36087)) {
                    error = 1;
                }
            }

            if (n1 < 0 || n1 > 36096) {
                error = 1;
            }

            if (error == 1) {
                String message = String.format("Verifique valores e intervalos válidos na documentação");
                JOptionPane.showMessageDialog(null, message, "Erro:", JOptionPane.ERROR_MESSAGE);
                result = 0;
            }

            return result;
        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    public static int calcula_2(String t2) {
        int n2 = 0, result = 0, error = 0;

        try {
            n2 = Integer.parseInt(t2);

            if (n2 >= 0 && n2 <= 8192) {                                        //intervalo definido para SOSTAT.PNTNO

                if (n2 >= 0 && n2 <= 2047) {                                    //2WAY without TimeStamp
                    result = ((n2 / 2) + 10000);
                    String message = String.format("Cuidado, pode ser ponto Analógico");
                    JOptionPane.showMessageDialog(null, message);
                }

                if (n2 >= 2048 && n2 <= 4095) {                                 //2WAY with TimeStamp

                    if (n2 % 2 != 0) {
                        String message = String.format("PTNO deve ser um numero par");
                        JOptionPane.showMessageDialog(null, message);
                        error = 1;
                    } else {
                        result = ((n2 + 27952) / 2);
                    }
                }

                if (n2 >= 4096 && n2 <= 4607) {                                 //Intervalo não utilizado
                    String message = String.format("Intervalo não utilizado");
                    JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.WARNING_MESSAGE);
                    error = 1;
                }

                if (n2 >= 4608 && n2 <= 5119) {                                 //4WAY with TimeStamp 

                    if (n2 >= 4608 && n2 <= 4615) {
                        result = (n2 + 20392);
                    }

                    if (n2 >= 4624 && n2 <= 4631) {
                        result = (n2 + 20392) - 8;
                    }

                    if (n2 >= 4640 && n2 <= 4647) {
                        result = (n2 + 20392) - 16;
                    }

                    if (n2 >= 4656 && n2 <= 4663) {
                        result = (n2 + 20392) - 24;
                    }

                    if (n2 >= 4672 && n2 <= 4679) {
                        result = (n2 + 20392) - 32;
                    }

                    if (n2 >= 4688 && n2 <= 4695) {
                        result = (n2 + 20392) - 40;
                    }

                    if (n2 >= 4696 && n2 <= 5119) {                                 //Intervalo não utilizado
                        String message = String.format("Intervalo não utilizado atualmente");
                        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.WARNING_MESSAGE);
                    }

                    if ((n2 >= 4616 && n2 <= 4623) || (n2 >= 4632 && n2 <= 4639) || (n2 >= 4648 && n2 <= 4655) || (n2 >= 4664 && n2 <= 4671) || (n2 >= 4680 && n2 <= 4687)) {
                        error = 1;
                    }
                }

                if (n2 >= 5120 && n2 <= 5631) {                                 //Intervalo não utilizado
                    String message = String.format("Intervalo não utilizado ");
                    JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.WARNING_MESSAGE);
                    error = 1;
                }


                if (n2 >= 5632 && n2 <= 6143) {                                 //LATCH with TimeStamp

                    if (n2 >= 5632 && n2 <= 5639) {
                        result = (n2 + 30368);
                    }

                    if (n2 >= 5648 && n2 <= 5655) {
                        result = (n2 + 30368) - 8;
                    }

                    if (n2 >= 5664 && n2 <= 5671) {
                        result = (n2 + 30368) - 16;
                    }

                    if (n2 >= 5680 && n2 <= 5687) {
                        result = (n2 + 30368) - 24;
                    }

                    if (n2 >= 5696 && n2 <= 5703) {
                        result = (n2 + 30368) - 32;
                    }

                    if (n2 >= 5712 && n2 <= 5719) {
                        result = (n2 + 30368) - 40;
                    }

                    if (n2 >= 5728 && n2 <= 5735) {
                        result = (n2 + 30368) - 48;
                    }

                    if (n2 >= 5744 && n2 <= 5751) {
                        result = (n2 + 30368) - 56;
                    }

                    if (n2 >= 5792 && n2 <= 5799) {
                        result = (n2 + 30368) - 80;
                    }

                    if (n2 >= 5808 && n2 <= 5815) {
                        result = (n2 + 30368) - 88;
                    }

                    if ((n2 >= 5640 && n2 <= 5647) || (n2 >= 5656 && n2 <= 5663) || (n2 >= 5672 && n2 <= 5681) || (n2 >= 5688 && n2 <= 5695) || (n2 >= 5704 && n2 <= 5711) || (n2 >= 5720 && n2 <= 5727) || (n2 >= 5736 && n2 <= 5743) || (n2 >= 5752 && n2 <= 5791) || (n2 >= 5800 && n2 <= 5807)) {
                        error = 1;
                    }

                    if (n2 >= 5816 && n2 <= 6143) {                             //Intervalo não utilizado
                        String message = String.format("Intervalo não utilizado atualmente");
                        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.WARNING_MESSAGE);
                    }

                }

                if (n2 >= 6144 && n2 <= 6999) {                                 //Intervalo não utilizado
                    String message = String.format("Intervalo não utilizado ");
                    JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.WARNING_MESSAGE);
                }

                if (n2 >= 7000 && n2 <= 8192) {                                 //PSEUDO
                    result = 0;
                    String message = String.format("Todo Pseudo point tem BITBYTE nulo");
                    JOptionPane.showMessageDialog(null, message, "Atenção:", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (n2 < 0 || n2 > 8192) {
                error = 1;
            }

            if (error == 1) {
                String message = String.format("Verifique valores e intervalos válidos na documentação");
                JOptionPane.showMessageDialog(null, message, "Erro:", JOptionPane.ERROR_MESSAGE);
                result = 0;
            }

            return result;

        } catch (NumberFormatException erro) {
            return -1;
        }
    }

    public static int calcula_raw(String tvmin) {
        int tr = 1, bias = 0, scale = 0, error = 0, result =0;
        int vmin = 0, vmax = 0;
        try {
            vmin = Integer.parseInt(tvmin);
                result = vmin;
                String message = String.format("Sem Erro");
                JOptionPane.showMessageDialog(null, message, "Sem Erro ", JOptionPane.ERROR_MESSAGE);
                error = 0;

            return result;
        } catch (NumberFormatException erro) {
            return -1;
        }
    }
    
}

