package it.unibo.generics.graph.api;

import java.util.List;

import it.unibo.generics.graph.impl.Step;

public interface SearchPattern<N> {
    public void addToFrontier(List<Step<N>> frontier, Step<N> current);
}
