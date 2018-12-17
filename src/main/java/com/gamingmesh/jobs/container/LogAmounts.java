package com.gamingmesh.jobs.container;

import java.util.HashMap;
import java.util.Map.Entry;

public final class LogAmounts {

    private String username;
    private String action;

    private String item;
    private int count = 0;

    private HashMap<CurrencyType, Double> amounts = new HashMap<>();

    private boolean newEntry = true;

    public LogAmounts(String item) {
	this.item = item;
    }

    public boolean isNewEntry() {
	return newEntry;
    }

    public void setNewEntry(boolean newEntry) {
	this.newEntry = newEntry;
    }

    public String getItemName() {
	return item;
    }

    public void add(HashMap<CurrencyType, Double> amounts) {
	for (Entry<CurrencyType, Double> one : amounts.entrySet()) {
	    add(one.getKey(), one.getValue());
	}
    }

    public void add(CurrencyType type, Double amount) {
	if (amount == null)
	    return;
	Double a = amounts.get(type);
	if (a == null)
	    a = 0D;
	amounts.put(type, a + amount);
    }

    public Double get(CurrencyType type) {
	Double a = amounts.get(type);
	if (a == null)
	    a = 0D;
	return ((int) (a * 100D)) / 100D;
    }

    public void addCount() {
	this.count++;
    }

    public int getCount() {
	return count;
    }

    public void setCount(int count) {
	this.count = count;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getUsername() {
	return username;
    }

    public void setAction(String action) {
	this.action = action;
    }

    public String getAction() {
	return action;
    }

}