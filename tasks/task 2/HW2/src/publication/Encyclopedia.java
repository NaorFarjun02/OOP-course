package publication;

/**
 * Represents an encyclopedia in the library system.
 * <p>
 * An {@code Encyclopedia} extends {@link Publication} and adds a volume number
 * and an editor. If no editor is provided (empty string), the editor defaults to {@code "unknown"}.
 * </p>
 *
 * <p><b>Note:</b> The editor check in {@link #setEditor(String)} uses {@code ==} instead of
 * {@code .equals()}, which means the fallback to {@code "unknown"} will not work correctly
 * for non-literal empty strings.</p>
 */
public class Encyclopedia extends Publication {

    /**
     * The volume number of this encyclopedia.
     */
    int volume;

    /**
     * The editor of this encyclopedia. Defaults to {@code "unknown"} if not provided.
     */
    String editor;

    /**
     * Default constructor. Creates an {@code Encyclopedia} with volume {@code 0} and an empty editor.
     */
    public Encyclopedia() {
        this.setVolume(0);
        this.setEditor("");
    }

    /**
     * Constructs an {@code Encyclopedia} with all required fields.
     *
     * @param title       the title of the encyclopedia
     * @param publication the name of the publisher
     * @param qty         the available quantity in stock
     * @param editor      the editor of this encyclopedia; defaults to {@code "unknown"} if empty
     * @param volume      the volume number of this encyclopedia
     */
    public Encyclopedia(String title, String publication, int qty, String editor, int volume) {
        super(title, publication, qty);
        this.setVolume(volume);
        this.setEditor(editor);
    }

    /**
     * Returns the volume number of this encyclopedia.
     *
     * @return the volume number
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the volume number of this encyclopedia.
     *
     * @param volume the volume number to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns the editor of this encyclopedia.
     *
     * @return the editor's name, or {@code "unknown"} if none was provided
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Sets the editor of this encyclopedia.
     * If the provided value is an empty string literal, it defaults to {@code "unknown"}.
     *
     * <p><b>Note:</b> Uses {@code ==} for comparison instead of {@code .equals()},
     * which may not behave as expected for non-literal empty strings.</p>
     *
     * @param editor the editor name to set
     */
    public void setEditor(String editor) {
        this.editor = editor == "" ? "unknown" : editor;
    }

    /**
     * Returns a string representation of this encyclopedia in the format:
     * <pre>id-Encyclopedia title vol. volume published by publisher edited by editor</pre>
     *
     * @return a formatted string describing this encyclopedia
     */
    public String toString() {
        String encyclopedia = "" + this.getId() + "-Encyclopedia " + this.getTitle() + " vol. " + this.getVolume();
        encyclopedia += " published by " + this.getPublication();
        encyclopedia += " edited by " + this.getEditor();
        return encyclopedia;
    }
}