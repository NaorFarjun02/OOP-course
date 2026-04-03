package manageWorkSpace;

/**
 * Represents a developer employee in the workspace management system.
 * <p>
 * A {@code Developer} extends {@link Employee} and adds the primary programming
 * language used by this developer.
 * </p>
 *
 * <p><b>Note:</b> {@link #equals(Developer)} takes a {@code Developer} parameter instead of {@code Object},
 * so it does <em>not</em> override {@link Object#equals(Object)} — only overloads it.
 * Polymorphic equality checks through {@code Object} will not behave as expected.</p>
 */
public class Developer extends Employee {

    /** The primary development (programming) language used by this developer. */
    String devLanguage;//development language

    /**
     * Constructs a {@code Developer} with the specified name, salary, and programming language.
     *
     * @param name        the full name of the developer
     * @param salary      the salary of the developer
     * @param devLanguage the primary programming language of the developer
     */
    public Developer(String name, double salary, String devLanguage) {
        super(name, salary);
        this.setDevLanguage(devLanguage);
    }

    /**
     * Sets the primary programming language of this developer.
     *
     * @param devLanguage the programming language to set
     */
    public void setDevLanguage(String devLanguage) {
        this.devLanguage = devLanguage;
    }

    /**
     * Returns the primary programming language of this developer.
     *
     * @return the developer's programming language
     */
    public String getDevLanguage() {
        return devLanguage;
    }

    /**
     * Checks equality between this developer and another {@code Developer}.
     * Two developers are considered equal if they share the same employee ID
     * (via {@link Employee#equals(Employee)}) and use the same programming language.
     *
     * <p><b>Note:</b> This method takes a {@code Developer} parameter instead of {@code Object},
     * so it overloads rather than overrides {@link Object#equals(Object)}.</p>
     *
     * @param developer the developer to compare with
     * @return {@code true} if both developers have the same ID and programming language; {@code false} otherwise
     */
    public boolean equals(Developer developer) {
        return super.equals(developer) && this.getDevLanguage().equals(developer.getDevLanguage());
    }

    /**
     * Returns a string representation of this developer in the format:
     * <pre>Developer [ID=id, Name=name, Salary=salary, Language=language]</pre>
     *
     * @return a formatted string describing this developer
     */
    public String toString() {
        return "Developer "+super.toString() + ", Language=" + this.getDevLanguage()+"]";
    }
}