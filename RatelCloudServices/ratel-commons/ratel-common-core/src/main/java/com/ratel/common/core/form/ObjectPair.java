package com.ratel.common.core.form;

public class ObjectPair<T, V> {

    private T left;

    private V right;

    public ObjectPair(T left, V right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return this.left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public V getRight() {
        return this.right;
    }

    public void setRight(V right) {
        this.right = right;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (!(o instanceof ObjectPair)) {
            return false;
        }
        ObjectPair<T, V> p = (ObjectPair<T, V>) o;
        T t1 = this.left;
        T t2 = p.left;
        if (t1 == t2 || (t1 != null && t1.equals(t2))) {
            V v1 = this.right;
            V v2 = p.right;
            return v1 == v2 || (v1 != null && v1.equals(v2));
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((left == null) ? 0 : left.hashCode());
        result = PRIME * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("{").append(left).append(",").append(right).append("}").toString();
    }
}