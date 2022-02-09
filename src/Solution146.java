import java.util.HashMap;
import java.util.Map;

public class Solution146 {
   public class LRUCache {
        class DlinkNode {
            int key;
            int value;
            DlinkNode prev;
            DlinkNode next;
        }

        private void addNode(DlinkNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DlinkNode node) {
            //这两个操作都有点看不懂
            //感觉还是对这些链表的理解，以及地址之间的关系不太熟练
            //这个就是把这个节点的前一个后一个节点给记录下来
            DlinkNode prev = node.prev;
            DlinkNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public void MoveToHead(DlinkNode node) {
            removeNode(node);
            addNode(node);
        }

        public DlinkNode popTail() {
            //这个返回了被移除的值
            DlinkNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DlinkNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DlinkNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DlinkNode();
            tail = new DlinkNode();
            head.next = tail;
            tail.prev = head;
//把两者连接起来
        }

        public int get(int key) {
//先是哈希表找
            //然后更新位置链表，更新的操作就是找到这个位置，然后将这个位置的点给移到头上，那么为什么要残留哈希表呢，不都需要遍历元素吗，哦哦哦哈希表是用来链接指的，但是这个arraylist保存两个值也是没有问题的啊
            DlinkNode node = cache.get(key);
            if (node == null)
                return -1;
            MoveToHead(node);
            return node.value;
            //这边是程序要求的返回值
        }

        public void put(int key, int value) {
            DlinkNode node = cache.get(key);
            if (node == null) {
                DlinkNode newNode = new DlinkNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                addNode(newNode);
                ++size;
                if (size > capacity) {
                    DlinkNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                MoveToHead(node);
            }
        }
    }
}

