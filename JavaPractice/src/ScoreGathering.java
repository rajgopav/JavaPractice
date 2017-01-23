import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ScoreGathering {
	class Node {
        int data, count = 1;
        Node left, right;
        public Node(int d) { data = d; }
    }

    Node addToBst(Node bst, int data) {
        if (bst == null) {
            return new Node(data);
        } else {
            if (data == bst.data) {
                bst.count++;
            } else if (data < bst.data) {
                bst.left = addToBst(bst.left, data);
            } else {
                bst.right = addToBst(bst.right, data);
            }
            return bst;
        }
    }

    String printBFS(Node bst) {
        Queue<Node> queue = new LinkedList<Node>(Collections.singletonList(bst));
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            if ((bst = queue.poll()) != null) {
                str.append(bst.data + ":" + bst.count);
                queue.add(bst.left);
                queue.add(bst.right);
            }
            str.append(",");
        }
        while (str.charAt(str.length() - 1) == ',')
            str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    @Test
    public void solve() {
        Node bst = null;
        for (Integer i : new int[] {4,2,5,5,6,1,4}) {
            bst = addToBst(bst, i);
        }
        assertEquals("4:2,2:1,5:2,1:1,,,6:1", printBFS(bst));
    }
}
