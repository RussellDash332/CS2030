class Book {
    private final Page[] pages;
    private final int currPageNum;

    Book(Page[] pages) {
        this(pages, 1);
        //this.currPageNum = 1;
    }

    private Book(Page[] pages, int pageNum) {
        this.pages = pages;
        this.currPageNum = pageNum;
    }

    Book gotoPage(int pageNum) {
        if (pageNum < 1 || pageNum > this.numPages()) {
            pageNum = this.currPageNum;
        }
        return new Book(this.pages, pageNum);
    }

    Book prevPage() {
        return this.gotoPage(this.currPageNum - 1);
        // return new Book(this.currPageNum - 1);
    }

    Book nextPage() {
        return this.gotoPage(this.currPageNum + 1);
        // return new Book(this.currPageNum + 1);
    }

    private int numPages() {
        return this.pages.length;
    }

    private Page getPage(int pageNum) {
        return this.pages[pageNum - 1];
    }

    @Override
    public String toString() {
        return this.getPage(this.currPageNum) + "\n" 
            + "--- " + this.currPageNum + " ---";
    }
}
