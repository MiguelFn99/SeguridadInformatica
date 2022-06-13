package unileon;

import java.util.PriorityQueue;

  
class Huffman {
	
	static double entropia = 0.5665095065529053;
    static char[] charArray = {'a', 'b'};
    static int[] charfreq = {13, 2};
    static int n = charfreq.length;
    static int[] longVector = new int[n];
    

    public static void printCode(HuffmanNode root, String s) {
  
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            //System.out.println(root.c + ":" + s);
            for (int i = 0; i < n; i++) {
				if (charArray[i] == root.c) {
					longVector[i] =  s.length();	
				}		
			}
            
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
  
    public static void main(String[] args) {
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());
  
        for (int i = 0; i < n; i++) {
  
        	HuffmanNode hn = new HuffmanNode();
  
            hn.c = charArray[i];
            hn.data = charfreq[i];
  
            hn.left = null;
            hn.right = null;
  
            q.add(hn);
        }
  
        HuffmanNode root = null;
  
        while (q.size() > 1) {
  
        	HuffmanNode x = q.peek();
            q.poll();
  
            HuffmanNode y = q.peek();
            q.poll();
            
            HuffmanNode f = new HuffmanNode();
  
            f.data = x.data + y.data;
            f.c = '-';
  
            f.left = x;
  
            f.right = y;
  
            root = f;

            q.add(f);
        }
  
        printCode(root, "");
        
        double longBinaria = 0;
        double sumFrec = 0;
        for (int i = 0; i < n; i++) {
			longBinaria += charfreq[i] * longVector[i];
			sumFrec += charfreq[i];
		}
        longBinaria /= sumFrec;
        System.out.println("La entropía es: " + entropia);
        System.out.println("Longtud binaria es: " + longBinaria);
        
        
        //Eficacia de código óptimo
        //Entropía / Longitud binaria
        
        System.out.println("Eficacia de código óptimo: " + entropia/longBinaria);
        
    }
}