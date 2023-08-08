package leetcode;

import java.util.*;

/**
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;

    //双向队列,队首存放刚刚查出来或插入的元素,队尾存放马上被剔除的元素
    private final Node firstNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        firstNode = new Node(-1, -1);
        firstNode.next = firstNode;
        firstNode.before = firstNode;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node searchNode = cache.get(key);
            //将searchNode放入队首
            searchNode.before.next = searchNode.next;
            searchNode.next.before = searchNode.before;
            Node beforeFirstNode = firstNode.next;
            beforeFirstNode.before = searchNode;
            firstNode.next = searchNode;
            searchNode.before = firstNode;
            searchNode.next = beforeFirstNode;
            return searchNode.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node searchNode = cache.get(key);
            searchNode.value = value;
            //将searchNode放入队首
            searchNode.before.next = searchNode.next;
            searchNode.next.before = searchNode.before;
            Node beforeFirstNode = firstNode.next;
            beforeFirstNode.before = searchNode;
            firstNode.next = searchNode;
            searchNode.before = firstNode;
            searchNode.next = beforeFirstNode;
        }else {
            if (cache.size() == capacity) {
                //剔除队尾元素
                Node afterRemoveNode = firstNode.before;
                Node afterLastNode = afterRemoveNode.before;
                cache.remove(afterRemoveNode.key);
                afterLastNode.next = firstNode;
                firstNode.before = afterLastNode;
            }
            //在队首插入该元素
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            Node beforeFirstNode = firstNode.next;
            newNode.before = firstNode;
            newNode.next = beforeFirstNode;
            firstNode.next = newNode;
            beforeFirstNode.before = newNode;
        }
    }

    public static class Node {
        public Node before;
        public Node next;
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(Node before, Node next, int value) {
            this.before = before;
            this.next = next;
            this.value = value;
        }

        public Node() {
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
