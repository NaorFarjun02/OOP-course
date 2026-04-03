public class Journal extends Publication {
    int issueNumber;
    int year;


    public Journal() {
        this.setIssueNumber(0);
        this.setYear(0);
    }

    public Journal(String title, String publication, int qty, int issueNumber, int year) {
        super(title, publication, qty);
        this.setIssueNumber(issueNumber);
        this.setYear(year);
    }


    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        String journal = "" + this.getId() + "-Journal " + this.getTitle() + " (" + this.getIssueNumber() + ") ";
        journal += "published by " + this.getPublication() + " (" + this.getYear() + ")";

        return journal;
    }
}
