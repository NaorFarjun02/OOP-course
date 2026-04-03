package manageWorkSpace;

/**
 * Represents an employee in the workspace management system.
 * <p>
 * Each employee is automatically assigned a unique ID using a shared static counter,
 * starting from {@code 0}. This class serves as the base class for
 * {@link Developer} and {@link Manager}.
 * </p>
 *
 * <p><b>Note:</b> Fields {@code name} and {@code salary} are package-private instead of {@code private}.</p>
 * <p><b>Note:</b> The static counter field has a typo: {@code employeeCouner} instead of {@code employeeCounter}.</p>
 * <p><b>Note:</b> {@link #equals(Employee)} takes an {@code Employee} parameter instead of {@code Object},
 * so it does <em>not</em> override {@link Object#equals(Object)} — only overloads it.
 * Polymorphic equality checks through {@code Object} will not behave as expected.</p>
 */
public class Employee {

    /** Shared counter used to auto-generate unique employee IDs. Starts at {@code 0}. Note: contains a typo in the source. */
    private static int employeeCouner = 0;

    /** The unique ID assigned to this employee upon creation. */
    private final int id;

    /** The name of this employee. */
    String name;

    /** The salary of this employee. */
    double salary;

    /**
     * Constructs an {@code Employee} with the specified name and salary.
     * Automatically assigns a unique ID.
     *
     * @param name   the full name of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, double salary) {
        this.id = employeeCouner++;
        this.setName(name);
        this.setSalary(salary);
    }

    /**
     * Checks equality between this employee and another {@code Employee} by comparing their IDs.
     *
     * <p><b>Note:</b> This method takes an {@code Employee} parameter instead of {@code Object},
     * so it overloads rather than overrides {@link Object#equals(Object)}.</p>
     *
     * @param employee the employee to compare with
     * @return {@code true} if both employees share the same ID; {@code false} otherwise
     */
    public boolean equals(Employee employee) {
        return this.id == employee.id;
    }

    /**
     * Returns the unique ID of this employee.
     *
     * @return the employee ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of this employee.
     *
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the salary of this employee.
     *
     * @return the employee's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the name of this employee.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the salary of this employee.
     *
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a partial string representation of this employee in the format:
     * <pre>[ID=id, Name=name, Salary=salary</pre>
     * Note: the closing {@code ]} bracket is intentionally omitted,
     * as subclasses are expected to append additional fields before closing.
     *
     * @return a partial formatted string describing this employee
     */
    public String toString() {
        return "[ID=" + this.getId() + ", Name=" + this.getName() + ", Salary=" + this.getSalary();
    }
}