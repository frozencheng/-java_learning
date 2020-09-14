package Hongbao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Hongbao {
    private final int num;
    private final int type;
    private double money;

    public Hongbao(double money, int num, int type) {
        this.money = money;
        this.num = num;
        this.type = type;

    }

    public ArrayList<Double> sendMoney() {
        //创建红包类的实例
        ArrayList<Double> list = new ArrayList<>();
        //调用发红包的方法
        // 判断设定红包的模式
        if (1 == type) {
            System.out.println("固定红包");
            // 固定红包 平均分 clear:将浮点数保留后两位的方法
//            System.out.println(money);
//            System.out.println(num);
            double yuan = money / num;
//            System.out.println(yuan);
            yuan = clear(yuan);
            for (int i = 0; i < num; i++) {
                if (i == num - 1) {
                    list.add(num - 1, money - yuan * (num - 1));
                } else {
                    list.add(i, yuan);

                }
            }
        }
        //float b = new Random().nextFloat();生成随机浮点数
        //需要一个方法进行数据清洗 将浮点数 保留后两位.
        else {
            System.out.println("随机红包");
            //使用 random
            Random random = new Random();


            double rest;
            for (int i = 0; i < num; i++) {
                // 随机数 乘以 金额数 就是随机一个小于金额数的值
                if (i != num - 1) {
                    rest = random.nextDouble() * money;
                    rest = clear(rest);
                    System.out.println(rest);
                    list.add(i, rest);
                    money = (double) Math.round((money - rest) * 100) / 100;
                }
                // 如果 剩下最后一位 直接将余额 赋值给最后一位
                else {
                    System.out.println(money);
                    list.add(num - 1, money);
                }
            }
        }
        return list;
    }

     /**定义一个 除法去小数点后两位的方法
    java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
    df.format(你要格式化的数字);

    例：new java.text.DecimalFormat("#.00").format(3.1415926)

    #.00 表示两位小数 #.0000四位小数 以此类推...
    改成数据清洗 保留后两位的浮点数
      */
    public double clear(double num) {
//        System.out.println(num);
        DecimalFormat df = new DecimalFormat("#.00");
        String sum = df.format(num);
//        System.out.println(sum);

        return Double.parseDouble(sum);
    }
}
