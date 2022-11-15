package com.xiaohu.sufa.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author huqiang
 * @Description LRUCache
 * @Date 2022/11/15 9:26
 **/
public class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //目前这头尾节点是虚拟的，只是占位
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //判断是否存在
        DLinkedNode node = cache.get(key);
        if (node != null) {
            //删除该节点
            deleteNode(node);
            //插入头节点
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //填加到头部节点
            DLinkedNode dLinkedNode = new DLinkedNode(key,value);
            setHead(dLinkedNode);
            ++size;
            if (size > capacity) {
                //删除不经常使用的，也就是尾节点
                DLinkedNode deleteTail = deleteTail();
                cache.remove(deleteTail.key);
                --size;

            }
        }else {
            //更新value值
            node.value = value;
            //移动到头部
            deleteNode(node);
            setHead(node);
        }
    }

    private DLinkedNode deleteTail() {
        DLinkedNode node = this.tail.prev;
        deleteNode(node);
        return node;
    }

    //并不是真正改变虚拟节点，相当于再虚拟节head点后面加一个节点，这个节点才算真正头节点
    private void setHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void deleteNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}
