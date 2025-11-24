package collectionPractice.list;

public class TestCustomLL {

    public static void main(String[] args) {

        // test 1
        testCustomLinkedListImplementation();

        // test 2
        testCustomLL();
    }

    private static void testCustomLL() {
        System.out.println("Test CustomLL...");

        CustomLL<Long> customLL = new CustomLL<>(1L, 10L, 100L);
        customLL.add(2L);
        customLL.addFirst(3L);
        customLL.add(4L);
        customLL.add(5L);
        customLL.add(6L);
        customLL.add(7L);
        customLL.add(8L);
        customLL.printLL();
        System.out.println(customLL.get(3));
        System.out.println(customLL.getFirst());
        System.out.println(customLL.getLast());
        System.out.println(customLL.size());
        System.out.println(customLL.head());
        System.out.println(customLL.tail());
        customLL.remove(3);
        customLL.printLL();
        customLL.remove(5L);
        customLL.printLL();
        customLL.removeFirst();
        customLL.removeLast();
        customLL.printLL();
        customLL.clear();
        customLL.printLL();
    }


    private static void testCustomLinkedListImplementation() {
        System.out.println("test 1");
        CustomLinkedListImplementation<String> custLL = new CustomLinkedListImplementation<>();

        System.out.println(custLL);
        System.out.println(custLL.size());

        custLL.addFirst("abc");
        custLL.addFirst("def");
        custLL.addLast("xyz");
        custLL.printList();
        custLL.set(2, "pqr");
        custLL.printList();
        System.out.println(custLL.size());
        custLL.removeFirst();
        custLL.removeLast();
        custLL.printList();
        System.out.println(custLL.getHead());
        custLL.addLast("xyz");
        custLL.addLast("xyz");
        custLL.addLast("def");
        custLL.addLast("htg");
        custLL.printList();
        System.out.println(custLL.remove("abc"));
        custLL.remove("xyz");
        custLL.printList();


        // test 2
        System.out.println("test 2");
        CustomLinkedListImplementation<Integer> custLL2 = new CustomLinkedListImplementation<>();
        custLL2.addLast(1);
//        custLL2.set(3, 6);
        custLL2.printList();
    }

}
