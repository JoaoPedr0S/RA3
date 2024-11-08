class HashTableFunction2Chained extends HashTableChained {

    public HashTableFunction2Chained(int size) {
        super(size);
    }

    @Override
    protected int hash(String key) {
        int hashValue = 0;
        int prime = 31;
        for (char c : key.toCharArray()) {
            hashValue = prime * hashValue + c;
        }
        return Math.abs(hashValue);
    }
}
