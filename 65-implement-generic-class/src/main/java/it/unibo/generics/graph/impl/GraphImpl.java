package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.SearchPattern;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N> > edges = new HashMap<>();
    private final SearchPattern<N> searchPattern;

    public GraphImpl(SearchPattern<N> searchPattern) {
        this.searchPattern = searchPattern;
    }

    @Override
    public void addNode(final N node) {
        edges.putIfAbsent(node, new HashSet<>());   
    }

    @Override
    public void addEdge(final N source, final  N target) {
        edges.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return this.edges.keySet();
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        return this.edges.get(node);
    }

    public int getNodesNumber () {
        return this.edges.keySet().size();
    }

    @Override
    public List<N> getPath(N source, N target) {
        final List<Step<N>> frontier = new LinkedList<>();
        final Set<N> visited  = new HashSet<>();
        frontier.add(new Step<>(source));
        while (!frontier.isEmpty()) {
            final Step<N> currentStep = frontier.removeFirst();
            final N currentNode = currentStep.getCurrentNode();
            if (currentNode.equals(target)) {
                return currentStep.getPath();
            }else if(!visited.contains(currentNode)){
                visited.add(currentNode);
                for (N linkedNode : this.linkedNodes(currentNode)) {
                    searchPattern.addToFrontier(frontier, new Step<N>(currentStep, linkedNode));
                }
            }
        }
        return Collections.emptyList();

    }
    
}
