class Parcel {
    Addressee addressee;
    Boolean delivered = false;

    Parcel(Addressee addressee) {
        this.addressee = addressee;
    }

    void delivered() {
        this.delivered = true;
    }
}