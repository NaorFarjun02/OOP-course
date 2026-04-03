package manageWorkSpace;

/**
 * Represents a manager employee in the workspace management system.
 * <p>
 * A {@code Manager} extends {@link Employee} and adds the department
 * that this manager is responsible for.
 * </p>
 *
 * <p><b>Note:</b> {@link #equals(Manager)} takes a {@code Manager} parameter instead of {@code Object},
 * so it does <em>not</em> override {@link Object#equals(Object)} — only overloads it.
 * Polymorphic equality checks through {@code Object} will not behave as expected.</p>
 */
public class Manager extends Employee {

    /** The department managed by this manager. */
    String department;

    /**
     * Constructs a {@code Manager} with the specified name, salary, and department.
     *
     * @param name       the full name of the manager
     * @param salary     the salary of the manager
     * @param department the department this manager is responsible for
     */
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.setDepartment(department);
    }

    /**
     * Sets the department of this manager.
     *
     * @param department the department name to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns the department managed by this manager.
     *
     * @return the department name
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Checks equality between this manager and another {@code Manager}.
     * Two managers are considered equal if they share the same employee ID
     * (via {@link Employee#equals(Employee)}) and manage the same department.
     *
     * <p><b>Note:</b> This method takes a {@code Manager} parameter instead of {@code Object},
     * so it overloads rather than overrides {@link Object#equals(Object)}.</p>
     *
     * @param manager the manager to compare with
     * @return {@code true} if both managers have the same ID and department; {@code false} otherwise
     */
    public boolean equals(Manager manager) {
        return super.equals(manager) && this.getDepartment().equals(manager.getDepartment());
    }

    /**
     * Returns a string representation of this manager in the format:
     * <pre>Manager [ID=id, Name=name, Salary=salary, Department=department]</pre>
     *
     * @return a formatted string describing this manager
     */
    public String toString() {
        return "Manager " + super.toString() + ", Department=" + this.getDepartment() + "]";
    }
}