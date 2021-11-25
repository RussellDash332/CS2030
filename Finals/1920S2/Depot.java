class Depot {
    Courier courier;

    void outForDelivery(Courier courier) {
        this.courier = courier;
        this.courier.deliverParcel();
    }
}