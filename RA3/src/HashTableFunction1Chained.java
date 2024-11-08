class HashTableFunction1Chained extends HashTableChained {

    public HashTableFunction1Chained(int size) {
        super(size);
    }

    @Override
    protected int hash(String key) {
        int hashValue = 5381;
        for (char c : key.toCharArray()) {
            hashValue = ((hashValue << 5) + hashValue) + c;  // hash * 33 + c
        }
        return Math.abs(hashValue);
    }
}
