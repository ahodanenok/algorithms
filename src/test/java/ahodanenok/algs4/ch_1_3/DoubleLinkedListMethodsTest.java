package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListMethodsTest {

    @Test
    public void testInsertFirstEmpty() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertFirst(DoubleNode.list(null), "a");
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testInsertFirstOneElement() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertFirst(DoubleNode.list("b"), "a");
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertFirstTwoElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertFirst(DoubleNode.list("b", "c"), "a");
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertFirstMultipleElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertFirst(DoubleNode.list("b", "c", "d"), "a");
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertEquals("d", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("d", currentNode.value);
        assertEquals("c", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertLastEmpty() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertLast(DoubleNode.list(null), "a");
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testInsertLastOneElement() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertLast(DoubleNode.list("b"), "a");
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertLastTwoElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertLast(DoubleNode.list("b", "c"), "a");
        assertEquals("b", currentNode.value);
        assertEquals("c", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertEquals("a", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("a", currentNode.value);
        assertEquals("c", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertLastMultipleElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertLast(DoubleNode.list("b", "c", "d"), "a");
        assertEquals("b", currentNode.value);
        assertEquals("c", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertEquals("d", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("d", currentNode.value);
        assertEquals("c", currentNode.prev.value);
        assertEquals("a", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("a", currentNode.value);
        assertEquals("d", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testRemoveFirstEmpty() {
        assertNull(DoubleLinkedListMethods.removeFirst(null));
    }

    @Test
    public void testRemoveFirstSingleElement() {
        assertNull(DoubleLinkedListMethods.removeFirst(DoubleNode.list("a")));
    }

    @Test
    public void testRemoveFirstTwoElements() {
        DoubleNode<String> node = DoubleLinkedListMethods.removeFirst(DoubleNode.list("a", "b"));
        assertEquals("b", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveFirstMultipleElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.removeFirst(DoubleNode.list("a", "b", "c"));
        assertEquals("b", currentNode.value);
        assertEquals("c", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testRemoveLastEmpty() {
        assertNull(DoubleLinkedListMethods.removeLast(null));
    }

    @Test
    public void testRemoveLastSingleElement() {
        assertNull(DoubleLinkedListMethods.removeLast(null));
    }

    @Test
    public void testRemoveLastTwoElements() {
        DoubleNode<String> node = DoubleLinkedListMethods.removeLast(DoubleNode.list("a", "b"));
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveLastMultipleElements() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.removeLast(DoubleNode.list("a", "b", "c", "d"));
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertBeforeEmpty() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertBefore(null, "a");
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testInsertBeforeSingleElement() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertBefore(DoubleNode.list("a"), "b");
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertBeforeFirst() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertBefore(DoubleNode.list("a", "b"), "c");
        assertEquals("c", currentNode.value);
        assertEquals("a", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("a", currentNode.value);
        assertEquals("c", currentNode.prev.value);
        assertEquals("b", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertBeforeMiddle() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertBefore(DoubleNode.list("a", "b", "c").next, "d");

        DoubleNode<String> currentNode = node;
        assertEquals("d", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("b", currentNode.next.value);

        currentNode = node.prev;
        assertEquals("a", currentNode.value);
        assertEquals("d", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = node.next;
        assertEquals("b", currentNode.value);
        assertEquals("d", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testInsertBeforeLast() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertBefore(DoubleNode.list("a", "b").next, "c");
        assertEquals("c", node.value);
        assertEquals("a", node.prev.value);
        assertEquals("b", node.next.value);

        DoubleNode<String> nextNode = node.next;
        assertEquals("b", nextNode.value);
        assertEquals("c", nextNode.prev.value);
        assertNull(nextNode.next);

        DoubleNode<String> previousNode = node.prev;
        assertEquals("a", previousNode.value);
        assertEquals("c", previousNode.next.value);
        assertNull(previousNode.prev);
    }

    @Test
    public void testInsertAfterEmpty() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertAfter(null, "a");
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testInsertAfterSingleElement() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertAfter(DoubleNode.list("a"), "b");
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);

        currentNode = currentNode.prev;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);
    }

    @Test
    public void testInsertAfterFirst() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertAfter(DoubleNode.list("a", "b"), "c");
        assertEquals("c", node.value);
        assertEquals("a", node.prev.value);
        assertEquals("b", node.next.value);

        DoubleNode<String> nextNode = node.next;
        assertEquals("b", nextNode.value);
        assertEquals("c", nextNode.prev.value);
        assertNull(nextNode.next);

        DoubleNode<String> previousNode = node.prev;
        assertEquals("a", previousNode.value);
        assertEquals("c", previousNode.next.value);
        assertNull(previousNode.prev);
    }

    @Test
    public void testInsertAfterMiddle() {
        DoubleNode<String> node = DoubleLinkedListMethods.insertAfter(DoubleNode.list("a", "b", "c").next, "d");

        DoubleNode<String> currentNode = node;
        assertEquals("d", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = node.next;
        assertEquals("c", currentNode.value);
        assertEquals("d", currentNode.prev.value);
        assertNull(currentNode.next);

        currentNode = node.prev;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("d", currentNode.next.value);

        currentNode = currentNode.prev;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);
    }

    @Test
    public void testInsertAfterLast() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.insertAfter(DoubleNode.list("a", "b").next, "c");
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);

        currentNode = currentNode.prev;
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertEquals("c", currentNode.next.value);

        currentNode = currentNode.prev;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);
    }

    @Test
    public void testRemoveNodeEmpty() {
        assertNull(DoubleLinkedListMethods.removeNode(null));
    }

    @Test
    public void testRemoveNodeSingleElement() {
        assertNull(DoubleLinkedListMethods.removeNode(DoubleNode.list("a")));
    }

    @Test
    public void testRemoveNodeTwoElementsFirst() {
        DoubleNode<String> node = DoubleLinkedListMethods.removeNode(DoubleNode.list("a", "b"));
        assertEquals("b", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveNodeTwoElementsLast() {
        DoubleNode<String> node = DoubleLinkedListMethods.removeNode(DoubleNode.list("a", "b").next);
        assertEquals("a", node.value);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void testRemoveNodeFirst() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.removeNode(DoubleNode.list("a", "b", "c"));
        assertEquals("b", currentNode.value);
        assertEquals("c", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("b", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testRemoveNodeMiddle() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.removeNode(DoubleNode.list("a", "b", "c").next);
        assertEquals("a", currentNode.value);
        assertEquals("c", currentNode.next.value);
        assertNull(currentNode.prev);

        currentNode = currentNode.next;
        assertEquals("c", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);
    }

    @Test
    public void testRemoveNodeLast() {
        DoubleNode<String> currentNode = DoubleLinkedListMethods.removeNode(DoubleNode.list("a", "b", "c").next.next);
        assertEquals("b", currentNode.value);
        assertEquals("a", currentNode.prev.value);
        assertNull(currentNode.next);

        currentNode = currentNode.prev;
        assertEquals("a", currentNode.value);
        assertEquals("b", currentNode.next.value);
        assertNull(currentNode.prev);
    }
}
