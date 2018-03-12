package com.liu.date20180312;

/**
 * Created by Herry on 2018/3/12.
 * 说明： 科大讯飞第三题笔试题。有待进一步完善。
 */
public class Inter3 {

    public static void main(String[] args) {

        String[][] input = {{"o", "^", "-"},
                            {"/", "v", "|"},
                            {"v", "x", "^"}};

        input = turnLeft(input);

        int length = input.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        input = flipVertical(input);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }








    }

    //向左旋转90度
    public static String[][] turnLeft(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                oldChar = input[j][length - 1 - i];
                if(oldChar.equals("<")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals(">")) {
                    temp[i][j] = "^";
                } else if(oldChar.equals("^")) {
                    temp[i][j] = "<";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals("|")) {
                    temp[i][j] = "-";
                } else if(oldChar.equals("-")) {
                    temp[i][j] = "|";
                }else if(oldChar.equals("\\")) {
                    temp[i][j] = "/";
                } else if(oldChar.equals("/")) {
                    temp[i][j] = "\\";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }
        return temp;
    }

    //向右旋转90度
    public static String[][] turnRight(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                oldChar = input[j][length - 1 - i];
                if(oldChar.equals("<")) {
                    temp[i][j] = "^";
                } else if(oldChar.equals(">")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals("^")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = "<";
                } else if(oldChar.equals("|")) {
                    temp[i][j] = "-";
                } else if(oldChar.equals("-")) {
                    temp[i][j] = "|";
                }else if(oldChar.equals("\\")) {
                    temp[i][j] = "/";
                } else if(oldChar.equals("/")) {
                    temp[i][j] = "\\";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }
        return temp;
    }

    //沿水平方向翻转
    public static String[][] flipHorizontal(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                oldChar = input[length - 1 - i][j];
                if(oldChar.equals("<")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals(">")) {
                    temp[i][j] = "<";
                }else if(oldChar.equals("\\")) {
                    temp[i][j] = "/";
                } else if(oldChar.equals("/")) {
                    temp[i][j] = "\\";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }
        if(length % 2 != 0 ) {
            for (int i = 0; i < length; i++) {
                temp[length/2+1][i] = input[length/2+1][i];
            }
        }
        return temp;
    }

    //沿垂直方向翻转
    public static String[][] flipVertical(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= length/2; j++) {
                oldChar = input[i][length - 1 - j];
                if(oldChar.equals("^")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = "^";
                } else if(oldChar.equals("\\")) {
                    temp[i][j] = "/";
                } else if(oldChar.equals("/")) {
                    temp[i][j] = "\\";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }

        if(length % 2 != 0 ) {
            for (int i = 0; i < length; i++) {
                temp[i][length/2+1] = input[i][length/2+1];
            }
        }

        return temp;
    }


    //沿对角线翻转
    public static String[][] turnDiagonalt(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                oldChar = input[j][i];
                if(oldChar.equals("<")) {
                    temp[i][j] = "^";
                } else if(oldChar.equals(">")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals("^")) {
                    temp[i][j] = "<";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals("|")) {
                    temp[i][j] = "-";
                } else if(oldChar.equals("-")) {
                    temp[i][j] = "|";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }
        return temp;
    }

    //沿反对角线翻转
    public static String[][] turnAntiDiagonalt(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                oldChar = input[j][length - 1 - i];
                if(oldChar.equals("<")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals(">")) {
                    temp[i][j] = "^";
                } else if(oldChar.equals("^")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = "<";
                } else if(oldChar.equals("|")) {
                    temp[i][j] = "-";
                } else if(oldChar.equals("-")) {
                    temp[i][j] = "|";
                } else {
                    temp[i][j] = oldChar;
                }
            }
        }
        return temp;
    }








}
