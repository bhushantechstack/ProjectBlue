package com.testing.projectblue.test;

public class SortingTest implements Comparable<SortingTest> {

    private int empId;
    private String employeeName;
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "SortingTest [empId=" + empId + ", employeeName=" + employeeName + "]";
    }
    @Override
    public int compareTo(SortingTest o) {
        return this.employeeName.compareTo(o.employeeName);
    }
    

}
