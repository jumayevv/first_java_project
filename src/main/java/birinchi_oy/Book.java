package Dars;

public class Book implements Cloneable{
    public String title;
    public author author;
    public publisher publisher;
    Integer publishedYear,pages;
    Book(String title,author author,Integer publishedYear,Integer pages,publisher publisher){
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.pages= pages;
        this.publisher = publisher;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public author getAuthor(){
        return this.author;
    }
    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "title: "  + this.title +
                this.author +
                "\npublished in: " + this.publishedYear +
                "\npages: "+this.pages;
    }
}
