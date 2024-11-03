package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

public class Step<N> {
    private final Step<N> previous;
    private final N current;
    
    
    public Step(Step<N> previous, N current) {
        this.previous = previous;
        this.current = current;
    }

    public Step(N current) {
        this(null, current);
    }

    public N getCurrentNode() {
        return current;
    }

    public List<N> getPath() {
        List<N> path = new LinkedList<>();
        Step<N> tmp = this;
        while (tmp != null) {
            path.addFirst(tmp.current);
            tmp = tmp.previous; 
        }
        return path;
    }

    
    

    

}
