package Entities;

public class Employee {

    private int id;
    private String name;
    private Double salary;


    public Employee(int id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public Double getSalary(){
        return this.salary;
    }

    public void increaseSalary(Double percentage){
        this.salary = salary * (1 + (percentage / 100));
    }

    @Override
    public String toString(){
        return this.id + ", " + this.name + ", " + String.format("%.2f", this.salary);
    }
}