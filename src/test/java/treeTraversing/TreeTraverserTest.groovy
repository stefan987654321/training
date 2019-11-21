package treeTraversing

import spock.lang.Specification

class TreeTraverserTest extends Specification {

    def "Should properly return InOrder"() {

        given:
        List<Node> order = new ArrayList<>()
        TreeTraverser treeTraverser = new TreeTraverser()
        def rootNode = tree.getTree().get(0)

        when:
        treeTraverser.inOrder(order, rootNode)

        then:
        def list = order.stream().map { o -> o.value }.toArray()

        list == expectedList
        list.size() == listSize

        where:
        tree        | listSize | expectedList
        new Tree1() | 5        | Arrays.asList(5, 1, 12, 7, 3)
        new Tree2() | 8        | Arrays.asList("D", "B", "F", "E", "A", "C", "H", "G")
        new Tree3() | 5        | Arrays.asList(4, 2, 5, 1, 3)
    }

    def "Should properly return preOrder"() {
        given:
        List<Node> order = new ArrayList<>()
        TreeTraverser treeTraverser = new TreeTraverser()
        def rootNode = tree.getTree().get(0)

        when:
        treeTraverser.preOrder(order, rootNode)

        then:
        def list = order.stream().map { o -> o.value }.toArray()

        list.size() == listSize
        list == expectedList

        where:
        tree        | listSize | expectedList
        new Tree1() | 5        | Arrays.asList(1, 5, 7, 12, 3)
        new Tree2() | 8        | Arrays.asList("A", "B", "D", "E", "F", "C", "G", "H")
        new Tree3() | 5        | Arrays.asList(1, 2, 4, 5, 3)
    }

    def "Should properly return postOrder"() {
        given:
        List<Node> order = new ArrayList<>()
        TreeTraverser treeTraverser = new TreeTraverser()
        def rootNode = tree.getTree().get(0)

        when:
        treeTraverser.postOrder(order, rootNode)

        then:
        def list = order.stream().map { o -> o.value }.toArray()

        list.size() == listSize
        list == expectedList

        where:
        tree        | listSize | expectedList
        new Tree1() | 5        | Arrays.asList(5, 12, 3, 7, 1)
        new Tree2() | 8        | Arrays.asList("D", "F", "E", "B", "H", "G", "C", "A")
        new Tree3() | 5        | Arrays.asList(4, 5, 2, 3, 1)
    }

}
