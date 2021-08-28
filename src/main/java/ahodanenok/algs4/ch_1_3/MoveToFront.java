package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Book, exercise 1.3.40
 */
public class MoveToFront {

    public static void main(String[] args) {
        System.out.println(applyTo(Arrays.asList(StdIn.readAllStrings())));
    }

    public static List<String> applyTo(List<String> strings) {
        Node<String> firstNode = null;
        for (String str : strings) {
            // so good that this method was implemented in the earlier exercise! :)
            firstNode = LinkedListMethods.remove(firstNode, str);

            Node<String> newNode = new Node<>(str);
            newNode.next = firstNode;
            firstNode = newNode;
        }

        List<String> result = new ArrayList<>();

        Node<String> currentNode = firstNode;
        while (currentNode != null) {
            result.add(currentNode.value);
            currentNode = currentNode.next;
        }

        return result;
    }
}
