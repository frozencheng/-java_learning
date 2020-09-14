package Hongbao;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* 用 两种构造方法 创造 3个Member 实例*/
        Member xiaoming = new Member();
        xiaoming.setMoney(1000);
        xiaoming.setName("小明");
        Member xiaohong = new Member("小红");
        Member zhangsan = new Member("张三");
        Member lisi = new Member("李四");
        Member laoba = new Member("老八");

        // 显而易见 就小明设置了金额 所以 小明这个冤大头就该发红包
        Hongbao hongbao = xiaoming.send();
        ArrayList<Double> list = hongbao.sendMoney();
        System.out.println("=======================");

        // 开始抢红包!
        xiaoming.receive(list);
        xiaohong.receive(list);
        zhangsan.receive(list);
        lisi.receive(list);
        laoba.receive(list);
        System.out.println("=================");

        //看看个人 余额情况
        xiaoming.show();
        xiaohong.show();
        zhangsan.show();
        lisi.show();
        laoba.show();


    }
}
