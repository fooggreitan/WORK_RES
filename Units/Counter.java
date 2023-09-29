public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean isClosed = false;

    public void add() {
        if (isClosed) {
            throw new IllegalStateException("Счетчик закрыт");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        isClosed = true;
    }
}
