package com.mph.model;

import java.io.Serializable;

public class Salary implements Serializable {
	private int basic;
	private int da;
	private int hra;
	private int pf;
	private int grossSalary;
	private int netSalary;
	public int getBasic() {
        return basic;
    }
    public void setBasic(int basic) {
        this.basic = basic;
    }
    public int getDa() {
        return da;
    }
    public void setDa(int basic) {
        this.da = basic * 50 / 100;
    }
    public int getHra() {
        return hra;
    }
    public void setHra(int basic) {
        this.hra = basic * 40 / 100;
    }
    public int getPf() {
        return pf;
    }
    public void setPf(int basic) {
        this.pf = basic * 10 / 100;
    }
    public int getGrossSalary() {
        return grossSalary;
    }
    public void setGrossSalary() {
        this.grossSalary = basic + da + hra + pf;
    }
    public int getNetSalary() {
        return netSalary;
    }
    public void setNetSalary() {
        this.netSalary = grossSalary - pf;
    }
	@Override
	public String toString() {
		return  "Salary Basic \t\t" + basic + "\n" +
				"Salary Da \t\t" + da + "\n" +
				"Salary Hra \t\t" + hra + "\n" +
				"Salary Pf \t\t" + pf + "\n" +
				"GrossSalary \t\t" + grossSalary +"\n" +
				"NetSalary \t\t" + netSalary ;
	}

}
