public class Encyclopedia extends Publication {
    int volume;
    String editor;

    public Encyclopedia() {
        this.setVolume(0);
        this.setEditor("");
    }

    public Encyclopedia(String title, String publication, int qty, String editor, int volume) {
        super(title, publication, qty);
        this.setVolume(volume);
        this.setEditor(editor);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == "" ? "unknown" : editor;
    }

    public String toString() {
        String encyclopedia = "" + this.getId() + "-Encyclopedia " + this.getTitle() + " vol. " + this.getVolume();
        encyclopedia+= " published by " + this.getPublication() ;
        encyclopedia+= " edited by " + this.getEditor();
        return encyclopedia;
    }
}
