package com.xiaohu.sufa.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author huqiang
 * @Description LruTest
 * @Date 2022/11/15 11:07
 **/
public class LruManager<K, V> {

    private Map<Integer, Node<K, V>> cache = new HashMap<>();

    private Node<K, V> head;

    private Node<K, V> tail;

    private int cap;

    private int size;

    public LruManager(int cap) {
        this.head = new Node<>("虚拟头节点");
        this.tail = new Node<>("虚拟尾节点");
        this.cap = cap;
        this.size = 0;
        head.setNext(tail);
        tail.setPrev(head);
    }

    public Map<Integer, Node<K, V>> getCache() {
        return cache;
    }

    public void setCache(Map<Integer, Node<K, V>> cache) {
        this.cache = cache;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void setTail(Node<K, V> tail) {
        this.tail = tail;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public V getOrDefault(K key, V defaultValue) {

        int k = Math.abs(hash(key));
        Node<K, V> v = cache.get(k);
        if (v == null) {
            return defaultValue;
        }
        //存在/移动到头节点
        moveToRealHead(v);
        return v.getValue();
    }

    public void put(K key, V value) {
        int k = Math.abs(hash(key));
        Node<K, V> v = cache.get(k);
        if (v == null) {
            Node<K, V> node = new Node<>(k, key, value, String.format("名字%s", k));
            ++size;
            cache.put(k, node);
            addRealHead(node);
            if (size > cap) {
                //删除尾节点
                Node<K, V> deleteNode = deleteTail();
                cache.remove(deleteNode.getHash());
                --size;
            }
        } else {
            moveToRealHead(v);
        }
    }

    private Node<K, V> deleteTail() {
        Node<K, V> prev = this.tail.getPrev();
        deleteNode(prev);
        return prev;
    }

    private void moveToRealHead(Node<K, V> node) {
        deleteNode(node);
        addRealHead(node);
    }

    /**
     * 添加真实头节点
     *
     * @param node 元素节点
     */
    private void addRealHead(Node<K, V> node) {
        node.setPrev(head);
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);
    }

    /**
     * 删除具体某一节点元素
     *
     * @param node 元素节点
     */
    private void deleteNode(Node<K, V> node) {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
