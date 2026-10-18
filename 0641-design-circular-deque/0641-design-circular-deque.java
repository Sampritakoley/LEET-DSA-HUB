class MyCircularDeque {

    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        arr[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        arr[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna