package com.example.nbatabs2;

import android.graphics.drawable.Drawable;

class Player {
    String name;
    int salary;
    int age;
    boolean checked;
    String team;
    int TeamIcon;
    int offset;
    int iconPos;

    public Player(String name,int salary,int age,boolean checked,String team,int TeamIcon,int iconPos){
        this.name=name;
        this.salary=salary;
        this.age=age;
        this.checked=checked;
        this.team=team;
        this.TeamIcon = TeamIcon;
        this.offset=0;
        this.iconPos= iconPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public String getTeam(){return team;}
    public void setTeam(String team){this.team=team;}
    public void setOffset(int _offset){
        if(_offset>2){_offset = 0;}
        this.offset=_offset;}
    public int getOffset(){return offset;}
    public int getIconPos(){return iconPos;}
    public void setIconPos(int IconPos)
    {this.iconPos=IconPos; }
    public int getTeamIcon(){return TeamIcon;}
    public void setTeamIcon(int tIcon){this.TeamIcon=tIcon;}

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }

    @Override
    public String toString(){
        return name+salary+age;
    }
}
