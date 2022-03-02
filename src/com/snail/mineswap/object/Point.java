package com.snail.mineswap.object;

public class Point
{
    int num;
    boolean lei;
    boolean knock;

public Point(){
    num=0;
    lei=false;
    knock=false;}
public void setLei(){
    lei=true; knock=true;num=-1;}
public void addnum(){
    if(!knock)
    num++;}
public int getNum(){
    return num;}
public boolean checkLei(){
    return lei;}
}
