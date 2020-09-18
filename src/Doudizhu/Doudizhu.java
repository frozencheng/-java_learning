package Doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Doudizhu {
    public static void main(String[] args) {
        //扑克牌的花色的集合
        List<String> color = List.of("♠", "♥", "♣", "♦");
        //扑克牌的牌号的集合
        List<String> numbers = List.of("2", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2");
        //扑克牌的序号的集合
        ArrayList<Integer> pokerindex = new ArrayList<>();
        //创建扑克牌的集合 key:序号,value:牌号
        HashMap<Integer, String> poker = new HashMap<>();
        int index = 0;
        poker.put(index, "大王");
        pokerindex.add(index);
        index++;
        poker.put(index, "小王");
        pokerindex.add(index);
        index++;

        //利用循环嵌套 构建 54张扑克牌
        for (String i : numbers) {
            for (String j : color) {
                poker.put(index, j + i);
                pokerindex.add(index);
                index++;

            }
        }

        //对存储有扑克牌序号的集合进行洗牌
        Collections.shuffle(pokerindex);

        //对三个玩家进行发牌 创造四个集合分别为 玩家1..3和底牌的集合
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> rest = new ArrayList<>();
        int res = 54;

        //进行发牌
        for (int s : pokerindex) {
            if (res % 3 == 0 && res > 3) {
                player1.add(s);
                res--;
            } else if (res % 3 == 1 && res > 3) {
                player2.add(s);
                res--;
            } else if (res % 3 == 2 && res > 3) {
                player3.add(s);
                res--;
            } else {
                rest.add(s);

            }
        }
        //分别对玩家和底牌集合进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(rest);

        //看牌 创建一个方法
        show("玩家1", player1, poker);
        show("玩家2", player2, poker);
        show("玩家3", player3, poker);
        show("底牌", rest, poker);


    }

    public static void show(String name, ArrayList<Integer> list, HashMap<Integer, String> map) {
        System.out.print(name + "的牌是:");
        for (int i : list) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }
}
