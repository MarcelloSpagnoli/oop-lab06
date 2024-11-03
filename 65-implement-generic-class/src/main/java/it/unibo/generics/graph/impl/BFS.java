package it.unibo.generics.graph.impl;

import java.util.List;

import it.unibo.generics.graph.api.SearchPattern;

public class BFS<N> implements SearchPattern<N>{

    @Override
    public void addToFrontier(List<Step<N>> frontier, Step<N> current) {
        frontier.addLast(current);
    }
    
}
