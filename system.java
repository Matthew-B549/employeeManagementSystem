import java.util.Scanner;

class Date {
    private int month;
    private int day;
    private int year;

    public Date() {
        this.month = 1;
        this.day = 1;
        this.year = 1970;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}

class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date dateOfHire;
    private Date terminationDate;
    private int vacationDaysLeft;
    private int scheduledVacationDays;
    private String lastAnnualReview;

    private static int employeeCounter = 0;

    public Employee() {
        this.employeeID = 0;
        this.firstName = "";
        this.lastName = "";
        this.fullName = "";
        this.dateOfHire = new Date();
        this.terminationDate = null;
        this.vacationDaysLeft = 0;
        this.scheduledVacationDays = 0;
        this.lastAnnualReview = "";
        employeeCounter++;
    }

    public Employee(int employeeID, String firstName, String lastName, Date dateOfHire, int vacationDaysLeft, String lastAnnualReview) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.dateOfHire = dateOfHire;
        this.terminationDate = null;
        this.vacationDaysLeft = vacationDaysLeft;
        this.scheduledVacationDays = 0;
        this.lastAnnualReview = lastAnnualReview;
        employeeCounter++;
    }

    public int getEmployeeID() {return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Date getDateOfHire() { return dateOfHire; }
    public void setDateOfHire(Date dateOfHire) { this.dateOfHire = dateOfHire; }

    public Date getTerminationDate() { return terminationDate; }
    public void setTerminationDate(Date terminationDate) { this.terminationDate = terminationDate; }

    public int getVacationDaysLeft() { return vacationDaysLeft; }
    public void setVacationDaysLeft(int vacationDaysLeft) { this.vacationDaysLeft = vacationDaysLeft; }

    public int getScheduledVacationDays() { return scheduledVacationDays; }
    public void setScheduledVacationDays(int scheduledVacationDays) { this.scheduledVacationDays = scheduledVacationDays; }

    public String getLastAnnualReview() { return lastAnnualReview; }
    public void setLastAnnualReview(String lastAnnualReview) { this.lastAnnualReview = lastAnnualReview; }

    public static int getEmployeeCounter() { return employeeCounter; }

    public void scheduleVacationDay(int days) {
        if (vacationDaysLeft >= days) {
            vacationDaysLeft -= days;
            scheduledVacationDays += days;
        } else {
            System.out.println("Not enough vacation days left to schedule.");
        }
    }

    public void cancelVacationDay(int days) {
        if (scheduledVacationDays >= days) {
            scheduledVacationDays -= days;
            vacationDaysLeft += days;
        } else {
            System.out.println("Not enough scheduled vacation days to cancel.");
        }
    }

    public void terminateEmployee(Date terminationDate) {
        this.terminationDate = terminationDate;
        employeeCounter--;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", employeeID=" + employeeID +
                ", dateOfHire=" + dateOfHire +
                ", terminationDate=" + (terminationDate == null ? "N/A" : terminationDate) +
                ", vacationDaysLeft=" + vacationDaysLeft +
                ", scheduledVacationDays=" + scheduledVacationDays +
                ", lastAnnualReview='" + lastAnnualReview + '\'' +
                '}';
    }
}

class Manager {
    private int managerBranchID;
    private String firstName;
    private String lastName;
    private String fullName;

    public Manager() {
        this.managerBranchID = 0;
        this.firstName = "";
        this.lastName = "";
        this.fullName = "";
    }

    public Manager(int managerBranchID, String firstName, String lastName) {
        this.managerBranchID = managerBranchID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public int getManagerBranchID() { return managerBranchID; }
    public void setManagerBranchID(int managerBranchID) { this.managerBranchID = managerBranchID; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @Override
    public String toString() {
        return "Manager{" +
                "fullName='" + fullName + '\'' +
                ", managerBranchID=" + managerBranchID +
                '}';
    }
}

class Branch {
    private int BranchID;
    private String location;
    private String address;
    private Manager supervisor;
    private byte branchEmployeesCounter = 0;

    private Employee[] branchEmployees;

    public Branch() {
        this.BranchID = 0;
        this.location = "";
        this.address = "";
    }

    public Branch(int BranchID, String location, String address, Manager supervisor, byte numberOfEmployeesInBranch) {
        this.BranchID = BranchID;
        this.location = location;
        this.address = address;
        this.supervisor = supervisor;
        this.branchEmployees = new Employee[numberOfEmployeesInBranch];
    }

    public int getBranchID() { return BranchID; }
    public void setBranchID(int BranchID) { this.BranchID = BranchID; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Manager getSupervisor() { return supervisor; }
    public void setSupervisor(Manager supervisor) { this.supervisor = supervisor; }

    public Employee[] getBranchEmployees() { return branchEmployees; }
    public void setBranchEmployees(Employee[] branchEmployees) { this.branchEmployees = branchEmployees; }

    public void addToTeam(Employee employee) {
        if (branchEmployeesCounter < branchEmployees.length) {
            branchEmployees[branchEmployeesCounter++] = employee;
        }
    }

    @Override
    public String toString() {
        return "Branch{" +
                "BranchID=" + BranchID +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", supervisor=" + (supervisor == null ? "N/A" : supervisor.getFullName()) +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("The three branch locations are Chicago Illinois, Columbus Ohio, and Indianapolis Indiana. The branch ID's are as follows in the same order as previously given: 6000, 4300, and 4600.");
        System.out.println("How many employees do you want per branch (recommendation of 3-4 for each of the 3 branches.)");
        byte n = input.nextByte();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = createEmployee(input);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("How many vacation days would you like to schedule for " + employees[i].getFullName() + "?");
            int daysToSchedule = input.nextInt();
            employees[i].scheduleVacationDay(daysToSchedule);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("How many vacation days would you like to cancel for " + employees[i].getFullName() + "?");
            int daysToCancel = input.nextInt();
            employees[i].cancelVacationDay(daysToCancel);
        }

        System.out.println("Enter the number (1-" + n + ") of the employee you want to terminate:");
        int terminateIndex = input.nextInt() - 1;
        String terminatedEmployeeName = employees[terminateIndex].getFullName();
        System.out.println("Enter termination date (MM DD YYYY):");
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        Date terminationDate = new Date(month, day, year);
        employees[terminateIndex].terminateEmployee(terminationDate);

        System.out.println("Terminated Employee: " + terminatedEmployeeName);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("There are " + Employee.getEmployeeCounter() + " employees.");
    }

    private static Employee createEmployee(Scanner input) {
        System.out.println("Enter first name:");
        String firstName = input.next();
        System.out.println("Enter last name:");
        String lastName = input.next();
        System.out.println("Enter employee ID");
        int employeeID = input.nextInt();
        System.out.println("Enter date of hire (MM DD YYYY):");
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        Date dateOfHire = new Date(month, day, year);
        System.out.println("Enter number of vacation days left:");
        int vacationDaysLeft = input.nextInt();
        input.nextLine();
        System.out.println("Enter last annual review:");
        String lastAnnualReview = input.nextLine();

        return new Employee(employeeID, firstName, lastName, dateOfHire, vacationDaysLeft, lastAnnualReview);
    }
}
