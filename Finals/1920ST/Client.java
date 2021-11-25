@SuppressWarnings("unchecked")
class Client {
    Triple triple;

    public Client() {
        triple = new Triple(1,2,3,this);
        triple.print();
        Client.addTriple(triple);
    }

    static void addTriple(Triple<Integer,Integer,Integer> triple) {
        System.out.println(String.format("%s", triple.t+triple.r+triple.s));
    }
}