package Arama;

import java.util.Scanner;

public class binarySearchTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    public binarySearchTree() {
        root = null;
    }

    public static void binarySearchTree() {
        binarySearchTree tree = new binarySearchTree();
        Scanner klavye = new Scanner(System.in);
        System.out.print("Eklemek istediğiniz sayıları virgülle ayırarak girin: ");
        String[] input = klavye.nextLine().split(",");

        for (String s : input) {
            tree.insert(Integer.parseInt(s.trim()));
        }

        System.out.print("Aranacak sayıyı girin: ");
        int arananSayi = klavye.nextInt();

        if (tree.search(arananSayi) != null) {
            System.out.println("Sayı ağaçta bulundu.");
        } else {
            System.out.println("Sayı ağaçta bulunamadı.");
        }
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.data == key)
            return root;

        if (root.data > key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }
}
