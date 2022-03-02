package com.snail.mineswap;



import javax.swing.*;

public class Main {
    public static Point[][] map = new Point[12][12];

    public static void main(String[] args) {
        JFrame window1=new JFrame("扫雷");
    }



    public static void initMap(){
        int x = ((map.length-2) * (map[0].length-2)) / 10; //表示一个地图的地雷数量
        int y=(map.length-2)*(map[0].length-2); //表示一个地图中还没开始判定的格子数
        boolean full=false;
        for (int i = 0; i < map.length; i++) {
            for(int j=0; j<map[0].length; j++){
                Point lattice=new Point();
                map[i][j]=lattice;}}
        for (int i = 1; i < map.length-1; i++) {
            if(x==0)
                full=true;
            for(int j=1; j<map[0].length-1; j++){
                if(y <= x && !full){
                    map[i][j].setLei();x--;}
                if(y > x && (int)(Math.random()*10+1) > 9 && !full){
                    map[i][j].setLei();x--;}
                y--;}}
        for(int i = 1; i < map.length-1;i++) {
            for (int j = 1; j < map[0].length-1; j++) {
                if(map[i][j].checkLei()){
                    for(int k=i-1;k<i+2;k++){
                        for(int m=j-1;m<j+2;m++){
                            map[k][m].addnum();}}}}}
        for (int i = 1; i < map.length-1; i++) {
            for(int j=1; j<map[0].length-1; j++){
                System.out.print(map[i][j].getNum());
                System.out.print(" ");
            }
            System.out.println();}
    }
}