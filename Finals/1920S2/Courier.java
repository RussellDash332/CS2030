class Courier {
    Parcel parcel;

    Courier(Parcel parcel) {
        this.parcel = parcel;
    }

    void deliverParcel() {
        this.parcel.delivered();
    }
}