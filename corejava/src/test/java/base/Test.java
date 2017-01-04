package base;

import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.System.out;

/**
 * Created by YZhi on 2016/9/21.
 */
public class Test {
    public final static String c = "";
    public static String b;

    static {
        System.out.println("static block");
    }

    public final String a = "";
    private String name;
    private double salary;
    private Date hireDay;

    {
        b = "block";
    }

    public Test(String name) {
        this.name = name;
    }

    public Test(double salary, String name) {
        this(name);
        this.salary = salary;

    }

    public Test(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public static void main(String[] args) {
        double x = 1;
        tripleValue(x);
        System.out.println(x);//1.0

        out.println("static import");

    }

    public static void tripleValue(double x) {
        x = 3 * x;
    }

    public static void methodName() {

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}