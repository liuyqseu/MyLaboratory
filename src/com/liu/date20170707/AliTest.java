package com.liu.date20170707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 阿里研发工程师JAVA(应届)校招笔试题
 * Created by Herry on 2017/7/7.
 *
 * 测试用例输入数据：(id, pId, cost)
 * 1, 0, 2
 * 2, 1, 3
 * 3, 1, 2
 * 4, 0, 3
 *
 * 这些节点构成的森林如下图所示：
 * ——————————————————————————————————————————————————————————————————
 *
 *                 (1, 0, 2)                   (4, 0, 3)
 *                _____|_____
 *               |           |
 *          (2, 1, 3)     (3, 1, 2)
 *
 * ——————————————————————————————————————————————————————————————————
 */
public class AliTest {

    public static void main(String[] args) {
        // 待输入list
        ArrayList<Integer> idList = new ArrayList<>();
        ArrayList<Integer> pIdList = new ArrayList<>();
        ArrayList<Integer> costList = new ArrayList<>();

        // 手动构造测试数据
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);

        pIdList.add(0);
        pIdList.add(1);
        pIdList.add(1);
        pIdList.add(0);

        costList.add(2);
        costList.add(3);
        costList.add(2);
        costList.add(3);

        int get = resolve(idList, pIdList, costList);
        System.out.println(get);
    }

    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for(int i = 0; i < ids.size(); i++) {
            Node node = new Node();
            node.setId(ids.get(i));
            node.setParentId(parents.get(i));
            node.setCost(costs.get(i));
            node.setIsleaf(1);
            if(nodeMap.containsKey(parents.get(i))) {
                Node pNode = nodeMap.get(parents.get(i));
                pNode.setIsleaf(0);
                nodeMap.put(parents.get(i), pNode);
            }
            nodeMap.put(ids.get(i), node);
        }

        List<Integer> costList = nodeMap.values()
                .stream()
                .filter(node -> node.getIsleaf() == 1)
                .map(node -> {
                    int myCost = node.getCost();

                    int pId = node.getParentId();
                    while(pId != 0) {
                        Node pNode = nodeMap.get(pId);
                        myCost += pNode.getCost();
                        pId = pNode.getParentId();
                    }
                    return myCost;
                }).collect(Collectors.toList());

        return costList.stream().max((h1, h2) -> h1.compareTo(h2)).get();

    }

    // 树节点
    static class Node {
        private int id; //id
        private int parentId; // 父id
        private int cost; // 耗费
        private int isleaf; // 是否为叶节点，1表示是叶节点，0表示不是叶节点

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getIsleaf() {
            return isleaf;
        }

        public void setIsleaf(int isleaf) {
            this.isleaf = isleaf;
        }
    }

}
