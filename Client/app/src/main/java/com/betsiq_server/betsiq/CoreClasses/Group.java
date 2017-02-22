package com.betsiq_server.betsiq.CoreClasses;

import java.util.Date;

/**
 * Created by Jacob on 22/02/2017.
 */

public class Group implements Comparable<Group>{

    private String id;
    private String Name;
    private int EntryFee;
    private Date Start;
    private String End;
    private int Prize;
    private int Winners;

    public Group (String name, int entry, Date start, String end, int prize, int winners){
        this.id = null;
        this.Name = name;
        this.EntryFee = entry;
        this.Start = start;
        this.End = end;
        this.Prize = prize;
        this.Winners = winners;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEntryFee() {
        return EntryFee;
    }

    public void setEntryFee(int entryFee) {
        EntryFee = entryFee;
    }

    public Date getStart() {
        return Start;
    }

    public void setStart(Date start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public int getPrize() {
        return Prize;
    }

    public void setPrize(int prize) {
        Prize = prize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWinners() {
        return Winners;
    }

    public void setWinners(int winners) {
        Winners = winners;
    }

    @Override
    public int compareTo(Group o) {
        int a = this.getEntryFee();
        int b = o.getEntryFee();
        return a < b ? -1
                : a > b ? 1
                : 0;
    }
}
