import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode
{
    int data;
    char c;
    HuffmanNode kiri;
    HuffmanNode kanan;
}

class Pembanding implements Comparator<HuffmanNode>
{
    public int compare(HuffmanNode x, HuffmanNode y)
    {
        return x.data - y.data;
    }
}

public class Huffman
{
    public static void printCode(HuffmanNode root, String s)
    {
        if(root.kiri == null && root.kanan == null && Character.isLetter(root.c))
        {
            System.out.println(root.c + " : " + s);
            return;
        }
        printCode(root.kiri, s + "0");
        printCode(root.kanan, s + "1");
    }

    public static void main(String[] args)
    {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {10, 5, 9, 12, 13, 21};
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new Pembanding());
        for (int i = 0; i < n; i++)
        {
            HuffmanNode huffmanNode = new HuffmanNode();

            huffmanNode.c = charArray[i];
            huffmanNode.data = charFreq[i];

            huffmanNode.kiri = null;
            huffmanNode.kanan = null;

            q.add(huffmanNode);
        }

        HuffmanNode root = null;

        while(q.size() > 1)
        {
            HuffmanNode x = q.peek(); q.poll();

            HuffmanNode y = q.peek(); q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            //f.c = '-';
            System.out.println("Jumlah internal node : " + f.data);
            f.kiri = x;
            f.kanan = y;

            root = f;
            q.add(f);

        }
        printCode(root, "");
    }
}
