package com.liu.date20180312;

import java.util.Scanner;

/**
 * Created by Herry on 2018/3/12.
 * 说明： 科大讯飞第三题笔试题。
 * 完善： 2018年3月13日09:27:24
 *
 */
public class Inter3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int n = Integer.parseInt(scanner.nextLine());
            String[][] input = new String[n][n];
            for(int i = 0; i < n; i ++) {
                char[] inputChars = scanner.nextLine().toCharArray();
                for(int j = 0; j < inputChars.length; j ++) {
                    input[i][j] = String.valueOf(inputChars[j]);
                }
            }

            //获取指令，并执行相应操作
            String[] orders = scanner.nextLine().split(" ");
            for(String order : orders) {
                switch(order) {
                    case "<":
                        input = turnLeft(input);
                        break;
                    case ">":
                        input = turnRight(input);
                        break;
                    case "|":
                        input = flipVertical(input);
                        break;
                    case "-":
                        input = flipHorizontal(input);
                        break;
                    case "\\":
                        input = turnDiagonalt(input);
                        break;
                    case "/":
                        input = turnAntiDiagonalt(input);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(input[i][j]);
                }
                System.out.println();
            }
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
                oldChar = input[length - 1 - j][i];
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
            for (int j = 0; j < length; j++) {
                oldChar = input[length - 1 - i][j];

                if(oldChar.equals("^")) {
                    temp[i][j] = "v";
                } else if(oldChar.equals("v")) {
                    temp[i][j] = "^";
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

    //沿垂直方向翻转
    public static String[][] flipVertical(String[][] input) {
        int length = input.length;
        String[][] temp = new String[length][length];

        String oldChar = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                oldChar = input[i][length - 1 - j];
                if(oldChar.equals(">")) {
                    temp[i][j] = "<";
                } else if(oldChar.equals("<")) {
                    temp[i][j] = ">";
                } else if(oldChar.equals("\\")) {
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
                oldChar = input[length - 1 - j][length - 1 - i];
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
