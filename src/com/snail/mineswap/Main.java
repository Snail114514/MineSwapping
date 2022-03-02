package com.snail.mineswap;



import com.snail.mineswap.object.Point;

import javax.swing.*;

public class Main {

    public static Point[][] map = new Point[12][12];

    public static int mineNum = ((map.length-2) * (map[0].length-2)) / 10; //表示一个地图的地雷数量
    public static int gridNum=(map.length-2)*(map[0].length-2); //表示一个地图中还没开始判定的格子数

    public static void main(String[] args) {
        initMap();
        showMine();
        JFrame window1=new JFrame("扫雷");
    }



    public static void initMap(){
        //遍历创建point
        for (int i = 0; i < map.length; i++) {
            for(int j=0; j<map[0].length; j++){
                Point lattice=new Point();
                map[i][j]=lattice;
            }
        }
        setMine();
        setNumber();
    }

    public static void setNumber(){
        //检查地雷，设置数字
        for(int i = 1; i < map.length-1;i++) {
            for (int j = 1; j < map[0].length-1; j++) {
                if(map[i][j].checkLei()){
                    for(int k=i-1;k<i+2;k++){
                        for(int m=j-1;m<j+2;m++){
                            map[k][m].addnum();
                        }
                    }
                }
            }
        }
    }


    public static void setMine(){
        boolean full=false;
        //安装地雷
        for (int i = 1; i < map.length-1; i++) {
            if(mineNum==0)
                full=true;
            for(int j=1; j<map[0].length-1; j++){
                if(gridNum <= mineNum && !full){
                    map[i][j].setLei();mineNum--;
                }
                if(gridNum > mineNum && (int)(Math.random()*10+1) > 9 && !full){
                    map[i][j].setLei();mineNum--;
                }
                gridNum--;
            }
        }
    }

    public static void showMine() {
        //展示
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                System.out.print(map[i][j].getNum());
                System.out.print(" ");
            }
            System.out.println();

        }
    }
}