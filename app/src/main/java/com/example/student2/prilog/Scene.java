package com.example.student2.prilog;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Мария on 22.01.2017.
 */
public class Scene {
    public Fight fight;
    public LinkedList<String> text=new LinkedList<>();
    public Proverka[] choices;
    public Scene(String s){
        File f=new File(s);
        try{
            Scanner sc=new Scanner(f);
            sc.nextLine();
            String ns=sc.nextLine();
            if(ns.equals("no"))this.fight=null;
            else this.fight=new Fight(ns);
            this.choices=new Proverka[sc.nextInt()];
            ns=sc.nextLine();
            for(int i=0;i<this.choices.length;i++)
                this.choices[i]=new Proverka(sc.nextLine());
            while (sc.hasNextLine())this.text.add(sc.nextLine());
            sc.close();
        }
        catch (Exception e){
            System.out.println("YEE"+e);
        }
    }
    public void show(){
        //this.fight.show();
        for(Proverka proverka:this.choices)proverka.show();
        for(String s:this.text) System.out.println(s);
    }
    public int listen(Player player,Trans trans,int x){
        if(this.fight!=null)fight.fight(player,trans);
        if(player.hp<=0)return -1;
        for(String s:this.text) System.out.println(s);
        return this.choices[x-1].proverka(player);
    }
}
