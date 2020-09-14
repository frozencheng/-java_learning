package Hongbao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 1.具有发红包的方法
 * 发红包的逻辑:
 * 设置红包金额
 * 设置红包人数
 * 红包属性:固定值/随机值
 * 发红包的人 发的金额不能大于自己的余额;
 * 2.具有收红包的方法
 * 接收红包的人 自己的余额要增加
 */
public class Member {
    private double money;
    private String name;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(double money, String name) {
        this.money = money;
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 展示个人信息
    public void show() {
        System.out.println("姓名:" + getName() + "余额:" + getMoney());

    }

    /* 发红包 创建一个红包类的实例 的方法*/
    public Hongbao send() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入红包金额:");
        boolean flag = true;
        double smoney = scanner.nextDouble();
        while (flag) {
            if (smoney > this.money && smoney > 0) {
                System.out.println("金额输入错误!请重新输入");
                smoney = scanner.nextDouble();
            } else {
                this.money -= smoney;
                flag = false;
            }
        }
        System.out.print("输入红包个数:");
        int num = scanner.nextInt();
        System.out.print("输入红包类型: 1 固定红包金额 2随机红包金额    ");
        int type = scanner.nextInt();
        return new Hongbao(smoney, num, type);
    }

    //抢红包
    public void receive(ArrayList<Double> list) {
        if (list.size() == 0) {//判断红包是否为空 红包空了 就是抢完了
            System.out.println("红包都抢完了,还点个锤子");
        } else {
            Random ra = new Random();
            int i = ra.nextInt(list.size());
            double money = list.get(i);
            System.out.println("恭喜" + name + money + "元");
            this.money += money;
            list.remove(i);
        }


    }


}
