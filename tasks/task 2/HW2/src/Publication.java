public class Publication {
    String title;
    String publication;
    int qty;

    private static int counter = 10;//count how much object created - start from 10
    private final int id;


    public Publication() {
        this.id = counter;
        counter++;

        this.setTitle("");
        this.setPublication("");
        this.setQty(0);


    }

    public Publication(String title, String publication, int qty) {
        this.id = counter;
        counter++;

        this.setTitle(title);
        this.setPublication(publication);
        this.setQty(qty);
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublication(String publication) {
        this.publication = publication;

    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public String getPublication() {
        return publication;
    }

    public int getQty() {
        return qty;
    }

    public int getId() {
        return id;
    }
}
