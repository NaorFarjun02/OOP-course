package publication;

/**
 * Represents an author of a publication.
 * <p>
 * Each author is identified by a name and an email address.
 * This class is typically used in conjunction with {@link Book}.
 * </p>
 *
 * <p><b>Note:</b> Fields {@code name} and {@code email} are package-private instead of {@code private}.</p>
 */
public class Author {

    String name;
    String email;

    /**
     * Default constructor. Creates an {@code Author} with an empty name and email.
     */
    public Author(){
        this.setName("");
        this.setEmail("");
    }

    /**
     * Constructs an {@code Author} with the specified name and email.
     *
     * @param name  the full name of the author
     * @param email the email address of the author
     */
    public Author(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    /**
     * Returns the name of this author.
     *
     * @return the author's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this author.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email address of this author.
     *
     * @return the author's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of this author.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of this author in the format:
     * <pre>name at email</pre>
     *
     * @return a formatted string with the author's name and email
     */
    public String toString(){
        return this.getName()+" at "+this.getEmail();
    }
}