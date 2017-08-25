package com.liu.date20170825;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 阿里校招笔试题 第二题
 * Created by Herry on 2017/8/25.
 */
public class OptimizeLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5], 0));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();

        //规则1
        for(int i =0; i < lineList.size(); i ++) {
            UnilateralLine unilateralLine = lineList.get(i);
            String sCen = unilateralLine.getSCen();
            String eCen = unilateralLine.getECen();
            int flag = unilateralLine.getFlag();
            for(int j =0; j < lineList.size(); j ++) {
                UnilateralLine unilateralLine2 = lineList.get(j);
                String sCen2 = unilateralLine2.getSCen();
                String eCen2 = unilateralLine2.getECen();
                int flag2 = unilateralLine2.getFlag();
                if(flag2 == 0 && sCen2.equals(eCen) && eCen2.equals(sCen)) {
                    String outString = "rule1:" + unilateralLine.getId() + "+" + unilateralLine2.getId();
                    result.add(outString);
                    unilateralLine.setFlag(1);
                    unilateralLine2.setFlag(1);
                    break;
                }
            }
        }

        //规则2
        for(int i =0; i < lineList.size(); i ++) {
            UnilateralLine unilateralLine = lineList.get(i);
            String sCen = unilateralLine.getSCen();
            String eCen = unilateralLine.getECen();
            int flag = unilateralLine.getFlag();
            for(int j =0; j < lineList.size(); j ++) {
                UnilateralLine unilateralLine2 = lineList.get(j);
                String sCen2 = unilateralLine2.getSCen();
                String eCen2 = unilateralLine2.getECen();
                int flag2 = unilateralLine2.getFlag();
                if(flag == 0 && flag2 == 0 && eCen.equals(sCen2)) {
                    for(int k =0; k < lineList.size(); k ++) {
                        UnilateralLine unilateralLine3 = lineList.get(k);
                        String sCen3 = unilateralLine3.getSCen();
                        String eCen3 = unilateralLine3.getECen();
                        int flag3 = unilateralLine3.getFlag();
                        if(flag3 == 0 && eCen2.equals(sCen3) && eCen3.equals(sCen)) {
                            String outString = "rule2:" + unilateralLine.getId() + "+" + unilateralLine2.getId() + "+" + unilateralLine3.getId();
                            result.add(outString);
                            unilateralLine.setFlag(1);
                            unilateralLine2.setFlag(1);
                            unilateralLine3.setFlag(1);
                            break;
                        }
                    }
                }
            }
        }

        //规则3
        for(int i =0; i < lineList.size(); i ++) {
            UnilateralLine unilateralLine = lineList.get(i);
            String sCen = unilateralLine.getSCen();
            String ePro = unilateralLine.getEPro();
            int flag = unilateralLine.getFlag();
            for(int j =0; j < lineList.size(); j ++) {
                UnilateralLine unilateralLine2 = lineList.get(j);
                String eCen2 = unilateralLine2.getECen();
                String sPro2 = unilateralLine2.getSPro();
                int flag2 = unilateralLine2.getFlag();
                if(flag2 == 0 && eCen2.equals(sCen) && ePro.equals(sPro2)) {
                    String outString = "rule3:" + unilateralLine.getId() + "+" + unilateralLine2.getId();
                    result.add(outString);
                    unilateralLine.setFlag(1);
                    unilateralLine2.setFlag(1);
                    break;
                }
            }
        }
        return result;
    }

    // 静态内部类
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        private String tType;//车型  //9.6m/17.5m
        private int flag;
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType, int flag) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
            this.flag = flag;
        }
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
        public int getFlag() {return flag;}
        public void setFlag(int flag) {this.flag = flag;}
    }

}
