package com.xiaohu.sufa.lru;

import java.util.Objects;

/**
 * @Version 1.0
 * @Author huqiang
 * @Description Node
 * @Date 2022/11/15 11:08
 **/
public class Node<K,V> {

    private Node<K,V> prev;

    private Node<K,V> next;

    private K key;

    private V value;

    private int hash;

    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node(int hash,K key, V value,String name) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.name = name;
    }

    public Node<K,V> getPrev() {
        return prev;
    }

    public void setPrev(Node<K,V> prev) {
        this.prev = prev;
    }

    public Node<K,V> getNext() {
        return next;
    }

    public void setNext(Node<K,V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return key.equals(node.key) && value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }


    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", key=" + key +
                ", value=" + value +
                ", hash=" + hash +
                ", name='" + name + '\'' +
                '}';
    }
}
