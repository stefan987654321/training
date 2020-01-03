package graphTraversing

import spock.lang.Specification

class GraphTraverserTest extends Specification {


    def "Should depth first traverse graph"() {
        given:
        GraphTraverser graphTraverser = new GraphTraverser()

        when:
        graphTraverser.depthFirstSearch(visited, graphTemplate.getGraph(), graphTemplate.getRoot())

        then:
        visited == result.toSet()

        where:
        visited                     | graphTemplate | result
        new LinkedHashSet<String>() | new Graph1()  | ["Bob", "Rob", "Maria", "Alice", "Mark"]
        new LinkedHashSet<String>() | new Graph2()  | ["r", "m", "n", "o", "p", "q"]
        new LinkedHashSet<String>() | new Graph3()  | ["a", "d", "b", "c", "e"]
    }


    def "Should breadth first traverse graph"() {
        given:
        GraphTraverser graphTraverser = new GraphTraverser()

        when:
        graphTraverser.breadthFirstSearch(visited, graphTemplate.getGraph(), graphTemplate.getRoot())

        then:
        visited == result.toSet()

        where:
        visited                     | graphTemplate | result
        new LinkedHashSet<String>() | new Graph1()  | ["Bob", "Alice", "Rob", "Mark", "Maria"]
        new LinkedHashSet<String>() | new Graph2()  | ["q", "m", "n", "p", "r", "o"]
        new LinkedHashSet<String>() | new Graph3()  | ["a", "d", "b", "c", "e"]
    }
}
